package pizza;

public class PizzaBuilder{

	private Crust crust;
    private DecoratedPizza pizza;
    private char size;
    private String type;

	public PizzaBuilder(){

		size = 'S';
        type = "THIN";
        crust = new Crust(type, size);
        pizza = new Pizza(crust);

	}

	protected void buildPizza(){

		crust = new Crust(type, size);
		pizza = new Pizza(crust);
	}

	public boolean setSize(char try_size){

        try_size = Character.toUpperCase(try_size);
		if(try_size == 'S'){
			size = 'S';
            return true;
        }
        else if(try_size == 'M'){
        	size = 'M';
            return true;
        }
        else if(try_size == 'L'){
        	size = 'L';
            return true;
        }

        return false;

	}

	public boolean setCrust(String  try_crust){

		try_crust = try_crust.toUpperCase();

        if(try_crust.equals("THIN")){
        	type = try_crust;
            return true;
        }
        else if(try_crust.equals("HAND")){
        	type = try_crust;
            return true;
        }
        else if(try_crust.equals("PAN")){
        	type = try_crust;
            return true;
        }

        return false;
    }

    public void addTopping(char topping_char){

        topping_char = Character.toUpperCase(topping_char);

        if(!(pizza instanceof PizzaDiscount)){

        	if(topping_char == 'P'){
                pizza = new Pepperoni(pizza);
        	}else if(topping_char == 'S'){

                pizza = new Sausage(pizza);

        	}else if(topping_char == 'O'){

                pizza = new Onions(pizza);

        	}else if(topping_char == 'G'){

                pizza = new GreenPeppers(pizza);

        	}else if(topping_char == 'M'){

                pizza = new Mushrooms(pizza);

        	}else if(topping_char == 'H'){

                pizza = new Ham(pizza);

        	}else if(topping_char == 'I'){

                pizza = new Pineapple(pizza);

        	}
        }
    	
    }

    

    public void addDiscount(){

        if(!(pizza instanceof PizzaFee)){
            pizza = new PizzaDiscount(pizza, "Senior Discount\n", 0.10);
        }

    }

    public void addFee(){

        pizza = new PizzaFee(pizza, "Delivery\n", 2.50);

    }
    public DecoratedPizza pizzaDone(){

        DecoratedPizza finnishedPizza = pizza;

        size = 'S';
        type = "THIN";
        crust = new Crust(type, size);
        pizza = new Pizza(crust);

        return finnishedPizza;

    }
}