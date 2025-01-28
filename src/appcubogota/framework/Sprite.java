/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcubogota.framework;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author Rafa
 */
public abstract class Sprite {
    public static int  n;
    protected int x,y;
    protected int ancho,alto;
    private Image imagen;
    protected static Game mundo;
    protected static Galeria galeria=new Galeria();
    protected boolean habilitado;
    public Sprite(Game game, String fichero){
        mundo=game;
        imagen=galeria.getImagen(fichero);
        ancho=imagen.getWidth(null);
        alto=imagen.getHeight(null);
        mundo.getSprites().add(this);
        habilitado=true;
    }
    
    public void dibujar(Graphics g){
        if (habilitado)
            g.drawImage(imagen, x, y, null);
    }
    public abstract void actualizar();
    /*sp:es el que golpea y this el golpeado*/
    public abstract void golpeado(Sprite sp);
    /* this es el que golpea -->mira con quien en 
    la lista sprites
    */
    public Sprite golpear(){
        Sprite sp=null,aux=null;        
        for (int i=0;i<mundo.getSprites().size();i++){
            sp=mundo.getSprites().get(i);
            if (this.isChocado(sp) && 
                    this!=sp && 
                        sp.habilitado) {
                System.out.println("golpear");
                sp.golpeado(this);  
                aux=sp;
                break;
            }
        }        
        return aux;
    }
    /*Mira si dos sprites colisionan this y sp
    */
    public boolean isChocado(Sprite sp){
        boolean choco=false;
        Rectangle rectSP=
                new Rectangle(sp.x,sp.y,sp.ancho,sp.alto);
        Rectangle rectThis=
                new Rectangle(this.x,this.y,this.ancho,this.alto);
        if (rectThis.intersects(rectSP)) {
            choco=true;
        }        
        return choco;
    }
}
