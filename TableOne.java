import java.util.Random;

public class TableOne {
	private int row;
	private int col;
	private String array [][];
	
	
	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}
	
	public void edit(int rowEdit, int colEdit, String editStr){
		array[rowEdit][colEdit]=editStr;
	}
	
	public void reset(int nRow,int nCol){
		row=nRow;
		col=nCol;
		array = new String [row][col];
		for(int counterA=0;counterA<row;counterA++){
			for(int counterB=0;counterB<col;counterB++){
				array [counterA][counterB]= getAscii();
			}
		}	
	}
	
	public void search(String searchStr){
		int sum=0;
		for(int counterA=0;counterA<row;counterA++){
			for(int counterB=0;counterB<col;counterB++){
				int count=0;
				count = checkOccurence(array[counterA][counterB],searchStr);
				if(count!=0)
					System.out.println("found in this coordinate ["+counterA+"] ["+counterB+"] - "+count+"time/s");
				sum+=count;
			}
		}
		System.out.println("String "+searchStr+" found "+sum+" time/s");
	}
	
	public int checkOccurence(String arrayStr, String searchStr){
		if(arrayStr.length()<searchStr.length())
			return 0;
		else{
			if(arrayStr.substring(0,searchStr.length()).equals(searchStr))
				return 1+checkOccurence(arrayStr.substring(1,arrayStr.length()),searchStr);
			else
				return checkOccurence(arrayStr.substring(1,arrayStr.length()),searchStr);
		}
	}
	
	public void print(){
		for(int counterA=0;counterA<row;counterA++){
			for(int counterB=0;counterB<col;counterB++){
				System.out.print(array[counterA][counterB]+"\t");
			}
			System.out.println();
		}
	}
	
	public String getAscii(){
		Random ran = new Random();
		String ascii="";
		for(int count=0;count<3;count++){
			ascii+=(char)(ran.nextInt(89)+33);
		}
		return ascii;
	}

}
