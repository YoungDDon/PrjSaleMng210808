package dao;

import controller.MainController;
import jdk.nashorn.internal.scripts.JO;
import vo.UserVO;

import javax.swing.*;
import java.sql.SQLException;

public class DaoUser extends DaoSet {
    public UserVO checkLogin(String id, String pw) {
        UserVO user = null;
        try {
            conn = connDB();
            String query = "select * from demo_users where id=? and password=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,id);
            pstmt.setString(2,pw);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new UserVO(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getDate(4), rs.getInt(5), rs.getString(6),
                        rs.getDate(7), rs.getString(8), rs.getString(9));

                MainController.getInstance().setSession(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public boolean registUser(UserVO vo) {
        boolean result = false;
        try {
            conn = connDB();
            String sql = "insert into demo_users values(user_id,user_name," +
                    "password, created_on, quota, products,exprires_on, admin_user " +
                    "id) valuse(demo_users_seq.nextval,?,?,sysdata,null,'Y',null,'N', ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getUserID());
            pstmt.setString(2,vo.getUserName());
            pstmt.setString(3,vo.getId());
            int cnt = pstmt.executeUpdate();
            result = cnt>0?true:false;
        } catch (SQLException e) {e.printStackTrace();}
        return result;
    }
//    public UserVO duplicateId(String id){
//        UserVO user = false;
//        try {
//            conn = connDB();
//            String query = "select * from demo_users where id=?";
//            pstmt = conn.prepareStatement(query);
//            pstmt.setString(1,id);
//            rs = pstmt.executeQuery();
//            if(rs.next()) {
//                JOptionPane.showMessageDialog(null,"이미 있는 ID");
//                return;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
}