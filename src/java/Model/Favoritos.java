/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Aurum CEO
 */
public class Favoritos {

    String id, idEquipo, titulo, img1, img2, descripcion, fecha;

    public Favoritos(String id, String idE, String ti, String i1, String i2, String des, String fe) {
        this.id=id;
        this.idEquipo=idE;
        titulo=ti;
        img1=i1;
        img2=i2;
        descripcion=des;
        fecha=fe;
    }

}
