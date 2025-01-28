/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcubogota;

import appcubogota.framework.Game;
import appcubogota.framework.TextSprite;

/**
 *
 * @author Rafa
 */
public class MiMundo extends Game{
    private TextSprite marcador;
    public MiMundo(){
        this.setFondo("salamanca.jpg");           
        for (int i=0;i<6;i++){
            new Gota(this);
        }    
        marcador=new TextSprite("MARCADOR",800,50);
        this.textSprites.add(marcador);
        this.prota=new Cubo(this,marcador);   
    }


}
