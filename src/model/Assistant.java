package model;
public class Assistant extends Coach{

	private boolean wasProfesional;
	private Expertise expertise;
	/**
	*method constructor that creates a new Assistnat
	*pos: a new Assistant is created
	*@param name, a String with the name of the assistant
	*@param identificator, a String with the id of the assistant
	*@param salary, a double with the salary of the assistant
	*@param state, a String with the State of the assistant
	*@param experienceYears, a int with the experienceYears of the assistant
	*@param wasProfesional, a boolean that has if the assistant was or not professional
	*@param expertise, a String with the expertise of the assistant
	*/
	public Assistant(String name, String identificator, double salary, String state, int experienceYears, boolean wasProfesional, String expertise){
		
				super(name,identificator,salary,state, experienceYears);

	this.wasProfesional = wasProfesional;
	this.expertise = Expertise.valueOf(expertise);
	
	}
	public boolean getWasProfesional(){
		return wasProfesional;
	}
	public void setWasProfesional(boolean wasProfesional){
		this.wasProfesional = wasProfesional;
	}
	public Expertise getExpertise(){
		return expertise;
	}
	public void setExpertise(Expertise expertise){
		this.expertise = expertise;
	}
	@Override
	/**
	*method that overrides the important information of the Employer
	*pre: Assistant exist
	*@return text, a String with the important information of the Assistant
	*/
	public String getInfo(){
		
		String text = "";
		
		text = "ASSISTANT COACH\n" +
			   "nombre: " + getName() +
			   "\n Identificador: " + getIdentificator() +
			   "\n Salario: " + getSalary() +
			   "\n Años de Experiencia: " + getExperienceYears() +
			   "\n Era Profesional: " + getWasProfesional() +
			   "\n Experiencia: " + getExpertise() +
			   "\n Estado: " + getState();
			   
		return text;
	}
	
}