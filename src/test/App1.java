package test;

import main.com.mmj.dao.IUser;
import main.com.mmj.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by MaMingJiang on 2016/6/12.
 * 使用合理描述参数和SQL语句返回值的接口(比如：IUser.class)，
 * 这样现在就可以至此那个更简单，更安全的代码，没有容易发生的字符串文字和转换的错误
 *
 * 这样可以省略userMapper.xml
 */
public class App1 {

    private static SqlSessionFactory sqlSessionFactory;
    private static String resource = "conf.xml";
    static{
        InputStream inputStream = App1.class.getClassLoader().getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
        sqlSessionFactory.getConfiguration().addMapper(IUser.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUser iuser = sqlSession.getMapper(IUser.class);
        User user = iuser.getUserById(1);
        if(user !=null){
            System.out.println(user);
        }

    }
}
