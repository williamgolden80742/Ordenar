/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenar;

import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author William
 */
public class Grafico extends javax.swing.JFrame {

    /**
     * Creates new form Grafico
     *
     * @param i
     * @throws java.io.IOException
     */
    private DefaultCategoryDataset linha = new DefaultCategoryDataset();
    private JFreeChart grafico = ChartFactory.createBarChart3D("Ordenação por algoritmo","Algoritmos","Segundos",linha,PlotOrientation.VERTICAL,true,true,true);        
    
    public Grafico() throws IOException {
        initComponents();
        grafLabel.setIcon(new javax.swing.ImageIcon(getGrafico()));
    }

 
    public void criarGrafico(String alg,long mili,String time, int Width, int Height) throws IOException {
        Double value =(double) mili;
        value/=1000;
        linha.addValue(value,alg,time);
    }
    
    public void criarGrafico(String alg,long mili,String time) throws IOException {
        criarGrafico(alg,mili,time,scrollPane.getWidth(),scrollPane.getHeight());
    }    
    
    public Image getGrafico() throws IOException {
        return grafico.createBufferedImage(scrollPane.getWidth()-5,scrollPane.getHeight()-5);
    }   
    
    public void updateGrafico() throws IOException {
        grafLabel.setIcon(new javax.swing.ImageIcon(getGrafico()));  
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        grafLabel = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        scrollPane.setViewportView(grafLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        try {
            updateGrafico();
        } catch (IOException ex) {
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentResized

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel grafLabel;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables

}
