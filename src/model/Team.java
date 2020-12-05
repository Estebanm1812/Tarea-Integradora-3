package model;
import java.util.ArrayList;
public class Team{

	protected String name;
	
	protected ArrayList <LineUp> lineUps;
	
	protected Player [] playerList;
	
	protected MainCoach [] coach;
	
	protected Assistant[] assistants;
	
	/**
	*method that creates a new team
	*pos: team is created
	*@param name, a String with the name of the team
	*/
	public Team(String name){
	
	this.name = name;
	
	playerList = new Player[25];
	
	lineUps = new ArrayList <LineUp>(); 
	
	assistants =new Assistant[3];
	
	coach = new MainCoach[1];

	
	}
	public String getName(){
	return name;	
	}
	public void setName(String name){
		this.name = name;
	}
	public ArrayList<LineUp> getLineUps(){
		return lineUps;
	}
	public void setLineUp(ArrayList <LineUp> lineUps){
		this.lineUps = lineUps;
	}
	public Player[] getPlayerList(){
		return playerList;
	}
	public void setPlaterList(Player [] playerList){
		this.playerList = playerList;
	}
	public MainCoach[] getMainCoach(){
		return coach;
	}
	public void setMainCoach(MainCoach[] coach){
		this.coach = coach;
	}
	public Assistant[] getAssistants(){
		return assistants;
	}
	public void setAssistans(Assistant[] assistants){
		this.assistants = assistants;
	}
	/**
	*method that find the first empty space in the playerList
	*pre: team is inizialized
	*@return pos, a int with the first free space found in playerList
	*/
	public int addPLayertoTeam(){
	
		int pos =0;
		boolean out = false;
		
		for(int i=0; i < playerList.length && out==false;i++){
			
			if(playerList[i] == null){
				
				pos = i;
				out = true;
			}
		}
		return pos;
	}
	/**
	*method that saves the important information of the team
	*pre: Team is inizialized
	*@return text, a String with the important information of the team
	*/
	public String infoTeam(){
		
		
		String text = "";

		String coachName = "";
		
		
		String assistansNames = "";
		
		String playersNames = "";
		
		String formations = "";
		
		if(coach[0].getState() == State.ACTIVE && coach[0] != null){
			
			coachName = coach[0].getName();
		}
		
		for(int i=0; i < assistants.length ;i++){
			
			if(assistants[i] != null){  
				if(assistants[i].getState() == State.INACTIVE){
			
					assistants[i] = null;
				}else{
				assistansNames+= assistants[i].getName() + ", ";
				}
			}
		}
		for(int i=0; i < playerList.length;i++){
			
			if(playerList[i] != null){
			
				if(playerList[i].getState() == State.INACTIVE){
				
					playerList[i] = null;
				}else{
				playersNames+= playerList[i].getName() + ", ";
				}
			}
		}
		for(int i=0; i < lineUps.size();i++){
				if(lineUps.get(i) != null){
			formations+= lineUps.get(i).getChain() + ", ";
				}
		}
		text+= "TEAM\n" +
				"Entrenador principal : " + coachName + 
				"\n Entrenadores Asistentes: " + assistansNames +
				"\n Jugadores: " + playersNames +
				"\n Formaciones usadas: "+ formations;
		return text;
	}
	/**
	*method that find the first empty space in the assistants array
	*pre: Team is inizialized
	*@return pos, a int with the first free space in assistants
	*/
	public int addAssistantToTeam(){
		
		int pos = 0;
		boolean out = false;
		
		for(int i=0; i < assistants.length && out==false;i++){
			
			if(assistants[i] == null){
			
				pos = i;
				out = true;
			}
		}
		return pos;
	}
	/**
	*method that adds a new lineup to the lineUps arraylist
	*pre: Team is inizialized
	*pos: lineUps increases its size and has a new lineup in the last position
	*@param date, a String with the date from when the lineUps was used
	*@param chain, a String with the formation that will be used
	*/
	public void addLineUp(String date, String chain ){
		
		LineUp tmp = new LineUp(date,chain);
		lineUps.add(tmp);
		
	}
	/**
	*method that saves the lineUps of the team
	*pre: Team is inizialized
	*@return text, a String with the lineUps in the way to show to the press
	*/
	public String lineUpsForPress(){
		
		String text = "\n";
		
		for(int i=0; i < lineUps.size();i++){
		
			text+= lineUps.get(i).showMatrix();
		
		}
		return text;
	}
	
}
