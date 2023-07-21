
public class Pizza extends DecoratedPizza
{
   //the base pizza is just the crust (and tomato sauce) with no toppings
   private Crust crust;

   public Pizza(Crust crust) //constructor-- set default values for new object
   {
      super();  //base level pizza
      this.crust = crust;
   }

   public double pizzaCost()
   {
      return crust.pizzaCost();
   }

   public String getImage()
   {
      String temp = "";
      temp += crust.getSize();
      return temp;
   }

   public String toString() 
   {
      return crust.toString();
   }
}