/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ifepson.commands;

import ifepson.IfCommand;

/**
 *
 * @author guillermot
 */
public class CortarPapel extends IfCommand {

    public CortarPapel() {
        this.commandId = 0x4B;
        this.name = "cortarPapel";
        this.descripcionComando = "Corta el papel";
    }

    @Override
    public boolean interpretaRespuesta(byte[] resp) {
        return true;
    }

}
