import java.util.Iterator;
import bst.*;
import ki.KeyedItem;

public class TreeSort
{
   //convenience method
   public static KeyedItem[] treeSort(KeyedItem[] sort)
   {
      //call below treeSort method, passing in sort and its size (use the java length variable to obtain n)

	     return treeSort(sort, sort.length);
   }
   
   //easier to use a KeyedItem array than Comparable
   public static KeyedItem[] treeSort(KeyedItem[] sort, int n)
   {
	  //error checking 
      if (n > sort.length || n <= 0)
      {
         n = sort.length;
      }
	  
	  //create a new Binary Search Tree
      //a balanced tree ensures logn inserts for nlogn sort

	  BinarySearchTree tree = new BinarySearchTree(true,true);
	  
	  
	  
      //need to use the Class class as the actual array type may be a subtype of KeyedItem
      Class cls = sort.getClass().getComponentType();
      KeyedItem[] temp = (KeyedItem[]) java.lang.reflect.Array.newInstance(cls, n);
	  
	  
 
      // fill up the search tree
      
      for(int i = 0; i < n; i++){

         try{
            tree.insert(sort[i]);
         }catch(bst.TreeException out){
            System.out.println("Error: duplicate item?:\n\r" + out);
            System.exit(0);
         }


      }

      //use a TreeIterator on your BST to call setInorder

      TreeIterator iterator = tree.iterator();
	  
	   iterator.setInorder();
      //pull sorted stuff out of the tree into temp
      for(int i = 0; iterator.hasNext();i++){
         temp[i] = (KeyedItem)iterator.next();
      }

      for(int i = n ; i < sort.length; i++){
         temp[i] = sort[i];
      }
	  

	  
	  
	  return temp;
	  
   }
}
