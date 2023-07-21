

public class Cone{
   private int coneType;
   private double price;
   private String coneName;


   public Cone(){
   		coneType = 1;
   		price = 0.59;
   		coneName = "Sugar Cone";

   }

   public Cone(int type){
   		coneType = type;
   		switch(coneType){
   			case 1: price = 0.59; coneName = "Sugar Cone"; break;
   			case 2: price = 0.79; coneName = "Waffle Cone"; break;
   			case 3:	price = 0.00; coneName = "Bowl"; break;
   			default: price = 0.59; coneName = "Sugar Cone"; break;
   		}
   }

   public double getCost(){
   		
   		return price;
   }
	public String toString( ){

        return "Cone: " + coneName + "\r\n";

    }

}
