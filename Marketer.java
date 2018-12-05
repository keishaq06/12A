
public class Marketer extends Employee{
	

	final double CLIENT_BONUS = 2000; //per new client
	final int PAID_VACATION = 10; //in days
	final int UNPAID_VACATION = 10; //in days
	final double HEALTH_INSURANCE = 10000; //$/year
	final double INCOME = 100000; //$/year
	
	private int numBonuses; //keeps track of how many commission based bonuses the employee received
	private int usedUnpaidVacation; //keeps track of how much unpaid vacation has been used
	private int usedVacation;//keeps track of how much paid vacation has been used
	
	public Marketer(int yearsWorked)
	{
		super(yearsWorked);
	}
	
	public void signDeal()  //adds one to numBonuses
	{
		numBonuses++;
	}
	
	public void usePaidVacation() //adds one to usedVacation
	{
		usedVacation++;
	}
	
	public void useUnpaidVacation() //adds one to usedUnpaidVacation
	{
		usedUnpaidVacation++;
	}
	
	public void workYear() //adds one to yearsWorked
	{
		super.setYears(super.getYears()+1);
	}
	
	@Override
	public double YTDValue() //calculates ytd value
	{
		double ytd = CLIENT_BONUS * numBonuses + HEALTH_INSURANCE + INCOME + PAID_VACATION* (INCOME/260);
		return ytd;
	}
	
	@Override
	public int yearsTillRetirement() //calculates years until retirement
	{
		//gives nearest int
		int retire = (int) Math.round((35 -(super.getYears() + (double)(usedUnpaidVacation+ usedVacation* 2)/260)));
		return retire;
	}

	
}
