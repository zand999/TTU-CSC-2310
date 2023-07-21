
/*
 *  The purpose of this class is to place the logic needed to ensure the creation of a "valid"
 *  pizza outside the various pizza classes (base pizza and toppings classes), 
 *  simplifying the logic in those classes.
 */ 
public class PizzaBuilder
{
   /* the size of the pizza (S, M, L) */
   private char size;

   /* an enumeration that will store the crust type (THIN, HAND, PAN) */
   private CrustType crustType; 

   /* 
    * Builds and returns the base pizza with valid settings for the crust.
    * Child classes can also add toppings, allowing the addition of specialty pizzas to the menu.
    */
   public DecoratedPizza buildPizza()
   {
      Crust crust = new Crust(size, crustType);
      Pizza pizza = new Pizza(crust);

      //reset to build another pizza
      size = 'S';
      crustType = CrustType.THIN;

      return pizza;
   }
   /* The constructor sets the size and crust type to valid default values. */
   public PizzaBuilder()
   {
      size = 'S';
      crustType = CrustType.THIN;
   }

   /* 
    * Allows the user to change the size of the crust.  
    * Ensures that only valid requests will change the size. 
    * Informs the user whether the requested change was successful (was the request valid).
    */
   public boolean setSize(char trySize)
   {
      boolean test = false;
      //lowercase s, m, l are also valid (change to uppercase)
      trySize = Character.toUpperCase(trySize);

      //check the character passed to the method against S, M, L
      if (trySize == 'S' || trySize == 'M' || trySize == 'L')
      {
         size = trySize; //only set for valid entries
         test = true;
      }
    
      return test;
   }

   /* 
    * Allows the user to change the type of the crust.  
    * Ensures that only valid requests will change the type of the crust. 
    * Informs the user whether the requested change was successful (was the request valid).
    */
   public boolean setCrust(String tryCrust)
   {
      boolean test = false;
      tryCrust = tryCrust.toLowerCase();

      //checking the String passed for "thin", "hand", or "pan" (ignores case)
      if (tryCrust.equals("thin"))
      {
         crustType = CrustType.THIN;
         test = true;
      }
      else if (tryCrust.equals("hand"))
      {
         crustType = CrustType.HAND;
         test = true;
      }
      else if (tryCrust.equals("pan"))
      {
         crustType = CrustType.PAN;
         test = true;
      }

      return test;
   }
}