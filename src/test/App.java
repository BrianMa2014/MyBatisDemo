package test;

import main.com.mmj.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by MaMingJiang on 2016/6/12.
 */
public class App {
    public static void main(String[] args) {
        String resource = "conf.xml";
        InputStream inputStream = App.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement = "mapping.userMapper.getUser";
        User user = sqlSession.selectOne(statement, 1);
        System.out.println(user);
    }
}
