package pizza;
public class MeatLovers extends PizzaBuilder{

    protected void buildPizza(){

        super.buildPizza();
        super.addTopping('P');
        super.addTopping('S');
        super.addTopping('H');
    }
}