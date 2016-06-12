package main.com.mmj.dao;

import main.com.mmj.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by MaMingJiang on 2016/6/12.
 * ���mapper.xml��һ�ַ�ʽ
 * Mybatis�ӿ�ע��
 */
public interface IUser {

    @Select("select * from user where id = #{id}")
    public User getUserById(int id);
}
