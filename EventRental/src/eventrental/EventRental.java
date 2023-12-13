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
import javafx.util.Pair;
//KINDA WORKS RIGHT NOW FORCED TO PUSH WHILE WORKING ON IT
/**
 *
 * @author Maven
 */
public class EventRental 
{
    private static final double CHAIR_COST = 10.0;
    private static final double TABLE_COST = 20.0;
    public static int position = 0;
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
        int i = 1;
        ArrayList<Table> tables = new ArrayList<>();
        ArrayList<Chair> chairs = new ArrayList<>();
        ArrayList<Position> positions = new ArrayList<>();
        String[] tablesChairChoice = {"Tables and Chairs", "Tables or Chairs"};
        String[] tablesOrChairsChoice = {"Tables", "Chairs"};
        String[] addMoreChoices = {"Yes", "No"};
        JFrame message = new JFrame("Receipt");
        JTextArea receiptTextArea;
        double totalAmt = 0.0;
        message.setSize(300, 400);
        message.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // inititalize jtext component
        receiptTextArea = new JTextArea();
        receiptTextArea.setEditable(false);
        // layout
        message.setLayout(new BorderLayout());
        // add component
        message.add(new JScrollPane(receiptTextArea), BorderLayout.CENTER);
        receiptTextArea.append("Tables and Chairs Reservations");
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
                    Position position = new Position();
                    chairAmount = Integer.parseInt(JOptionPane.showInputDialog(null, "How many Chairs do you need?", "Event Planner", JOptionPane.QUESTION_MESSAGE));
                    chairz.setChairAmount(chairAmount);
                    position.setChairAmount(chairAmount);
                    tableAmount = Calculations.CalculateTableAmount(chairAmount);
                    tablez.setTableAmount(tableAmount);
                    position.setTableAmount(tableAmount);
                    tables.add(tablez);
                    chairs.add(chairz);
                    positions.add(position);
                    totalAmt += chairAmount * CHAIR_COST + tableAmount * TABLE_COST;
                    break;
                case "Tables or Chairs":
                    userChoice = (String)JOptionPane.showInputDialog(null, "Choose Tables or Chairs", "Event Planner", JOptionPane.QUESTION_MESSAGE, null, tablesOrChairsChoice,  tablesOrChairsChoice[0]);
                    switch(userChoice)
                    {
                        case "Tables":
                            Table table = new Table();
                            Chair Chair = new Chair();
                            Position positionz = new Position();
                            chairAmount = 0;
                            Chair.setChairAmount(chairAmount);
                            positionz.setChairAmount(chairAmount);
                            tableAmount = Integer.parseInt(JOptionPane.showInputDialog(null, "How many Tables do you want?", "Event Planner", JOptionPane.QUESTION_MESSAGE)); //gets user input
                            table.setTableAmount(tableAmount);
                            positionz.setTableAmount(tableAmount);
                            tables.add(table);
                            chairs.add(Chair);
                            positions.add(positionz);
                            totalAmt += tableAmount * TABLE_COST;
                            break;
                        
                        case "Chairs":
                            Chair chair = new Chair();
                            Table Table = new Table();
                            Position Position = new Position();
                            tableAmount = 0;
                            Table.setTableAmount(tableAmount);
                            Position.setTableAmount(tableAmount);
                            chairAmount = Integer.parseInt(JOptionPane.showInputDialog(null, "How many Chairs do you want?", "Event Planner", JOptionPane.QUESTION_MESSAGE)); //gets user input
                            chair.setChairAmount(chairAmount);
                            Position.setChairAmount(chairAmount);
                            chairs.add(chair);
                            tables.add(Table);
                            positions.add(Position);
                            totalAmt += chairAmount * CHAIR_COST;
                            break;
                    }
                    break;
            }
            tryAgain = tryAgain(addMoreChoices);
        }
        while (tryAgain == true); 
        for (Object obj : positions)
        {
            receiptTextArea.append("\nPosition " + i + ":");
            i++;
            Position newPosition = (Position) obj;
            receiptTextArea.append("\nTable: " + newPosition.getTableAmount());
            receiptTextArea.append("\nChair: " + newPosition.getChairAmount());
        }
        
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
          position += 1;
      }
      else if (tryAgain == 1)
      {
         tryAgainBool = false;
      }
      return tryAgainBool;
    }
}
