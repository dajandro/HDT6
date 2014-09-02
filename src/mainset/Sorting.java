package mainset;

/*
 * Universidad del Valle de GuatemalaTo change this license header, choose License Headers in Project Properties.
 * Universidad del Valle de GuatemalaTo change this template file, choose Tools | Templates
 * Universidad del Valle de Guatemalaand open the template in the editor.
 */

/**
 *
 * @author Pablo
 */

public class Sorting
{
   //-----------------------------------------------------------------
   //  Sorts the specified array of objects using the selection
   //  sort algorithm.
   //-----------------------------------------------------------------
   public static void selectionSort (Comparable[] list)
   {
      int min;
      Comparable temp;

      for (int index = 0; index < list.length-1; index++)
      {
         min = index;
         for (int scan = index+1; scan < list.length; scan++)
            if (list[scan].compareTo(list[min]) < 0){
                
               min = scan;
            }
         // Swap the values
         temp = list[min];
         list[min] = list[index];
         list[index] = temp;
      }
   }

   //-----------------------------------------------------------------
   //  Sorts the specified array of objects using the insertion
   //  sort algorithm.
   //-----------------------------------------------------------------
   public static void insertionSort (Comparable[] list)
   {
      for (int index = 1; index < list.length; index++)
      {
         Comparable key = list[index];
         int position = index;

         //  Shift larger values to the right
         while (position > 0 && key.compareTo(list[position-1]) < 0)
         {
            list[position] = list[position-1];
            position--;
         }
            
         list[position] = key;
      }
   }
   
   public static void bubble (Comparable[] list){
       //pre:0<=n<=data.lenght
       //post: values in list ordered in ascending order
       int numSorted=0;//number of values in order

 
      Comparable temp;
       while (numSorted<list.length){
           for (int index=1;index<list.length-numSorted;index ++){
               if (list[index-1].compareTo(list[index]) < 0){
                   // Swap the values
                    temp = list[index-1];
                    list[index-1] = list[index];
                    list[index] = temp;
               }
                   
           }
           numSorted++;
       }
   }
}
