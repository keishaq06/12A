
public class Employee {
	private int yearsWorked;

	Employee(int yearsWorked) {
		this.yearsWorked = yearsWorked;
	}

	double YTDValue() { 
		return 0;
	}

	int yearsTillRetirement() { //calculates years until retirement
		return 35 - yearsWorked;
	}

	void setYears(int x) { //sets yearsWorked to the value of x
		yearsWorked = x;
	}

	int getYears() {
		return yearsWorked;
	}

}
