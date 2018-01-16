/*
 * Class:       AD 325 WI 18
 * Author:      Danielle Coulter
 * Title:       Sorting.java
 * Due Date:    Jan 16, 2018
 */
package sorting;
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
    
    public void createRandom(int[] randomNumbers){
     
        int n = randomNumbers.length;
        Random r = new Random();
        
        for (int i=0; i<n; ++i)
        System.out.print(randomNumbers[i] = r.nextInt(100001));
        System.out.println();
        
        
    }//end create Random
    
    public void shellSort(int[] randomNumbers){
        
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
    
    public void selectionSort(int[] randomNumbers){
        
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
    }//end selectionSort
        
    public void insertionSort(int[] randomNumbers){
        
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
    }//end insertionSort
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
