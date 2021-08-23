package dao;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoProduct extends DaoSet {

    public Object[] getCate() {
        Object[] result = null;
        String sql = "select DISTINCT category from demo_product_info";
        ArrayList list = new ArrayList();
        try {
            conn = connDB();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            result = list.toArray();
        } catch (SQLException e) { e.printStackTrace(); }
        return result;
    }

    public Object[] getProdList(String cate) {
        Object[] result = null;
        String sql = "select product_id, product_name from demo_product_info where category = ? ";
        ArrayList list = new ArrayList();
        try {
            conn = connDB();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cate);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1)+"/"+rs.getString(2));
            }
            result = list.toArray();
        } catch (SQLException e) { e.printStackTrace(); }
        return result;
    }

    public String getProdPrice(String pId) {
        String result = "";
        String sql = "select List_Price from demo_product_info where Product_id = ? ";
        ArrayList list = new ArrayList();
        try {
            conn = connDB();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(pId));
            rs = pstmt.executeQuery();
            if(rs.next()) {
                result = rs.getString(1);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return result;
    }

    public ImageIcon getProdImg(String pId) {
        ImageIcon result = null;
        String sql = "select product_image from demo_product_info where product_id = ? ";
        try {
            conn = connDB();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(pId));
            rs = pstmt.executeQuery();
            if(rs.next()) result =
                    new ImageIcon(ImageIO.read(rs.getBinaryStream(1)));
        } catch (Exception e) {e.printStackTrace();}
        return result;
    }

}
