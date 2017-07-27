package ${packageController};

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.kanglefu.modules.base.controller.BaseController;
import ${packageServiceI}.I${javaName}Service;

/**
* 描述：${tableRemark} Controller
* @author ${author}
* @date ${date}
*/
@RestController
@RequestMapping(value = "/${javaName?uncap_first}")
public class ${javaName}Controller extends BaseController {

    @Autowired
    private I${javaName}Service ${javaName?uncap_first}Service;

}