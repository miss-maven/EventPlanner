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
public class Table {
    public void calculateCost() {
        //tables are $20
        int amountTables = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tables you would like to rent: "));
        double tableCost = 20.00;
        double multiTable; 
        double tableLength = 0;
        multiTable = tableCost * tableLength;
        double totalTables = tableCost * amountTables;
        JOptionPane.showMessageDialog(null, "Tables Total $ " + totalTables);
    }
}
