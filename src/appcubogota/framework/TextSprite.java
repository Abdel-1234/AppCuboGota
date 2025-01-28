/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcubogota.framework;

import java.awt.Graphics;

/**
 *
 * @author Rafa
 */
public class TextSprite {
    private String texto;
    private int x,y;
    public TextSprite(String texto,int x, int y){
        this.texto=texto;
        this.x=x;
        this.y=y;
    }
    public void dibujar(Graphics g){
        g.drawString(texto, x, y);
    }
    public void setText(String texto){
        this.texto=texto;               
    }    
}
