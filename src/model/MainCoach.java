package model;

public class MainCoach extends Coach implements Price{

	private int teamsManaged;
	
	private int wonChampionships;

	public MainCoach(String name, String identificator, double salary, String state, int experienceYears, int teamsManaged, int wonChampionships){
	
		super(name,identificator,salary, state ,experienceYears);
		this.teamsManaged = teamsManaged;
		
		this.wonChampionships = wonChampionships;
	}
	public int getTeamsManaged(){
		return teamsManaged;
	}
	public void setTeamsManaged(int teamsManaged){
		this.teamsManaged = teamsManaged;
	}
	public int getWonChampionships(){
		return wonChampionships;
	}
	public void setWonChampionships(int wonChampionships){
		this.wonChampionships = wonChampionships;
	}
	@Override
	public String getInfo(){
		
		String text = "";
		
		text = "MAIN COACH\n" +
			   "nombre: " + getName() +
			   "\n Identificador: " + getIdentificator() +
			   "\n Salario: " + getSalary() +
			   "\n Años de Experiencia: " + getExperienceYears() +
			   "\n Equipos que maneja: " + getTeamsManaged() +
			   "\n Campeonatos Ganados: " + getWonChampionships() +
			   "\n Estado: " + getState() +
			   "\n Precio: " + calculatePrice() +
			   "\n Nivel: " + calculateLevel();
			   
		return text;
	}
	public double calculatePrice(){
		
		double price = 0;
		
		
		price = (getSalary()*10) + (getExperienceYears()*100) + (getWonChampionships()*50); 
		return price;
	}
	public double calculateLevel(){
		
		double lvl = 0;
		
		lvl = 5 + (getWonChampionships()/10);
		
		return lvl;
	}
}