package pizza;
public class Pineapple extends DecoratedPizza{

    DecoratedPizza pizza;

    public Pineapple(DecoratedPizza pizza){
        this.pizza = pizza;
    }

    public double pizzaCost(){
        return (pizza.pizzaCost() + 0.89);
    }

    public String getImage(){
        return pizza.getImage() + "I";
    }

    public String toString(){
        return pizza.toString() + "Pineapple\r\n";
    }
}