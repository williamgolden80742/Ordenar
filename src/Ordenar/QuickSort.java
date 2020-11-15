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
public class QuickSort extends Coleta {
    void quickSort(long[] arr, int left, int right) {
        int i, j;
        long x, y;

        i = left;
        j = right;
        x = arr[(int)(left + right) / 2];

        while (i <= j) {
            while (arr[i] < x && i < right) {
                i++;
            }
            while (arr[j] > x && j > left) {
                j--;
            }
            if (i <= j) {
                y = arr[i];
                arr[i] = arr[j];
                arr[j] = y;
                i++;
                j--;
            }
        }

        if (j > left) {
            quickSort(arr, left, j);
        }
        if (i < right) {
            quickSort(arr, i, right);
        }
    }

    void runQuickSort(long[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }   
}
