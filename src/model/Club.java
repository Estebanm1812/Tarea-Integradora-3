package model;
import java.util.ArrayList;
public class Club{

	private String name;

	private String nit;
	
	private String creationDate;
	
	private Team [] team;
	
	private ArrayList <Employee> employers;
	
	
	public Club(String name, String nit, String creationDate){
		
	this.name = name;
	
	this.nit = nit;
	
	this.creationDate = creationDate;
	
	team = new Team[2];
	
	employers = new ArrayList < Employee>();
	
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getNit(){
		return nit;
	}
	public void setNit(String nit){
		this.nit = nit;
	}
	public String getCreationDate(){
		return creationDate;
	}
	public void setCreationDate(String creationDate){
		this.creationDate = creationDate;
	}
	public Team[] getTeam(){
		return team;
	}
	public void setTeam(Team[] team){
		this.team = team;
	}
	public ArrayList <Employee> getEmployers(){
		return employers;
	}
	public void setEmployers(ArrayList <Employee> employers){
		this.employers = employers;
	}
	
	public void addTeam(String name){
	
	int pos=0;
	boolean out = false;
		for(int i=0; i < team.length && out==false;i++){
	
			if(team[i] == null){
			
				pos = i;
				out = true;
			}
		}
		team[pos]= new Team(name);
	}
	public String teamListName(){
		
		String text = "";

		for(int i =0; i < team.length;i++){
			
			text+= "(" + i + ")" + team[i].getName();
			
		}
		return text;
	}
	public void hireEmployee(String name, String identificator, double salary, String state, int shirtNumber, int gols, String position, double average){
		
		Player tmp;
		
		tmp = new Player(name, identificator,salary, state, shirtNumber, gols, position, average);
		
		employers.add(tmp);
		
	}
	
	public void hireEmployee(String name, String identificator, double salary, String state, int experienceYears, int teamsManaged, int wonChampionships){
		
	MainCoach tmp;
	
	tmp = new MainCoach(name, identificator, salary, state, experienceYears, teamsManaged, wonChampionships);
	employers.add(tmp);
	}
	
	public void hireEmployee(String name, String identificator, double salary, String state, int experienceYears, boolean wasProfesional, String expertise){
		
	Assistant tmp;
	tmp = new Assistant(name, identificator,salary, state, experienceYears, wasProfesional, expertise);
	employers.add(tmp);	
	}
	public String employersInfo(){
		
		String text = "";
		
		for(int i=0; i < employers.size();i++){
			
			text+= employers.get(i).getInfo();
			
		}
		return text;
		
	}
	public void fireEmployee(int position){
		
		State  txt = State.INACTIVE;
		
		employers.get(position).setState(txt);
		
		
		
	}
	public String employersNames(){
		
		String text = "";
		
		for(int i=0; i < employers.size();i++){
			
			text+= "(" + i + ") " + employers.get(i).getName();
			
		}
		
		return text;
	}
	public String playersNames(){
		String text = "";
		
		for(int i=0; i < employers.size();i++){
			
			if(employers.get(i) instanceof Player){
			text+= "(" + i + ") " + employers.get(i).getName();
			}
		}
		
		return text;
	}
	public String mainCoachNames(){
		String text = "";
		
		for(int i=0; i < employers.size();i++){
			
			if(employers.get(i) instanceof MainCoach){
			text+= "(" + i + ") " + employers.get(i).getName();
			}
		}
		
		return text;
	}
	public String assistantCoachesNames(){
		String text = "";
		
		for(int i=0; i < employers.size();i++){
			
			if(employers.get(i) instanceof Assistant){
			text+= "(" + i + ") " + employers.get(i).getName();
			}
		}
		
		return text;
	}
	public void addPlayertoTeam(int playerPosition, int teamPosition){
		
		int freeSpace = 0;
		
		freeSpace = team[teamPosition].addPLayertoTeam();
		team[teamPosition].playerList[freeSpace] = (Player)employers.get(playerPosition);
	}
	public String showListOfCoachs(){
		
		String text = "";
		
		for(int i=0; i < employers.size();i++){
			
			
			if(employers.get(i) instanceof MainCoach){
			
				text += "(" + i + ") " + employers.get(i).getName();
			}
		}
		return text;
	}
	public void addMainCoachToTeam(int coachPosition, int teamPosition){
		
		if(team[teamPosition].coach[1] == null){
		team[teamPosition].coach[1] = (MainCoach) employers.get(coachPosition);
		}
		
	}
	public void addAssistantToTeam(int assistanPosistion, int teamPosition){
		
		int space = 0;
		space = team[teamPosition].addAssistantToTeam();
		team[teamPosition].assistants[space] = (Assistant) employers.get(assistanPosistion);
	}
}