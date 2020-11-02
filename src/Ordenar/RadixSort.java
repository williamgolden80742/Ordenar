/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenar;

import java.util.Arrays;


/**
 *
 * @author William
 */
public class RadixSort extends Ord {
    // A utility function to get maximum value in arr[]
    long getMax(long arr[], int n) {
        long mx = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    void countSort(long arr[], int n, int exp) {
        long output[] = new long[n]; // output array
        int i;
        long count[] = new long[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            count[(int)(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[(int) count[(int)(arr[i] / exp) % 10] - 1] = arr[i];
            count[(int)(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
    
    void runRadixSort (long arr[]) {       
        int n = arr.length;
        // Find the maximum number to know number of digits
        long m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);           
        }           
    }
}
