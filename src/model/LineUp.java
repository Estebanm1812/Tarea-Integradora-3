package model;
public class LineUp{

	public final static int LINEUP_ROWS = 10;
	public final static int LINEUP_COLUMNS = 7;
	
	private String date;
	
	private int [][] lineUp;
	
	
	public LineUp(String date, String chain){
	
		
		this.date = date;
		
		lineUp = stringToMatrix(chain);
		
	}
	public String getDate(){
		return date;
	}
	public void setDate(String date){
		this.date = date;
	}
	public int[][] getLineUp(){
		return lineUp;
	}
	public void setLineU(int [][] lineUp){
		this.lineUp = lineUp;
	}
	public int[][] stringToMatrix(String chain){
		
		
		int quantity =0;
		
		int divide = 0;
		
		int anotherDivide = 0;
		
		String text = chain;
		
		String [] tmpText = text.split("-");
		
		int [][] matrix = new int[LINEUP_ROWS][LINEUP_COLUMNS];
		
		int [] tmpNumber = new int[tmpText.length];
		
		for(int i=0; i < tmpText.length;i++){
				
				tmpNumber[i]= Integer.valueOf(tmpText[i]);
				quantity+=1;
		}
	
		divide = (int)(10/quantity);	
		
		for(int i=matrix.length-1; i>=0 ; i-=divide){
			
			
			
			for(int k=0; k < tmpNumber.length;k++){
				anotherDivide = (int)(7/tmpNumber[k]);
			
				for(int j=0; j<matrix[0].length; j+=anotherDivide){  
						
						matrix[i][j] = 1;
					
				}
			}
				
		}
				return matrix;
			}
		
		
		
		
	
	public String showMatrix(){
		
		String text = "\n";
		
		for(int i=0; i < lineUp.length;i++){
			
			for(int j=0; j < lineUp[0].length;j++){
			
				text+= lineUp[i][j] + "\t";
				
			}
		}
		return text;
	}
	/*
	
	
	*/
}