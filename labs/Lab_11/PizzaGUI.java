import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.dnd.*;

//DO THIS
//You will need to implement ToppingSelected and Drawable as well!
public class PizzaGUI extends CenterFrame implements ActionListener, ToppingSelected,Drawable
{

   public static void main (String[] args)
   {
      PizzaGUI pg = new PizzaGUI(800, 425);
   }
   
   private DecoratedPizza pizza;
   private ToppingList lstToppings; 
   
   private Image image;
   private JPanel controls;
   private DrawPanel pizzaPanel;

   private JRadioButton small;
   private JRadioButton medium;
   private JRadioButton large;

   private JRadioButton thin;
   private JRadioButton handtossed;
   private JRadioButton deepdish;

   private JLabel pizzaCrust;
   private JLabel pizzaSize;
   private JLabel pizzaToppings;

   private JButton btn;

   private JCheckBox mushrooms;
   private JCheckBox pepperoni;
   private JCheckBox peppers;
   private JCheckBox onions;
   private JCheckBox sausage;

   public PizzaGUI(int width, int height)
   {  
      super (width, height, "Pizza Time!");

      //create a new DrawPanel()
	  //set the drawable to PizzaGUI
	  //set the Background to white (Color.white)

      pizzaPanel = new DrawPanel();
      pizzaPanel.setDrawable(this);  //can't register the pizza as the object that it refers to is constantly changing (Decorator)
      pizzaPanel.setBackground(Color.white);
	  

      setResizable(false);
      setUp(width, height);
      setVisible(true);
   }

   private void setUp(int width, int height)
   {
      setBackground(Color.white);

      controls = new JPanel();
      controls.setBackground(Color.white);
      setLayout(new GridLayout(1, 2));
      add(pizzaPanel);
      add(controls);

      small = new JRadioButton("S", true);
      small.setBackground(Color.white);
      medium = new JRadioButton("M");
      medium.setBackground(Color.white);
      large = new JRadioButton("L");
      large.setBackground(Color.white);
      ButtonGroup size = new ButtonGroup();
      size.add(small);
      size.add(medium);
      size.add(large);

	  //DO THIS (add action listeners to the small, medium, and large JRadioButtons)
      small.addActionListener(this);
      medium.addActionListener(this);
      large.addActionListener(this);


	  //if one of these check boxes is changed, the pizza is rebuilt and redrawn
	  
	  
	  
	  
      thin = new JRadioButton("Thin", true);
      thin.setBackground(Color.white);
      handtossed = new JRadioButton("Hand-Tossed");
      handtossed.setBackground(Color.white);
      deepdish = new JRadioButton("Deep Dish");
      deepdish.setBackground(Color.white);
      ButtonGroup crust = new ButtonGroup();
      crust.add(thin);
      crust.add(handtossed);
      crust.add(deepdish);

      btn = new JButton("Order!");
      btn.setBackground(Color.white);

      pizzaSize = new JLabel("Select Pizza Size:");
      pizzaCrust = new JLabel("Select Pizza Crust:");
      pizzaToppings = new JLabel("Select Pizza Toppings:");

      mushrooms = new JCheckBox("Mushrooms");
      mushrooms.setBackground(Color.white);
      pepperoni = new JCheckBox("Pepperoni");
      pepperoni.setBackground(Color.white);
      sausage = new JCheckBox("Sausage");
      sausage.setBackground(Color.white);
      onions = new JCheckBox("Onions");
      onions.setBackground(Color.white);
      peppers = new JCheckBox("Green Peppers");
      peppers.setBackground(Color.white);

      EasyGridBag bag = new EasyGridBag(6, 3, controls);
      controls.setLayout(bag);
      bag.fillCellCenterWithinCell(1, 1, pizzaSize);

      bag.fillCellAlignWithinCell(2,1,GridBagConstraints.WEST,small);
      bag.fillCellAlignWithinCell(3,1,GridBagConstraints.WEST,medium);
      bag.fillCellAlignWithinCell(4,1,GridBagConstraints.WEST,large);
      bag.fillCellAlignWithinCell(1,1,GridBagConstraints.WEST,pizzaSize);

      bag.fillCellAlignWithinCell(1,2,GridBagConstraints.WEST,pizzaCrust);
      bag.fillCellAlignWithinCell(2,2,GridBagConstraints.WEST,thin);
      bag.fillCellAlignWithinCell(3,2,GridBagConstraints.WEST,handtossed);
      bag.fillCellAlignWithinCell(4,2,GridBagConstraints.WEST,deepdish);

      //this code is being replaced by your Jlist and lstToppings
/*       
      bag.fillCellAlignWithinCell(1,3,GridBagConstraints.WEST,pizzaToppings);

      bag.fillCellAlignWithinCell(2,3,GridBagConstraints.WEST,pepperoni);
      bag.fillCellAlignWithinCell(3,3,GridBagConstraints.WEST,onions);
      bag.fillCellAlignWithinCell(4,3,GridBagConstraints.WEST,peppers);
      bag.fillCellAlignWithinCell(5,3,GridBagConstraints.WEST,sausage);
      bag.fillCellAlignWithinCell(6,3,GridBagConstraints.WEST,mushrooms);

      bag.fillCellWithRowColSpan(2, 3, 5, 1, GridBagConstraints.BOTH, lstToppings);
 */
      bag.fillCellCenterWithinCell(6, 2, btn);
      btn.addActionListener(this);  //a JFrame can listen for events on itself
      btn.setActionCommand("Order");
   
	  lstToppings = new ToppingList(this);
   
      bag.fillCellAlignWithinCell(1, 3, GridBagConstraints.WEST, pizzaToppings);
      bag.fillCellWithRowColSpan(2, 3, 5, 1, GridBagConstraints.BOTH, lstToppings);
   
	  //DO THIS
  
      //obtain the default DragSource for this JVM (one instance per JVM) (DragSource method)
      DragSource dragSource = DragSource.getDefaultDragSource();

      //create a DragGestureRecognizer to listen for drags
      //lstToppings will be notified when a drag gesture is detected (first & third parameters)
	  //you will use the copy action: DnDConstants.ACTION_COPY
      
      dragSource.createDefaultDragGestureRecognizer(lstToppings, DnDConstants.ACTION_COPY, lstToppings);
      //create and set up a new DropTarget that will listen for drags and
      //drops over pizzaPanel component (first parameter), 
      //and will notify the DropTargetListener (lstToppings, second parameter)
      //the transferable is extracted from the event object
      //lstToppings is the listener that is notified
	  DropTarget dropTarget = new DropTarget(pizzaPanel,lstToppings);


      pizza = buildPizza();  //build and display the default pizza
   }
   
