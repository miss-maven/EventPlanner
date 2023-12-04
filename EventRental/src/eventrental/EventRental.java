/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventrental;

import javax.swing.JOptionPane;

/**
 *
 * @author Maven
 */
public class EventRental {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choice; 
        do {
            choice = Integer.parseInt(JOptionPane.showInputDialog("Select: \n1. Rent Table\n2. Rent Chair\n3. Quit"));
            switch (choice) {
                case 1: 
                    Table table = new Table();
                    table.calculateCost();
                    break;
                case 2: 
                    Chair chair = new Chair();
                    chair.calculateCost();
                    break;
                case 3: 
                    break; 
                default: 
                    JOptionPane.showMessageDialog(null, "Invalid choice");
            }
        }
        while (choice !=3); 
    }
    
}
