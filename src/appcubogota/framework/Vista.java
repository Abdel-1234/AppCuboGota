/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcubogota.framework;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

/**
 *
 * @author Rafa
 */
public class Vista extends Frame{
    private ArrayList<Sprite> sprites;
    private ArrayList<TextSprite> textSprites;
    private int ancho, alto;
    private Image fondo;
    private Graphics2D g;
    private BufferStrategy buffer=null;
    public Vista(){
        this.setUndecorated(true);
        this.setResizable(false);
        GraphicsConfiguration gc=this.getGraphicsConfiguration();
        Rectangle pantalla=gc.getBounds();
        ancho=(int)pantalla.getWidth();
        alto=(int)pantalla.getHeight();
        this.setSize(ancho, alto);
        this.setVisible(true);         
        this.createBufferStrategy(2);       
        buffer=this.getBufferStrategy();
        g=(Graphics2D)buffer.getDrawGraphics();        
    }
    public void dibujar(){
        if (fondo!=null){
            //g.drawImage(fondo, 0, 0, null);
            g.drawImage(fondo, 0, 0, ancho, alto, null);
        }else{
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, ancho, alto);
        }
        if (sprites!=null){
            for(int i=0;i<sprites.size();i++){
                sprites.get(i).dibujar(g);
            }
        }    
        if (textSprites!=null){
            for(int i=0;i<textSprites.size();i++){
                textSprites.get(i).dibujar(g);
            }
        } 
        buffer.show();
    }

    public void setSprites(ArrayList<Sprite> sprites) {
        this.sprites = sprites;
    }
    public void setTextSprites(ArrayList<TextSprite> textSprites) {
        this.textSprites = textSprites;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setFondo(Image fondo) {
        this.fondo = fondo;
    }
    
}
