package model;
public class LineUp{

	public final static int LINEUP_ROWS = 10;
	public final static int LINEUP_COLUMNS = 7;
	
	private String date;
	
	private String chain;
	
	private int [][] lineUp;
	
	
	public LineUp(String date, String chain){
	
		this.chain = chain;
		
		this.date = date;
		
		lineUp = stringToMatrix(chain);
		
	}
	public String getDate(){
		return date;
	}
	public void setDate(String date){
		this.date = date;
	}
	public String getChain(){
		return chain;
	}
	public void setChain(String chain){
		this.chain = chain;
	}
	public int[][] getLineUp(){
		return lineUp;
	}
	public void setLineU(int [][] lineUp){
		this.lineUp = lineUp;
	}
	public int[][] stringToMatrix(String chain){
		
		
		double quantity =0;
		
		double divide = 0;
		
		int k=0;
		
		double anotherDivide = 0;
		
		boolean out = false;
		
		String text = chain;
		
		String [] tmpText = text.split("-");
		
		int [][] matrix = new int[LINEUP_ROWS][LINEUP_COLUMNS];
		
		int [] tmpNumber = new int[tmpText.length];
		
		for(int i=0; i < tmpText.length;i++){
				
				tmpNumber[i]= Integer.valueOf(tmpText[i]);
				quantity+=1;
				
		}
	
		divide = (10/quantity);	
		
		divide = Math.ceil(divide);

		
		for(int i=matrix.length-1; i>=0 ; i-=divide){
				
				quantity = 0;
				out = false;
				System.out.println(quantity);
					
					System.out.println(k);
				for(int j=matrix[0].length-1; j>=0 && out==false; j--){  
						
						
						
						quantity+=1;
						if(quantity<=tmpNumber[k]){
							System.out.println("Entro al IF");
							matrix[i][j] = 1;
						}else{
							out = true;
						}
						
				}
				k+=1;
		}
			
				
		
		return matrix;
	}
	public String showMatrix(){
		
		String text = "\n";
		
		for(int i=0; i < lineUp.length;i++){
			
				text+= "\n"; 
				
			for(int j=0; j < lineUp[0].length;j++){
			
				text+= lineUp[i][j] + "\t";
				
			}
		}
		return text;
	}
	/*
	
	
	*/
}