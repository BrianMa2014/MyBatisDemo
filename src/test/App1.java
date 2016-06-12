package test;

import main.com.mmj.dao.IUser;
import main.com.mmj.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by MaMingJiang on 2016/6/12.
 * ʹ�ú�������������SQL��䷵��ֵ�Ľӿ�(���磺IUser.class)��
 * �������ھͿ��������Ǹ����򵥣�����ȫ�Ĵ��룬û�����׷������ַ������ֺ�ת���Ĵ���
 *
 * ��������ʡ��userMapper.xml
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
