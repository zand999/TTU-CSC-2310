public class InfoSecurityAnalyst implements Visitable{

	private String name;
	private double income;
	private int vacationDays;

	public void accept(Visitor visitor){

		visitor.visit(this);

	}


	public InfoSecurityAnalyst(String name, double income, int vacationDays){

		this.name = name;
		this.income = income;
		this.vacationDays = vacationDays;

	}


	public String getName(){

		return name;

	}
	public double getIncome(){

		return income;

	}

	public int getVacation(){

		return vacationDays;

	}



}