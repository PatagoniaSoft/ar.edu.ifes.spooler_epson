/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myjob.DocumentsExporter;

import java.util.EventObject;
import java.sql.ResultSet;
import javax.swing.table.TableModel;

/**
 *
 * @author guillermot
 */
public class ToSheetEventArgs extends EventObject {

    ResultSet dataTable = null;
    TableModel tableModel = null;

    public ResultSet getDataTable() {
        return dataTable;
    }

    public void setDataTable(ResultSet dataTable) {
        this.dataTable = dataTable;
    }

    public TableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    String fileName = "";

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ToSheetEventArgs(Object source)
    {
        super(source);
    }

    public ToSheetEventArgs(Object source, ResultSet dataTable, String fileName)
    {
        super(source);
        this.fileName = fileName;
        this.dataTable = dataTable;
    }

    public ToSheetEventArgs(Object source, TableModel table, String fileName) {
        super(source);
        this.fileName = fileName;
        this.tableModel = table;
    }
}
