package pizza;
public class Pizza extends DecoratedPizza{

	private Crust crust;

    public Pizza(Crust crust){
        super();
        this.crust = crust;
    }

    public double pizzaCost(){

        return crust.crustCost();

    }

    public String getImage(){

        return String.valueOf(crust.getCrust());

    }

    public String toString(){

        return crust.toString();

    }

}