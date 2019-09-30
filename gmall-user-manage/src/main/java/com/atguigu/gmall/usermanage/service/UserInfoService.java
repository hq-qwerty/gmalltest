package com.atguigu.gmall.usermanage.service;

import com.atguigu.gmall.usermanage.bean.UserInfo;

import java.util.List;

public interface UserInfoService {

    //1.1 查询所有用户信息
    List<UserInfo> findAll();

    //1.2 根据用户输入条件检索数据(等值查询)
    List<UserInfo> findByCondition(UserInfo userInfo);

    //1.3 根据用户输入条件检索数据(非等值查询)
    List<UserInfo> findByExample(String nickName);

    //2.1 添加数据
    void addUser(UserInfo userInfo);

    //3.1 修改user by 主键
    void updUser(UserInfo userInfo);

    //3.2 修改user by condition
    void updUserByCondition(UserInfo userInfo);

    //4.1 删除user 根据对象中的已有字段值进行等值匹配删除
    void delUser(UserInfo userInfo);

    //4.2 删除user 根据主键值删除
    void delUserByPrimaryKey(UserInfo userInfo);

    //4.2 删除user 根据自定义条件
    void delUserByCondition(List<String> list);

}
