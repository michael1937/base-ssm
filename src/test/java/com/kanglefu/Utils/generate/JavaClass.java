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
     *  日期
     */
    private String date;

    /**
     *  package
     */
    private String packageModel;
    private String packageMapper;
    private String packageServiceI;
    private String packageService;
    private String packageController;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPackageModel() {
        return packageModel;
    }

    public void setPackageModel(String packageModel) {
        this.packageModel = packageModel;
    }

    public String getPackageMapper() {
        return packageMapper;
    }

    public void setPackageMapper(String packageMapper) {
        this.packageMapper = packageMapper;
    }

    public String getPackageServiceI() {
        return packageServiceI;
    }

    public void setPackageServiceI(String packageServiceI) {
        this.packageServiceI = packageServiceI;
    }

    public String getPackageService() {
        return packageService;
    }

    public void setPackageService(String packageService) {
        this.packageService = packageService;
    }

    public String getPackageController() {
        return packageController;
    }

    public void setPackageController(String packageController) {
        this.packageController = packageController;
    }
}
