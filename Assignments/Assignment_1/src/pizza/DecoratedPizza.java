package pizza;
public abstract class DecoratedPizza{

	private DecoratedPizza next_pizza_item;

	DecoratedPizza(){

		next_pizza_item = null;

	}

	DecoratedPizza(DecoratedPizza next){

		next_pizza_item = next;

	}

	public double pizzaCost(){

        return next_pizza_item.pizzaCost();

    }

    public String getImage(){

        return next_pizza_item.getImage();

    }

    public String toString(){

        return next_pizza_item.toString();

    }
}