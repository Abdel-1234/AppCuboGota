/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcubogota;

import appcubogota.framework.Game;
import appcubogota.framework.Sprite;

/**
 *
 * @author Rafa
 */
public class Gota extends Sprite{
    
    public Gota(Game game) {
        super(game, "gota.png");
        colocar();       
    }

    @Override
    public void actualizar() {
        Sprite sp;
        this.y+=10;
        if (this.y>this.mundo.getAlto()){
            y=-this.alto;
            colocar();
        }
        sp=this.golpear();
        if (sp instanceof Cubo){
            colocar();
       //     sp.golpeado(this);
            System.out.println("es cubo?");
        }
        
    }
    public void colocar(){
        x=(int)(Math.random()*mundo.getAncho()-ancho);
        y=-(int)(Math.random()*800);
    }

    @Override
    public void golpeado(Sprite sp) {
       
    }
}
