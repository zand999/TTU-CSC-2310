

public class IceCreamDriver{
	private static Keyboard input = Keyboard.getKeyboard();

	

	public static void main(String[] args){

		double total = 0.0;
		int scoops,numOrdered = 0;
		String strInput = "";
		Flavor flavor;
		Topping topping;
		Cone cone;
		strInput = input.readString("Would you like to order an ice cream cone? (y/n) ");


		while(strInput.equals("y") || strInput.equals("Y")){

			numOrdered++;
			flavor = getFlavorChoice();
			topping = getToppingChoice();
			scoops = getScoopsChoice();
			cone = getConeChoice();


			IceCream icecream = new IceCream(scoops,flavor,topping);
			IceCreamCone icecreamcone = new IceCreamCone(icecream, cone);


			System.out.println("Your order:");
            System.out.println(icecreamcone.getIceCreamCone());


            total += icecreamcone.getPrice();
            



			strInput = input.readString("Would you like to order an ice cream cone? (y/n) ");
		}
		System.out.println("Your total order for " + numOrdered + " orders of ice cream is: " + Currency.formatCurrency(total));

	}
	
	public static Flavor getFlavorChoice(){

		Flavors flavors = Flavors.getFlavors();
		Flavor flavor = Flavor.vanilla;
		int choice;
		System.out.println(flavors.listFlavors());

		choice = input.readInt("Enter your desired flavor: ");

		if(choice < 1 || choice > flavors.numFlavors()){

	        while(choice < 1 || choice > flavors.numFlavors()){
	            
	            System.out.println("Please select 1-" + flavors.numFlavors() + " for the flavor.");
	            choice = input.readInt("Enter your desired flavor: ");
	            
	        }
	        
	    }
	    flavor = flavors.getFlavor(choice);
	    return flavor;
	}
	public static Topping getToppingChoice(){

		Toppings toppings = Toppings.getToppings();
		Topping topping = Topping.no_topping;

		int choice;
		System.out.println(toppings.listToppings());

		choice = input.readInt("Enter your desired topping: ");

		if(choice < 1 || choice > toppings.numToppings()){

	        while(choice < 1 || choice > toppings.numToppings()){
	            
	            System.out.println("Please select 1-" + toppings.numToppings() + " for the toppings.");
	            choice = input.readInt("Enter your desired topping: ");
	            
	            
	        }
	        
	    }

	    topping = toppings.getTopping(choice);
		return topping;

	}
	public static int getScoopsChoice(){

		int choice;
		choice = input.readInt("How many scoops (1, 2, or 3) would you like? ");
		if(choice < 1 || choice > 3){
			while(choice < 1 || choice > 3){
				System.out.println("Please select 1, 2, or 3 for the number of scoops.");
				choice = input.readInt("How many scoops (1, 2, or 3) would you like? ");
			}
			

		}
		return choice;

	}
	
	public static Cone getConeChoice(){

		int choice;
		choice = input.readInt("Would you like a 1:  Sugar cone, 2:  Waffle cone, 3:  Cup? ");

		if(choice < 1 || choice > 3){
			while(choice < 1 || choice > 3){
				System.out.println("Please select 1, 2, or 3 for cone choice.");
				choice = input.readInt("Would you like a 1:  Sugar cone, 2:  Waffle cone, 3:  Cup? ");
			}
			

		}
		Cone cone = new Cone(choice);
		return cone;

	}
	
}