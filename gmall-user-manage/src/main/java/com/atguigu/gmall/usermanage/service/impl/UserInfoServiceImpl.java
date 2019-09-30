package com.atguigu.gmall.usermanage.service.impl;

import com.atguigu.gmall.usermanage.bean.UserInfo;
import com.atguigu.gmall.usermanage.mapper.UserInfoMapper;
import com.atguigu.gmall.usermanage.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 查询所有用户信息
     * SELECT * FROM user_info
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    /**
     * 根据用户输入条件查询用户信息(等值查询)
     * SELECT * FROM user_info WHERE column=？
     * @param userInfo
     * @return
     */
    @Override
    public List<UserInfo> findByCondition(UserInfo userInfo) {

        return userInfoMapper.select(userInfo);
    }

    /**
     * 根据用户输入条件查询用户信息(非等值查询)
     * SELECT * FROM user_info WHERE nick_name like ?
     * @param nickName
     * @return
     */
    @Override
    public List<UserInfo> findByExample(String nickName) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("nickName","%"+nickName+"%");
        return userInfoMapper.selectByExample(example);
    }

    /**
     * 新增用户信息
     * INSERT INTO user_info VALUES(?,?,?,?,?)
     * @param userInfo
     */
    @Override
    public void addUser(UserInfo userInfo) {

        userInfoMapper.insertSelective(userInfo);

    }

    /**
     * 修改user by 主键
     * UPDATE user_info SET column=value... WHERE id=?
     * @param userInfo
     */
    @Override
    public void updUser(UserInfo userInfo) {

        userInfoMapper.updateByPrimaryKeySelective(userInfo);

    }

    /**
     * 修改user by condition
     * UPDATE user_info SET column=value... WHERE column=value
     * @param userInfo
     */
    @Override
    public void updUserByCondition(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",userInfo.getName());
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }

    /**
     * 删除user 根据对象中的已有字段值进行等值匹配删除
     * DELETE FROM user_info WHERE login_name = ? AND nick_name = ? AND name = ?
     * @param userInfo
     */
    @Override
    public void delUser(UserInfo userInfo) {
        userInfoMapper.delete(userInfo);
    }

    /**
     * 删除user 根据主键值删除
     * DELETE FROM user_info WHERE id = ?
     * @param userInfo
     */
    @Override
    public void delUserByPrimaryKey(UserInfo userInfo) {
        userInfoMapper.deleteByPrimaryKey(userInfo.getId());
    }

    /**
     * 删除user 根据自定义条件删除
     * DELETE FROM user_info WHERE ( id in ( ? , ? ) )
     * @param list
     */
    @Override
    public void delUserByCondition(List<String> list) {
        Example example = new Example(UserInfo.class);

        example.createCriteria().andIn("id",list);
        userInfoMapper.deleteByExample(example);
    }
}
