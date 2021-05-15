package model;

import java.util.InputMismatchException;

import exceptions.NegativeValueException;

public class Lifter {
	
	private String name;
	private int age;
	private int sex;
	private double maxDeadlift;
	private double maxBench;
	private double maxSquat;
	private double bodyweight;
	
	public Lifter(String name, int age, int sex, double bodyweight, double maxDeadlift, double maxBench, double maxSquat) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.bodyweight = bodyweight;
		this.maxDeadlift = maxDeadlift;
		this.maxBench = maxBench;
		this.maxSquat = maxSquat;
	}
	public double toKilos(char type, double weight) {
		double kilos = 0;
		switch(type) {
		case 'L': 
			kilos = weight / 2.205;
			break;
		case 'P':
			kilos = weight * 6.35029;
			break;
		case 'K':
			kilos = weight;
			break;
		default:
			System.out.println("Invalid weight unit entered!");
			break;
		}
		return kilos;
	}
	
	public String wilkStandards(double wilks) {
		String lifterStandard;
		if (wilks < 250.0) {
			lifterStandard = "Beginner";
		}
		else if (wilks >= 250.0 && wilks < 300) {
			lifterStandard = "Novice";
		}
		else if (wilks >= 300 && wilks <= 350) {
			lifterStandard = "Intermediate";
		}
		else if (wilks >= 350 && wilks <= 400) {
			lifterStandard = "Advanced";
		}
		else if (wilks >= 400 && wilks <= 450) {
			lifterStandard = "Expert";
		}
		else if (wilks >= 450 && wilks <= 500) {
			lifterStandard = "Elite";
		}
		else if (wilks >= 500 && wilks <= 550) {
			lifterStandard = "Super Elite";
		}
		else {
			lifterStandard = "Strongest ever";
		}
		return lifterStandard;
	}
	public double ageRatio() {
		double ratio;
		if (age >= 14 && age <= 17) {
			ratio = 1.13;
		}
		else if (age >= 18 && age <= 23) {
			ratio = 1.02;
		}
		else if (age >= 24 && age <= 39) {
			ratio = 1.0;
		}
		else if (age >= 40 && age <= 49) {
			ratio = 1.05;
		}
		else if (age >= 50 && age <= 59) {
			ratio = 1.17;
		}
		else if (age >= 60 && age <= 69) {
			ratio = 1.31;
		}
		else if (age >= 70 && age <= 79) {
			ratio = 1.45;
		}
		else {
			ratio = 1.56;
		}
		return ratio;
	}
	/**
	 * Calculates the number of wilks that the individual's lifts is worth
	 * @return wilks the value of wilks
	 */
	public double wilks(char units) {
		double ageRatio = ageRatio();
		final double TOP_COEFFICIENT = 500.0;
		double totalLifted = maxSquat + maxBench + maxDeadlift; // total lifted by user in kilograms
		
		double totalLiftedKilos = toKilos(units, totalLifted);
		double bodyweightKilos = toKilos (units, bodyweight);
		
		System.out.println(ageRatio + ", " + totalLiftedKilos + "kg");
		// declaring variables
		double a;
		double b;
		double c;
		double d;
		double e;
		double f;
		double wilks = 0;
		// men
		if (sex == 0) { 
			a = -216.0475144;
			b = 16.2606339;
			c = -0.002388645;
			d = -0.00113732;
			e = 0.00000701863;
			f = -0.00000001291;
		}
		// women
		else {
			a = 594.31747775582;
			b = -27.23842536447;
			c = 0.82112226871;
			d = -0.00930733913;
			e = 0.00004731582;
			f = -0.00000009054;
		}
	
		wilks = (TOP_COEFFICIENT / (
				a + 
				b * bodyweightKilos + 
				c * Math.pow(bodyweightKilos , 2) + 
				d * Math.pow(bodyweightKilos, 3) + 
				e * Math.pow(bodyweightKilos, 4) + 
				f * Math.pow(bodyweightKilos, 5))) * totalLiftedKilos * ageRatio; 
		return wilks;
	}
	/**
	 * Getters and setters
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public double getBodyweight() {
		return bodyweight;
	}
	public void setBodyweight(double bodyweight) {
		this.bodyweight = bodyweight;
	}

	public double getMaxDeadlift() {
		return maxDeadlift;
	}
	public void setMaxDeadlift(double maxDeadlift) {
		this.maxDeadlift = maxDeadlift;
	}
	public double getMaxBench() {
		return maxBench;
	}
	public void setMaxBench(double maxBench) throws NegativeValueException {
		try {
			this.maxBench = maxBench;
		}
		catch(InputMismatchException e) {
			System.out.println("Please enter a numerical value!");
		}
		
	}
	public double getMaxSquat() {
		return maxSquat;
	}
	public void setMaxSquat(double maxSquat) {
		this.maxSquat = maxSquat;
	}
	
	
	
}
