package com.kanglefu.utils.generate;

/**
 * Created by Michael on 2017/7/26.
 * 数据库表中字段相关
 */
public class ColumnClass {

    /**
     * 数据库字段名称
     **/
    private String columnName;

    /**
     * 数据库字段类型
     **/
    private String columnType;

    /**
     * 数据库字段注释
     **/
    private String columnComment;

    /**
     * 对应JAVA属性名
     **/
    private String javaPropertyName;


    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getJavaPropertyName() {
        return javaPropertyName;
    }

    public void setJavaPropertyName(String javaPropertyName) {
        this.javaPropertyName = javaPropertyName;
    }
}
