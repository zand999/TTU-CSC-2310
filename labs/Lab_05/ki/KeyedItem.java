//place this file in the ki subdirectory
package ki;

public abstract class KeyedItem
{
	//create private instance variable of type Comparable
   private Comparable comparable;
	
  
   public KeyedItem(Comparable key) 
   {
	   
	   comparable = key;
   }  

   public Comparable getKey() 
   {
	   
	   
      return comparable;
   }  

   //Use Comparable's toString() method
   public String toString()
   {
	   return comparable.toString();
	   
   }
}