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
	public void addTeam(){
		
	String name;
	
	System.out.println("Ingrese el nombre del equipo");
	name = sc.nextLine();
	
	club.addTeam(name);
	System.out.println("Se ha añadido el equipo " + name);
	}
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
	public void fireEmployee(){
		
		int position = 0;
		
		System.out.println(club.employersNames());
		position = sc.nextInt();
		sc.nextLine();
		
		club.fireEmployee(position);
	}
	public int teamMenu(){
		
		int option = 0;
		
		System.out.println("Seleccione una Opcion: \n" +
						   "(0) Para Volver al menu principal\n" +
						   "(1) Para Crear un Equipo\n" +
						   "(2) Para añadir un Jugador a un equipo\n" +
						   "(3) Para Añadir el Coach principal del Equipo\n" +
						   "(4) Para Añadir un Entrenador Assistente\n" +
						   "(5) Para Ver la informacion de los Equipos"
							);
		option = sc.nextInt();
		sc.nextLine();
		return option;
	}
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
		case 5: System.out.println(club.teamsInfo());
		break;
		}
	}
	public void addPlayerToTeam(){
		System.out.println("Entro al metodo");
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
	public void removePlayerOfDresser(){
		
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
		}while(dresser!=2 || dresser!=1);
			
		text = club.removeFromDresser(player, dresser);
		System.out.println(text);
			
	}
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
	public void officeExecuteOperation(int option){
		
		switch(option){
		
		case 1: addCoachToOffice();
		break;
		case 2: removeCoachFromOffice();
		break;
		case 3: System.out.println(club.officeInfo());
		
		
		}
	}
	public void addCoachToOffice(){
		
		int coach = 0;
		
		System.out.println(club.coachesList());
		coach = sc.nextInt();
		sc.nextLine();
		club.addCoachToOffice(coach);
	}
	public void removeCoachFromOffice(){
		
		int coach = 0;
		
		System.out.println(club.coachesList());
		coach = sc.nextInt();
		sc.nextLine();
		club.removeFromOffice(coach);
		
		
	}
	public void showOneDresserInformation(){
		
		int choice = 0;
		do{
		System.out.println("De que vestidor quiere saber la informacion");
		choice = sc.nextInt();
		sc.nextLine();
		}while(choice!=2 && choice!=1);
		System.out.println(club.dresserInfo(choice));
		
		
	}
}
		
	
	