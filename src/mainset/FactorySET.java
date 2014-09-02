/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainset;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Daniel Orozco <daniel.orozco>
 */
public class FactorySET {
    
    public Set getSET(int n)
    {
        switch (n)        
        {
            case 1: 
                return new HashSet();
            case 2:
                return new TreeSet();
            case 3:
                return new LinkedHashSet();
             default:
                System.out.println("Ha escogido una opción incorrecta");
                return null;
        }
    }
    
}
