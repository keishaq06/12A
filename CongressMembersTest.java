import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CongressMembersTest {
	/*CongressMembersTest.java
	 * Keisha Quirimit
	 * kquirimi
	 * Program 4
	 * fills an array with CongressMembers objects and sorts the array
	 * by first name and average approval rating
	 */

	public static void main(String[] args) {

		FileWriter f;
		PrintWriter p;
		CongressMembers[] members;

		try {
			File approval = new File("approval.txt");
			Scanner lineScan = new Scanner(approval);
			int numLines = 0;
			String line = "";
			while (lineScan.hasNextLine()) { // counts how many members in file
				numLines++;
				line = lineScan.nextLine();
			}
			
			lineScan.close();
			members = new CongressMembers[numLines]; // instantiates an array to hold CongressMembers objects
			Scanner approvalScan = new Scanner(approval); // new Scanner created to read file again

			double[] ratings = new double[5]; // instantiates an array to hold the read ratings from file
			String name = ""; // String variable to hold name

			for (int i = 0; i < members.length; i++) { // for loop to read file and store into array members
				name = approvalScan.next(); // reads name from file
				name += " " + approvalScan.next(); // reads last name to add to name string
				for (int j = 0; j < ratings.length; j++) {
					ratings[j] = approvalScan.nextDouble(); // reads approval ratings from file and stores ratings array
				}

				members[i] = new CongressMembers(name, ratings); // uses read data to add a CongressMembers object to
																	// the members array
			}
			approvalScan.close();

			try {
				members = sortByFirstName(members); // members array sorted by first name
				f = new FileWriter("output.txt"); // creates a file output
				p = new PrintWriter(f);
				p.println(members.length); // prints the number of members in the file
				p.println();
				p.println("Sorted by First Name");
				p.println();
				for (int i = 0; i < members.length; i++) // prints out data sorted by first name
				{
					p.print(members[i].getName());
					p.print(" ");
					for (int j = 0; j < members[i].getRatings().length; j++) { // goes through the array of
						p.print(members[i].getRatings()[j]); // prints rating
						p.print(" ");
					}
					p.println();
				}
				p.println();
				p.println();
				p.println("Sorted by Approval Rating");
				p.println();
				members = sortByApprovalRating(members); // members sorted by approval rating
				for (int i = 0; i < members.length; i++) // prints out data sorted by approval rating
				{
					p.print(members[i].getName()); // prints member name in the file
					p.print(" ");
					for (int j = 0; j < members[i].getRatings().length; j++) {
						p.print(members[i].getRatings()[j]); // print member's rating
						p.print(" ");
					}
					p.println();
				}
				p.close();
			} catch (IOException ex) {
				System.out.println(ex.toString() + " file error."); //prints if error outputting file
			}

		} catch (FileNotFoundException e) {
			System.out.println(e + " file not found"); //prints if stated file isn't found
		}

	}//end of main

	public static CongressMembers[] sortByFirstName(CongressMembers[] theMembers) { // method to sort members by first name
		CongressMembers temp = null; 

		for (int i = 0; i < theMembers.length; i++) { //runs for the length of theMembers array
			for (int j = 1; j < theMembers.length - i; j++) {
				if (theMembers[j - 1].getName().compareTo(theMembers[j].getName()) > 0) { //checks if need to switch names
					temp = theMembers[j - 1];
					theMembers[j - 1] = theMembers[j]; //swaps the two objects in the array
					theMembers[j] = temp;
				}
			}//ends of inner for loop
		}//end of outer for loop
		return theMembers;
	}//end of method

	public static CongressMembers[] sortByApprovalRating(CongressMembers[] theMembers) { //sorts theMembers by average rating, greatest to least
		double avg1 = 0;
		double avg2 = 0;

		CongressMembers temp = null;

		for (int i = 0; i < theMembers.length; i++) { //runs for the length of theMembers array
			for (int j = 1; j < theMembers.length - i; j++) {

				avg1 = theMembers[j - 1].getAverageRating();
				avg2 = theMembers[j].getAverageRating();

				if (avg2 > avg1) //checks if need to swap
				{
					temp = theMembers[j - 1];
					theMembers[j - 1] = theMembers[j]; //swaps the two objects
					theMembers[j] = temp;
				}
			} // end of inner for loop
		} // end of outer for loop

		return theMembers;
	} //end of method

}//end of class
