package pizza;
public class Ham extends DecoratedPizza{

    DecoratedPizza pizza;

    public Ham(DecoratedPizza pizza){
        this.pizza = pizza;
    }

    public double pizzaCost(){
        return (pizza.pizzaCost() + 0.89);
    }

    public String getImage(){
        return pizza.getImage() + "H";
    }

    public String toString(){
        return pizza.toString() + "Ham\r\n";
    }
}