package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Lifter;

public class ResultsController implements Initializable {
	
	@FXML
	private Label name;
	@FXML 
	private Label age;
	@FXML
	private Label sex;
	@FXML 
	private Label totalLifted;
	@FXML
	private Label totalWilks;
	@FXML
	private Label percentile;
	@FXML
	private Label performanceLevel;
	@FXML
	private Label resultMessage;
	@FXML
	private Button mainScene;
	
	
	public Lifter getPerson(Lifter person) {
		return person;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// Block 1
		name.setText("");
		age.setText("");
		sex.setText("");
		// Block 2
		totalLifted.setText("");
		totalWilks.setText("");
		percentile.setText("");
		performanceLevel.setText("");
		// performance summary
		resultMessage.setText("");
	}
}
