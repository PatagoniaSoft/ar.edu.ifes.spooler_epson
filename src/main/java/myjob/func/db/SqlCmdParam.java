/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package myjob.func.db;

/**
 *
 * @author guillermot
 */
public class SqlCmdParam {
    String paramName = "";
    Object value = "";

    public SqlCmdParam() {
    }

    public SqlCmdParam(String schemaName, String tableName, String driverName, String columnName, Integer ordinal, Object value) {
        this.paramName = schemaName;
        this.value = value;
    }

    public SqlCmdParam(String tableName, String driverName, String columnName, Integer ordinal, Object value) {

        this.value = value;
    }

    public String getSchemaName() {
        return paramName;
    }

    public void setSchemaName(String schemaName) {
        this.paramName = schemaName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }


}