    public void draw(Graphics g, int width, int height)
   {
      //call your DecoratedPizza instance variable's draw method (make sure to complete this within DecoratedPizza.java as well)
      pizza.draw(g, width, height);
	  
   }   

   //DO THIS
   //complete this build pizza method
   public DecoratedPizza buildPizza()
   {
      //call methods to build the pizza:
	  //create a new PizzaBuilder
	  PizzaBuilder builder = new PizzaBuilder();
	  //set the crust
	  
	  //set the size
	  
	  //grab a DecoratedPizza from the PizzaBuilder (buildPizza method)

	  //set your Toppings and update your DecoratedPizza


      repaint();  //paints the DrawPanel, which calls draw here in the GUI, which draws the newly configured pizza
      return pizza;
   }
   
   //the method that is called when a successful drop has occurred
   //invisible check boxes are toggled
   public void toppingSelected(String topping)
   {
      
	  //call setSelected and set to true on toppings based on the string 
	  if(topping.equals("pepperoni")){
      pepperoni.setSelected(true);
     }
	  
	  /*
	  if (topping.equals("pepperoni"))
      {​​​​
         pepperoni.setSelected(true);
      }​​​​
 
      else if (topping.equals("onions"))
      {​​​​
         onions.setSelected(true);
      }​​​​
 
      else if (topping.equals("green peppers"))
      {​​​​
         peppers.setSelected(true);
      }​​​​
 
      else if (topping.equals("sausage"))
      {​​​​
         sausage.setSelected(true);
      }​​​​
 
      else if (topping.equals("mushrooms"))
      {​​​​
         mushrooms.setSelected(true);
      }​​​​
 */
      //update the pizza image by rebuilding the pizza
      pizza = buildPizza();
	  
	  
   }   
   
   public void actionPerformed(ActionEvent ae)
   {
      //the pizza has been ordered, so now we make it
      if (ae.getActionCommand().equals("Order"))
      {
         String temp = pizza.toString();
         java.text.DecimalFormat fmt = new java.text.DecimalFormat("0.00");
         temp = temp + "$" + fmt.format(pizza.pizzaCost());
         SimpleDialogs.normalOutput(temp, "Pizza Order");

		 //DO THIS (resets)
         //reset the Toppings (resets hidden check boxes)
		    resetToppings();
         //reset lstToppings (to get the topping choices back)
	        lstToppings.reset();
      }

      //called after each interaction with the GUI to make sure the latest pizza is displayed
      pizza = buildPizza();
   }   
   
   public void setCrust(PizzaBuilder pizza)
   {
      if (thin.isSelected())
      {
         pizza.setCrust("thin");
      }
      else if (handtossed.isSelected())
      {
         pizza.setCrust("hand");
      }
      else
      {
         pizza.setCrust("pan");
      }
   }

   public void setSize(PizzaBuilder pizza)
   {
      if (small.isSelected())
      {
         pizza.setSize('S');
      }
      else if (medium.isSelected())
      {
         pizza.setSize('M');
      }
      else
      {
         pizza.setSize('L');
      }
   }

   public DecoratedPizza setToppings(DecoratedPizza pizza)
   {

      if (pepperoni.isSelected())
      {
         pizza = new Pepperoni(pizza);
      }

      if (onions.isSelected())
      {
         pizza = new Onions(pizza);
      }

      if (peppers.isSelected())
      {
         pizza = new Peppers(pizza);
      }

      if (sausage.isSelected())
      {
         pizza = new Sausage(pizza);
      }

      if (mushrooms.isSelected())
      {
         pizza = new Mushrooms(pizza);
      }

      return pizza;
   }


   
   public void resetToppings()
   {
      pepperoni.setSelected(false);
      onions.setSelected(false);
      peppers.setSelected(false);
      sausage.setSelected(false);
      mushrooms.setSelected(false);
   }
   
   
}