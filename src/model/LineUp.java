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
	public int[][] stringToMatrix(String chain){
		
		
		int quantity =0;
		
		String tmpText = "";
		
		int [][] matrix = new int[LINEUP_ROWS][LINEUP_COLUMNS];
		
			for(int i=0; i < 20;i++){
				
				for(int j=0; j < 20;j++){
				
					//tmpText = chain.charAt(i);
					if( tmpText.equals("-")){
						
					}else{
						quantity = chain.charAt(i);
						
						
					}
				}
			}
	
		return matrix;
	}
	
}