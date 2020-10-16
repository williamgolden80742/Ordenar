package Ordenar;
import java.io.IOException;

class Home {

    public static void main(String[] args) throws IOException {
        long[] arr;
        int pos = 5;
        String url = "C:\\Users\\William\\Desktop\\DadosGeoProcessamento2.csv";
        RadixSort r = new RadixSort();
        BubbleSort b = new BubbleSort();
        QuickSort q = new QuickSort();
       
        arr = new long[172801];       
        r.values(url,arr, pos);         
        r.runRadixSort(arr);
        System.out.println("\nRadix Sort : \n");
        r.print(arr);
        
        arr = new long[172801];
        q.values(url,arr, pos);
        q.runQuickSort(arr);
        System.out.println("\n\nQuick Sort : \n");
        q.print(arr);
        
        arr = new long[172801];
        b.values(url,arr, pos);
        b.runBubbleSort(arr);
        System.out.println("\n\nBubble Sort : \n");
        b.print(arr);

    }
    
}
