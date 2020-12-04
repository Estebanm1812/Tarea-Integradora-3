package model;
import java.util.ArrayList;
public class Club{

	private String name;

	private String nit;
	
	private String creationDate;
	
	private Team [] team;
	
	private ArrayList <Employee> employers;
	
	private Player [][] dresser1;
	
	private Player [][] dresser2;
	
	private Coach [][] office;
	
	public Club(String name, String nit, String creationDate){
		
	this.name = name;
	
	this.nit = nit;
	
	this.creationDate = creationDate;
	
	team = new Team[2];
	
	employers = new ArrayList < Employee>();
	
	dresser1 = new Player[7][6];
	
	dresser2 = new Player[7][7];
	
	office = new Coach[6][6];
	
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
			
			if(team[i]!=null){
			text+= "(" + i + ") " + team[i].getName();
			}
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
			
			text+= employers.get(i).getInfo() + "\n";
			
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
			
			text+= "(" + i + ") " + employers.get(i).getName() + "\n";
			
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
		
		if(employers.get(playerPosition).getState() == State.ACTIVE){
		
		freeSpace = team[teamPosition].addPLayertoTeam();
		team[teamPosition].playerList[freeSpace] = (Player)employers.get(playerPosition);
		}
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
		
		if(employers.get(coachPosition).getState() == State.ACTIVE){
		if(team[teamPosition].coach[0] == null){
		team[teamPosition].coach[0] = (MainCoach) employers.get(coachPosition);
		}
		}
	}
	public void addAssistantToTeam(int assistanPosistion, int teamPosition){
		
		int space = 0;
		if(employers.get(assistanPosistion).getState() == State.ACTIVE){
		space = team[teamPosition].addAssistantToTeam();
		team[teamPosition].assistants[space] = (Assistant) employers.get(assistanPosistion);
		}
	}
	public String addPlayertoDressRoom(int playerPosition, int dresser){
		
		Player tmp = (Player)employers.get(playerPosition);
		
		String text = ""; 
		
		boolean out = false;
		
		boolean out2 = false;
		
		int pos = 0;
		
		int pos2 = 0;
		
		switch(dresser){
		case 1:
		for(int i=0; i < dresser1.length && out==false; i+=2){
			
			
			for(int j=0; j < dresser1[0].length && out2 == false;j+=2){
			
				if(dresser1[i][j] == null){
			
					out = true;
					out2 = true;
					
					pos = i;
					pos2 = j;
				}
			}
		}
		dresser1[pos][pos2] = tmp;
		if(dresser1[pos][pos2] != null){
			text = "El jugador " + employers.get(playerPosition).getName() + " entro al Vestidor";
		}else{
			text = "El jugador no entro correctamenta al vestuario";
		}
		break;
		case 2:
		for(int i=0; i < dresser2.length && out==false; i+=2){
			
			
			for(int j=0; j < dresser2[0].length && out2 == false;j+=2){
			
				if(dresser2[i][j] == null){
			
					out = true;
					out2 = true;
					
					pos = i;
					pos2 = j;
				}
			}
		}
		dresser2[pos][pos2] = tmp;
		if(dresser2[pos][pos2] != null){
			text = "El jugador " + employers.get(playerPosition).getName() + " entro al Vestidor";
		}else{
			text = "El jugador no entro correctamenta al vestuario";
		}
		break;
		}
		return text;
	}
	public String removeFromDresser(int player, int dresser){
		
		Player tmp = (Player)employers.get(player);
		
		String text = ""; 
		
		boolean out = false;
		
		boolean out2 = false;
		
		int pos = 0;
		
		int pos2 = 0;
		
		switch(dresser){
		case 1:
		for(int i=0; i < dresser1.length && out==false; i+=2){
			
			
			for(int j=0; j < dresser1[0].length && out2 == false;j+=2){
			
				if(dresser1[i][j].equals(employers.get(player))){
			
					out = true;
					out2 = true;
					
					pos = i;
					pos2 = j;
				}
			}
		}
		dresser1[pos][pos2] = null;
		if(dresser1[pos][pos2] == null){
			text = "El jugador " + employers.get(player).getName() + " Salio del Vestidor";
		}else{
			text = "El jugador no salio correctamenta al vestuario";
		}
		break;
		case 2:
		for(int i=0; i < dresser2.length && out==false; i+=2){
			
			
			for(int j=0; j < dresser2[0].length && out2 == false;j+=2){
			
				if(dresser2[i][j].equals(employers.get(player))){
			
					out = true;
					out2 = true;
					
					pos = i;
					pos2 = j;
				}
			}
		}
		dresser2[pos][pos2] = null;
		if(dresser2[pos][pos2] == null){
			text = "El jugador " + employers.get(player).getName() + " Salio del vestidor";
		}else{
			text = "El jugador no salio correctamenta al vestuario";
		}
		break;
		}
		return text;
	}
	public String dresserInformation(){
		
		String text = "";
		
		text = "Vestidor 1 \n";
		
		for(int i=0; i < dresser1.length;i++){
			
			for(int j=0; j < dresser1[0].length;j++){
			
				if(dresser1[i][j] == null){
					
					text += "0 \t";
					
				}else{
					
					text += "1 \t";
				}
			
			}
		}
		text += "\n Vestidor 2 \n";
		for(int i=0; i < dresser2.length;i++){
			
			for(int j=0; j < dresser2[0].length;j++){
			
				if(dresser2[i][j] == null){
					
					text += "0 \t";
					
				}else{
					
					text += "1 \t";
				}
			
			}
		}
		return text;
	}
	public void addCoachToOffice(int coach){
		
		boolean out = false;
		
		boolean out2 = false;
		
		int pos = 0;
		
		int pos2 = 0;
		
		if(employers.get(coach).getState() != State.INACTIVE){

		for(int i=0; i < office.length && out == false;i++){
			
			
			for(int j=0; j < office[0].length && out2 == false;j++){
			
				if(office[i][j] == null){	
			
					out = true;
					out2 = true;
					pos = i;
					pos2 = j;
					
				}
			}
		}
		
		if(employers.get(coach) instanceof MainCoach){
		office[pos][pos2] = (MainCoach)employers.get(coach);
		}else if(employers.get(coach) instanceof Assistant){
		office[pos][pos2] = (Assistant)employers.get(coach);	
		}
		}
	}
	public String coachesList(){
		
		String text = "";
		
		for(int i=0; i <employers.size();i++){
			
			if(employers.get(i) instanceof MainCoach || employers.get(i) instanceof Assistant){
				
			
				text+= "(" + i + ") " + employers.get(i).getName() + "\n";
				
			}
		}
		
		return text;
	}
	public void removeFromOffice(int coach){
		
		boolean out = false;
		
		boolean out2 = false;
		
		int pos = 0;
		
		int pos2 = 0;
		
		if(employers.get(coach).getState() != State.INACTIVE){
		
			for(int i=0; i < office.length && out==false; i++)
		
				for(int j=0; j < office[0].length && out2 == false; j++){
					
					if(office[i][j].equals(employers.get(coach))){
					
					pos = i;
					pos2 = j;
					out = true;
					out2 = true;
					
					}
				}
		
		}
		office[pos][pos2] = null;
	}
	public String teamsInfo(){
		
		String text = "";
		
		for(int i=0; i < team.length;i++){
		
			if(team[i] != null){
			
				text += team[i].infoTeam() + "\n";
			}
		}
		return text;
	}
	public String dresserInfo(int choice){
		
		String text = "\n";
		switch(choice){
		
		case 1:
		for(int i=0; i < dresser1.length;i++){
				text+= "\n";
			for(int j=0; j < dresser1[0].length;j++){
			
				if(dresser1[i][j] == null){
					
					text += "0 \t";
					
				}else{
					
					text += dresser1[i][j].getName() + " \t";
				}
			
			}
		}
		break;
		case 2:
		for(int i=0; i < dresser2.length;i++){
			
					text+= "\n";
				
			for(int j=0; j < dresser2[0].length;j++){
			
				if(dresser2[i][j] == null){
					
					text += "0 \t";
					
				}else{
					
					text += dresser2[i][j].getName() +"\t";
				}
			
			}
		}
	}
	return text;
	}
	public String officeInfo(){
		
		String text = "\n";
		
		for(int i=0; i < office.length;i++){
			
			for(int j=0; j < office[0].length;j++){
			
				text+= "\n";
				
				if(office[i][j] == null){
					
					text += "0 \t";
					
				}else{
					
					text += office[i][j].getName() +" \t";
				}
			
			}
		}
		
		
		return text;
	}
	public void createNewLineUp(String chain,String date, int teamPosition){
		
		team[teamPosition].addLineUp(date, chain);
		
	}
	public String showLineUpsForPress(int teamPosition){
		
		String text = "\n";
		
		text += team[teamPosition].lineUpsForPress();
		return text;
	}
}