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
public class abrirDNF extends IfCommand {

    public abrirDNF() {
        this.commandId = 0x48;
        this.name = "abrirDocumentoNoFiscal";
        this.nombreA = "ABRIRDNF";
        this.descripcionComando = "Este comando es el primer paso en la producción de un Documento No Fiscal. Se imprime el encabezado del comprobante fiscal, pero se lo identifica claramente como \"NO FISCAL\".";

    }

    @Override
    public boolean interpretaRespuesta(byte[] resp) {
        return true;
    }
}
