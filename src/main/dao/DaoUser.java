package dao;

import controller.MainController;
import vo.UserVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class DaoUser extends DaoSet {
    public UserVO checkLogin(String id, String pw) {
        UserVO user = null;
        try {
            conn = connDB();
            String query = "select * from demo_users where id=? and password=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
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
            if (duplicateId(vo.getId())) {
                return false;
            }
            String sql = "insert into demo_users (user_id, user_name, password," +
                    "created_on, quota, products, expires_on, admin_user," +
                    "id) values(demo_users_seq.nextval,?,?,sysdate" +
                    ",null, 'Y', null, 'N',?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getUserName());
            pstmt.setString(2, vo.getPassword());
            pstmt.setString(3, vo.getId());
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                JOptionPane.showMessageDialog(null, "등록에 성공했습니다.");
                result = true;
            } else {
                JOptionPane.showMessageDialog(null, "등록에 실패했습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean duplicateId(String id) {
        boolean result = false;
        try {
            conn = connDB();
            String sql = "select * from demo_users where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "중복된 ID입니다.");
                result = true;
            }
        } catch (SQLException e) {e.printStackTrace();}
        return result;
    }

    public DefaultTableModel getUserList(DefaultTableModel model, String srch) {
        String query = "";

        try {
            conn = connDB();
            if(srch.equals("")) { query = "select * from demo_users"; }
            else { query = "select * from demo_users where user_name = ?"; }
            pstmt = conn.prepareStatement(query);
            if(!srch.equals("")) pstmt.setString(1, srch);
            rs = pstmt.executeQuery();
            model = new DefaultTableModel(new String[]{"USER_ID","ID","이름","입사일","QUOTA","상품유무",
                    "퇴사일","관리자 여부"}, 0);
            while(rs.next()) {
                String[] tmpArr = {rs.getInt(1)+"", rs.getString(9), rs.getString(2),
                        rs.getDate(4)+"", rs.getInt(5)+"", rs.getString(6),
                        String.valueOf(rs.getDate(7))+"", rs.getString(8)
                };
                model.addRow(tmpArr);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return model;
    }
}