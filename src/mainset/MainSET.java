/**
* Universidad del Valle de Guatemala
* Pablo Diaz 13203
* Daniel Orozco 13312
*/

package mainset;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Pablo
 */
public class MainSET {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado  = new Scanner(System.in);
        
        
        System.out.println("1. Hash Set");
        System.out.println("2. Tree Set");
        System.out.println("3. Linked Hash Set");
        System.out.print("Ingrese opcion:");
        int tipo_set = teclado.nextInt();
        
        FactorySET factory = new FactorySET();
        Set dJava;
        Set dWeb;
        Set dCel;
        
        
        dJava = factory.getSET(tipo_set);
        dWeb = factory.getSET(tipo_set);
        dCel = factory.getSET(tipo_set);
        
        boolean ingreso_nombre=true;
        while (ingreso_nombre)
        {       
            boolean ingreso=true;

            System.out.println("1. Ingrese el nombre");
            System.out.println("2. salir");
            System.out.print("Ingrese opcion: ");
            int opcion2= teclado.nextInt();
            
            if (opcion2==1)
            {
                System.out.print("Ingrese nombre: ");
                String nombre= teclado.next();
            
                while(ingreso)
                {                       
                    System.out.println("1. Desarrollador Java");
                    System.out.println("2. Desarrolador Web");
                    System.out.println("3. Desarrollador Celulares");
                    System.out.println("4. Finalizar");
                    System.out.print("Ingrese opcion: ");
                    int opcion = teclado.nextInt();

                    if (opcion==1)
                    {
                        dJava.add(nombre);
                    }

                    if (opcion==2)
                    {
                        dWeb.add(nombre);
                    }
                    if (opcion==3)
                    {
                        dCel.add(nombre);
                    }

                    if (opcion==4)
                    {
                        ingreso=false;
                    }

                }
            }
            if (opcion2==2)
            {
                ingreso_nombre=false;
                ingreso=false;
            }
        }
        
        // opciones
        // 1. Intersección de los 3 conjuntos
        /*Set dJava;
        Set dWeb;
        Set dCel;*/
        
        Iterator iteratorJ = dJava.iterator();
        Iterator iteratorW = dWeb.iterator();
        Iterator iteratorC = dCel.iterator();
        
        Set todos = dJava;
        todos.retainAll(dWeb);
        todos.retainAll(dCel);
        System.out.println(todos.toString());
        
        // 2. Java pero no Web
    }

}
