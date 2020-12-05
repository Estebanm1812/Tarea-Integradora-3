package model;

public abstract class Coach extends Employee{

	private int experienceYears;
	
	/**
	*method that creates a coach
	*@param name, a String with the name of the coach
	*@param salary, a double with the salary of the coach
	*@param identificator, a String with the id number of the coach
	*@param state, a String with the state of the coach
	*@param experienceYears, a int with the amount of experienceYears that the coach has
	*/
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