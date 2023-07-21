import java.util.ArrayList;
import java.awt.Graphics;

/**
 *  This class represents a black jack hand, which contains two or more Cards.
 */
public class BlackJackHand
{
   /** The ArrayList to store all of the Cards in the BlackJackHand. */
   private ArrayList<Card> hand;

   /** A boolean to keep track of whether the Hand is soft or not. */
   private boolean soft;

   /** A boolean to keep track of whether the Hand has been doubled or not. */
   private boolean doubled;

   /**
    * The constructor to accept the starting two Cards for this BlackJackHand. 
    * If one of the Cards is an ace, this BlackJackHand is soft (card.getFaceInt() == 1).
    * The hand is not doubled initially.
    */
   public BlackJackHand(Card card1, Card card2)
   {
      //remember to instantiate the ArrayList before adding anything to it
      //add card1 and then card2 at the end of hand
	  
	  hand = new ArrayList<Card>();
    hand.add(0,card1);
    hand.add(1,card2);
	  
	  //update soft to be true if one of the cards is an ace (value of 1)
	  //otherwise, update soft to be false

    if(card1.getFaceInt() == card2.getFaceInt()){
      soft = true;
    }else{
      soft = false;
    }



     doubled = false;
   }

   /** Draws this BlackJackHand (a player hand) to the screen. */
   public void drawPlayerHands(Graphics g, int x, int y)
   {
      int count = 0;
      //DO THIS write a for-each loop to draw all of the cards in the player's hand
      for(Card card : hand){

         card.draw(g, x, y + (count*35));
         count++;
      }
   }

   /** Draws this BlackJackHand (the dealer's hand) to the screen. */
   public void drawDealerHand(Graphics g, int x, int y, boolean done)
   {
      int count = 0;
      //DO THIS write a for-each loop to draw all of the cards in the dealer's hand

      for(Card card : hand){
         //the first card that the dealer gets is the up card
         //unless the current game is complete, the second card is hidden
         if (count == 0) 
         {            
            card.draw(g, x, y + (count*35));
         }

         else if (done)
         {
            card.draw(g, x, y + (count*35));
         }

         count++;
      }
   }

   /**
    * Helper method to computes the value of this BlackJackHand.
    * Two values are determined (can be computed simultaneously).  
    * The first total is obtained with all aces being counted as 1.
    * The second total is obtained with one ace being counted as 11, if there is at least one ace.
    * Both totals are returned in an integer array!
    * This is to help the calling method (see the next method) to determine if this BlackJackHand is soft or not.
    */
   private int[] sum()
   {
      int[] sum = new int[2];
      sum[0] = 0;
      sum[1] = 0;
      boolean ace = false;  //only one ace is given the value of 11

      //DO THIS (use a for-each statement and complete some details below
      for(Card card : hand){


         int faceInt = card.getFaceInt();
         if (faceInt > 10)
         {
            faceInt = 10;
         }
         sum[0] += faceInt;

         if (faceInt == 1 && !ace) //an ace should be given a value of 11 in this case (faceInt + 10)
         {
            sum[1] += 11;
            ace = true;
         }
         else
         {
            sum[1] += faceInt;
         }

    }

      return sum;
   }

   /**
    * Computes the value of this BlackJackHand.
    * Determines whether this BlackJackHand is soft or not using both totals returned from the helper sum method.

    * If the second total is less than 21 but the second total and the first total are the same, 
    * either total is used and this BlackJackHand is not soft.

    * Otherwise, the second total is used and this BlackJackHand is soft. 
	* If the second total is greater than 21, the first total is used and this BlackJackHand is not soft.
    * Remember to set soft to true if the hand is soft.
    */
   public int handValue()
   {
      int[] total = sum();

      //DO THIS
	  int value;

      if (total[1] <= 21)
      {
         
		 
         if (total[1] == total[0])
         {
            soft = false;
         }

         else if (total[1] > total[0])
         {
            soft = true;
         }
		 
		      value = total[1];
      }
      else //second total is greater than 21
      {
         value = total[0];
         soft = false;
      }


      return value;
   }

   /**
    * Hits this BlackJackHand by adding the Card passed in 
    * to the ArrayList storing the Cards in this BlackJackHand. 
    * This method should be very short.
    */
   public void hit(Card card)
   {
      //DO THIS add card to the end of hand
      hand.add(card);

   }

   /**
    * This method determines whether the BlackJackHand can be split or not. 
    * In order qualify for a possible split, the BlackJackHand can only have two Cards, and they must have the same value.
    * This means that any two cards with value 10 can be split, i.e. a King and a Queen can be split.
    */
   public boolean canSplit()
   {
      boolean split = false;

      if (hand.size() == 2)
      {
         //DO THIS
  		 int card1 = hand.get(0).getFaceInt();
       if (card1 > 10)
       {
          card1 = 10;
       }

       int card2 = hand.get(1).getFaceInt();
       if (card2 > 10)
       {
          card2 = 10;
       }

       if (card1 == card2)
       {
          split = true;
       }
      }
      //System.out.println(split);
      return split;
   }

   /**
    * If the BlackJackHand can be split, this method will split the BlackJackHand. 
    * The two Cards in the current BlackJackHand become one Card each for two new BlackJackHands.
    * The next two Cards for the two new BlackJackHands are passed in as parameters.
    * You will need to create new BlackJackHands.
    */
   public BlackJackHand[] split(Card card1, Card card2)
   {
      BlackJackHand[] split = null;

      if (canSplit())
      {
         //DO THIS
         split = new BlackJackHand[2];
		 //split hand into two new BlackJackHand objects
         split[0] = new BlackJackHand(hand.get(0),card1 );
         split[1] = new BlackJackHand(hand.get(1),card2 );
      }

      return split;
   }


   //NO WORK BELOW HERE
   
   
   /** Returns the value of the first Card in the ArrayList in case this BlackJackHand is the dealer's hand. */
   public int upCard()
   {
      Card card = hand.get(0);

      int faceInt = card.getFaceInt();
      if (faceInt > 10)
      {
         faceInt = 10;
      }

      return faceInt; 
   }

   /** Returns the number of Cards in this BlackJackHand. */
   public int numCards()
   {
      return hand.size();
   }

   /**
    * Returns true if this BlackJackHand has been doubled, and false otherwise. 
    */
   public boolean isDouble()
   {
      return doubled;
   }

   /**
    * Sets this BlackJackHand as having been doubled. 
    */
   public void doubleDown()
   {
      doubled = true;
   }

   /**
    * Returns true if this BlackJackHand is soft, and false otherwise. 
    */
   public boolean isSoft()
   {
      return soft;
   }
}