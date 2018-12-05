
public class BoardMember extends Employee {
	final double YEARLY_BONUS = 20000; //$/year
	final int PAID_VACATION = 20; //in days
	final int UNPAID_VACATION = 10; //in days
	final int SICK_LEAVE = 10; //in days
	final double HEALTH_INSURANCE = 20000; //$/year
	final double INCOME = 200000; //$/year
	
	private int usedUnpaidVacation; //keeps track of how much unpaid vacation has been used
	private int usedVacation; //keeps track of how much paid vacation has been used
	private int usedSickDays; //keeps track of how many sick days have been used
	
	public BoardMember(int yearsWorked)
	{
		super(yearsWorked);
	}
	
	public int getUsedUnpaidVacation() 
	{
		return usedUnpaidVacation;
	}
	
	public void setUsedUnpaidVacation(int num) //sets usedUnpaidVacation to the value of nums
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
	
	public int getUsedSickDays()
	{
		return usedSickDays;
	}
	
	public void setUsedSickDays(int num) //sets usedSickDays to the value of num
	{
		usedSickDays = num; 
	}
	
	
	public void usePaidVacation() //adds one to usedVacation
	{
		usedVacation++;
	}
	
	public void useUnpaidVacation() //adds one to usedUnpaidVacation
	{
		usedUnpaidVacation++;
	}
	
	public void useSickDay() //adds one to usedSickDays
	{
		usedSickDays++;
	}
	
	public void workYear() //adds one to yearsWorked
	{
		super.setYears(super.getYears()+1);
	}
	
	@Override
	public double YTDValue()  //calculates ytd value
	{
		double ytd = YEARLY_BONUS + HEALTH_INSURANCE + INCOME
				+ PAID_VACATION * (INCOME/260) 
				+(SICK_LEAVE - usedSickDays) * ((INCOME/260) /2);
		return ytd;
	}
	
	@Override
	public int yearsTillRetirement() //calculate years until retirement
	{
		//gives nearest int value 
		int retire = (int)Math.round((35 - (super.getYears() + (double)(usedUnpaidVacation + usedVacation* 2 + usedSickDays)/260)));
		
		return retire;
		
		
	}
	
	
}
