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

    private static SqlSessionFactory sqlSessionFactory;
    private static String resource = "conf.xml";
    static{
        InputStream inputStream = App.class.getClassLoader().getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    public static void main(String[] args) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement = "main.com.mmj.entity.UserMapper.GetUserById";
        try {
            User user = sqlSession.selectOne(statement, 1);
            if (user != null) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(sqlSession!=null){
                sqlSession.close();
            }
        }

    }
}
