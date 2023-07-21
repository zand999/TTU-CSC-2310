package pizza;
public class Hawaiian extends PizzaBuilder{

    protected void buildPizza(){

        super.buildPizza();
        super.addTopping('H');
        super.addTopping('I');
    }
}