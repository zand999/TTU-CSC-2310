package pizza;
class PizzaToppingFactory{

    public static DecoratedPizza addPepperoni(DecoratedPizza dec_pizza){

        dec_pizza = new PizzaTopping(dec_pizza, "Pepperoni\n", "P", 0.99);

        return dec_pizza;

    }

    
}