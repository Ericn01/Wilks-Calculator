package model;

public class Person {
	
	private String name;
	private int age;
	private int sex;
	private int experienceLevel;
	private double maxDeadlift;
	private double maxBench;
	private double maxSquat;
	private double bodyweight;
	
	public Person(String name, int age, int sex, int experienceLevel, double maxDeadlift, double bodyweight, double maxBench, double maxSquat) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.bodyweight = bodyweight;
		this.experienceLevel = experienceLevel;
		this.maxDeadlift = maxDeadlift;
		this.maxBench = maxBench;
		this.maxSquat = maxSquat;
	}
	/**
	 * Calculates the number of wilks that the individual's lifts is worth
	 * @return wilks the value of wilks
	 */
	public double wilks() {
		final double TOP_COEFFICIENT = 500.0;
		double totalLifted = getTotalLifted(); // total lifted by user in kilograms
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
				b * bodyweight + 
				c * Math.pow(bodyweight , 2) + 
				d * Math.pow(bodyweight, 3) + 
				e * Math.pow(bodyweight, 4) + 
				f * Math.pow(bodyweight, 5))) * totalLifted; 
		
		return wilks;
	}
	
	public double getTotalLifted() {
		double totalLifted = maxSquat + maxBench + maxDeadlift;
		return totalLifted;
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
	public int getExperienceLevel() {
		return experienceLevel;
	}
	public void setExperienceLevel(int experienceLevel) {
		this.experienceLevel = experienceLevel;
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
	public void setMaxBench(double maxBench) {
		this.maxBench = maxBench;
	}
	public double getMaxSquat() {
		return maxSquat;
	}
	public void setMaxSquat(double maxSquat) {
		this.maxSquat = maxSquat;
	}
	
	
	
}
