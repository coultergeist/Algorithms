/*
 * Class:       AD 325 WI 18
 * Author:      Danielle Coulter
 * Title:       Sorting.java
 * Due Date:    Jan 16, 2018
 */
//package sorting;
import java.util.Random;

/**
 *
 * @author daniellecoulter
 */
public class Sorting {

        /* The majority of code was used from Rajat Mishra and can
        *       be found at https://www.geeksforgeeks.org/shellsort/
        *
        *  I have added the function to calculate run time performance 
        *  to the main(). In addition, we will also generate an array
        *  of 100,000 numbers to be sorted so to capture the Big O.
        * 
        *  We will compare the run time of shell, selection and
        *  insertion sorts to find the best run time.
        */
    
    public static int[] createRandom(int length){
     
        Random r = new Random();
        int[] randomNumbers = new int[length];
            
        for (int i=0; i<length; ++i){
                randomNumbers[i] = r.nextInt(100000);
        }
            return randomNumbers;
    }//end create Random
    
    public static void shellSort(int[] randomNumbers){
        
        int n = randomNumbers.length;

        for (int gap = n/2; gap > 0; gap /= 2){
            for (int i = gap; i < n; i += 1){
                
                int temp = randomNumbers[i];
                int j;
                for (j = i; j >= gap && randomNumbers[j - gap] > temp; j -= gap)
                        randomNumbers[j] = randomNumbers[j - gap];

                randomNumbers[j] = temp;
            }//end inner for
        }//end outer for
    }//end shellSort
    
    public static void selectionSort(int[] arr){
        
        
        int n = arr.length;
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }//end selectionSort
        
    public static void insertionSort(int[] arr){
        
       int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }//end insertionSort
        
    /*
    public static void shellSortTiming(int[]     
         long startTime = System.currentTimeMillis();
            shellSort(shellSortArr);
            long endTime = System.currentTimeMillis();
               System.out.println("Shell Sort run time is " + (endTime - startTime) + "ms.");
                                       }
        */
    public static void main(String[] args) {
                        
            int[] shellSortArr = createRandom(100000);
            int[] selectionSortArr = shellSortArr.clone();
            int[] insertionSortArr = shellSortArr.clone();
            
            //shellSortTiming(shellSortArr);
            
            long startTime = System.currentTimeMillis();
            shellSort(shellSortArr);
            long endTime = System.currentTimeMillis();
            System.out.println("Shell Sort run time is " + (endTime - startTime) + "ms.");
                
            startTime = System.currentTimeMillis();
            selectionSort(selectionSortArr);
            endTime = System.currentTimeMillis();
            System.out.println("Selection Sort run time is " + (endTime - startTime) + "ms.");
            
            startTime = System.currentTimeMillis();
            insertionSort(insertionSortArr);
            endTime = System.currentTimeMillis();
            System.out.println("Insertion Sort run time is " + (endTime - startTime) + "ms.");
    }
    
}
