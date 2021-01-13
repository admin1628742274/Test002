package com.javacto.dao;

import com.javacto.po.User;
import com.javacto.utils.BaseDao;
import com.javacto.utils.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {
    /**
     * 查询总条数
     */
    @Override
    public int getTotalCount(User user) {
        int count = 0;
        Connection conn =null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            //1.加载驱动
            conn = BaseDao.getConnection();
            String sql = "SELECT * FROM blog_user  WHERE 1=1 ";
            //3.处理预编译SQL语句  PreparedStatement  这里会使用到? 就是占位符  从左边开始数
            //4.如果有 第三步有使用到? 占位符，这里就必需给所有? 赋值   上面有多少个，必需全部赋值
      /*      int num = 1;
            if(user!=null){
                if(!user.getBuSex().equals("")){
                    sql=sql+" and bu_sex= ?";
                }
            }
            pstm =conn.prepareStatement(sql);
            System.out.println(sql);
            if(user!=null){
                if(!user.getBuSex().equals("")){
                    pstm.setObject(num++,user.getBuSex());

                }
            }*/
            pstm=conn.prepareStatement(sql);
            //结束
            //5.执行预编译SQL语句
            rs = pstm.executeQuery();
            //6.循环；
            while (rs.next()){
                 count++;
               /* count =rs.getInt(1);*/
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pstm,rs);
        }

        return  count;
    }
    /**
     * 分页查询
     */
    @Override
    public List<User> getPageUser(Page page, User user) {
        //1.创建ArrayList
        List<User> list = new ArrayList<User>();
        Connection conn =null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            //1.加载驱动
            conn = BaseDao.getConnection();
            String sql = "SELECT * FROM blog_user  WHERE 1=1 ";
            //3.处理预编译SQL语句  PreparedStatement  这里会使用到? 就是占位符  从左边开始数

            //4.如果有 第三步有使用到? 占位符，这里就必需给所有? 赋值   上面有多少个，必需全部赋值
            /*int num = 1;
            if(user!=null){
                if(!user.getBuSex().equals("")){
                    sql=sql+" and bu_sex= ?";

                }
            }

            sql+= " LIMIT ?,?";*/
            pstm =conn.prepareStatement(sql);

            System.out.println(sql);
           /* if(user!=null){
                if(!user.getBuSex().equals("")){
                    pstm.setObject(num++,user.getBuSex());

                }
            }
            //各位同学一定要debug调试
            //开始  (当前页-1)*每页显示几条
            int  begin = (page.getCurPageNo()-1)*page.getPageSize();
            int end = page.getPageSize();
            pstm.setObject(num++,begin);
            pstm.setObject(num++,end);*/

            //结束
            //5.执行预编译SQL语句
            rs = pstm.executeQuery();
            //6.循环；
            while (rs.next()){
                //这里一定要创建User对象  请务必创建一个
                User user1 = new User();
                user1.setBuUserId(rs.getInt(1));
                user1.setBuEmail(rs.getString(2));
                user1.setBuUserName(rs.getString(3));
                user1.setBuPassword(rs.getString(4));
                //后面的，各们同学自己完成。
                //必需把 user1  存入list集合中
                list.add(user1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pstm,rs);
        }

        return  list;
    }
    /**
     * 根据id查询对象
     */
    public  User getUserById(int id){
        Connection conn =null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            //1.加载驱动
            conn = BaseDao.getConnection();
            String sql = "SELECT * FROM blog_user WHERE bu_user_id = ? ";
            //3.处理预编译SQL语句  PreparedStatement  这里会使用到? 就是占位符  从左边开始数
            pstm =conn.prepareStatement(sql);
            //4.给预编译的sql语句赋值
            pstm.setObject(1,id);

            System.out.println(sql);
            //结束
            //5.执行预编译SQL语句
            rs = pstm.executeQuery();
            //6.循环；
            while (rs.next()){
                User user1 = new User();
                user1.setBuUserId(rs.getInt(1));
                user1.setBuEmail(rs.getString(2)); //email
                user1.setBuUserName(rs.getString(3)); //用户名
                user1.setBuPassword(rs.getString(4)); //密码
                user1.setBuSex(rs.getString(5));//性别 1.男 2女 3未知
                user1.setBuBirthday(rs.getDate(6)); //生日
                user1.setBuIdentityCode(rs.getString(7));//身份证号
                user1.setBuMobile(rs.getString(8));//电话
                return user1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pstm,rs);
        }
        return null;
    };
    /**
     * 根据id删除对象
     */
    public int deleteUserById(int id){
        Connection conn =null;
        PreparedStatement pstm = null;
        try{
            //1.加载驱动
            conn = BaseDao.getConnection();
            String sql = "DELETE FROM blog_user WHERE bu_user_id = ?";
            //3.处理预编译SQL语句  PreparedStatement  这里会使用到? 就是占位符  从左边开始数
            pstm =conn.prepareStatement(sql);
            //4.给预编译的sql语句赋值
            pstm.setObject(1,id);
            //5.执行预编译SQL语句
            int i = pstm.executeUpdate();
            //6.返回结果；
            if (i>0){
                return i;
            }else {
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pstm,null);
        }
        return 0;
    }
    /**
     * 修改用户信息
     */
    public int updateUser(User user){
        Connection conn =null;
        PreparedStatement pstm = null;
        try{
            //1.加载驱动
            conn = BaseDao.getConnection();
            String sql = "UPDATE blog_user SET BU_USER_NAME =?,BU_PASSWORD=?,BU_SEX=?,BU_IDENTITY_CODE=?,BU_MOBILE=? WHERE bu_user_id = ?";
            //3.处理预编译SQL语句  PreparedStatement  这里会使用到? 就是占位符  从左边开始数
            pstm =conn.prepareStatement(sql);
            //4.给预编译的sql语句赋值
            pstm.setObject(1,user.getBuUserName());
            pstm.setObject(2,user.getBuPassword());
            pstm.setObject(3,user.getBuSex());
            pstm.setObject(4,user.getBuIdentityCode());
            pstm.setObject(5,user.getBuMobile());
            pstm.setObject(6,user.getBuUserId());
            //5.执行预编译SQL语句
            int i = pstm.executeUpdate();
            //6.返回结果；
            if (i>0){
                return i;
            }else {
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pstm,null);
        }
        return 0;

    }
    /**
     * 添加用户
     */
    public int addUser(User user){
        String sql = "INSERT INTO blog_user (bu_email,bu_user_name,bu_password,bu_sex,bu_birthday,bu_identity_code,bu_mobile,bu_createtime,bu_createuser,bu_updatetime,bu_updateuser,bu_status) VALUES (?,?,?,?,?,?,?,NULL,NULL,NULL,NULL,1)";
        Object[] objects = {user.getBuEmail(),user.getBuUserName(),user.getBuPassword(),user.getBuSex(),user.getBuBirthday(),user.getBuIdentityCode(),user.getBuMobile()};
        int i = BaseDao.executeUpdate(sql, objects);
        return i;
    }
}
