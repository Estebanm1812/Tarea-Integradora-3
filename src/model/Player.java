package model;
public class Player extends Employee implements Price{

	private int shirtNumber;
	
	private int gols;
	
	private double average;
	
	private Position position;
	
	public Player(String name, String identificator, double salary, String state, int shirtNumber, int gols, String position, double average){
	
		super(name, identificator, salary, state);
	this.shirtNumber = shirtNumber;
	
	this.position = Position.valueOf(position);
	
	this.gols = gols;
	this.average = average;
	
	}
	public int getShirtNumber(){
		return shirtNumber;
	}
	public void setShirtNumber(int shirtNumber){
		this.shirtNumber = shirtNumber;
	}
	public int getGols(){
		return gols;
	}
	public void setGols(int gols){
		this.gols = gols;
	}
	public double getAverage(){
		return average;
	}
	public void setAverage(double average){
		this.average = average;
	}
	public Position getPosition(){
		return position;
	}
	public void setPosition(Position position){
		this.position = position;
	}
	@Override
	public String getInfo(){
		
		String text = "";
		
		text = "PLAYER\n" +
			   "nombre: " + getName() +
			   "\n Identificador: " + getIdentificator() +
			   "\n Salario: " + getSalary() +
			   "\n Numero de Camiseta: " + getShirtNumber() +
			   "\n Cantidad de Goles: " + getGols() +
			   "\n Promedio: " + getAverage() +
			   "\n Posicion: " + getPosition() +
			   "\n Estado: " + getState() +
			   "\n Precio: " + calculatePrice() +
			   "\n Nivel: " + calculateLevel();
			   
		return text;
	}
	public double calculatePrice(){
		
		double price = 0;
		
		double salaryMultiply = 0;
		
		
		if(getPosition() == Position.DOORMAN){
			
			salaryMultiply = getSalary() * 12;
			price = salaryMultiply + (getAverage()*150);
			
		}else if(getPosition() == Position.DEFENDER){
			
			salaryMultiply = getSalary() * 13;
			price = salaryMultiply + (getAverage()*125) + (getGols()*100);
			
		}else if(getPosition() == Position.VOLANTE) {
			
			salaryMultiply = getSalary() * 14;
			price = salaryMultiply + (getAverage()*135) + (getGols()*125);
			
		}else{
			salaryMultiply = getSalary() * 15;
			price = salaryMultiply + (getAverage()*145) + (getGols()*150);
		}
		return price;
	}
	public double calculateLevel(){
		
		double lvl = 0;
		
		
		if(getPosition() == Position.DOORMAN){
			
			lvl = getAverage() *0.9;
			
		}else if(getPosition() == Position.DEFENDER){
			
			lvl = getAverage() + (getGols()/100);
			
		}else if(getPosition() == Position.VOLANTE) {
			
			lvl = getAverage() + (getGols()/90);
			
		}else{
			
			lvl = getAverage() + (getGols()/80);
		}
		
		
		return lvl;
	}
}