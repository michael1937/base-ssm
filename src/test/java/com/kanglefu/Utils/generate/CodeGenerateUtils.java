package com.kanglefu.utils.generate;

import freemarker.template.Template;
import org.joda.time.DateTime;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Michael on 2017/7/26.
 * 代码生成工具
 */
public class CodeGenerateUtils {

    /**
     * 数据库连接配置（一般不用改）
     */
    private static String jdbcDriver = "com.mysql.jdbc.Driver";
    private static String jdbcUrl = "jdbc:mysql://192.168.127.101:3306/essm?useUnicode=true&characterEncoding=UTF-8";
    private static String jdbcUser = "root";
    private static String jdbcPassword = "kanglefu";

    /**
     * 作者信息(写上自己的名字吧)
     */
    private static String author = "Michael";
    private static String currentDate = new DateTime().toString("yyyy-MM-dd HH:mm:ss");

    /**
     * 表名与类名可能会有区别 比如表名为t_user 我们需要生成的JAVA类为 User.java时 去除2个长度的前缀
     */
    private static int tableNameIgnorePrefixLength = 2; // 表名转JAVA类时去除的前缀长度

    // 父包名 不同的模块使用不同的模块名
    private static String modulePackage = "com.kanglefu.modules.demo2";

    // 代码生成的项目目录
    private static String targetProject = "/src/main/java";

    /**
     * 忽略的属性字段
     */
    private static String[] columnsIgnore;

    /**
     * 需要生成代码的表
     */
    private static String[] tableNames;

    /**
     * 代码物理路径 (默认代码生成在当前项目中)
     */
    private static String baseDir;

