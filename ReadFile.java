import java.util.Scanner; 
import java.io.*;
public class ReadFile {
	/*ReadFile.java
	 * Keisha Quirimit
	 * kquirimi
	 * Program 3
	 * fills an array by reading a file of data and calculates average
	 * rainfall and highest/lowest rainfall years
	 */

	public static void main(String[] args) {
		double[] rainfall = populateArray(); //fills an array
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the option \"average\", \"highest\", \"lowest\": ");
		String command = input.next(); //user prompted to input a command
		
		while(!command.equals("quit")) //runs while the user hasn't entered "quit"
		{
		if(command.equals("average")) //goes into finding the average rainfall
		{
			System.out.print("Average rainfall since 1849: ");
			System.out.printf("%.2f", findAverage(rainfall));
			System.out.println(" inches");
		}
		else if(command.equals("highest")) //finds year of highest rainfall
		{
			int highRainYear = findHighestYearIndex(rainfall);
			double highestRain = rainfall[highRainYear];
			System.out.print("Highest rainfall since 1849: ");
			System.out.println(highestRain + " inches which occurred during year " 
					+ (highRainYear + 1849));
		}
		else if(command.equals("lowest")) //finds year of lowest rainfall
		{
			int lowRainYear = findLowestYearIndex(rainfall);
			double lowestRain = rainfall[lowRainYear];		
			System.out.print("Lowest rainfall since 1849: ");
			System.out.println(lowestRain + " inches which occurred during year " 
			+ (1849 + lowRainYear));
		}
		else 
			System.out.println("Invalid input"); //other input than above tells user that their input is invalid
		System.out.println();
		System.out.println("Enter the option \"average \", \"highest\", \"lowest\": ");
		command = input.next(); //user prompted to enter another command
		
		}
		
	
	}
	
	public static double[] populateArray()
	{
		double[] rain = new double[168]; //creates new array to fit the rainfall data
		try 
		{
			File data = new File("rainfall.txt");
			Scanner fileRead = new Scanner(data);
			int index = 0; //keeps track of array index to add double to
			while(fileRead.hasNextDouble()) //keeps reading file until no unread doubles
			{
				rain[index]= fileRead.nextDouble(); //adds the read double into the array
				index++; //moves on to next index in array
			}
			return rain; //returns the filled array of doubles
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File not found"); 
			double[] empty = new double[168];
			return empty; //returns an empty array if file not found
		}
		
	}
	
	public static int findHighestYearIndex(double[] set)
	{
		double highest = set[0];
		int index = 0; //keeps track of index in array
		for(int i = 1; i<set.length; i++)
		{
			if(set[i] > highest) //checks if value at this index is greater than current "highest"
			{
				highest = set[i]; //sets highest to a new greater value
				index = i; //index set to the index of the current highest value
			}
		}
		return index; //returns index of the highest value in the array
	}
	
	public static int findLowestYearIndex(double[] dataset)
	{
		double lowest = dataset[0];
		int index = 0;
		for(int i = 1; i<dataset.length;i++)
		{
			if(dataset[i] < lowest) //checks if value at current index is less than current 
			{
				lowest = dataset[i]; //sets lowest to current value at the index i
				index = i; //index set to index of the current lowest value
				
			}
		}
		return index; //returns index of the lowest value in the array
	}
	
	public static double findAverage(double[] dataset)
	{
		double average = 0;
		double sum = 0;
		for(int i =0; i<dataset.length; i++)
		{
			sum+= dataset[i]; //adds up the amount of rainfall
		}
		average = sum/dataset.length; //calculates average
		return average; //returns the average rainfall
		
	}

}
