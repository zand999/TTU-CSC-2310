package pizza;
class PizzaTopping extends DecoratedPizza{

    private DecoratedPizza pizza;
    private String string;
    private String letter;
    private double cost;

    PizzaTopping(DecoratedPizza pizza_component,  String  topping_string,  String  topping_letter,  double topping_cost){
    
        this.pizza = pizza_component;
        string = topping_string;
        letter = topping_letter;
        cost = topping_cost;

    }

    public double pizzaCost(){

        return (pizza.pizzaCost() + cost);

    }

    public String getImage(){

        return (pizza.getImage() + letter);

    }

    public String toString(){

        return (pizza.toString() + string + "\r\n");

    }
}