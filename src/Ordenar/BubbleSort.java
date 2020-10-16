/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenar;

/**
 *
 * @author William
 */
public class BubbleSort extends Ord {
    
    void runBubbleSort(long[] arr) {
        int aLength = arr.length;
        long c = 0;
        for (int j = 0; j < aLength; j++) {
            for (int i = j; i < aLength; i++) {
                if (arr[i] < arr[j]) {
                    c = arr[i];
                    arr[i] = arr[j];
                    arr[j] = c;
                }
            }
        }
    }
}
