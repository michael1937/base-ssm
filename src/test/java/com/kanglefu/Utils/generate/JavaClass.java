package com.kanglefu.utils.generate;

/**
 * Created by Michael on 2017/7/26.
 *  数据库表与JAVA类的转换
 */
public class JavaClass extends TableClass {

    /**
     *  作者
     */
    private String author;

    /**
     *  对应的JAVA名
     */
    private String javaName;

    /**
     *  日期
     */
    private String date;

    /**
     *  包名
     */
    private String packageName;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getJavaName() {
        return javaName;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
