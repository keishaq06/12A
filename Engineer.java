
public class Engineer extends Employee {
	final double YEARLY_BONUS = 5000; //$/year
	final int PAID_VACATION = 10; //in days
	final int UNPAID_VACATION = 10; //in days
	final double HEALTH_INSURANCE = 10000; //$/year
	final double INCOME = 100000; //$/year
	
	private int usedUnpaidVacation; //keep track of how much unpaid vacation has been used
	private int usedVacation; //keeps track of how much paid vacation has been used
	
	public Engineer(int yearsWorked)
	{
		super(yearsWorked);
	}
	
	public int getUsedUnpaidVacation()
	{
		return usedUnpaidVacation;
	}
	
	public void setUsedUnpaidVacation(int num) //sets usedUnpaidVacation to the value of num
	{
		usedUnpaidVacation = num;
	}
	
	public int getUsedVacation()
	{
		return usedVacation;
	}
	
	public void setUsedVacation(int num) //sets usedVacation to the value of num
	{
		usedVacation = num;
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
		double ytd = YEARLY_BONUS + HEALTH_INSURANCE + INCOME
				+ PAID_VACATION * (INCOME/260);
		return ytd;
	}
	
	@Override
	public int yearsTillRetirement() //calculates years until retirement
	{
		int retire = (int)(Math.round((35 - (super.getYears() + (double)(usedUnpaidVacation + usedVacation*2)/260))));
		return retire;
	}
	
	
}
