package main.com.mmj.dao;

import main.com.mmj.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by MaMingJiang on 2016/6/12.
 * ���mapper.xml��һ�ַ�ʽ
 * Mybatis�ӿ�ע��
 */
public interface IUser {

    @Select("select * from user where id = #{id}")
    public User getUserById(int id);

    public User selectUserById(int id);

    public void addUser(User user);

    public void deleteUser(int id);

    public void updateUser(User user);

    public List<User> selectUserByName(String name);



}
