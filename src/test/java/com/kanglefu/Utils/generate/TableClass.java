package com.kanglefu.utils.generate;

import java.util.List;

/**
 * Created by Michael on 2017/7/26.
 *  数据库表与JAVA类的转换
 */
public class TableClass {

    /**
     *  表名
     */
    private String tableName;

    /**
     *  表注释
     */
    private String tableRemark;

    /**
     *  表中的字段
     */
    private List<ColumnClass> columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableRemark() {
        return tableRemark;
    }

    public void setTableRemark(String tableRemark) {
        this.tableRemark = tableRemark;
    }

    public List<ColumnClass> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnClass> columns) {
        this.columns = columns;
    }
}
