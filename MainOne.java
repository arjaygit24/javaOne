import java.util.InputMismatchException;
import java.util.Scanner;

public class MainOne {

	public static void main(String[] args) {
		int choose=4;
		Scanner read = new Scanner(System.in);
		TableOne tableOne = new TableOne();
		while(choose!=5){
			switch(choose){
				case 1:
					System.out.println("Printing Table");
					tableOne.print();
					break;
				case 2:
					String searchStr=checkString(1,3," string to search");
					tableOne.search(searchStr);
					break;
				case 3:
					System.out.println("Editing Table");
					int rowEdit=checkNumber(0,tableOne.getRow()-1,"rows to edit");
					int colEdit=checkNumber(0,tableOne.getCol()-1, "cols to edit");
					String editStr=checkString(3,3,"string to replace");
					tableOne.edit(rowEdit,colEdit,editStr);
					break;
				case 4:
					System.out.println("Table Resets");
					int nRow=checkNumber(0,10,"row");
					int nCol=checkNumber(0,10,"col");
					tableOne.reset(nRow, nCol);
					break;
				case 5:
					System.out.println("Exiting Program");
				default:
					break;
			}
		option();
		choose=checkNumber(1,5,"");
		}
	}
	
	public static String checkString(int lowLimit, int highLimit,String editSearch){
		Scanner read = new Scanner(System.in);
		boolean correct=false;
		String word="";
		while(!correct){
			System.out.println("Enter "+editSearch+" ");
			word=read.nextLine();
			word=word.trim().replaceAll("\n", "");
			word=word.trim().replaceAll(" ", "");
			word=word.trim().replaceAll("\t", "");
			if(word.length()<lowLimit || word.length()>highLimit){
				System.out.print("Invalid re-enter string. ");
			}
			else
				correct=true;
		}
		return word;
	}
	
	public static int checkNumber(int lowLimit, int highLimit, String word){
		Scanner read = new Scanner(System.in);
		int choose=0;
		boolean correct = false;
		while(correct==false){
			System.out.print("Enter "+word+" ");
			try{
				choose = Integer.parseInt(read.next());
				if(choose>=lowLimit && choose<=highLimit)
					break;
				else
					System.out.print("Invalid! Not in range. ");
			}
			catch(NumberFormatException e){
				System.out.println("Invalid! Not an integer.");
				correct=false;
			}
		}
		return choose;
	}
	
	public static void option(){
		System.out.println("Choose from the following");
		System.out.println("1. Print 2. Search 3. Edit 4. Reset 5. Exit");
	}

}
