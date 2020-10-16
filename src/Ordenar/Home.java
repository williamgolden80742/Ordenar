package Ordenar;
import java.io.IOException;

class Home {

    public static void main(String[] args) throws IOException {
        long[] arr;
        int pos = 5;
        RadixSort r = null;
        BubbleSort b = null;
        QuickSort q = null;
       
        arr = new long[172801];       
        r.values(arr, pos);         
        r = new RadixSort(arr);
        System.out.println("\nRadix Sort : \n");
        r.print(arr);
        
        arr = new long[172801];
        q.values(arr, pos);
        q = new QuickSort(arr);
        System.out.println("\n\nQuick Sort : \n");
        q.print(arr);
        
        arr = new long[172801];
        b.values(arr, pos);
        b = new BubbleSort(arr);
        System.out.println("\n\nBubble Sort : \n");
        b.print(arr);

    }
    
}
