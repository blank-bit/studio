package com.wang.controller;

import com.wang.entity.ServerResponse;
import com.wang.entity.User;
import com.wang.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-12-16 15:34:58
 */
@RestController
@RequestMapping("/homework")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("/selectOne/{id}")
    public User selectOne(@PathVariable Integer id) {
        return this.userService.queryById(id);
    }

    /**
     * 查询全部数据
     *
     * @return 全部数据
     */
    @RequestMapping("/getAll")
    public ServerResponse<List<User>> getAll(){
        if(userService.getAll() != null)
            return ServerResponse.getSuccess("全部的数据",userService.getAll(),userService.getAll().size());

        return ServerResponse.getError("查询失败");
    }

    /**
     * 向表中添加数据
     *
     * @param user
     * @return 结果
     */
    @RequestMapping("/add")
    public ServerResponse<List<User>> Add(@RequestBody User user)
    {
        if(userService.queryById(user.getId()) == null && userService.add(user) == 1)
            return ServerResponse.AddSuccess("加入名字"+user.getName()+" id为"+user.getId(),userService.getAll(),userService.getAll().size());

        return ServerResponse.AddError("已存在名字"+user.getName()+" id为"+user.getId());
    }

    /**
     * 删除表中数据
     *
     * @param user
     * @return 结果
     */
    @RequestMapping("/delete")
    public ServerResponse<List<User>> delete(@RequestBody User user)
    {
        if(userService.deleteById(user.getId()) == 1 && userService.getAll()!=null)
            return ServerResponse.DeleteSuccess("删除名字"+user.getName()+" id为"+user.getId(), userService.getAll(), userService.getAll().size());

        return ServerResponse.DeleteError("这个id不存在 id为"+user.getId());
    }

}