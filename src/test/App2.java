package test;

import main.com.mmj.dao.IUser;
import main.com.mmj.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Created by MaMingJiang on 2016/6/12.
 * 使用合理描述参数和SQL语句返回值的接口(比如：IUser.class)，
 * 这样现在就可以至此那个更简单，更安全的代码，没有容易发生的字符串文字和转换的错误
 *
 * 这样可以省略userMapper.xml
 */
public class App2 {

    private static SqlSessionFactory sqlSessionFactory;
    private static String resource = "conf.xml";
    static{
        InputStream inputStream = App2.class.getClassLoader().getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
//        sqlSessionFactory.getConfiguration().addMapper(IUser.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUser iuser = sqlSession.getMapper(IUser.class);
        //1 . query User
        User user = iuser.selectUserById(6);
        if(user !=null){
            System.out.println(user);
        }
        //2 . add User
        try {
            User addUser = new User();
            addUser.setName("Brian");
            addUser.setDept("Tech");
            addUser.setWebsite("www.baidu.com");
            addUser.setPhone("13122222");
            iuser.addUser(addUser);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        //3 . delete User
        iuser.deleteUser(6);
        sqlSession.commit();

        //4 . update User
        User updateUser = iuser.selectUserById(8);
        updateUser.setPhone("44444");
        updateUser.setName("modifyName454");
        updateUser.setWebsite("wwww.yint.com454");
        iuser.updateUser(updateUser);
        sqlSession.commit();
        System.out.println("查询user 集合...");
        List<User> users = iuser.selectUserByName("Brian");
        for(User us : users){
            System.out.println("[]"+us);
        }
        //Expected one result (or null) to be returned by selectOne(), but found: 11
//        User user1 = sqlSession.selectOne("selectUserByName","Brian");
//        System.out.println("selectOne:"+user1);
        //select by id
        User user1 = sqlSession.selectOne("selectUserById",11);
        System.out.println("selectOne:"+user1);
    }
}
