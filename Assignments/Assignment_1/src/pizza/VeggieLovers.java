package pizza;
public class VeggieLovers extends PizzaBuilder{

    protected void buildPizza(){

        super.buildPizza();
        super.addTopping('O');
        super.addTopping('G');
        super.addTopping('M');
    }
}