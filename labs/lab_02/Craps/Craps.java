/*

	Author: Alex Zandstra
	Date:9-10-20
	


*/
import java.util.Random;
public class Craps
{

   public static int playCraps(int num_rolls){
     
	 
	 int total,numtimes=0;
	 double percentage;
	 CrapsDice roller = new CrapsDice();
	 for(int i = 0; i < num_rolls;i++){

	 	total = roller.roll();

	 	if(total == 2 || total == 3 || total == 12){
	 		numtimes++;
	 	}

	 }

	 percentage = 100 * ((double)numtimes / (double)num_rolls);
	 return (int)percentage;
   }
   public static void main(String[] args){
      
	  
	  int percentage = playCraps(752);
	  
	  System.out.println("The percentage of times 2,3, or 12 were rolled was " + percentage + "%");
	  
   }

}