import java.io.*;
import java.util.Scanner;
public class PayrollTest {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Payroll payroll = new Payroll(20);
		
		// get the text data file into the Employee array
		populateArray(payroll);
		
		// sort by YTDValue and print
		payroll.sortEmployeesByCost();
		printArrayYTD(payroll.getEmployees());
		System.out.println();
		
		// sort by years till retirement and print
		payroll.sortEmployeesByRetirement();
		printArrayRetirement(payroll.getEmployees());

	}
	
	
	// This method populates the Employee array belonging to Payroll
	public static void populateArray(Payroll payroll) throws IOException{
		File f = new File("employees.txt");
		Scanner payScan = new Scanner(f);
		
		
		
		int index = 0;
		while(payScan.hasNextLine()){
			char choice = payScan.next().charAt(0);
			int years = 0, vacay = 0, unpaid = 0, bonus = 0, sick = 0;
			switch(choice) {
				case 'B':
					payroll.getEmployees()[index] = new BoardMember(0);
					years = payScan.nextInt();
					for(int i = 0; i<years; i++) {
						BoardMember placeHolder = (BoardMember)payroll.getEmployees()[index];
						placeHolder.workYear();
					}
					unpaid = payScan.nextInt();
					for(int i = 0; i<unpaid; i++) {
						BoardMember placeHolder = (BoardMember)payroll.getEmployees()[index];
						placeHolder.useUnpaidVacation();
					}
					vacay = payScan.nextInt();
					for(int i = 0; i<vacay; i++) {
						BoardMember placeHolder = (BoardMember)payroll.getEmployees()[index];
						placeHolder.usePaidVacation();
					}
					sick = payScan.nextInt();
					for(int i = 0; i<sick; i++) {
						BoardMember placeHolder = (BoardMember)payroll.getEmployees()[index];
						placeHolder.useSickDay();
					}
					break;
				case 'E':
					payroll.getEmployees()[index] = new Engineer(0);
					years = payScan.nextInt();
					for(int i = 0; i<years; i++) {
						Engineer placeHolder = (Engineer)payroll.getEmployees()[index];
						placeHolder.workYear();
					}
					unpaid = payScan.nextInt();
					for(int i = 0; i<unpaid; i++) {
						Engineer placeHolder = (Engineer)payroll.getEmployees()[index];
						placeHolder.useUnpaidVacation();
					}
					vacay = payScan.nextInt();
					for(int i = 0; i<vacay; i++) {
						Engineer placeHolder = (Engineer)payroll.getEmployees()[index];
						placeHolder.usePaidVacation();
					}
					break;
				case 'C':
					payroll.getEmployees()[index] = new Custodian(0);
					years = payScan.nextInt();
					for(int i = 0; i<years; i++) {
						Custodian placeHolder = (Custodian)payroll.getEmployees()[index];
						placeHolder.workYear();
					}
					unpaid = payScan.nextInt();
					for(int i = 0; i<unpaid; i++) {
						Custodian placeHolder = (Custodian)payroll.getEmployees()[index];
						placeHolder.useUnpaidVacation();
					}
					vacay = payScan.nextInt();
					for(int i = 0; i<vacay; i++) {
						Custodian placeHolder = (Custodian)payroll.getEmployees()[index];
						placeHolder.usePaidVacation();
					}
					break;
				case 'M':
					payroll.getEmployees()[index] = new Marketer(0);
					years = payScan.nextInt();
					for(int i = 0; i<years; i++) {
						Marketer placeHolder = (Marketer)payroll.getEmployees()[index];
						placeHolder.workYear();
					}
					bonus = payScan.nextInt();
					for(int i = 0; i<bonus; i++) {
						Marketer placeHolder = (Marketer)payroll.getEmployees()[index];
						placeHolder.signDeal();
					}
					unpaid = payScan.nextInt();
					for(int i = 0; i<unpaid; i++) {
						Marketer placeHolder = (Marketer)payroll.getEmployees()[index];
						placeHolder.useUnpaidVacation();
					}
					vacay = payScan.nextInt();
					for(int i = 0; i<vacay; i++) {
						Marketer placeHolder = (Marketer)payroll.getEmployees()[index];
						placeHolder.usePaidVacation();
					}
					break;
				case 'I':
					payroll.getEmployees()[index] = new Intern(0);
					years = payScan.nextInt();
					for(int i = 0; i<years; i++) {
						Intern placeHolder = (Intern)payroll.getEmployees()[index];
						placeHolder.workYear();
					}
					unpaid = payScan.nextInt();
					for(int i = 0; i<unpaid; i++) {
						Intern placeHolder = (Intern)payroll.getEmployees()[index];
						placeHolder.useUnpaidVacation();
					}
					break;
				case 'A':
					payroll.getEmployees()[index] = new Accountant(0);
					years = payScan.nextInt();
					for(int i = 0; i<years; i++) {
						Accountant placeHolder = (Accountant)payroll.getEmployees()[index];
						placeHolder.workYear();
					}
					unpaid = payScan.nextInt();
					for(int i = 0; i<unpaid; i++) {
						Accountant placeHolder = (Accountant)payroll.getEmployees()[index];
						placeHolder.useUnpaidVacation();
					}
					vacay = payScan.nextInt();
					for(int i = 0; i<vacay; i++) {
						Accountant placeHolder = (Accountant)payroll.getEmployees()[index];
						placeHolder.usePaidVacation();
					}
					break;
				default:
					break;
			}
			index++;
		}
		payScan.close();
		
	}
	
	//This method prints the array in terms of YTDValue
	public static void printArrayYTD(Employee[] e) {
		System.out.println("Printing array by YTD");
		for(int i = 0; i < e.length; i++) {
			System.out.printf("%.2f\n", e[i].YTDValue());
			
		}
	}
	
	//This method prints the array in terms of years till Retirement
	public static void printArrayRetirement(Employee[] e) {
		System.out.println("Printing array by Retirement");
		for(int i = 0; i < e.length; i++) {
			System.out.println(e[i].yearsTillRetirement());
		}
	}

}
