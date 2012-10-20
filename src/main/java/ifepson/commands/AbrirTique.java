/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifepson.commands;

import ifepson.IfAction;
import ifepson.RespuestaCheck;
import ifepson.IfCommand;
import ifepson.doc.IndexedOut;
import ifepson.doc.Parametro;

/**
 *
 * @author guillermot
 */
public class AbrirTique extends IfCommand {

    public FormatoDatos getFormatoDatos() {
        return FormatoDatos.parseLetra(params.get(Parametro.ABT__FORMATO_DATOS));
    }

    public void setFormatoDatos(FormatoDatos formatoDatos) {
        params.put(Parametro.ABT__FORMATO_DATOS, formatoDatos.getLetra());
    }

    public AbrirTique() {
        this.commandId = 0x40;
        this.name = "AbrirComprobanteTiqueFiscal";
        this.nombreA = "TIQUEABRE";
        this.descripcionComando = "Este comando es el primer paso para producir un comprobante fiscal Tique. Los datos de la Hora y Fecha son impresos en el momento en que se facture el primer ítem o que se envíe una línea de texto Fiscal. Se rechazará el comando si hay un comprobante o Tique fiscal abierto. Se rechazará si la Memoria Fiscal está llena, si hay un error en la Memoria de Trabajo o en la Memoria Fiscal. Se rechazará si hay papel en las estaciones de slip o de validación.";

        this.params.put(Parametro.ABT__FORMATO_DATOS, FormatoDatos.NO_DNFH.getLetra());
        
        this.respuestaChecks.add(new RespuestaCheck(IfAction.RETRY, new Object[] {IndexedOut.EF__DOCUM_FISC_ABIERTO, "1"}));
    }

    
    @Override
    public boolean interpretaRespuesta(byte[] resp) {
        return true;
    }

    public static enum FormatoDatos {

        NO_DNFH("C"), SI_DNFH("G");

        FormatoDatos(String letra) {
            this.letra = letra;
        }
        String letra = "";

        public String getLetra() {
            return letra;
        }

        public static FormatoDatos parseLetra(String letra) {

            switch (letra.charAt(0)) {
                case 'C':
                    return FormatoDatos.NO_DNFH;
                case 'G':
                    return FormatoDatos.SI_DNFH;
            }

            return null;
        }
    }
}
