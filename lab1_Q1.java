// I certify the code of this lab is entirely my own work.

import java.util.Scanner;
class ExpressionResult{

	private String exp; private static int res;

	public ExpressionResult(){
		exp="0";
	}

	public ExpressionResult(String exp) {
		this.exp = exp;
		evaluate(exp);
	}
	

	public String ToString(){
		return exp + " = " + res ;
	}
	
	public static int evaluate(String exp){

		String array[] = exp.split(" " );
		char op = array[1].charAt(0) ;
		int num1 = Integer.parseInt(array[0]);
		int num2= 0;
		
		for(int j=0 ;j<array.length; j++)
		{
			if(array.length < 2*j+2 ){
				break;
			}
						if( 0 != array[2*j+1].charAt(0)/2)
						{
							op =  array[2*j+1].charAt(0) ;
							num2 = Integer.parseInt(array[2*j+2]);
						}
						else{
							num2 = Integer.parseInt(array[2*j+2]);
						}

			switch(op) {
				case '+':
					res = num1+num2;
					break;
				case '-':
					res = num1-num2;
					break;
				case '*':
					res  = num1*num2;
					break;

				case '^':
					res  = (int) Math.pow(num1,num2);
					
					break;
					

				default:
					res  = num1/num2;
			}
			num1 = res  ;
		}
		return res;
	}
	
}

public class lab1_Q1 {
	public static void main(String[] args){

		char enterVal ='a';

		while(enterVal != 'X')
		{
			System.out.print("Please enter an algebraic expression : ");
			Scanner myObj = new Scanner(System.in);
			String userInput = myObj.nextLine();
			System.out.print("For exit enter 'X' : ");
			enterVal = myObj.next().charAt(0);
			System.out.println("Enter the user algebraic expression : "+  userInput);
			
			System.out.print("Enter the second user algebraic expression : ");
			Scanner myObj2 = new Scanner(System.in);
			String userInput2 = myObj2.nextLine();

			ExpressionResult obj1 = new  ExpressionResult(userInput2);
			System.out.println( obj1.ToString() );

		}

	}
}