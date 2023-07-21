package pizza;
public class Sausage extends DecoratedPizza{

    DecoratedPizza pizza;

    public Sausage(DecoratedPizza pizza){
        this.pizza = pizza;
    }

    public double pizzaCost(){
        return (pizza.pizzaCost() + 0.99);
    }

    public String getImage(){
        return pizza.getImage() + "S";
    }

    public String toString(){
        return pizza.toString() + "Sausage\r\n";
    }
}