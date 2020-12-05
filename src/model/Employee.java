package model;
public abstract class Employee{

	private String name;
	
	private String identificator;
	
	private double salary;
	
	private State state;
	
	/**
	*method that creates a new Employee
	*@param name, a String with the name of the employee
	*@param salary, a double with the salary of the  employee
	*@param identificator, a String with the id number of the employee
	*@param state, a String with the state of the employee
	*/
	public Employee(String name, String identificator, double salary, String state){
		
		this.name = name;
			
		this.identificator = identificator;
		
		this.salary = salary;
		
		this.state = State.valueOf(state);
			
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getIdentificator(){
		return identificator;
	}
	public void setIdentificator(String identificator){
		this.identificator = identificator;
	}
	public double getSalary(){
		return salary;
	}
	public void setSalary(double salary){
		this.salary = salary;
	}
	public State getState(){
		return state;
	}
	public void setState(State state){
		this.state = state;
	}
	/**
	*method that saves the information of the employer that will be override in the subclases
	*pre: Employee exist
	*@return text, a String with the information of the employer
	*/
	public String getInfo(){
		
		String text = "";
		
		return text;
	}
}