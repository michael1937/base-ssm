package ${packageModel};

import com.kanglefu.modules.base.model.CommonBaseModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Time;


/**
* 描述：${tableRemark}模型
* @author ${author}
* @date ${date}
*/
@Table(name="${tableName}")
public class ${javaName} extends CommonBaseModel {

<#if columns?exists>
    <#list columns as model>

    /**
    * ${model.columnComment!}
    */
    <#if (model.columnType = 'BIT' || model.columnType = 'TINYINT' || model.columnType = 'SMALLINT' || model.columnType = 'MEDIUMINT' || model.columnType = 'INT' || model.columnType = 'INTEGER')>
    @Column(name = "${model.columnName}")
    private Integer ${model.javaPropertyName};
    </#if>
    <#if (model.columnType = 'BIGINT')>
    @Column(name = "${model.columnName}")
    private Long ${model.javaPropertyName};
    </#if>
    <#if (model.columnType = 'FLOAT' || model.columnType = 'DOUBLE')>
    @Column(name = "${model.columnName}")
    private Double ${model.javaPropertyName};
    </#if>
    <#if (model.columnType = 'DECIMAL')>
    @Column(name = "${model.columnName}")
    private BigDecimal ${model.javaPropertyName};
    </#if>
    <#if (model.columnType = 'TIME')>
    @Column(name = "${model.columnName}")
    private Time ${model.javaPropertyName};
    </#if>
    <#if (model.columnType = 'YEAR' || model.columnType = 'DATE' || model.columnType = 'DATETIME' || model.columnType = 'TIMESTAMP')>
    @Column(name = "${model.columnName}")
    private Date ${model.javaPropertyName};
    </#if>
    <#if (model.columnType = 'CHAR' || model.columnType = 'VARCHAR' || model.columnType = 'TINYTEXT' || model.columnType = 'TEXT' || model.columnType = 'MEDIUMTEXT' || model.columnType = 'LONGTEXT')>
    @Column(name = "${model.columnName}")
    private String ${model.javaPropertyName};
    </#if>
    <#if (model.columnType = 'TINYBLOB' || model.columnType = 'BLOB' || model.columnType = 'MEDIUMBLOB' || model.columnType = 'LONGBLOB')>
    @Column(name = "${model.columnName}")
    private byte[] ${model.javaPropertyName};
    </#if>
    </#list>
</#if>

<#if columns?exists>
    <#list columns as model>
    <#if (model.columnType = 'BIT' || model.columnType = 'TINYINT' || model.columnType = 'SMALLINT' || model.columnType = 'MEDIUMINT' || model.columnType = 'INT' || model.columnType = 'INTEGER')>
    <#--<#if (model.columnType = 'VARCHAR' || model.columnType = 'text')>-->
    public Integer get${model.javaPropertyName?cap_first}() {
        return this.${model.javaPropertyName};
    }

    public void set${model.javaPropertyName?cap_first}(Integer ${model.javaPropertyName}) {
        this.${model.javaPropertyName} = ${model.javaPropertyName};
    }

    </#if>
    <#if (model.columnType = 'BIGINT')>
    public Long get${model.javaPropertyName?cap_first}() {
        return this.${model.javaPropertyName};
    }

    public void set${model.javaPropertyName?cap_first}(Long ${model.javaPropertyName}) {
        this.${model.javaPropertyName} = ${model.javaPropertyName};
    }

    </#if>
    <#if (model.columnType = 'FLOAT' || model.columnType = 'DOUBLE')>
    <#--<#if (model.columnType = 'VARCHAR' || model.columnType = 'text')>-->
    public Double get${model.javaPropertyName?cap_first}() {
    return this.${model.javaPropertyName};
    }

    public void set${model.javaPropertyName?cap_first}(Double ${model.javaPropertyName}) {
    this.${model.javaPropertyName} = ${model.javaPropertyName};
    }

    </#if>
    <#if (model.columnType = 'DECIMAL')>
    public BigDecimal get${model.javaPropertyName?cap_first}() {
    return this.${model.javaPropertyName};
    }

    public void set${model.javaPropertyName?cap_first}(BigDecimal ${model.javaPropertyName}) {
    this.${model.javaPropertyName} = ${model.javaPropertyName};
    }

    </#if>
    <#if (model.columnType = 'TIME')>
    public Time get${model.javaPropertyName?cap_first}() {
    return this.${model.javaPropertyName};
    }

    public void set${model.javaPropertyName?cap_first}(Time ${model.javaPropertyName}) {
    this.${model.javaPropertyName} = ${model.javaPropertyName};
    }

    </#if>
    <#if (model.columnType = 'YEAR' || model.columnType = 'DATE' || model.columnType = 'DATETIME' || model.columnType = 'TIMESTAMP')>
    public Date get${model.javaPropertyName?cap_first}() {
    return this.${model.javaPropertyName};
    }

    public void set${model.javaPropertyName?cap_first}(Date ${model.javaPropertyName}) {
    this.${model.javaPropertyName} = ${model.javaPropertyName};
    }

    </#if>
    <#if (model.columnType = 'CHAR' || model.columnType = 'VARCHAR' || model.columnType = 'TINYTEXT' || model.columnType = 'TEXT' || model.columnType = 'MEDIUMTEXT' || model.columnType = 'LONGTEXT')>
    public String get${model.javaPropertyName?cap_first}() {
    return this.${model.javaPropertyName};
    }

    public void set${model.javaPropertyName?cap_first}(String ${model.javaPropertyName}) {
    this.${model.javaPropertyName} = ${model.javaPropertyName};
    }

    </#if>
    <#if (model.columnType = 'TINYBLOB' || model.columnType = 'BLOB' || model.columnType = 'MEDIUMBLOB' || model.columnType = 'LONGBLOB')>
    public byte[] get${model.javaPropertyName?cap_first}() {
    return this.${model.javaPropertyName};
    }

    public void set${model.javaPropertyName?cap_first}(byte[] ${model.javaPropertyName}) {
    this.${model.javaPropertyName} = ${model.javaPropertyName};
    }

    </#if>
    </#list>
</#if>
}