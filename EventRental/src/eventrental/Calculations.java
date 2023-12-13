/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventrental;
import java.util.ArrayList;
/**
 *
 * @author MccarthD3455
 */
public class Calculations
{
    public static int CalculateTableAmount(int chairAmount)
    {
        if(chairAmount % 2 == 0)
        {
            int tables; 
            tables = (chairAmount / 2) - 1;
            System.out.println(tables);
            return tables;
        }
        else
        {
            int tables; 
            tables = ((chairAmount / 2) - 1/2);
            System.out.println(tables);
            return tables;
        } 
    }
}
