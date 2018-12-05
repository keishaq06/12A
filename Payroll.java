
public class Payroll {
	
	Employee[] employees; 
	
	public Payroll(int x)
	{
		employees = new Employee[x];
	}

	public Employee[] getEmployees()
	{
		return employees;
	}
	public void sortEmployeesByRetirement() //sort employees in ascending order of when the employee will retire
	{
		int years = employees[0].yearsTillRetirement(); //holds preceding value
		int years1 = employees[1].yearsTillRetirement(); //holds next value  
		Employee temp = null;
		
		for(int i = 0; i<employees.length;i++)
		{
			for(int j = 1; j< employees.length - i; j++)
			{
			   years = employees[j-1].yearsTillRetirement(); 
			   years1 = employees[j].yearsTillRetirement();
			   if(years > years1) //checks if a larger value precedes a smaller one
			   {
				   //switches the two values so that the smaller value precedes the larger value
				   temp = employees[j];
				   employees[j] = employees[j-1];
				   employees[j-1] = temp;
			   }
			}
		}
		
	}
	
	public void sortEmployeesByCost() //sort employees in descending order of the YTDValue() of each employee
	{
		double ytd = employees[0].YTDValue(); //holds preceding value
		double ytd1 = employees[1].YTDValue(); //holds next value
		Employee temp = null;
		
		for(int i = 0; i<employees.length;i++)
		{
			for(int j = 1; j< employees.length - i; j++)
			{
			   ytd = employees[j-1].YTDValue();
			   ytd1 = employees[j].YTDValue();
			   if(ytd1 > ytd) //checks if smaller value precedes a larger one
			   {
				   //switches the values so that the larger one comes before the smaller value
				   temp = employees[j];
				   employees[j] = employees[j-1];
				   employees[j-1] = temp;
			   }
			}
			
		}
	}
}
