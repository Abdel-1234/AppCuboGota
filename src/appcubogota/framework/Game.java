/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcubogota.framework;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafa
 */
public abstract class Game extends Thread implements KeyListener{
    private Vista vista;
    private ArrayList<Sprite> sprites;
    protected ArrayList<TextSprite> textSprites;
    private Image fondo;
    private Galeria galeria;
    protected Protagonista prota;
    public Game(){
        vista=new Vista();
        vista.addKeyListener(this);
        sprites=new ArrayList();
        vista.setSprites(sprites);           
        textSprites=new ArrayList();
        vista.setTextSprites(textSprites);
        galeria=new Galeria();      
    }
    public void setFondo(String fichero){
        this.fondo=galeria.getImagen(fichero);
        vista.setFondo(fondo);
    }
    @Override
    public void run(){
        long tFrame=40000000L;
        long tInic,tFin,tCurro;
        long tDormir,caniasTime;
        while(true){//GAME LOOP
            tInic=System.nanoTime();
            actualizar();
            pintar();
            tFin=System.nanoTime();
            tCurro=tFin-tInic;
            tDormir=tFrame-tCurro;
            descansar(tDormir);            
        }        
    }
    public void descansar(long tDormir){
        try {
            Thread.sleep(tDormir/1000000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void pintar(){
        vista.dibujar();
    }
    public void actualizar(){
        for (int i=0;i<sprites.size();i++){
            sprites.get(i).actualizar();
        }
        
           
    }

    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ESCAPE){
            System.exit(0);
        }else{
            prota.doAction(e.getKeyCode());
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    public int getAlto(){
        return vista.getAlto();
    }
    public int getAncho(){
        return vista.getAncho();
    }
    public ArrayList<Sprite> getSprites(){
        return sprites;
    }
    
}
