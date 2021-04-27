package com.lovemio.mybatisplus.controller;


 import com.baomidou.mybatisplus.core.conditions.Wrapper;
 import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
 import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
 import com.baomidou.mybatisplus.core.toolkit.Wrappers;
 import org.springframework.web.bind.annotation.*;
 import org.springframework.beans.factory.annotation.Autowired;
 import com.lovemio.mybatisplus.service.IUserService;
 import com.lovemio.mybatisplus.entity.User;
 import lombok.extern.slf4j.Slf4j;
 import com.lovemio.mybatisplus.utils.Result;
 import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 import org.springframework.web.bind.annotation.RestController;

 /**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lwj
 * @since 2021-04-25
 * @version v1.0
 */
 @RestController
 @Slf4j
 @RequestMapping("/user")
  public class UserController {
 @Autowired
 private IUserService userService;

 /**
 * 查询分页数据
 */
 @RequestMapping(value = "/list")
 public Result findListByPage(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,@RequestParam(name = "pageSize", defaultValue = "20") int pageSize){
     Page<User> page = userService.page(new Page<>(pageNum, pageSize));
     return Result.success(page);
 }


 /**
 * 根据id查询
 */
 @RequestMapping(value = "/getById")
 public Result getById(@RequestParam("id") String id){
    return Result.success(userService.getById(id));
}

/**
* 新增
*/
@RequestMapping(value = "/add", method = RequestMethod.POST)
public Result add(@RequestBody User user){
    return Result.success(userService.save(user));
}

/**
* 删除
*/
@RequestMapping(value = "/del")
public Result del(@RequestParam("id") Integer id){
    return Result.success(userService.removeById(id));
}

/**
* 批量删除
*/
@RequestMapping(value = "/batchDel")
public Result batchDel(@RequestParam("ids") List<String> ids){
return Result.success(userService.removeByIds(ids));
}

/**
* 修改
*/
@RequestMapping(value = "/update", method = RequestMethod.POST)
public Result update(@RequestBody User user){
    return Result.success(userService.saveOrUpdate(user));
}


    @RequestMapping("/test")
    public Result test(){

        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        Map map = new HashMap<>();
        map.put("id",1);
        map.put("username","李白");
        wrapper.allEq(map);
        //或者使用LambdaQueryWrapper 以链式调用
        //LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.lambdaQuery().allEq(map);
        //List<User> list = userService.list(lambdaQueryWrapper);
        wrapper.eq("username","李白");

        List<User> list = userService.list(wrapper);
        return Result.success(list);
    }


     @RequestMapping("/test2")
     public Result test2(){


         Map map = new HashMap<>();
         map.put("id",1);
         map.put("username","李白");
         LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>().eq(User::getUsername,"李白");

         List<User> list = userService.list(lambdaQueryWrapper);
         return Result.success(list);
     }
}
