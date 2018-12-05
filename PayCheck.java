import java.util.Scanner;

public class PayCheck {

	public static void main(String[] args) {
		/* PayCheck.java
		 * Keisha Quirimit
		 * kquirimi
		 * Programming Assignment 1
		 * uses user input to calculate someone's next paycheck based on hours worked
		 * (regular and overtime) and pay rate
		 */
		double hoursWorked = 0;
		double payRate = 0;
		double payCheck = 0;
		
		Scanner scnr = new Scanner(System.in);
		System.out.println("Please enter the total hours worked Monday through Sunday"); //asks for user input for hours worked
		hoursWorked = scnr.nextDouble(); //hours worked input saved as a double
		System.out.println("Please enter your pay rate (in terms of dollars per hour)"); //asks for user input for payrate
		payRate = scnr.nextDouble(); //payrate input saved as a double
		
		if(hoursWorked > 40) //checks if person worked overtime
		{
			double overHours = hoursWorked - 40;
			double overtimePay = overHours * payRate * 1.5;	//calculates overtime pay
			payCheck = overtimePay + 40*payRate; //adds overtime pay to regular payrate
			System.out.print("Your paycheck for this week is: "); 
			System.out.printf("%.2f", payCheck); //prints out paycheck amount
		}
		else //calculates paycheck for individual who didn't work overtime
		{
			payCheck = hoursWorked*payRate;
			System.out.print("Your paycheck for this week is: "); 
			System.out.printf("%.2f", payCheck); //prints out paycheck amount
		}
		
		
		

	} //end of main method

} //end of class
