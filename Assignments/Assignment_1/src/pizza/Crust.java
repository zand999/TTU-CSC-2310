package pizza;
public class Crust{

	private char crustSize;
	private String crustType;

	public Crust(String crustType, char crustSize){

		this.crustSize = crustSize;
		this.crustType = crustType;


	}

	public double crustCost(){


        return ((CrustSize.valueOf(String.valueOf(crustSize)).getCost())+(CrustType.valueOf(crustType).getCost()));

	}

	public String toString(){

        return "Size: " + crustSize + "\r\nCrust: " + crustType + "\r\n";
    }

    public char getCrust(){

        return crustSize;
    }

    public String getType(){

        return crustType;
    }



}