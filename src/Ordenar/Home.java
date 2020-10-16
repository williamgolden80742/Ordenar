package Ordenar;
import java.io.IOException;

class Home {

    public static void main(String[] args) throws IOException {
        long[] arr;
        int pos = 6;
        String url = "C:\\Users\\William\\Desktop\\DadosGeoProcessamento2.csv";
        RadixSort r = new RadixSort();
        BubbleSort b = new BubbleSort();
        QuickSort q = new QuickSort();
       
        arr = new long[172801];       
        r.values(url,arr, pos);         
        System.out.println("\nRadix Sort : \n");
        r.runRadixSort(arr);
        r.print(arr);
        
        arr = new long[172801];
        q.values(url,arr, pos);
        System.out.println("\n\nQuick Sort : \n");        
        q.runQuickSort(arr);
        q.print(arr);
        
        arr = new long[172801];
        b.values(url,arr, pos);
        System.out.println("\n\nBubble Sort : \n");        
        b.runBubbleSort(arr);
        b.print(arr);

    }
    
}
