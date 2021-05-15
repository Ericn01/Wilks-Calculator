package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Lifter;

public class MainController implements Initializable{
	final ToggleGroup group = new ToggleGroup();
	
	private Parent root;
	// Inputs
	@FXML
	private TextField nameInput;
	@FXML
	private TextField bodyweightInput;
	@FXML 
	private TextField squat;
	@FXML
	private TextField benchInput;
	@FXML
	private TextField deadliftInput;
	// labels
	@FXML
	private Label wilks;
	@FXML
	private Label percentile;
	// radio buttons
	@FXML
	private RadioButton male;
	@FXML
	private RadioButton female;
	
	// Combobox
	@FXML 
	private ComboBox<String> units = new ComboBox<String>();
	private String[] options = {"Kg", "Lbs", "Stones"};
	// slider
	@FXML
	private Slider ageInput;
	// buttons
	@FXML 
	Button submit;
	@FXML 
	Button clear;
	
	private TextField fields[] = {benchInput, deadliftInput, squat, bodyweightInput};
	
	public char unitsSelected() {
		char unitSelected = 'A';
		String unit = units.getValue();
		System.out.println(unit);
		if (unit.equals("Kg")) {
			unitSelected = 'K';
		}
		else if (unit.equals("Lbs")) {
			unitSelected = 'L';
		}
		else if (unit.equals("Stones")) {
			unitSelected = 'S';
		}
		else {
			System.out.println("An error has occured");
		}
		return unitSelected;
	}
	public void submit(ActionEvent event) throws IOException {
			String name = nameInput.getText();
			int sex;
			if (male.isSelected()) {
				sex = 0;
			}
			else {
				sex = 1;
			}
			char unitsType = unitsSelected();
			
			double bodyweight = Double.parseDouble(bodyweightInput.getText());
			int age = (int) ageInput.getValue(); 
			
			double squatVal = Double.parseDouble(squat.getText());
			double benchpress = Double.parseDouble(benchInput.getText());
			double deadlift = Double.parseDouble(deadliftInput.getText());
			
			Lifter inputtedLifter = new Lifter(name, age, sex, bodyweight, deadlift, benchpress, squatVal);
			
			double wilksVal = inputtedLifter.wilks(unitsType);
			System.out.println(squatVal);
			System.out.println("Name: " + inputtedLifter.getName() + " Age: " + inputtedLifter.getAge() +
					" Squat: " + inputtedLifter.getMaxSquat()
					+ " Bench: " + inputtedLifter.getMaxBench() +
					" Deadlift " + inputtedLifter.getMaxDeadlift());
			String lifterStandard = inputtedLifter.wilkStandards(wilksVal);
			
			
			FXMLLoader switchToResults = new FXMLLoader(getClass().getResource("Results.fxml"));
			root = switchToResults.load();
			ResultsController resultsPage = switchToResults.getController();
			
			resultsPage.getPerson(inputtedLifter);
	}
	
	/**
	 * Clear all the inputed value
	 * @param event
	 */
	public void clear(ActionEvent event) {
		nameInput.clear();
		bodyweightInput.clear();
		squat.clear();
		benchInput.clear();
		deadliftInput.clear();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		units.getItems().addAll(options);
		male.setToggleGroup(group);
		female.setToggleGroup(group);
		units.getSelectionModel().selectFirst();
		unitsSelected();
	}
	
	public void iteratePlaceholder(TextField field[], String message) {
		try {
			for (TextField i: field) {
				i.setPromptText(message);
			}
		}
		catch(NullPointerException e) {
			System.out.println("At least one parameter is null - please enter a value in the missing field!");
		}
	}
}
