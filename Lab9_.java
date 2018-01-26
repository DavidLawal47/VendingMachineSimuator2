package lab_9vendingMachine;

//public class Lab9_ {
	
	/*
	 * David Lawal CSCI 1302 TR 2:00pm -350
	Vending Machine simulation programs that displays candy to user and asks for correct 
	amount of money and allows the user to choose what candy they want. GUI will be the technology that will be used for this 
	program
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab9_ extends JFrame implements ActionListener{
   private static final int WIDTH = 300;
   private static final int HEIGHT = 300;

        //Instance variables
   ProductDispenser Candy = new ProductDispenser(150, 100);
	ProductDispenser Chips = new ProductDispenser(75, 12);
	ProductDispenser Gum = new ProductDispenser(100, 12);
	ProductDispenser Cookies = new ProductDispenser(25, 12);

   private JLabel headingMainL;
   private JLabel selectionL;

   private JButton exitB, candyB, chipsB, gumB, cookiesB;
  
   public Lab9_(){
      setTitle("Candy Machine");      //set the window title
      setSize(WIDTH, HEIGHT);         //set the window size

      Container pane  = getContentPane();  //get the container
      pane.setLayout(new GridLayout(7,1)); //set the pane layout

     headingMainL = new JLabel("Hello, and welcome to Dave's Candy Shop",
                              SwingConstants.CENTER); //instantiate
                                                  //the first label
      selectionL = new JLabel("To Make a Selection, "
                            + "Click on the Product Button",
                              SwingConstants.CENTER); //instantiate
                                             //the second label

      pane.add(headingMainL);   //add the first label to the pane
      pane.add(selectionL);     //add the second label to the pane

      candyB = new JButton("Candy");  //instantiate the candy
                                      //button
      candyB.addActionListener(this);   //register the
                                             //listener to the
                                             //candy button
      chipsB = new JButton("Chips");  //instantiate the chips
                                      //button
      chipsB.addActionListener(this);  //register the
                                            //listener to the
                                            //chips button
      gumB = new JButton("Gum");     //instantiate the gum button
      gumB.addActionListener(this);  //register the listener
                                          //to the gum button

      cookiesB = new JButton("Cookies");   //instantiate the
                                           //cookies button
      cookiesB.addActionListener(this); //register the
                              //listener to the cookies button

      exitB = new JButton("Exit");   //instantiate the exit button
      exitB.addActionListener(this); //register the listener
                                          //to the exit button

      pane.add(candyB);     //add the candy button to the pane
      pane.add(chipsB);     //add the chips button to the pane
      pane.add(gumB);       //add the gum button to the pane
      pane.add(cookiesB);   //add the cookies button to the pane
      pane.add(exitB);      //add the exit button to the pane

      setVisible(true);     //show the window and its contents
      setDefaultCloseOperation(EXIT_ON_CLOSE);

   } //end constructor

          //class to handle button events
        public void actionPerformed (ActionEvent e){
          if (e.getActionCommand().equals("Exit"))
              System.exit(0);
          else if (e.getActionCommand().equals("Candy"))
              sellProduct(Candy, "Candy");
          else if (e.getActionCommand().equals("Chips"))
              sellProduct(Chips, "Chips");
          else if (e.getActionCommand().equals("Gum"))
              sellProduct(Gum, "Gum");
          else if (e.getActionCommand().equals("Cookies"))
              sellProduct(Cookies, "Cookies");
      }
        //Method to sell a product
   private void sellProduct(ProductDispenser product, String cashreg){
     double coinsInserted = 0;
     double price;
     double coinsRequired;

     String str;

     if (product.getProdQty() > 0){
        price = product.getProdCost();
        coinsRequired = price - coinsInserted;

        while (coinsRequired > 0){
            str = JOptionPane.showInputDialog("To buy "
                                  + cashreg
                                  + " please insert "
                                  + coinsRequired + " cents");
            coinsInserted = coinsInserted
                            + Integer.parseInt(str);
            coinsRequired = price - coinsInserted;
        }

       

        JOptionPane.showMessageDialog(null,"Please pick up your "
                               + cashreg + " and enjoy",
                                "Thank you, enjoy",
                               JOptionPane.PLAIN_MESSAGE);
     }
     else           //dispenser is empty
        JOptionPane.showMessageDialog(null,"Sorry "
                               + cashreg
                               + " is sold out\n" +
                               "Make another selection",
                               "Thank you,enjoy",
                               JOptionPane.PLAIN_MESSAGE);
   }//end sellProduct

   public static void main(String[] args){
        Lab9_ candyShop = new Lab9_();
        
        
   }class ProductDispenser {
		// Data elements:
		private double prodCost;
		private int prodQty;

		// Methods:
		ProductDispenser(double cost, int qty) { // Constructor
			prodCost = cost;
			prodQty = qty;
		}
		double getProdCost() {
			return prodCost;
		}
		int getProdQty() {
			return prodQty;
		}
		void setProdQty(int qty) {
			prodQty -= qty;
		}
		class CashRegister {
			// Data elements:
			private double cashOnHand;

			// Methods:
			CashRegister() { 						// Constructor
				cashOnHand = 0;
			}
			double getCashOnHand() {
				return cashOnHand;
			}
			void setCashOnHand(double purchase) {
				cashOnHand += purchase;
			}
			
		}
   }
}


