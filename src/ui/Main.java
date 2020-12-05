package ui;
import java.util.Scanner;
import model.Club;
public class Main{
	
	private Club club;
	private Scanner sc;
	
	public Main(){
		
		sc = new Scanner(System.in);
	}
	
	public static void main(String[]args){
		
		int option = 0;
		
		System.out.println("Iniciando la Aplicacion");

		Main app = new Main();
		app.createClub();
		do{
			option= app.showMenu();
			app.executeOperation(option);
			
		}while (option!=0 );
	}
	/**
	*method that creates a new club
	*pos: club is created
	*/
	public void createClub(){
	
		String name = "";
		
		String nit;
		
		String creationDate;
		
		System.out.println("Ingrese el nombre del club");
		name = sc.nextLine();
		System.out.println("Ingrese el nit del club");
		nit = sc.nextLine();
		System.out.println("Ingrese la fecha de cuando se creo el club");
		creationDate = sc.nextLine();
		
		club = new Club(name, nit, creationDate);
		
	}
	/**
	*method that shows the menu of the possible operations
	*@return option, it is the action that the user choosed
	*/
	public int showMenu(){
		
		int option = 0;
		
		System.out.println("Elija una opcion: \n" +
						   "(0) Para terminar la app\n" +
						   "(1) Para Abrir el Menu de Equipos\n" +
						   "(2) Para Abrir el menu de Empleados\n" +
						   "(3) Para Abrir el Menu de Vestidores\n" +
						   "(4) Para Abrir el Menu De Oficinas\n"
		


		);
		option = sc.nextInt();
		sc.nextLine();
		return option;
	}
	/**
	*method that executes the operation selected by the user
	*pre: the method showMenu shows the options to the user
	*@param option, it is the option that user choosed
	*/
	public void executeOperation(int option){
		
		switch(option){
			
		case 0: System.out.println("Adieu");
		break;
		case 1: 
		int option4 = 0;
		do{
			option4 = teamMenu();
			teamExecuteOperation(option4);
		}while(option4!=0);
		break;
		case 2: 
		int option2=0;
		do{
			option2 = employeeMenu();
			employeeExecuteOperation(option2);
			}while(option2!=0);
		break;
		case 3:
		int option5 = 0;
		do{
			option5 = dresserMenu();
			dresserExecuteOperation(option5);
			}while(option5!=0);
		break;
		case 4:
		int option6 = 0;
		do{
			option6 = officeMenu();
			officeExecuteOperation(option6);
			}while(option6!=0);
		}
	}
	/**
	*method that adds a new Team to the club
	*pre: club is initizialized and has empty position
	*pos: a new team is created in the first empty position
	*/
	public void addTeam(){
		
	String name;
	
	System.out.println("Ingrese el nombre del equipo");
	name = sc.nextLine();
	
	club.addTeam(name);
	System.out.println("Se ha añadido el equipo " + name);
	}
	/**
	*method that create a new player
	*pre: club is initizialized
	*pos: the arraylist Employer increases it size with a new player
	*/
	public void addPlayer(){
		
	String name;
	
	String id;
	
	double salary =0;
	
	int shirtNumber =0;
	
	int gols=0;
	
	String position = "";
	
	double average =0;
	
	int option = 0;
	
	String state = "ACTIVE";
	
	int option3 =0;
	
	System.out.println("Ingrese el nombre del jugador");
	name = sc.nextLine();
	System.out.println("Ingrese el id del jugador");
	id = sc.nextLine();
	System.out.println("Ingrese el salario del jugador");
	salary = sc.nextDouble();
	System.out.println("Ingrese el numero de camiseta del jugador");
	shirtNumber = sc.nextInt();
	sc.nextLine();
	System.out.println("Ingrese la cantidad de goles hechos por el jugador");
	gols = sc.nextInt();
	sc.nextLine();
	System.out.println("Ingrese el promedio del jugador");
	average = sc.nextDouble();
	System.out.println("Seleccione la posicion del Jugador: \n" +
					   "(1) Portero\n" +
					   "(2) Defensor\n" +
					   "(3) Volante\n" +
					   "(4) Delantero\n");
	option = sc.nextInt();
	sc.nextLine();
	switch(option){
		
		case 1:  position = "DOORMAN";
		break;
		case 2:  position = "DEFENDER";
		break;
		case 3:  position = "VOLANTE";
		break;
		case 4: position = "STRIKER";
	}
			
	club.hireEmployee(name, id, salary,state,  shirtNumber, gols, position, average);
		
	}
	/**
	*method that shows to the user the list of what he can do related to the users
	*pre: showMenu works
	*@return option, the action that the user decided to do
	*/
	public int employeeMenu(){
		
		int option =0;
		
		System.out.println("Elija una opcion\n" +
						   "(0) Para salir del menu\n" +
						   "(1) Para añadir un jugador\n" +
						   "(2) Para añadir un Entrenador Principal\n" +
						   "(3) Para añadir un Entrenador Assistente\n" +
						   "(4) Para ver la lista de Empleados\n" +
						   "(5) Para Despedir un Empleado"
						   );
		option = sc.nextInt();
		sc.nextLine();
		return option;
	}
	/**
	*method that executes the choosed option from the employeeMenu
	*pre: employeeMenu and showMenu works
	*@param option, it is the choosed option by the user
	*/
	public void employeeExecuteOperation(int option){
		
		switch(option){
		
		case 1: addPlayer();
		break;
		case 2: addMainCoach();
		break;
		case 3: addAssistant();
		break;
		case 4:
		String text = club.employersInfo();
		System.out.println(text);
		break;
		case 5: fireEmployee();
		}
	}
	/**
	*method that adds a new Employer of type Main Coach
	*pre: club is initizialized
	*pos: the arraylist employers has a new Employer of type MainCoach
	*/
	public void addMainCoach(){
		
		String name;
	
		String id;
	
		double salary =0;
	
		int experienceYears =0;
		
		int managedTeams =0;
		
		int wonChampionships =0;
		
		String state = "ACTIVE";
		
		System.out.println("Ingrese el nombre del Coach");
		name = sc.nextLine();
		System.out.println("Ingrese el Id del coach");
		id = sc.nextLine();
		System.out.println("Ingrese el salario del coach");
		salary = sc.nextDouble();
		System.out.println("Ingrese los años de experiencia del coach");
		experienceYears = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese la cantidad de equipos que maneja");
		managedTeams = sc.nextInt();
		sc.nextLine();
		System.out.println("Ingrese cuantos campeonatos ha ganado");
		wonChampionships = sc.nextInt();
		sc.nextLine();
			
		club.hireEmployee(name, id, salary, state, experienceYears, managedTeams, wonChampionships);
	}
	/**
	*method that adds a new Employer of type Assitant to the club
	*pre: club is initizialized
	*pos: the arraylist employers has a new Employer of type Assistant
	*/
	public void addAssistant(){
		
		String name ="";
	
		String id = "" ;
	
		double salary =0;
		
		int experienceYears =0;
		
		boolean wasProfesional = false;
		
		String expertise = "";
		
		String state = "ACTIVE";	
			
		int option=0;
		
		int option2=0;
		
		int option3=0;
		
		System.out.println("Ingrese el nombre del Coach");
		name = sc.nextLine();
		System.out.println("Ingrese el Id del coach");
		id = sc.nextLine();
		System.out.println("Ingrese el salario del coach");
		salary = sc.nextDouble();
		System.out.println("Ingrese los años de experiencia del coach");
		experienceYears = sc.nextInt();
		sc.nextLine();
		System.out.println("El Coach fue profesional?\n " +
						   "(1) Para Si\n" +
						   "(2) Para No\n");
		option = sc.nextInt();
		sc.nextLine();
		switch(option){
			
			case 1: wasProfesional = true;
			break;
			case 2: wasProfesional = false;
			break;
			
		}
		System.out.println("Que experiencia tiene?\n"+
						   "(1) Para Ofensivo\n" + 
						   "(2) Para Defensivo\n" +
						   "(3) Para Posesion\n" +
						   "(4) Para Jugadas de Laboratorio");
		option2 = sc.nextInt();
		sc.nextLine();
		switch(option2){
			
			case 1: expertise = "OFENSIVE";
			break;
			case 2: expertise = "DEFENSIVE";
			break;
			case 3: expertise = "POSESION";
			break;
			case 4: expertise = "LABPLAYS";
			break;
			
		}
		
		club.hireEmployee(name, id, salary, state, experienceYears, wasProfesional, expertise);
	}
	/**
	*method that changes the state of a Employee from active to inactive
	*pre: there is at least one Employee created and the method employersNames in the Club works
	*pos: the state of the choosed Employee changes from active to inactive
	*/
	public void fireEmployee(){
		
		int position = 0;
		
		System.out.println(club.employersNames());
		position = sc.nextInt();
		sc.nextLine();
		
		club.fireEmployee(position);
	}
	/**
	*method that shows the list of actions that the user can do related to the teams
	*pre: the method showMenu works and club is initizialized
	*@return option, an int with the choosed option by the user
	*/
	public int teamMenu(){
		
		int option = 0;
		
		System.out.println("Seleccione una Opcion: \n" +
						   "(0) Para Volver al menu principal\n" +
						   "(1) Para Crear un Equipo\n" +
						   "(2) Para añadir un Jugador a un equipo\n" +
						   "(3) Para Añadir el Coach principal del Equipo\n" +
						   "(4) Para Añadir un Entrenador Assistente\n" +
						   "(5) Para Añadir una Formacion\n" +
						   "(6) Para Ver las Formaciones para la prensa\n" +
						   "(7) Para Ver la informacion de los Equipos"
							);
		option = sc.nextInt();
		sc.nextLine();
		return option;
	}
	/**
	*method that executes the choosed option by the user from the TeamMenu
	*pre: teamMenu, showMenu and executeOperation work
	*@param option, it is an int with the choosed option by the user
	*/
	public void teamExecuteOperation(int option){
		
		switch(option){
		
		case 1: addTeam();
		break;
		case 2: addPlayerToTeam();
		break;
		case 3: addMainCoachToTeam();
		break;
		case 4: addAssistantCoachToTeam();
		break;
		case 5: addLineUp();
		break;
		case 6: showLineUps();
		break;
		case 7: System.out.println(club.teamsInfo());
		break;
		}
	}
	/**
	*method that adds a choosed player to a choosed team
	*pre: there is at least one team and player created
	*pos: a new player will be added in the first empty space in the array players in the choosed team
	*/
	public void addPlayerToTeam(){
		
		int position = 0;
		
		int teamPosition = 0;
		
		System.out.println(club.teamListName());
		teamPosition = sc.nextInt();
		sc.nextLine();
		System.out.println(club.playersNames());
		position = sc.nextInt();
		sc.nextLine();
		club.addPlayertoTeam(position, teamPosition);
	}
	/**
	*method that adds a choosed MainCoach to a choosed Team
	*pre: club is initizialized, there is at least one MainCoach and team created
	*pos: the choosed Team has a new MainCoach
	*/
	public void addMainCoachToTeam(){
		
		int position = 0;
		
		int teamPosition = 0;
		
		System.out.println(club.teamListName());
		teamPosition = sc.nextInt();
		sc.nextLine();
		System.out.println(club.mainCoachNames());
		position = sc.nextInt();
		sc.nextLine();
		club.addMainCoachToTeam(position, teamPosition);
		
		
	}
	/**
	*method that adds a choosed Assistant to the choosed team
	*pre: club initizialized, there is atleast one team and Assitant created
	*pos: the choosed team has a new Assistant in the first empty position of the assistants
	*/
	public void addAssistantCoachToTeam(){
		
		int position = 0;
		
		int teamPosition = 0;
		
		System.out.println(club.teamListName());
		teamPosition = sc.nextInt();
		sc.nextLine();
		System.out.println(club.assistantCoachesNames());
		position = sc.nextInt();
		sc.nextLine();
		club.addAssistantToTeam(position, teamPosition);
	}
	/**
	*method that adds a player to the choosed dresser
	*pre: club is initizialized and there is at least one user created
	*pos: the choosed dresser has a new Player in its first free space
	*/
	public void addPlayertoDresser(){
		
		int player = 0;
		
		int dresser = 0;
		
		String text = "";
		
		System.out.println(club.playersNames());
		player =sc.nextInt();
		sc.nextLine();
		do{
		System.out.println("En que Vestidor va entrar?");
		dresser = sc.nextInt();
		sc.nextLine();
		}while(dresser!=2 && dresser!=1);
		text = club.addPlayertoDressRoom(player, dresser);
		System.out.println(text);
	}
	/**
	*method that shows to the user the list of actions he can do related to the dressers
	*pre: club initizialized
	*@return option, an int with the choosed option by the user
	*/
	public int dresserMenu(){
		
		int option = 0;
		
		System.out.println("Elija una opcion:\n" +
						   "(0) Para Volver al menu Principal\n" +
						   "(1) Para agregar un jugador a un Vestidor\n" +
						   "(2) Para Sacar un jugador de un Vestidor\n" +
						   "(3) Para ver la informacion de los Vestidores\n" +
						   "(4) Para ver la Informacion de uno De los Vestidores\n"
							);
							
		option = sc.nextInt();
		sc.nextLine();
		return option;
	}
	/**
	*method that executes the choosed option by the user in the dresserMenu
	*pre: club initizialized
	*@param operation, an int with the choosed option by the user
	*/
	public void dresserExecuteOperation(int operation){
		
		switch(operation){
		
		case 1: addPlayertoDresser();
		break;		
		case 2: removePlayerOfDresser();
		break;
		case 3: System.out.println(club.dresserInformation());
		break;
		case 4:showOneDresserInformation();
		}
	}
	/**
	*method that removes a choosed player from the choosed dresser
	*pre: there is at least one player created and club is initizialized
	*pos: the dresser will be empty in the space where the player was
	*/
	public void removePlayerOfDresser(){
		
		int player = 0;
		
		int dresser = 0;
		
		String text = "";
		
		System.out.println(club.playersNames());
		player =sc.nextInt();
		sc.nextLine();
		do{
		System.out.println("De que Vestidor va a salir");
		dresser = sc.nextInt();
		sc.nextLine();
		}while(dresser!=2 || dresser!=1);
			
		text = club.removeFromDresser(player, dresser);
		System.out.println(text);
			
	}
	/**
	*method that shows to the user the list of actions he can do related to the offices
	*pre: club is initizialized
	*@return option, an int with the choosed option by the user
	*/
	public int officeMenu(){
		
		int option = 0;
		
		System.out.println("Elija una opcion: \n" +
						   "(0) Para volver al menu principal\n" +
						   "(1) Para Añadir un entrenador a las oficinas\n" +
						   "(2) Para Sacar un entrenador de las Oficinas\n" +
						   "(3) Para ver la Informacion de las oficinas\n" 
						   
		);
		option = sc.nextInt();
		sc.nextLine();
		
		return option;
	}
	/**
	*method that executes the choosed action by the user related to the offices
	*pre: club is initizialized and officeMenu works
	*@param option, an int with the choosed option by the user
	*/
	public void officeExecuteOperation(int option){
		
		switch(option){
		
		case 1: addCoachToOffice();
		break;
		case 2: removeCoachFromOffice();
		break;
		case 3: System.out.println(club.officeInfo());
		
		
		}
	}
	/**
	*method that adds a coach to the office
	*pre: club is initizialized and there is at least one coach Created
	*pos: the office has a new Coach in the first empty space
	*/
	public void addCoachToOffice(){
		
		int coach = 0;
		
		System.out.println(club.coachesList());
		coach = sc.nextInt();
		sc.nextLine();
		club.addCoachToOffice(coach);
	}
	/**
	*method that removes a coach from the office
	*pre: club is initizialized and there is atleast one coach created
	*/
	public void removeCoachFromOffice(){
		
		int coach = 0;
		
		System.out.println(club.coachesList());
		coach = sc.nextInt();
		sc.nextLine();
		club.removeFromOffice(coach);
		
		
	}
	/**
	*method that shows the current information of the dressers
	*/
	public void showOneDresserInformation(){
		
		int choice = 0;
		do{
		System.out.println("De que vestidor quiere saber la informacion");
		choice = sc.nextInt();
		sc.nextLine();
		}while(choice!=2 && choice!=1);
		System.out.println(club.dresserInfo(choice));
		
		
	}
	/**
	*method that adds a new lineUp to a choosed Team
	*pre: there is atleast one team Created and club is initizialized
	*pos: the choosed team has a new lineup in its arraylist lineups
	*/
	public void addLineUp(){
		
		String date = "";
		
		int team = 0;
		
		String chain = "";
		
		int calculate = 0;
		
		int [] tmpNumber;
		
		String [] tmpText;
		
		System.out.println("Ingrese la fecha de cuando se usara la formacion");
		date = sc.nextLine();
		System.out.println(club.teamListName());
		team = sc.nextInt();
		sc.nextLine();
		do{
		calculate = 0;
		System.out.println("Ingrese la formacion en formato Numero - Numero\n Recuerde que la formacion debe ser de 10 jugadores" );
		chain = sc.nextLine();
		tmpText	= chain.split("-");
		tmpNumber = new int[tmpText.length];
		for(int i=0; i < tmpText.length;i++){
			tmpNumber[i]= Integer.valueOf(tmpText[i]);
		}
		for(int i=0; i < tmpNumber.length;i++){
			calculate+= tmpNumber[i];
		}
		}while(calculate!=10);
		club.createNewLineUp(chain, date, team);
	}
	/**
	*method shows the lineUps of choosed team
	*pre: there is atleast one team and lineUp created, club is initizialized
	*/
	public void showLineUps(){
		
		int team = 0;
		
		String text = "";
		
		System.out.println(club.teamListName());
		team = sc.nextInt();
		sc.nextLine();
		text = club.showLineUpsForPress(team);
		System.out.println(text);
	}
}
		
	
	