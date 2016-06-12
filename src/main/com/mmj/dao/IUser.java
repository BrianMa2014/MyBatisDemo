package main.com.mmj.dao;

import main.com.mmj.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by MaMingJiang on 2016/6/12.
 * 替代mapper.xml的一种方式
 * Mybatis接口注解
 */
public interface IUser {

    @Select("select * from user where id = #{id}")
    public User getUserById(int id);
}
