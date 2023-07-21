package pizza;
public class Mushrooms extends DecoratedPizza{

    DecoratedPizza pizza;

    public Mushrooms(DecoratedPizza pizza){
        this.pizza = pizza;
    }

    public double pizzaCost(){
        return (pizza.pizzaCost() + 0.79);
    }

    public String getImage(){
        return pizza.getImage() + "G";
    }

    public String toString(){
        return pizza.toString() + "Mushrooms\r\n";
    }
}