package model;

public abstract class Coach extends Employee{

	private int experienceYears;
	
	public Coach(String name, String identificator, double salary, String state, int experienceYears){
		
		super(name, identificator, salary, state);
		this.experienceYears = experienceYears;
	}
	public int getExperienceYears(){
		return experienceYears;
	}
	public void setExperienceYears(int experienceYears){
		this.experienceYears = experienceYears;
	}
	
}