
public class Intern extends Employee{
	final int UNPAID_VACATION = 10; //in days
	final double HEALTH_INSURANCE = 5000; //$/year
	final double INCOME = 40000; //$/year
	 
	private int usedUnpaidVacation; //keeps track of how much unpaid vacation has been used
	
	public Intern(int yearsWorked)
	{
		super(yearsWorked);
	}
	
	public void useUnpaidVacation() //adds one to usedUnpaidVacation
	{
		usedUnpaidVacation++;
	}
	
	public void workYear() //adds one to yearsWorked
	{
		super.setYears(super.getYears()+1);
	}
	
	public double YTDValue() //calculates ytd value
	{
		double ytd = HEALTH_INSURANCE + INCOME;
		return ytd;
	}
	
	public int yearsTillRetirement() //calculates years until retirement
	{
		//gives nearest int value
		int years = (int) Math.round((35 -(super.getYears() + (double)(usedUnpaidVacation / 260))));
		return years;
	}

	
}
