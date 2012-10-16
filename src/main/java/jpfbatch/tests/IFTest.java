/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpfbatch.tests;

import ifepson.commands.AbrirTique;
import ifepson.commands.CerrarTique;
import ifepson.commands.ImprItemTique;
import ifepson.commands.ImprTxtFiscTique;
import ifepson.commands.PagoCancelDescRecaTique;
import ifepson.commands.SubtotalTique;
import ifepson.doc.IndexedOut;
import ifepson.IfCommand;
import java.io.IOException;
import java.util.Map;

import jpfbatch.IfBatch;
import myjob.func.io.PortConfig;

/**
 *
 * @author guillermot
 */
public class IFTest {
    public static void doTiquetTest() throws IOException {
        
        IfBatch.InitRxTx("rxtx/linux_x86_64/");
        
        IfBatch ifb = new IfBatch();
        
        PortConfig pf = new PortConfig();
        
        pf.setPortName("/dev/ttyS0");
        pf.setStopBits(1);
        pf.setParity(0);
        pf.setBaudRate(9600);
        pf.setDataBits(8);
        
        ifb.setPortConfig(pf);
        
        IfCommand c = null;

        c = new AbrirTique();

        ifb.addCommand(c);

        c = new ImprTxtFiscTique();

        ((ImprTxtFiscTique) c).setLineaExtra("linea extra");

        ifb.addCommand(c);

        c = new ImprItemTique();

        ((ImprItemTique) c).setBultos(1);
        ((ImprItemTique) c).setCalificador(ImprItemTique.CalificadorItem.MONTO_AGREGADO_O_VENTA_SUMA);
        ((ImprItemTique) c).setCantidad(0.01d);
        ((ImprItemTique) c).setDescripcionProducto("item de linea");
        ((ImprItemTique) c).setPrecioUnitario(10);
        ((ImprItemTique) c).setIva(21d);

        ifb.addCommand(c);

        c = new SubtotalTique();

        ifb.addCommand(c);

        c = new PagoCancelDescRecaTique();

        ((PagoCancelDescRecaTique) c).setCalificador(PagoCancelDescRecaTique.Calificador.DESCUENTO);

        ((PagoCancelDescRecaTique) c).setDescripcionEnTique("POR SER MUY FEO");

        ((PagoCancelDescRecaTique) c).setMonto(0.05d);

        ifb.addCommand(c);

        c = new PagoCancelDescRecaTique();

        ((PagoCancelDescRecaTique) c).setCalificador(PagoCancelDescRecaTique.Calificador.SUMA_IMPORTE_PAGADO);

        ((PagoCancelDescRecaTique) c).setDescripcionEnTique("EFECTIVO");

        ((PagoCancelDescRecaTique) c).setMonto(0.05d);

        ifb.addCommand(c);

        c = new CerrarTique();

        ifb.addCommand(c);
        
        ifb.run();
        
        
        // acá vienen todas las respuestas
        // que pueden ser cualquiera de ifepson.doc.IndexedOut
        // hay que analizarlas para ver si viene con algun error
        
        Map<IndexedOut, String> respuesta = ifb.getRespuesta();
    }
}
