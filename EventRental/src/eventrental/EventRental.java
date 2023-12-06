/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventrental;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.util.ArrayList;
//KINDA WORKS RIGHT NOW FORCED TO PUSH WHILE WORKING ON IT
/**
 *
 * @author Maven
 */
public class EventRental 
{
 
    /**
     * @param args the command line arguments
     */   
    public static void main(String[] args) 
    {
        // TODO code application logic here
        String choice;
        String userChoice;
        int chairAmount;
        int tableAmount;
        ArrayList<Table> tables = new ArrayList<>();
        ArrayList<Chair> chairs = new ArrayList<>();
        String[] tablesChairChoice = {"Tables and Chairs", "Tables or Chairs"};
        String[] tablesOrChairsChoice = {"Tables", "Chairs"};
        String[] addMoreChoices = {"Yes", "No"};
        JFrame message = new JFrame("Receipt");
        JTextArea receiptTextArea;
        message.setSize(300, 400);
        message.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // inititalize jtext component
        receiptTextArea = new JTextArea();
        receiptTextArea.setEditable(false);
        // layout
        message.setLayout(new BorderLayout());
        // add component
        message.add(new JScrollPane(receiptTextArea), BorderLayout.CENTER);
        receiptTextArea.append("Event Rental Reservations");
        //FinalFrame finalFrame = new FinalFrame();
        boolean tryAgain = true;
        do 
        {
            choice = (String)JOptionPane.showInputDialog(null, "Choose what you want", "Event Planner", JOptionPane.QUESTION_MESSAGE, null, tablesChairChoice, tablesChairChoice[0]); //DropDown menu
            switch (choice) 
            {
                case "Tables and Chairs":
                    Chair chairz = new Chair();
                    Table tablez = new Table();
                    chairAmount = Integer.parseInt(JOptionPane.showInputDialog(null, "How many Chairs do you need?", "Event Planner", JOptionPane.QUESTION_MESSAGE));
                    chairz.setChairAmount(chairAmount);
                    tableAmount = Calculations.CalculateTableAmount(chairAmount);
                    tablez.setTableAmount(tableAmount);
                    tables.add(tablez);
                    chairs.add(chairz);
                    break;
                case "Tables or Chairs":
                    userChoice = (String)JOptionPane.showInputDialog(null, "Choose Tables or Chairs", "Event Planner", JOptionPane.QUESTION_MESSAGE, null, tablesOrChairsChoice,  tablesOrChairsChoice[0]);
                    switch(userChoice)
                    {
                        case "Tables":
                            Table table = new Table();
                            Chair Chair = new Chair();
                            chairAmount = 0;
                            Chair.setChairAmount(chairAmount);
                            tableAmount = Integer.parseInt(JOptionPane.showInputDialog(null, "How many Tables do you want?", "Event Planner", JOptionPane.QUESTION_MESSAGE)); //gets user input
                            table.setTableAmount(tableAmount);
                            tables.add(table);
                            chairs.add(Chair);
                            break;
                        
                        case "Chairs":
                            Chair chair = new Chair();
                            Table Table = new Table();
                            tableAmount = 0;
                            Table.setTableAmount(tableAmount);
                            chairAmount = Integer.parseInt(JOptionPane.showInputDialog(null, "How many Chairs do you want?", "Event Planner", JOptionPane.QUESTION_MESSAGE)); //gets user input
                            chair.setChairAmount(chairAmount);
                            chairs.add(chair);
                            tables.add(Table);
                            break;
                    }
                    break;
            }
            tryAgain = tryAgain(addMoreChoices);
        }
        while (tryAgain == true); 
        for (Object obj : tables)
        {
            int i = 1;
            Table newTable = (Table) obj;
            receiptTextArea.append("\nPosition " + i);
            receiptTextArea.append("\nTable: " + newTable.getTableAmount() + " $ ");
        }
        for (Object obj : chairs)
        {
            int i = 1;
            Chair newChair = (Chair) obj;
            receiptTextArea.append("\nPosition " + i);
            receiptTextArea.append("\nChair: " + newChair.getChairAmount() + " $ ");
        }
        
        double totalAmt = 0.0;    // placeholder
        receiptTextArea.append("\n---------------");
        receiptTextArea.append("\nTotal: $" + totalAmt);
        if (tryAgain == false)
        {
            message.setVisible(true);
        }
    }
     public static boolean tryAgain(String[] addMoreChoices)
    {
      int tryAgain;
      boolean tryAgainBool = false;
      tryAgain = JOptionPane.showOptionDialog(null, "Do you wish to add another position?","Event Planner", 0, 3, null, addMoreChoices, addMoreChoices[0]); //buttons for JOptionPane 
      if(tryAgain == 0)
      {
          tryAgainBool = true;
      }
      else if (tryAgain == 1)
      {
         tryAgainBool = false;
      }
      return tryAgainBool;
    }
    
     /*public class FinalFrame extends JFrame
     {
         private JTextArea receiptTextArea;
         
         public FinalFrame() 
         {
             // setting up jframe
             setTitle("Receipt");
             setSize(300, 400);
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             
             // inititalize jtext component
             receiptTextArea = new JTextArea();
             receiptTextArea.setEditable(false);
             
             // layout
             setLayout(new BorderLayout());
             
             // add component
             add(new JScrollPane(receiptTextArea), BorderLayout.CENTER);
             
             // display
             setVisible(true);
         }
         
         public void addItem(String item, double price)
         {
             // use this method to set receipt items (chair, table)
             receiptTextArea.append(String.format("%-20s $%.2f\n", item, price));           
         }
         
         public void setTotalAmt(double total)
         {
             // use this method to set total
             receiptTextArea.append("\n---------------\n");
             receiptTextArea.append(String.format("Total: $%.2f", total));           
         }
         
     }*/
}
