/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcubogota;

import appcubogota.framework.Game;
import appcubogota.framework.Protagonista;
import appcubogota.framework.Sprite;
import appcubogota.framework.TextSprite;
import java.awt.event.KeyEvent;

/**
 *
 * @author Rafa
 */
public class Cubo extends Protagonista{
    private int contadorGotas;
    private TextSprite marcador;
    private Bala bala;
    public Cubo(Game game, TextSprite marcador) {
        super(game, "cubo.png");
        x=200;
        y=mundo.getAlto()-this.alto;
        this.marcador=marcador;
        bala=new Bala(game);
    }

    @Override
    public void actualizar() {
      
    }

    @Override
    public void doAction(int tecla) {
        if (tecla==KeyEvent.VK_LEFT){
            x-=30;
        }
        if (tecla==KeyEvent.VK_RIGHT){
            x+=30;
        }
        if (tecla==KeyEvent.VK_D){
            bala.disparar(this);
        }
    }

    @Override
    public void golpeado(Sprite sp) {      
        if (sp instanceof Gota){
            contadorGotas++;
            marcador.setText(""+contadorGotas);
            System.out.println("Numero gotas"+contadorGotas);
        }    
    }
    
}
