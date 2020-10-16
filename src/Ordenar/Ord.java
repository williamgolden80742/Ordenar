/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author William
 */
public class Ord {
 
    void values (String url,long[] arr, int l) throws FileNotFoundException, IOException {
        try (BufferedReader buffRead = new BufferedReader(new FileReader(url))) {
            String linha = "";
            int count = 0;
            while (true) {
                if (linha != null) {
                    String[] arrayDados = linha.split(";");
                    try {
                        linha = arrayDados[l];
                        arr[count++] = Integer.parseInt(linha);
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {

                    }
                } else {
                    break;
                }
                linha = buffRead.readLine();
            }
        }
    }
    
    void print(long arr[]) {
        int n = arr.length;
        for (int i = 0;i < n; i++) {
            if (arr[i] != 0) 
                System.out.println(arr[i] + "");
           
        }
    }
    
}
