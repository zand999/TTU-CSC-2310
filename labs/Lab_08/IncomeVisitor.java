import java.text.DecimalFormat;
public class IncomeVisitor implements Visitor{

	private double income;

	DecimalFormat fmt = new DecimalFormat("#,##0.00");

	public void visit(SoftwareDev softwareDev){

		income = softwareDev.getIncome() * 1.30;

	}
	public void visit(DatabaseAdmin databaseAdmin){

		income = databaseAdmin.getIncome() * 0.90;

	}
	public void visit(ComputerSysAnalyst computerSysAnalyst){

		income = computerSysAnalyst.getIncome() * 1.30;

	}
	public void visit(WebDev webDev){
		
		income = webDev.getIncome() * 0.90;

	}
	public void visit(InfoSecurityAnalyst infoSecurityAnalyst){

		income = infoSecurityAnalyst.getIncome() * 1.10;

	}
	public double getNewIncome(){

		return income;

	}


}