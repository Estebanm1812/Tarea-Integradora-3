package model;
public abstract class Employee{

	private String name;
	
	private String identificator;
	
	private double salary;
	
	private State state;
	
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
	
	public String getInfo(){
		
		String text = "";
		
		return text;
	}
}