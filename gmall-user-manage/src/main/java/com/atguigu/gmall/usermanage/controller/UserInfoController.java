package com.atguigu.gmall.usermanage.controller;


import com.atguigu.gmall.usermanage.bean.UserInfo;
import com.atguigu.gmall.usermanage.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 查询所有用户信息
     * http://localhost:8080/findAll
     * @return
     */
    @RequestMapping("findAll")
    @ResponseBody
    public List<UserInfo> findAll(){
        return userInfoService.findAll();
    }

    /**
     * 根据用户输入条件查询用户信息(等值查询)
     * http://localhost:8080/findByCondition?loginName=atguigu
     * @param userInfo
     * @return
     */
    @RequestMapping("findByCondition")
    @ResponseBody
    public List<UserInfo> findByCondition(UserInfo userInfo){
        return userInfoService.findByCondition(userInfo);
    }

    /**
     * 根据用户输入条件查询用户信息(非等值查询)
     * http://localhost:8080/findByExample?nickName=i
     * @param nickName
     * @return
     */
    @RequestMapping("findByExample")
    @ResponseBody
    public List<UserInfo> findByExample(String nickName){

        return userInfoService.findByExample(nickName);
    }

    /**
     * 新增user
     * http://localhost:8080/addUser
     * @param userInfo
     */
    @RequestMapping("addUser")
    @ResponseBody
    public void addUser(UserInfo userInfo){
        userInfo.setLoginName("qwerty");
        userInfo.setNickName("asdfgh");
        userInfo.setName("zxcvbn");

        userInfoService.addUser(userInfo);
    }

    /**
     * 修改user by 主键
     * http://localhost:8080/updUser
     * @param userInfo
     */
    @RequestMapping("updUser")
    @ResponseBody
    public void updUser(UserInfo userInfo){
        userInfo.setLoginName("nevermore");
        userInfo.setNickName("zhsngsanfeng");
        userInfo.setName("zhangwuji");
        userInfo.setId("4");
        userInfoService.updUser(userInfo);
    }

    /**
     * 修改user by 其他条件
     * http://localhost:8080/updUserByCondition
     * @param userInfo
     */
    @RequestMapping("updUserByCondition")
    @ResponseBody
    public void updUserByCondition(UserInfo userInfo){
        userInfo.setLoginName("zhouzhiruo");
        userInfo.setNickName("zhouzhou");
        userInfo.setName("张三");
        userInfoService.updUserByCondition(userInfo);
    }

    /**
     * 删除user 根据对象中的已有字段值进行等值匹配删除
     * http://localhost:8080/delUser
     * @param userInfo
     */
    @RequestMapping("delUser")
    @ResponseBody
    public void delUser(UserInfo userInfo){
        userInfo.setLoginName("zhouzhiruo");
        userInfo.setNickName("zhouzhou");
        userInfo.setName("张三");
        userInfoService.delUser(userInfo);
    }

    /**
     * 删除user 根据主键值删除
     * http://localhost:8080/delUserByPrimaryKey
     * @param userInfo
     */
    @RequestMapping("delUserByPrimaryKey")
    @ResponseBody
    public void delUserByPrimaryKey(UserInfo userInfo){
        userInfo.setLoginName("zhouzhiruo");
        userInfo.setNickName("zhouzhou");
        userInfo.setName("张三");
        userInfo.setId("4");
        userInfoService.delUserByPrimaryKey(userInfo);
    }

    /**
     * 删除user 根据条件删除
     * http://localhost:8080/delUserByCondition
     * @param string
     */
    @RequestMapping("delUserByCondition")
    @ResponseBody
    public void delUserByCondition(String string){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        userInfoService.delUserByCondition(list);
    }




}
