/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ifepson.commands;

/**
 *
 * @author guillermot
 */
public class CierreX extends CierreXZ {

    public CierreX() {
        super();
        this.descripcionComando = "Realiza un cierre X, no es necesario enviar ningun parametro";
        this.nombreA = "CIERREX";
        this.setTipoCierre(TipoCierre.X);
    }



}
