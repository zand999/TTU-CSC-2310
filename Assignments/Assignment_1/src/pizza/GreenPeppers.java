package pizza;
public class GreenPeppers extends DecoratedPizza{

    DecoratedPizza pizza;

    public GreenPeppers(DecoratedPizza pizza){
        this.pizza = pizza;
    }

    public double pizzaCost(){
        return (pizza.pizzaCost() + 0.69);
    }

    public String getImage(){
        return pizza.getImage() + "G";
    }

    public String toString(){
        return pizza.toString() + "GreenPeppers\r\n";
    }
}