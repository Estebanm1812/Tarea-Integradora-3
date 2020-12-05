package model;

public class MainCoach extends Coach implements Price{

	private int teamsManaged;
	
	private int wonChampionships;
	/**
	*method that creates a coach
	*@param name, a String with the name of the coach
	*@param salary, a double with the salary of the coach
	*@param identificator, a String with the id number of the coach
	*@param state, a String with the state of the coach
	*@param experienceYears, a int with the amount of experienceYears that the coach has
	*@param teamsManaged, a int with the amount teams that the coach handles
	*@param wonChampionships, a int with the amout of wonChampionships
	*/
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
	/**
	*method that overrides the important information of the Employer
	*pre: MainCoach exist
	*@return text, a String with the important information of the MainCoach
	*/
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
	/**
	*method that calculates the price of the MainCoach in the market
	*pre: MainCoach exists
	*@return price, a double with the price of the MainCoach in the market
	*/
	public double calculatePrice(){
		
		double price = 0;
		
		
		price = (getSalary()*10) + (getExperienceYears()*100) + (getWonChampionships()*50); 
		return price;
	}
	/**
	*method that calculate the level of the MainCoach
	*pre: MainCoach exists
	*@return lvl, a double with the level of the MainCoach
	*/
	public double calculateLevel(){
		
		double lvl = 0;
		
		lvl = 5 + (getWonChampionships()/10);
		
		return lvl;
	}
}