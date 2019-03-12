package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.GlobalException.MyException;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    private static final String SUCCESS_CALLBACK ="success";
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @RequestMapping("/100001")
    public String  hello(){
        return "hello111111";
    }

    @PostMapping(value ="/100002")
    @ResponseBody
    public String exceptionDemo(@RequestParam(required = false,value = "data") String data){
        if("1".equals(data)){
            throw new MyException("我错啦");
        }
        return "没错11122";
    }

    @RequestMapping(value = "/100003",method = RequestMethod.GET)
    public String insterUser(@RequestParam(value = "name") String name){
        userMapper.insertUser(name);
        return SUCCESS_CALLBACK;
    }

    @RequestMapping(value = "/100004",method = RequestMethod.GET)
    public String delteUser(@RequestParam(value = "id") Integer id){
          userMapper.deleteUser(id);
          return SUCCESS_CALLBACK;
    }

    @RequestMapping(value = "/100005",method = RequestMethod.GET)
    public String updateUser(@RequestParam(value = "id") Integer id,@RequestParam(value = "name") String name){
          userMapper.updateUser(name,id);
          return  SUCCESS_CALLBACK;
    }

    @RequestMapping(value = "/100006",method = RequestMethod.GET)
    public String queryUser(@RequestParam(value = "id") Integer id){
        return  JSON.toJSONString(userMapper.queryUser(id));
    }

    @RequestMapping(value = "/100007",method =RequestMethod.GET)
    public String transf(){
        userService.tranAction();
        return SUCCESS_CALLBACK;
    }
}
