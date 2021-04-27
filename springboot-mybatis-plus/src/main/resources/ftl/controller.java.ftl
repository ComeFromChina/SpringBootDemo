package ${package.Controller};


 import org.springframework.web.bind.annotation.*;
 import org.springframework.beans.factory.annotation.Autowired;
 import com.lovemio.mybatisplus.service.${table.serviceName};
 import com.lovemio.mybatisplus.entity.${entity};
 import lombok.extern.slf4j.Slf4j;
 import com.lovemio.mybatisplus.utils.Result;
 import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
 import java.util.List;
<#if restControllerStyle>
 import org.springframework.web.bind.annotation.RestController;
<#else>
 import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
 import ${superControllerClassPackage};
</#if>

 /**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 * @version v1.0
 */
<#if restControllerStyle>
 @RestController
<#else>
 @Controller
</#if>
 @Slf4j
 @RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if><#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
 class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
 <#if superControllerClass??>
  public class ${table.controllerName} extends ${superControllerClass} {
 <#else>
  public class ${table.controllerName} {
 </#if>
 @Autowired
 private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};

 /**
 * 查询分页数据
 */
 @RequestMapping(value = "/list")
 public Result findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,@RequestParam(name = "pageSize", defaultValue = "20") int pageSize){
     Page<${entity}> page = ${(table.serviceName?substring(1))?uncap_first}.page(new Page<>(pageNum, pageSize));
     return Result.success(page);
 }


 /**
 * 根据id查询
 */
 @RequestMapping(value = "/getById")
 public Result getById(@RequestParam("id") String id){
    return Result.success(${(table.serviceName?substring(1))?uncap_first}.getById(id));
}

/**
* 新增
*/
@RequestMapping(value = "/add", method = RequestMethod.POST)
public Result add(@RequestBody ${entity} ${entity?uncap_first}){
    return Result.success(${(table.serviceName?substring(1))?uncap_first}.save(${entity?uncap_first}));
}

/**
* 删除
*/
@RequestMapping(value = "/del")
public Result del(@RequestParam("id") Integer id){
    return Result.success(${(table.serviceName?substring(1))?uncap_first}.removeById(id));
}

/**
* 批量删除
*/
@RequestMapping(value = "/batchDel")
public Result batchDel(@RequestParam("ids") List<String> ids){
return Result.success(${(table.serviceName?substring(1))?uncap_first}.removeByIds(ids));
}

/**
* 修改
*/
@RequestMapping(value = "/update", method = RequestMethod.POST)
public Result update(@RequestBody ${entity} ${entity?uncap_first}){
    return Result.success(${(table.serviceName?substring(1))?uncap_first}.saveOrUpdate(${entity?uncap_first}));
}

}
</#if>