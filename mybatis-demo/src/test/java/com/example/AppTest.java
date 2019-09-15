package com.example;

import static org.junit.Assert.assertTrue;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //加载mybatis核心配置文件，并创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        inputStream.close();
    }

    @Test
    public void test01(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @Test
    public void test02(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = User.builder().userName("ceshi123")
                .realName("测试").mobile("1380564111")
                .email("1434501995@qq.com").build();
        userMapper.insert(user);

        System.out.println(userMapper.selectByPrimaryKey(user.getId()));
    }


    /**
     * 测试占位符
     */
    @Test
    public void test03(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectWithPlaceHolder("user_name", "t_user", 1);
        System.out.println(user);
    }

    /**
     * 使用数组批量查询
     */
    @Test
    public void test04(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Integer[] ids = new Integer[]{1,2};
        List<User> userList = userMapper.batchQueryById(ids);
        System.out.println(userList);
    }

    /**
     * 使用集合批量插入
     */
    @Test
    public void test05(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = new ArrayList<>();
        User user1 = User.builder().userName("wangwu1").email("121212@qq.com")
                .mobile("13122223333").positionId(1).build();
        User user2 = User.builder().userName("wangwu2").email("444444@qq.com")
                .mobile("13344445555").positionId(2).build();

        users.add(user1);
        users.add(user2);

        userMapper.batchInsert(users);
        sqlSession.commit();
    }

    /**
     * choose when 相当于java的if else ，有一个条件满足，另一个条件就不会执行了
     */
    @Test
    public void testChoose(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.selectForChooseOp(null,null);

        userMapper.selectForChooseOp("wangwu1",1);
        userMapper.selectForChooseOp("",2);
    }

    @Test
    public void testOneToOne(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User user = mapper.selectForOneToOne(1);
//        user.getPosition();

        User user = mapper.selectForOneToOne1(1);
        System.out.println(user);
    }

    @Test
    public void testOneToMany(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

//        User user = userMapper.selectForOneToMany(2);
        User user = userMapper.selectForOneToMany1(2);

        System.out.println(user.getJobHistories());
    }


    /**
     * 懒加载，按需加载，需要这个属性时，才会执行查询语句
     */
    @Test
    public void testSelectFormanyToMany1(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

//        User user = userMapper.selectForOneToMany(2);
        List<User> users = userMapper.selectFormanyToMany1(null);

        System.out.println(users);
    }
}
