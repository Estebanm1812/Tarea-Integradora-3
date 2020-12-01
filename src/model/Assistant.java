package model;
public class Assistant extends Coach{

	private boolean wasProfesional;
	private Expertise expertise;
	
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