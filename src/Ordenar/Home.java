/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenar;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author William
 */
public class Home extends javax.swing.JFrame implements ActionListener {

    Grafico g;
    DefaultTableModel modelo;
    boolean initTable = true;

    SelectArquivo sA = new SelectArquivo();

    public Home() throws IOException {
        initComponents();
        this.g = new Grafico();
        listener();
        coluna.setEnabled(false);
    }

    void listener() {
        procurar.addActionListener(this);
        graficoButton.addActionListener(this);
        algButton.addActionListener(this);
    }

    void print(long arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }

    void Algoritmos() throws IOException {
        try {
            
        //PREPARANDO TABELA DE RELATÓRIOS
            if (initTable) {
                modelo = (DefaultTableModel) resultadaTable.getModel();
                modelo.setNumRows(0);
                initTable = false;
            }
        // INSTANCIANDO ARRAY DA DADOS
            long[] arr;
            String url = sA.getSelectedFile();
        // INSTANCIANDO ALGORITMOS ORDENAÇÃO E COLETA
            RadixSort r = new RadixSort();
            BubbleSort b = new BubbleSort();
            QuickSort q = new QuickSort();
            Coleta o = new Coleta();               
        // COLETANDO COLUNA SELECIONADA
            int pos = coluna.getSelectedIndex();
            String  columnName = (String) coluna.getSelectedItem();
            
            long start, finish;
        // COLETANDO DATA E HORARIO ATUAL
            Date date = new Date();
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String time = fmt.format(date);
         
        // IMPRIMANDO COLUNA SELECIONADA    
            modelo.addRow(new Object[]{
                "Coleta : " + time + ", Coluna : " + columnName,});

        // RADIX SORT INICIO
        
            // Coleta de dados
            arr = new long[172900];
            r.values(url, arr, pos);

            start = r.time();
            // Rodando algoritmo
            r.runRadixSort(arr);
            finish = r.time();

            // Exibição de tempo 
            modelo.addRow(new Object[]{
                "Radix Sort : " + String.valueOf(finish - start) + " milisegundos \n",});

            // Alimentando gráfico
            g.criarGrafico("Radix Sort", finish - start, columnName);

            // Impressão 
            print(arr);

        // RADIX SORT FINAL  
        // QUICK SORT INICIO   
        
            // Coleta de dados
            arr = new long[172900];
            q.values(url, arr, pos);

            start = q.time();
            // Rodando algoritmo            
            q.runQuickSort(arr);

            finish = q.time();

            // Exibição de tempo 
            modelo.addRow(new Object[]{
                "\n\nQuick Sort : " + String.valueOf(finish - start) + " milisegundos \n",});

            // Alimentando gráfico
            g.criarGrafico("Quick Sort", finish - start, columnName);

            // Impressão
            print(arr);

        // QUICK SORT FINAL 
        // BUBBLE SORT INICIO 
        
            // Coleta de dados
            arr = new long[172900];
            b.values(url, arr, pos);

            start = b.time();
            // Rodando algoritmo 
            b.runBubbleSort(arr);

            finish = b.time();

            // Exibição de tempo 
            modelo.addRow(new Object[]{
                "\n\nBubble Sort : " + String.valueOf(finish - start) + " milisegundos \n",});
            // Alimentando gráfico
            g.criarGrafico("Bubble Sort", finish - start, columnName);

            // Impressão
            print(arr);

        // BUBBLE SORT FINAL   
        
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Selecione um arquivo");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == procurar) {
            sA.setVisible(true);
        }
        if (e.getSource() == algButton) {
            try {
                Algoritmos();
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == graficoButton) {
            try {
                Grafico();
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void Grafico() throws IOException {
        this.g.updateGrafico();
        this.g.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        procurar = new javax.swing.JButton();
        urlLabel = new javax.swing.JLabel();
        algButton = new javax.swing.JButton();
        graficoButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        coluna = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultadaTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        procurar.setBackground(new java.awt.Color(102, 102, 102));
        procurar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        procurar.setForeground(new java.awt.Color(204, 204, 204));
        procurar.setText("PROCURAR");
        procurar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        urlLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        urlLabel.setForeground(new java.awt.Color(102, 102, 102));
        urlLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        algButton.setText("Rodar Algoritmo");

        graficoButton.setText("Exibir gráfico");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("COLUNA : ");

        coluna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        resultadaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Relatório"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(resultadaTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(graficoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(algButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(urlLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(procurar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coluna, 0, 94, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coluna, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(procurar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(urlLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(algButton)
                    .addComponent(graficoButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        Coleta o = new Coleta();
        urlLabel.setText(" " + sA.getSelectedFile());
        try {
            String[] list = o.titleList(sA.getSelectedFile());
            coluna.removeAllItems();
            for (String l : list) {
                coluna.addItem(l);
            }
            coluna.setEnabled(true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_formWindowGainedFocus

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Home().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton algButton;
    private javax.swing.JComboBox<String> coluna;
    private javax.swing.JButton graficoButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton procurar;
    private javax.swing.JTable resultadaTable;
    private javax.swing.JLabel urlLabel;
    // End of variables declaration//GEN-END:variables

}
