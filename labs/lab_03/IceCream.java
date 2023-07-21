
public class IceCream{

   private int numScoopes;
   //private String flavor;
   //private String topping;
   private Flavor flavor;
   private Topping topping;
   private double cost;


   public IceCream(){
      numScoopes = 1;
      flavor = Flavor.vanilla;
      topping = Topping.no_topping;
   }

   public IceCream(int numScoopes, Flavor flavor, Topping topping){
   	 

       if(flavor != null){

         this.flavor = flavor;

       }else{
         System.out.println("Error: null flavor objects setting defualt value");

         
       }
       if(topping != null){

         this.topping = topping;

       }else{
         System.out.println("Error: null topping objects setting defualt value");
         
       }
       if(numScoopes <= 3 || numScoopes >=1){

         this.numScoopes = numScoopes;

       }else{

         System.out.println("Error: null flavor or topping objects setting defualt values");
         
       }
       cost = ((numScoopes - 1) * 0.75) + topping.price();
   		
   }
   public double getCost(){
      return cost;
   }

   public String toString(){

      return "Number of Scoops: " + numScoopes + "\r\nFlavor: " + flavor.toString() + "\r\nTopping: " + topping.toString()+ "\r\nTopping: ";

   }

}