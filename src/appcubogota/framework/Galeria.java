/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcubogota.framework;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Rafa
 */
public class Galeria {
    private String RUTA="./../../assets/";
    public Image getImagen(String fichero){        
        //PARA LOS MAS ATREVIDOS
        //USAR UN HASHMAP Y BUSCAR LA IMAGEN
        //SINO ESTA llamamos a cargarImagen
        return cargarImagen(fichero);
    }
    private Image cargarImagen(String fichero){
        Image img=null;
        URL url=this.getClass().getResource(RUTA+fichero);
        try {
            img=ImageIO.read(url);
        } catch (IOException ex) {
            System.out.println("Error en la cargad de la imagen");
        }
        return img;
    }
}
