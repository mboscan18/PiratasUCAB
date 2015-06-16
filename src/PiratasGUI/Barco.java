/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PiratasGUI;

import AppPackage.AnimationClass;
import java.awt.Color;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mary S. Gonzalez
 */
public class Barco extends javax.swing.JLabel{
    private final AnimationClass barcoAnimated;
    private JLabel labelBarco;
    public Hilo movimiento;
    private int llegada;

    class Hilo extends Thread {

        public void run(int caso) {
            while(llegada==0){
                switch (caso){
                    case 1: this.moverXDerechaHilo(10, 1000); 
                            llegada=1; 
                            System.out.print("MAMAWEVADA");
                            break;
                        
                }
                
            }
        }
        
        public void moverXDerechaHilo(int x, int x1){
            barcoAnimated.jLabelXRight(x, x1, 100, 20, labelBarco);
            labelBarco.setBackground(Color.yellow);
            System.out.print("asd");
            llegada = 1;
        }
        
    }
        
    public Barco(JPanel p){
        llegada = 0;
        barcoAnimated = new AnimationClass();
        String filePath = new File("").getAbsolutePath();
        labelBarco = new JLabel();
        labelBarco.setIcon(new ImageIcon(filePath + "\\src\\images\\barcoPirata.png"));
        p.add(labelBarco);
        labelBarco.setLocation(10,10);
        labelBarco.setVisible(true);  
        
        movimiento = new Hilo();
     //   movimiento.run(1);
    }
    
    public void iniciar(int caso){
        movimiento.run(caso);

    }

   public void moverXDerecha(int x, int x1){
            movimiento.moverXDerechaHilo(x,x1);
        }


}


