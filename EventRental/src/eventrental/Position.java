/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventrental;

/**
 *
 * @author MccarthD3455
 */
public class Position
{
    int amountTable;
    int amountChair;
   
   public int getTableAmount()
   {
       return amountTable;
   }
   
   public void setTableAmount(int tableAmount)
   {
       amountTable = tableAmount;
   }
   
   public int getChairAmount()
   {
       return amountChair;
   }
   
   public void setChairAmount(int chairAmount)
   {
       amountChair = chairAmount;
   }
}
