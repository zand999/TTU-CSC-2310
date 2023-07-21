public interface Visitable{

	public void accept(Visitor visitor);
	public String getName();

}