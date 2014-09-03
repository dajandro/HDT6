/**
* Universidad del Valle de Guatemala
* Pablo Diaz 13203
* Daniel Orozco 13312
*/

package mainset;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JOptionPane;

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
     
        int tipo_set = JOptionPane.showOptionDialog(
                                        null ,
                                        "Seleccione opcion", 
                                        "Selector de opciones",
                                        JOptionPane.YES_NO_CANCEL_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,    // null para icono por defecto.
                                        new Object[] { "1. HashSet", "2. TreeSet", "3. Linked Hash Set" },   // null para YES, NO y CANCEL
                                        "1. HashSet");
       
        tipo_set+=1;
        FactorySET factory = new FactorySET();
        Set dJava, dWeb, dCel;
        //se crean los conjuntos a utilizar
        dJava = factory.getSET(tipo_set);
        dWeb = factory.getSET(tipo_set);
        dCel = factory.getSET(tipo_set);
        
        boolean ingreso_nombre=true;
        while (ingreso_nombre)
        {       
            boolean ingreso=true;

            int opcion2 = JOptionPane.showOptionDialog(
                                        null ,
                                        "Seleccione opcion", 
                                        "Selector de opciones",
                                        JOptionPane.YES_NO_CANCEL_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,    // null para icono por defecto.
                                        new Object[] { "ingresar nombre "," salir"  },   // null para YES, NO y CANCEL
                                        "");
            opcion2+=1;
            if (opcion2==1)
            {
                String nombre = JOptionPane.showInputDialog(
                                null,
                                "Ingrese nombre",
                                JOptionPane.QUESTION_MESSAGE);  // el icono sera un iterrogante
            
                while(ingreso)
                {                       
                    int opcion_conjunto=JOptionPane.showOptionDialog(
                                        null ,
                                        "Seleccione opcion para " + nombre, 
                                        "Selector de opciones",
                                        JOptionPane.YES_NO_CANCEL_OPTION,
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,    // null para icono por defecto.
                                        new Object[] {"1 Desarrolador Java", "2. Desarrollador Web",
                                        "3.Desarrollador Celular", "4. salir"},   // null para YES, NO y CANCEL
                                        "1");
                    opcion_conjunto+=1;
                    if (opcion_conjunto==1)
                    {
                        dJava.add(nombre);
                    }

                    if (opcion_conjunto==2)
                    {
                        dWeb.add(nombre);
                       
                    }
                    if (opcion_conjunto==3)
                    {
                        dCel.add(nombre);
                    }

                    if (opcion_conjunto==4)
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
        System.out.println("conjuntos");
        System.out.println(dWeb.toString());
        System.out.println(dCel.toString());
        System.out.println(dJava.toString());
        Iterator iteratorJ = dJava.iterator();
        Iterator iteratorW = dWeb.iterator();
        Iterator iteratorC = dCel.iterator();
        
        Set todos = factory.getSET(tipo_set); //variable temporal 
        todos.addAll(dJava);
        todos.retainAll(dWeb);
        todos.retainAll(dCel);
        System.out.println("Desarrolladores Java, Celular y Web" + todos.toString());
        
        // 2. Java pero no Web
        
        
        
        //3. Web y Celulares pero no Java
         
        Set WebCel= factory.getSET(tipo_set); //variable temporal
        WebCel.addAll(dWeb);                  //se agrega el conjunto web inicial
        WebCel.retainAll(dCel);               //se mantiene la union entre 
        WebCel.removeAll(dJava);              //se quita el conjunto java
        
        
        System.out.println("Desarrolladores Web y Celular pero no Java "  + WebCel.toString());
        
        //4. Web o Celular  pero no Java
        Set WeboCel = factory.getSET(tipo_set); //variable temporal
        WeboCel.addAll(dWeb);                  //se agrega el conjunto web
        WeboCel.addAll(dCel);                  //se agrega el conjunto celular
        WeboCel.removeAll(dJava);              //se quitan el conjunto de java
        
        System.out.println("Desarrolladores Web o Celular pero no Java " + WeboCel.toString());
       
        
       //5. conjunto java es subconjunto de web
        if (dJava.contains(dWeb))
            System.out.println("Desarrollador java SI es subconjunto de desarrollador web");
        
        if (dJava.contains(dWeb)==false)
            System.out.println("Desarrollador java No es subconjunto de desarrollador web");
        
        //6. conjunto más grande
       
        Set conjuntoMayor = factory.getSET(tipo_set);           //variable temporal
        if (dWeb.size()>dCel.size() &&  dWeb.size()>dJava.size())
            conjuntoMayor.addAll(dWeb);//si el mayor fue web se agrega este a la variable temporal
        
        if (dCel.size()>dWeb.size() && dCel.size()>dJava.size())
            conjuntoMayor.addAll(dCel);//si el mayor fue celular se agrega a la variable temporal
        
        if (dJava.size()>dWeb.size() && dJava.size()>dCel.size())
            conjuntoMayor.addAll(dJava); //si el mayor fue el de Java se agrega a la variable temporal
        
        
        System.out.println("El conjunto mayor es " + conjuntoMayor.toString());
        

        //7. Ordena el conjunto más grande
        
        
        Object[] arregloNoOrdenado=  conjuntoMayor.toArray(); //se pasa a un arreglo tipo objeto
        
        //se mete el arreglo a un arreglo comparable
        Comparable[] arregloOrdenado = new Comparable[arregloNoOrdenado.length]; 
        for (int i = 0 ; i<arregloNoOrdenado.length;i++)
            arregloOrdenado[i]=(Comparable) arregloNoOrdenado[i];
        
        //se ordena el nuevo arreglo
        Sorting.selectionSort(arregloOrdenado);
        
        //se muestra el nuevo arreglo
        System.out.println("El conjunto más grande y ordenado es : ");
        System.out.print("[");
        for (int j = 0; j<arregloOrdenado.length;j++)
        {
            System.out.print(arregloOrdenado[j].toString().concat(", "));
        }
        System.out.print("]\n");
        
    }

}
