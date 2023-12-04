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
public class Chair {
    //chairs are $10 each 
    public void calculateCost() {
        int amountChairs = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount of chairs you would like to rent: "));
        double costChair = 10.00;
        double totalChairs = costChair * amountChairs; 
        JOptionPane.showMessageDialog(null, "Chairs Total $ " + totalChairs);
    }
}
