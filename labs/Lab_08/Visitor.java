public interface Visitor{

	public void visit(SoftwareDev softwareDev);
	public void visit(DatabaseAdmin databaseAdmin);
	public void visit(ComputerSysAnalyst computerSysAnalyst);
	public void visit(WebDev webDev);
	public void visit(InfoSecurityAnalyst infoSecurityAnalyst);


}