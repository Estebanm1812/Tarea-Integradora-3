package model;
import java.util.ArrayList;
public class Team{

	protected String name;
	
	protected ArrayList <LineUp> lineUps;
	
	protected Player [] playerList;
	
	protected MainCoach [] coach;
	
	protected Assistant[] assistants;
	
	
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
	public String infoTeam(){
		
		String text = "";
		
		
		return text;
	}
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
}
