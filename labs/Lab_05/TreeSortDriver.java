import java.util.ArrayList;

public class TreeSortDriver
{

   private static CD[] readMusic(String fileName)
   {
      //DO THIS complete this method using the FileIO class
	  //create a new FileIO object for reading
      FileIO file = new FileIO(fileName, 1);
      String str = file.readLine();            //the artist
      ArrayList<CD> cds = new ArrayList<CD>();

      while (!(file.EOF())) //while we are not at the end of the file
      {
		 //file.readLine() will parse one line of the file at a time
         String title = file.readLine();
         int year = Integer.parseInt(file.readLine());
         int rating = Integer.parseInt(file.readLine());
         int numTracks = Integer.parseInt(file.readLine());
         CD cd = new CD(title, str, year, rating, numTracks);

         cds.add(cd);
         int tracks = 1;

         while (tracks <= numTracks)
         {
            String track_str = file.readLine();
            String[] pieces = track_str.split(",");    //divide the string up into two pieces by splitting on a comma (use the String split method)
            String len = pieces[0];
            String songTitle = pieces[1];
            cd.addSong(songTitle, len);
            tracks++;
         }

         str = file.readLine();
      }


      //create a CD[] of the correct size (cds.size()) and populate it using a for-each statement
      CD[] cds_array = new CD[cds.size()];

      int i = 0;
      for(CD temp: cds){

         cds_array[i] = temp;
         
         //System.out.println(cds_array[i].toString());
         i++;
      }
      
     


      return cds_array;
   }
   
   public static void main (String[] args)
   {
      //use the Keyboard class, try-catch, and a while loop to continue calling readMusic 
      //until a valid file name is entered
      //as checked exceptions have been converted to unchecked exceptions, 
      //you must remember to do this with end user input, the compiler will not help you

      CD[] library = null;
      String filename;
      Keyboard input = Keyboard.getKeyboard();
      boolean error = true;


      while(error){
         try{
            filename = input.readString("Enter Library Filename:");

            library = readMusic(filename);

            error = false;
         }catch(FileIOException out){
               System.out.println("Invalid Filename.\r\n" + out);

         }
         
      }
      /*System.out.println("test\r\n");
      for(int i = 0; i < library.length; i++){
         System.out.println(library[i].toString());
      }
      System.out.println("test\r\n\r\n\r\n");
      */
      CD[] newLibrary = (CD[])TreeSort.treeSort(library);

      //once you have the array of CDs back from readMusic, sort them
      //and print them out to make sure that they are sorted
      System.out.println("\r\n\r\nNew Library:\r\n");
      for(int i = 0; i < newLibrary.length; ++i){
         //System.out.println("test");
         System.out.println(newLibrary[i].toString());
      }


   }
}