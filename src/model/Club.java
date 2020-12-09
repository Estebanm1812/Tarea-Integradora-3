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
	
	/**
	*method constructor to create a new Club
	*pos: Club is created
	*@param name, a String with the name of the club
	*@param nit, a String with the identificator of the club
	*@param creationDate, a String of when the club was founded
	*/
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
	/**
	*method that adds a new Team
	*pre: team has empty space
	*pos: a new Team is created in the first empty space
	*@param name, a String with the name of the team
	*/
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
	/**
	*method that shows the current teams with their position in the array team
	*@return text, a String with the names of the teams and their position in the array team
	*/
	public String teamListName(){
		
		String text = "";

		for(int i =0; i < team.length;i++){
			
			if(team[i]!=null){
			text+= "(" + i + ") " + team[i].getName();
			}
		}
		return text;
	}
	/**
	*method that hires a Employee of type player
	*pre: employers is inizialized
	*pos: the arraylist employers increasedt it size and it has a new Player in the last position
	*@param name, a String with the name of the player
	*@param identificator, a String with the id of the player
	*@param salary, a double with the salary of the player
	*@param state, a String with the state of the player
	*@param shirtNumber, an int with the shirtNumber of the player
	*@param gols, a int with the amount of gols that the player has done
	*@param position, a String with the position of the player in the field
	*@param average, a double with the average point that the player has
	*/
	public void hireEmployee(String name, String identificator, double salary, String state, int shirtNumber, int gols, String position, double average){
		
		Player tmp;
		
		tmp = new Player(name, identificator,salary, state, shirtNumber, gols, position, average);
		
		employers.add(tmp);
		
	}
	/**
	*method that hires a new employer of type MainCoach
	*pre: employers is inizialized
	*pos: the arraylist increases it size and has a new MainCoach in the last position
	*@param name, a String with the name of the MainCoach
	*@param identificator, a String with the id of the MainCoach
	*@param salary, a double with the salary of the MainCoach
	*@param state, a String with the state of the MainCoach
	*@param experienceYears, an int with the experienceYears that the MainCoach has
	*@param teamsManaged, an int with the quantity of teams that the MainCoach manage
	*@param wonChampionships,a int with the quantity of championships that the MainCoach has won
	*/
	public void hireEmployee(String name, String identificator, double salary, String state, int experienceYears, int teamsManaged, int wonChampionships){
		
	MainCoach tmp;
	
	tmp = new MainCoach(name, identificator, salary, state, experienceYears, teamsManaged, wonChampionships);
	employers.add(tmp);
	}
	/**
	*method that hires a new employer of type Assistant
	*pre: employers is inizialized
	*pos: the arraylist increases it size and has a new Assistant in the last position
	*@param name, a String with the name of the Assistant
	*@param identificator, a String with the id of the Assistant
	*@param salary, a double with the salary of the Assistant
	*@param state, a String with the state of the Assistant
	*@param experienceYears, an int with the experienceYears that the Assistant has
	*@param wasProfesional, a boolean with the value if he was or not professional
	*@param expertise, a String with the expertise that the assistant has 
	*/
	public void hireEmployee(String name, String identificator, double salary, String state, int experienceYears, boolean wasProfesional, String expertise){
		
	Assistant tmp;
	tmp = new Assistant(name, identificator,salary, state, experienceYears, wasProfesional, expertise);
	employers.add(tmp);	
	}
	/**
	*method that shows the most important information about the current employers
	*@return text, a String with the most important information of the employers.
	*/
	public String employersInfo(){
		
		String text = "";
		
		for(int i=0; i < employers.size();i++){
			
			text+= employers.get(i).getInfo() + "\n";
			
		}
		return text;
		
	}
	/**
	*method that changes the state of a employer from Active no INACTIVE
	*pre: the employer in the position choosed exist and employers is inizialized
	*pos: the state of the choosed employer is now INACTIVE
	*@param position, it is the position of the choosed employer in the arraylist employers
	*/
	public void fireEmployee(int position){
		
		State  txt = State.INACTIVE;
		
		employers.get(position).setState(txt);
		
		
		
	}
	/**
	*method that shows the names of the employers and their position in the arraylist employers
	*@return text, a String with the names and their position in employers
	*/
	public String employersNames(){
		
		String text = "";
		
		for(int i=0; i < employers.size();i++){
			
			text+= "(" + i + ") " + employers.get(i).getName() + "\n";
			
		}
		
		return text;
	}
	/**
	*method that shows the names and the position of the Players in the arraylist employers
	*@return text, a String with the names of the Players and their position in employers
	*/
	public String playersNames(){
		String text = "";
		
		for(int i=0; i < employers.size();i++){
			
			if(employers.get(i) instanceof Player){
			text+= "(" + i + ") " + employers.get(i).getName();
			}
		}
		
		return text;
	}
	/**
	*method that shows the names and the position of the MainCoaches in the arraylist employers
	*@return text, a String with the names of the MainCoaches and their position in employers
	*/
	public String mainCoachNames(){
		String text = "";
		
		for(int i=0; i < employers.size();i++){
			
			if(employers.get(i) instanceof MainCoach){
			text+= "(" + i + ") " + employers.get(i).getName();
			}
		}
		
		return text;
	}
	/**
	*method that shows the names and the position of the Assistants in the arraylist employers
	*@return text, a String with the names of the Assistants and their position in employers
	*/
	public String assistantCoachesNames(){
		String text = "";
		
		for(int i=0; i < employers.size();i++){
			
			if(employers.get(i) instanceof Assistant){
			text+= "(" + i + ") " + employers.get(i).getName();
			}
		}
		
		return text;
	}
	/**
	*method that adds a player to a team
	*pre: employers is inizialized, the player in the playerPosition exist and the team in teamPosition exist
	*pos: the team in teamPosition will have a player in the first empty space in its players array
	*@param playerPosition, it is the position of the player in the arraylist employers
	*@param teamPosition, it is the position of the team in the array team
	*/
	public void addPlayertoTeam(int playerPosition, int teamPosition){
		
		int freeSpace = 0;
		
		if(employers.get(playerPosition).getState() == State.ACTIVE){
		
		freeSpace = team[teamPosition].addPLayertoTeam();
		team[teamPosition].playerList[freeSpace] = (Player)employers.get(playerPosition);
		}
	}
	/**
	*method that shows the list of The MainCoaches
	*@return text, a String with the list of the MainCoaches and their position in employers
	*/
	public String showListOfCoachs(){
		
		String text = "";
		
		for(int i=0; i < employers.size();i++){
			
			
			if(employers.get(i) instanceof MainCoach){
			
				text += "(" + i + ") " + employers.get(i).getName();
			}
		}
		return text;
	}
	/**
	*method that adds the mainCoach to a team
	*pre: employers is inizialized, employers in coachPosition exist and team in teamPosition exist
	*pos: the array coach in the choosed team has a MainCoach in the empty space
	*@param coachPosition, position of the choosed MainCoach in employers
	*@param teamPosition, position of the choseed team in team
	*/
	public void addMainCoachToTeam(int coachPosition, int teamPosition){
		
		if(employers.get(coachPosition).getState() == State.ACTIVE){
		if(team[teamPosition].coach[0] == null){
		team[teamPosition].coach[0] = (MainCoach) employers.get(coachPosition);
		}
		}
	}
	/**
	*method that adds a Assistant to a team
	*pre: employers is inizialized, employers in assistanPosistion exist and team in teamPosition exist
	*pos: the array assistans in the choosed team has a new Assistant in the first empty space
	*@param assistanPosistion, position of the choosed Assistant in employers
	*@param teamPosition, position of the choseed team in team
	*/
	public void addAssistantToTeam(int assistanPosistion, int teamPosition){
		
		int space = 0;
		if(employers.get(assistanPosistion).getState() == State.ACTIVE){
		space = team[teamPosition].addAssistantToTeam();
		team[teamPosition].assistants[space] = (Assistant) employers.get(assistanPosistion);
		}
	}
	/**
	*method that adds a player to a DressRoom
	*pre: dresser1 and dresser2 are inizialized, employers in playerPosition exist
	*pos: the choosed dresser has a Player in the first empty allowed space
	*@param playerPosition, the position of the player in employers
	*@param dresser, which dresser is the player goint to enter
	*@return text, a String with the information if the Player entered or not
	*/
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
	/**
	*method that removes a player from a DressRoom
	*pre: dresser1 and dresser2 are inizialized, employers in player exist
	*pos: the choosed dresser will remove the player and be null in that space
	*@param player, the position of the player in employers
	*@param dresser, which dresser is the player goint to enter
	*@return text, a String with the information if the Player leaved or not
	*/
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
	/**
	*method that shows the information of the dressers
	*pre: dresser1 and dresser2 are inizialized
	*@return text, a String with the current information of the dressers
	*/
	public String dresserInformation(){
		
		String text = "";
		
		text = "Vestidor 1 \n";
		
		for(int i=0; i < dresser1.length;i++){
			
			text+= " \n";
			
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
			text+= "\n";
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
	/**
	*method that adds a coach to the office
	*pre: employers in coach exist
	*pos: the office has a new coach in the first allowed space
	*@param coach, the position of the coach in employers
	*/
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
	/**
	*method that shows the list of the coachesList
	*pre: employers is inizialized
	*@return text, a String with the names of the coaches and their position in employers
	*/
	public String coachesList(){
		
		String text = "";
		
		for(int i=0; i <employers.size();i++){
			
			if(employers.get(i) instanceof MainCoach || employers.get(i) instanceof Assistant){
				
			
				text+= "(" + i + ") " + employers.get(i).getName() + "\n";
				
			}
		}
		
		return text;
	}
	/**
	*method that removes a coach from a office
	*pre: office is inizialized
	*pos: the position where the coach was is null
	*@param coach, the position of the coach in employers
	*/
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
	/**
	*method that saves the most import information of the current teams
	*pre: team is inizialized and the created teams have a MainCoach
	*@return text, a String with the most import information of the current teams
	*/
	public String teamsInfo(){
		
		String text = "";
		
		for(int i=0; i < team.length;i++){
		
			if(team[i] != null){
			
				text += team[i].infoTeam() + "\n";
			}
		}
		return text;
	}
	/**
	*method that saves the current information of the dressers
	*pre: dresser1 and dresser2 are inizialized
	*@param choice, a int with the position of the dresser choosed by the user
	*@return text, a String with the information of the choosed dresser
	*/
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
	/**
	*method that shows the current state of the office
	*pre: office is inizialized
	*@return text, a String with the current state of the office
	*/
	public String officeInfo(){
		
		String text = "\n";
		
		for(int i=0; i < office.length;i++){
			
				text+= "\n";
				
			for(int j=0; j < office[0].length;j++){
			
				
				if(office[i][j] == null){
					
					text += "0 \t";
					
				}else{
					
					text += office[i][j].getName() +" \t";
				}
			
			}
		}
		
		
		return text;
	}
	/**
	*method that create a new LineUp
	*pre: team is inizialized and exist a team in teamPosition
	*pos: a new lineup will be added at the lineup arraylist in the choosed team
	*@param chain, a String with the chain of how the lineup is
	*@param date, a String with the chain of when the luneup will be use
	*@param teamPosition, a int with the position of the choosed team in team
	*/
	public void createNewLineUp(String chain,String date, int teamPosition){
		
		team[teamPosition].addLineUp(date, chain);
		
	}
	/**
	*method that shows the lineUps for the press of a choosed team
	*pre: team is inizialized and team in teamPosition exist
	*@param teamPosition, a int with the positon of the choosed team in team
	*@return text, a String with the information of the lineups of the choosed team;
	*/
	public String showLineUpsForPress(int teamPosition){
		
		String text = "\n";
		
		text += team[teamPosition].lineUpsForPress();
		return text;
	}
}