class VacationVisitor implements Visitor{

	private int vacationDays;

	private int calculate(int num){

		if(num % 2 == 0){

			num += 2;

		}else{

			num--;

		}
		return num;

	}

	public void visit(SoftwareDev softwareDev){

		vacationDays = calculate(softwareDev.getVacation());

	}
	public void visit(DatabaseAdmin databaseAdmin){

		vacationDays = calculate(databaseAdmin.getVacation());

	}
	public void visit(ComputerSysAnalyst computerSysAnalyst){

		//vacation days 365 
		vacationDays = 365; 

	}
	public void visit(WebDev webDev){
		//vacation days 0 
		vacationDays = 0;

	}
	public void visit(InfoSecurityAnalyst infoSecurityAnalyst){

		vacationDays = calculate(infoSecurityAnalyst.getVacation());

	}
	public int getVacationDays(){
		return vacationDays;
	}


}