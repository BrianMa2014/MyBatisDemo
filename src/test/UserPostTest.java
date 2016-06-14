package test;

import main.com.mmj.dao.IUser;
import main.com.mmj.entity.Post;
import main.com.mmj.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by MaMingJiang on 2016/6/14.
 */
public class UserPostTest {

    private static SqlSessionFactory sqlSessionFactory;

    static{
        InputStream inputStream = UserPostTest.class.getClassLoader().getResourceAsStream("conf.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    public static void main(String[] args) {
        SqlSession session = sqlSessionFactory.openSession();
        IUser iuser = session.getMapper(IUser.class);
        User user = iuser.selectUserById(1);
        if(user != null) {
            System.out.println(user);
            for (Post post : user.getPosts()){
                System.out.println(post);
            }
        }
    }
}
