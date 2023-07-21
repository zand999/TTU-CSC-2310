package pizza;
public class PizzaFee extends DecoratedPizza{

    private DecoratedPizza pizza;
    private String discription;
    private double fee;

    public PizzaFee(DecoratedPizza pizza_component, String msg, double fee){

        pizza = pizza_component;
        discription = msg;
        this.fee = fee;


    }

    public double pizzaCost(){

        return pizza.pizzaCost() + fee;
    }

    public String toString(){

        return pizza.toString() + discription;

    }
}