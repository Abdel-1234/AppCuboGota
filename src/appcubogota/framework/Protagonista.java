/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcubogota.framework;

/**
 *
 * @author Rafa
 */
public abstract class Protagonista extends Sprite{

    public Protagonista(Game game, String fichero) {
        super(game, fichero);
    }

    @Override
    public abstract void actualizar();
    public abstract void doAction(int tecla);
    
}
