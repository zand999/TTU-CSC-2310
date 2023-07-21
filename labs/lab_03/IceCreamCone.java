
public class IceCreamCone{
   

   private IceCream icecream;
   private Cone cone;
   private double cost;

   public IceCreamCone(IceCream icecream, Cone cone){
      Currency curr = new Currency();
      if(icecream != null){

         this.icecream = icecream;

      }else{
         System.out.println("Error: null icecream objects setting defualt value");

         
      }
      if(cone != null){

         this.cone = cone;

      }else{
         System.out.println("Error: null cone objects setting defualt value");
         
      }
      cost = 1.99 + cone.getCost() + icecream.getCost();

   }
   public double getPrice(){
      
      return cost;
   }
   public String getIceCreamCone(){
      return icecream.toString() + cone.toString();
      
   }   



   
}