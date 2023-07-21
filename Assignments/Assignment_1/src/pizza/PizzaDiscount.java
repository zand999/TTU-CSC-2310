package pizza;
public class PizzaDiscount extends DecoratedPizza{
    
    private DecoratedPizza pizza;
    private String discription;
    private double discount;

    PizzaDiscount(DecoratedPizza pizza_component, String msg, double discount){
        
        pizza = pizza_component;
        discription = msg;
        this.discount = discount;

    }

    public double pizzaCost(){

        return (pizza.pizzaCost() - (pizza.pizzaCost() * discount));

    }

    public String toString(){

        return (pizza.toString() + discription);

        
    }
}