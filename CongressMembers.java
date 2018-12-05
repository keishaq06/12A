
public class CongressMembers {
	private String fullName;
	private double[] ratings;
	
	public CongressMembers()
	{
		fullName = "";
		ratings = new double[5];
	}
	
	public CongressMembers(String theName, double[] theRatings)
	{
		fullName = theName;
		ratings = theRatings;
	}
	
	public String getName()
	{
		return fullName;
	}
	
	public void setName(String n)
	{
		fullName = n;
	}
	
	public double[] getRatings()
	{
		return ratings;
	}
	
	public void setRatings(double[] r)
	{
		ratings = r;
	}
	
	public double getAverageRating()
	{
		double average = 0;
		double sum = 0;
		for(int i =0; i<ratings.length; i++)
		{
			sum+= ratings[i]; //adds the 5 ratings for the CongressMember
		}
		average = sum/ratings.length;
		return average;
	}
}
