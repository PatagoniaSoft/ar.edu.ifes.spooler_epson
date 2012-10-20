/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifepson.commands;

import ifepson.IfCommand;
import ifepson.doc.Parametro;
import myjob.func.general.GeneralFunc;

/**
 *
 * @author guillermot
 */
public class AvanzaHojaSuelta extends IfCommand {

    public int getLineas() {
        return Integer.parseInt(params.get(Parametro.AHS__CANTIDAD_LINEAS));
    }

    public void setLineas(int lineas) {
        this.params.put(Parametro.AHS__CANTIDAD_LINEAS, GeneralFunc.stringFormat("{0:00}", lineas));
    }

    public AvanzaHojaSuelta() {
        this.commandId = 0x53;
        this.name = "avanazHojaSuelta";
        this.descripcionComando = "Avanza el papel de la hoja suelta";

        this.params.put(Parametro.AHS__CANTIDAD_LINEAS, GeneralFunc.stringFormat("{0:00}", 0));
    }

  

    @Override
    public boolean interpretaRespuesta(byte[] resp) {
        return true;
    }
}
