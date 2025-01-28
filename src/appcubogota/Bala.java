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
public class Bala extends Sprite{
    
    public Bala(Game game) {
        super(game, "bala.png");
        habilitado=false;
        
    }

    @Override
    public void actualizar() {
        Sprite sp;
        if (habilitado){
            y-=10;
            if (y<0){
                habilitado=false;
            }else {
              sp=this.golpear();
              if (sp instanceof Gota){                  
                  ((Gota) sp).colocar();
              }
             }            
        }       
        
    }

    @Override
    public void golpeado(Sprite sp) {
        
    }
    public void disparar(Cubo cubo){
        habilitado=true;
        y=800;
        x=200;
    }
    
}