    static {
        tableNames = new String[]{
                "x_demo_common"
                , "x_column_test"
                , "t_base_custom"
                , "t_app_version"
        };
        // 全小写,数据库字段名
        columnsIgnore = new String[]{
                "id"
        };

        try {
            baseDir = new File("").getCanonicalPath(); // 默认当前项目文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 子包名
     */
    enum PackageName {
        MODEL, MAPPER, SERVICE, CONTROLLER
    }

    /**
     * java 文件最终生成的目录地址 全路径
     */
    public static String getTargetDir(PackageName packageName) {
        String moduleDir = modulePackage;

        moduleDir = moduleDir.replaceAll("\\.", "/");

        return baseDir + targetProject + "/" + moduleDir + "/" + packageName.name().toLowerCase() + "/";
    }

    /**
     * 开始生成代码
     */
    public static void main(String[] args) throws Exception {

//        String moduleDir = getTargetDir(PackageName.MODEL);
//        System.out.println(moduleDir);
//
//        File file = new File(moduleDir);
//        if (file.exists()) {
//            System.out.println("已经存在的文件夹");
//        }

        // 获取需要生成代码的表 并封装完成
        List<JavaClass> list = getJavaClasses();
//
//        System.out.println("表解析完成，本次生成代码共有 " + list.size() + " 个表需要进行");
//
        generateModel(list);

        generateMapper(list);

        generateServiceI(list);

        generateService(list);

        generateController(list);

//        JavaClass javaClass = getJavaClass("x_demo_common");

//        String result = underline2Camel("x_demo_common",false);
//        String result = camel2Underline("AXssourSsd");
//        System.out.println(baseDir + javaParentDir);

//        generate();
    }

    /**
     * 生成 Model
     */
    private static void generateModel(List<JavaClass> list) throws Exception {

        for (JavaClass javaClass : list) {

            String modelName = javaClass.getJavaName();
            System.out.println("准备生成 Model : " + modelName);

            String fileName = javaClass.getJavaName() + ".java";

            String templateName = "Model.ftl";

            generateFileByTemplate(templateName, getTargetDir(PackageName.MODEL), fileName, javaClass);
        }
    }

    /**
     * 生成 Mapper
     */
    private static void generateMapper(List<JavaClass> list) throws Exception {

        for (JavaClass javaClass : list) {

            String mapperName = javaClass.getJavaName() + "Mapper";
            System.out.println("准备生成 Mapper : " + mapperName);

            String fileName = javaClass.getJavaName() + "Mapper.java";

            String templateName = "Mapper.ftl";

            generateFileByTemplate(templateName, getTargetDir(PackageName.MAPPER), fileName, javaClass);
        }
    }

    /**
     * 生成 IService
     */
    private static void generateServiceI(List<JavaClass> list) throws Exception {

        for (JavaClass javaClass : list) {

            String serviceIName = "I" + javaClass.getJavaName() + "Service";
            System.out.println("准备生成 IService : " + serviceIName);

            String fileName = "I" + javaClass.getJavaName() + "Service.java";

            String templateName = "IService.ftl";

            generateFileByTemplate(templateName, getTargetDir(PackageName.SERVICE), fileName, javaClass);
        }
    }

    /**
     * 生成 Service
     */
    private static void generateService(List<JavaClass> list) throws Exception {

        for (JavaClass javaClass : list) {

            String serviceName = javaClass.getJavaName() + "Service";
            System.out.println("准备生成 Service : " + serviceName);

            String fileName = javaClass.getJavaName() + "Service.java";

            String templateName = "Service.ftl";

            generateFileByTemplate(templateName, getTargetDir(PackageName.SERVICE) + "/impl", fileName, javaClass);
        }
    }

    /**
     * 生成 Controller
     */
    private static void generateController(List<JavaClass> list) throws Exception {

        for (JavaClass javaClass : list) {

            String mapperName = javaClass.getJavaName() + "Controller";
            System.out.println("准备生成 Controller : " + mapperName);

            String fileName = javaClass.getJavaName() + "Controller.java";

            String templateName = "Controller.ftl";

            generateFileByTemplate(templateName, getTargetDir(PackageName.CONTROLLER), fileName, javaClass);
        }
    }

    /**
     * 获取 数据库 连接
     */
    private static Connection getConnection() throws Exception {
        Class.forName(jdbcDriver);
        Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
        return connection;
    }

    /**
     * 默认同作者同时间
     */
    private static JavaClass getDefaultJavaClass() {

        JavaClass javaClass = new JavaClass();
        javaClass.setAuthor(author);
        javaClass.setDate(currentDate);

        return javaClass;
    }

    /**
     * 根据属性 tableNames 封装出对应需要生成代码的 JavaClass 信息
     */
    private static List<JavaClass> getJavaClasses() throws Exception {

        List<JavaClass> list = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            if (tableNames != null && tableNames.length > 0) {
                connection = getConnection();

                for (String tableName : tableNames) {
                    if (tableName != null && tableName.trim().length() > 0) {

                        JavaClass javaClass = getDefaultJavaClass();
                        javaClass.setTableName(tableName);
                        javaClass.setJavaName(underline2Camel(tableName.substring(tableNameIgnorePrefixLength - 1, tableName.length()), false));

                        javaClass.setPackageModel(modulePackage + "." + PackageName.MODEL.name().toLowerCase());
                        javaClass.setPackageMapper(modulePackage + "." + PackageName.MAPPER.name().toLowerCase());
                        javaClass.setPackageService(modulePackage + "." + PackageName.SERVICE.name().toLowerCase() + ".impl");
                        javaClass.setPackageServiceI(modulePackage + "." + PackageName.SERVICE.name().toLowerCase());
                        javaClass.setPackageController(modulePackage + "." + PackageName.CONTROLLER.name().toLowerCase());

                        DatabaseMetaData databaseMetaData = connection.getMetaData();
                        resultSet = databaseMetaData.getTables(null, "%", tableName, null);
                        while (resultSet.next()) {
                            javaClass.setTableRemark(resultSet.getString("REMARKS"));
                        }

                        resultSet = databaseMetaData.getColumns(null, "%", tableName, "%");

                        List<ColumnClass> columns = new ArrayList<ColumnClass>();

                        while (resultSet.next()) {

                            String columnName = resultSet.getString("COLUMN_NAME");
                            if (Arrays.asList(columnsIgnore).contains(columnName.toLowerCase())) {
                                continue;
                            }
                            ColumnClass columnClass = new ColumnClass();
                            //获取字段名称
                            columnClass.setColumnName(columnName);
                            //获取字段类型
                            columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
                            //字段在数据库的注释
                            columnClass.setColumnComment(resultSet.getString("REMARKS"));

                            //转换字段名称，如 sys_name 变成 SysName
                            columnClass.setJavaPropertyName(underline2Camel(columnName, true));

                            columns.add(columnClass);
                        }
                        javaClass.setColumns(columns);

                        list.add(javaClass);
                    }
                }
            }
        } finally {

            if (resultSet != null) {
                resultSet.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
        return list;
    }

    /**
     * 根据模板生成文件
     */
    private static void generateFileByTemplate(String templateName, String dir, String fileName, JavaClass javaClass) throws Exception {

        File parentDir = new File(dir);
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(new File(dir, fileName));
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
        template.process(javaClass, out);
    }

    /**
     * 下划线转驼峰法
     *
     * @param sourceStr  源字符串
     * @param smallCamel 大小驼峰,是否为小驼峰
     * @return 转换后的字符串
     */
    private static String underline2Camel(String sourceStr, boolean smallCamel) {
        if (sourceStr == null || "".equals(sourceStr)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher = pattern.matcher(sourceStr);
        while (matcher.find()) {
            String word = matcher.group();
            sb.append(smallCamel && matcher.start() == 0 ? Character.toLowerCase(word.charAt(0)) : Character.toUpperCase(word.charAt(0)));
            int index = word.lastIndexOf('_');
            if (index > 0) {
                sb.append(word.substring(1, index).toLowerCase());
            } else {
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }

    /**
     * 驼峰法转下划线
     *
     * @param line 源字符串
     * @return 转换后的字符串
     */
    public static String camel2Underline(String line) {
        if (line == null || "".equals(line)) {
            return "";
        }
        line = String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String word = matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end() == line.length() ? "" : "_");
        }
        return sb.toString();
    }
}
