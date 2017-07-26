package ${packageName};

import com.kanglefu.modules.base.model.CommonBaseModel;

import javax.persistence.*;
import java.util.Date;


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
    <#if (model.columnType = 'VARCHAR' || model.columnType = 'text')>
    @Column(name = "${model.columnName}")
    private String ${model.javaPropertyName};
    </#if>
    <#if model.columnType = 'DATETIME' >
    @Column(name = "${model.columnName}")
    private Date ${model.javaPropertyName};
    </#if>
    </#list>
</#if>

<#if columns?exists>
    <#list columns as model>
    <#if (model.columnType = 'VARCHAR' || model.columnType = 'text')>
    public String get${model.javaPropertyName?cap_first}() {
    return this.${model.javaPropertyName};
    }

    public void set${model.javaPropertyName?cap_first}(String ${model.javaPropertyName}) {
    this.${model.javaPropertyName} = ${model.javaPropertyName};
    }

    </#if>
    <#if model.columnType = 'DATETIME' >
    public Date get${model.javaPropertyName?cap_first}() {
    return this.${model.javaPropertyName};
    }

    public void set${model.javaPropertyName?cap_first}(Date ${model.javaPropertyName}) {
    this.${model.javaPropertyName} = ${model.javaPropertyName};
    }
    </#if>
    </#list>
</#if>
}