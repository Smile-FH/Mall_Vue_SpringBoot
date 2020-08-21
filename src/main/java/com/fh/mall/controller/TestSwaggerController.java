package com.fh.mall.controller;

import com.fh.mall.entity.TestUser;
import com.fh.mall.utils.MD5Util;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Description: swagger测试类
 * @Author HueFu
 * @Date 2020-8-18 17:28
 */
@RestController
public class TestSwaggerController {

    static Map<Integer, TestUser> userMap = Collections.synchronizedMap(new HashMap<>());

    static {
        TestUser user = new TestUser();
        user.setId(1);
        user.setName("mall1");
        user.setPassword(MD5Util.MD5Encode("123455", "UTF-8"));
        TestUser user2 = new TestUser();
        user2.setId(2);
        user2.setName("mall2");
        user2.setPassword(MD5Util.MD5Encode("111111","UTF-8"));
        userMap.put(1,user);
        userMap.put(2,user2);
    }

    @ApiOperation(value = "获取用户列表", notes = "没有笔记呀")
    @GetMapping("/users")
    public List<TestUser> getUserList(){
        List<TestUser> users = new ArrayList<>(userMap.values());
        return users;
    }

    @ApiOperation(value = "新增用户", notes = "根据User对象新增用户")
    @ApiImplicitParam(name = "user", value = "测试用户类实体", required = true, dataType = "TestUser")
    @PostMapping("/saveUser")
    public String postUser(TestUser user){
        userMap.put(user.getId(), user);
        return "保存成功啦";
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int")
    @GetMapping("/users/{id}")
    public TestUser getUser(@PathVariable Integer id) {
        return userMap.get(id);
    }

    @ApiOperation(value = "更新用户详细信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    @PutMapping("/users/{id}")
    public String putUser(@PathVariable Integer id, @RequestBody TestUser user) {
        TestUser tempUser = userMap.get(id);
        tempUser.setName(user.getName());
        tempUser.setPassword(user.getPassword());
        userMap.put(id, tempUser);
        return "更新成功";
    }

    @ApiOperation(value = "删除用户", notes = "根据id删除对象")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int")
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userMap.remove(id);
        return "删除成功";
    }

}
