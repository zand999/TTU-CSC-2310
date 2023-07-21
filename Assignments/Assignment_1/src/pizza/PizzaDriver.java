package pizza;


import java.text.DecimalFormat;
import java.io.*;
import util.*;

public class PizzaDriver{

	private static double total = 0.0;

	private static int menu(){

		int input;
		


	    while(true){

	    	System.out.println("\r\n1. Meat Lover's");
	        System.out.println("2. Veggie Lover's");
	        System.out.println("3. Hawaiian");
	        System.out.println("4. Build Your Own");

	        Keyboard reader = Keyboard.getKeyboard();
	        input = reader.readInt("\nSelect from the above: ");


	        if(input >= 1 || input <= 4){
                break;
	        }

	        System.out.println("Invalid Input. Please Select 1-4.\r\n ");


	    }    
	        
	    


		return input;
	}
	private static void requestSize(PizzaBuilder pizza_builder){


		String input;
        Keyboard reader = Keyboard.getKeyboard();
        input = reader.readString("\nWhat size pizza (S/M/L)? ");
        while(!(pizza_builder.setSize(input.charAt(0)))){

        	input = reader.readString("\nWhat size pizza (S/M/L)? ");

        }

        


	}

	private static void requestCrust(PizzaBuilder pizza_builder){

		String input;
		Keyboard reader = Keyboard.getKeyboard();
        input = reader.readString("\nWhat type of crust (Thin/Hand/Pan)? ");
        while(!(pizza_builder.setCrust(input))){

        	input = reader.readString("\nWhat type of crust (Thin/Hand/Pan)? ");
        	
        }

	}

	private static void requestToppings(PizzaBuilder pizza_builder){


        String input = " ";
		Keyboard reader = Keyboard.getKeyboard();

        while(input.charAt(0) != 'D' && input.charAt(0) != 'd'){

        	input = reader.readString("\n(P)epperoni, (O)nions, (G)reen Peppers,\n(S)ausage, (M)ushroms, (D)one\n");
        	pizza_builder.addTopping(input.charAt(0));

        }


	}


	private static void showOrder(DecoratedPizza dec_pizza){

		DecimalFormat fmt = new DecimalFormat("#,##0.00");

		System.out.println("\nYour Pizza:");
        System.out.println(dec_pizza.toString());
        total += dec_pizza.pizzaCost();
        System.out.println("The cost of your pizza is $" + fmt.format(dec_pizza.pizzaCost()));

	}

	public static void main(String[] args){

		String input = "y";

		Keyboard reader = Keyboard.getKeyboard();

		int numPizzas = 0;
		int choice;

		PizzaBuilder pizza;

		DecimalFormat fmt = new DecimalFormat("#,##0.00");


		input = reader.readString("Would you like to order a pizza (y/n)? ");

        if(input.equals("N") || input.equals("N")){
            System.out.println("\nYou ordered " + numPizzas + " pizza(s) for a grand total of $" + total);
           
        }else{

        	while(true){

        		

				choice = menu();
            	
				switch(choice){

					case 1: 
						pizza = new MeatLovers();
						requestSize(pizza);
                        requestCrust(pizza);
                        pizza.buildPizza();
                        break;
					case 2:
						pizza = new VeggieLovers();
						requestSize(pizza);
						requestCrust(pizza);
                        pizza.buildPizza();
                        break;
					case 3:
						pizza = new Hawaiian();
						requestSize(pizza);
						requestCrust(pizza);
                        pizza.buildPizza();
                        break;
					default:
						pizza = new PizzaBuilder();
						requestSize(pizza);
						requestCrust(pizza);
                        pizza.buildPizza();

                        requestToppings(pizza);
                        break;

				}
	            
	            input = reader.readString("Are you a senior citizen (y/n)? ");

                if(input.charAt(0) == 'Y' || input.charAt(0) == 'y'){
                    pizza.addDiscount();
                }

                input = reader.readString("Do you need this pizza delivered (y/n)? ");
                if(input.charAt(0) == 'Y' || input.charAt(0) == 'y'){
                    pizza.addFee();
                }

                numPizzas++;

	            
	            showOrder(pizza.pizzaDone());
	       

	            input = reader.readString("Would you like to order a pizza (y/n)? ");
        		if(input.equals("N") || input.equals("n")){
		            System.out.println("\nYou ordered " + numPizzas + " pizza(s) for a grand total of $" + fmt.format(total));
		            break;
		        }

		        numPizzas = 0;

			}

        }

		







	}

}