/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PiratasGUI;

import AppPackage.AnimationClass;
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
    private JPanel panel;
    private int posx, posy, posx1, posy1;
    private int movX, movY;
    private String filePath = new File("").getAbsolutePath();
    
    /*Imagenes*/
    private ImageIcon imageBarco, kraken, tormenta, tornado ;

    class Hilo extends Thread {
        
        public Hilo(int x, int y, int x1, int y1){
            posx = x;
            posx1 = x1;
            posy = y;
            posy1 = y1;
        }

        public void run() {
            
            if(posx1 >= posx){
                movX = 1;   // El punto al que queremos movernos esta a la derecha
            }else
            if(posx1 < posx){
                movX = 2;   // El punto al que queremos movernos esta a la izquierda
            } 
            if(posy1 >= posy){
                movY = 1;   // El punto al que queremos movernos esta hacia abajo
            }else
            if(posy1 < posy){
                movY = 2;   // El punto al que queremos movernos esta hacia arriba
            }
            
            System.out.println("EMPECE A MOVERME  "+movX +" "+ movY);
            
            // MOVIMIENTO EN EL EJE X
            if(movX == 1){
                System.out.println("Entre en x1");
                barcoAnimated.jLabelXRight(posx, posx1, 100, 20, labelBarco);   // Se mueve hacia la derecha
            }else
            if(movX == 2){
                System.out.println("Entre en x2");
                barcoAnimated.jLabelXLeft(posx, posx1, 100, 20, labelBarco);    // Se mueve hacia la izquierda
            }    
            
            // MOVIMIENTO EN EL EJE Y
            if(movY == 1){
                System.out.println("Entre en y1");
                barcoAnimated.jLabelYDown(posy, posy1, 100, 20, labelBarco);    // Se mueve hacia la abajo
            }else
            if(movY == 2){
                System.out.println("Entre en y2");
                barcoAnimated.jLabelYUp(posy, posy1, 100, 20, labelBarco);      // Se mueve hacia la arriba
            }
            int sw=0;
            System.out.println("\nprime X:"+labelBarco.getX()+"\n"+"Y:"+labelBarco.getY());
            while (sw == 0){
            //    System.out.println("\nX:"+labelBarco.getX()+"\n"+"Y:"+labelBarco.getY());
                if((labelBarco.getX() == posx1) && (labelBarco.getY() == posy1)){
                 
                    sw = 1;
                }  
                System.out.print("");
            }
            System.out.println("TERMINE DE MOVERME");
           // labelBarco.setBackground(Color.yellow);
            
           // labelBarco.setVisible(false);
            System.out.println("X nuevo = " + labelBarco.getX());
            System.out.println("Y nuevo = " + labelBarco.getY());
            labelBarco.setLocation(labelBarco.getX(), labelBarco.getY());
            
            
            /*Al llegar, evaluar si el sitio tiene una calamaidad. Si tiene, llamar a setCalamidadBarco*/
            setCalamidadBarco("Kraken");
            
            
          //  labelBarco.setVisible(true);
            System.out.println("X nuevo2 = " + labelBarco.getX());
            System.out.println("Y nuevo2 = " + labelBarco.getY());
        }
        
        public void setCalamidadBarco(String calamidad){
            switch (calamidad){
               case "Kraken": labelBarco.setIcon(kraken); break;
               case "Tornado": labelBarco.setIcon(tornado); break;
               case "Tormenta": labelBarco.setIcon(tormenta); break;    
               default:labelBarco.setIcon(imageBarco); break;    
           }
        }
    }
        
    public Barco(JPanel p, String nombreBarco){
        panel = p;
        barcoAnimated = new AnimationClass();
        labelBarco = new JLabel();
        
        /*Imagenes*/
        switch (nombreBarco){
            case "Venganza Errante":
                imageBarco = new ImageIcon(filePath + "\\src\\images\\barcoPirata.png");
                kraken =  new ImageIcon(filePath + "\\src\\images\\barcoPkraken.png");
                tornado = new ImageIcon(filePath + "\\src\\images\\barcoPtornado.png");
                tormenta = new ImageIcon(filePath + "\\src\\images\\barcoPtormenta.png");
                
                break;
            case "Interceptor": 
                imageBarco = new ImageIcon(filePath + "\\src\\images\\interceptorBarco.png");
                kraken =  new ImageIcon(filePath + "\\src\\images\\intercepkraken.png");
                tornado = new ImageIcon(filePath + "\\src\\images\\interceptornado.png");
                tormenta = new ImageIcon(filePath + "\\src\\images\\interceptormenta.png");
                break;
            case "Invencible": 
                imageBarco = new ImageIcon(filePath + "\\src\\images\\invenBarco.png");
                kraken =  new ImageIcon(filePath + "\\src\\images\\invenkraken.png");
                tornado = new ImageIcon(filePath + "\\src\\images\\inventornado.png");
                tormenta = new ImageIcon(filePath + "\\src\\images\\inventormenta.png");
                break;    
        }
        labelBarco.setIcon(this.imageBarco);
    }

   /**
    * Crea el hilo que realizara el movimiento del barco
    * 
    * @param x1 Posicion en el eje X de la pantalla donde el Barco Terminara el movimiento
    * @param y1 Posicion en el eje Y de la pantalla donde el Barco Terminara el movimiento
    */
   public void CrearHilo(int x1, int y1){ 
       movimiento = new Hilo(labelBarco.getX(),labelBarco.getY(),x1,y1);
   }
   
   /**
    * Recibe las posicion en la que apararecera el barco e iniciara el movimiento
    * 
    * @param x Posicion en el eje X de la pantalla donde el Barco iniciara el movimiento
    * @param y Posicion en el eje Y de la pantalla donde el Barco iniciara el movimiento
    */
   public void AparecerBarco(int x, int y){
       panel.add(labelBarco);
       labelBarco.setBounds(x, y, 150, 136);
       labelBarco.setVisible(true);
   }
   
}


