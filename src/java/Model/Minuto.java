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
public class Minuto {

    String idMinuto, idHorario, minuto, descripcion, equipos, gLocales, gVisitas;

    public Minuto(String idM,
            String idH,
            String min,
            String des,
            String eq,
            String gL,
            String gV) {
        idMinuto = idM;
        idHorario = idH;
        minuto = min;
        descripcion = des;
        equipos = eq;
        gLocales = gL;
        gVisitas = gV;

    }
}
