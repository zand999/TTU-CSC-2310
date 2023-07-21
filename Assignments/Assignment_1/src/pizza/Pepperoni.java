package pizza;
public class Pepperoni extends DecoratedPizza{

    DecoratedPizza pizza;

    public Pepperoni(DecoratedPizza pizza){
        this.pizza = pizza;
    }

    public double pizzaCost(){
        return (pizza.pizzaCost() + 0.99);
    }

    public String getImage(){
        return pizza.getImage() + "P";
    }

    public String toString(){
        return pizza.toString() + "Pepperoni\r\n";
    }
}