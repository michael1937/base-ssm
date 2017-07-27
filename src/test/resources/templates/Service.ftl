package ${packageService};

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ${packageModel}.${javaName};
import ${packageMapper}.${javaName}Mapper;
import ${packageServiceI}.I${javaName}Service;

import com.kanglefu.modules.base.service.impl.BaseService;

/**
* 描述：${tableRemark} Service
* @author ${author}
* @date ${date}
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class ${javaName}Service extends BaseService<${javaName}> implements I${javaName}Service {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ${javaName}Mapper ${javaName?uncap_first}Mapper;

}