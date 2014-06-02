/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author TLK-USER
 */
public class FotoEquipo {

    String idSeleccion, nombre, img1, img2, texto, fecha;

    public FotoEquipo(String id, String n,  String im1, String im2, String te, String fe) {
        idSeleccion = id;
        nombre = n;
        
        img1 = im1;
        img2 = im2;
        texto = te;
        fecha = fe;

    }

}
