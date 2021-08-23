package ui;

import dao.DaoCustomer;
import dao.DaoProduct;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlSale extends JPanel {
    private JDatePicker dPic;
    private JTextField tfSearch;
    private JTable table;
    private JLabel lbProdImg, getProdImgBack;


    public PnlSale() {
        setLayout(null);

        JLabel lbDate = new JLabel("\uB0A0\uC9DC\uC120\uD0DD");
        lbDate.setBounds(12, 10, 52, 15);
        add(lbDate);

        JLabel lbCusName = new JLabel("    \uACE0\uAC1D\uBA85");
        lbCusName.setBounds(345, 10, 57, 15);
        add(lbCusName);

        JComboBox cbCate = new JComboBox(new DaoProduct().getCate());
        cbCate.setBounds(12, 41, 130, 19);
        add(cbCate);

        JComboBox cbCusName = new JComboBox(new DaoCustomer().getCustAll());
        cbCusName.setBounds(411, 8, 188, 19);
        add(cbCusName);

        JLabel lbProdImgTitle = new JLabel("제품 이미지");
        lbProdImgTitle.setBounds(700, 43, 90, 15);
        add(lbProdImgTitle);

        DaoProduct daoProduct = new DaoProduct();
        JComboBox cbProd = new JComboBox(daoProduct.getProdList(cbCate.getSelectedItem().toString()));
        cbProd.setBounds(147, 41, 209, 19);
        add(cbProd);

        tfSearch = new JTextField();
        tfSearch.setBounds(488, 41, 111, 20);
        add(tfSearch);
        tfSearch.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 70, 587, 280);
        add(scrollPane);

        table = new JTable();
        scrollPane.setColumnHeaderView(table);

        JButton btnAdd = new JButton("\uCD94\uAC00");
        btnAdd.setBounds(360, 360, 60, 23);
        add(btnAdd);

        JButton btnCancle = new JButton("\uCDE8\uC18C");
        btnCancle.setBounds(423, 360, 64, 23);
        add(btnCancle);

        JButton btnPay = new JButton("\uACB0\uC81C");
        btnPay.setBounds(490, 360, 109, 23);
        add(btnPay);

        JTextField tfTotal = new JTextField();
        tfTotal.setBackground(Color.GRAY);
        tfTotal.setBounds(12, 360, 243, 30);
        add(tfTotal);

        JTextField tfPrice = new JTextField();
        String pId = cbProd.getSelectedItem().toString().split("/")[0];
        tfPrice.setText(daoProduct.getProdPrice(pId));
        tfPrice.setBounds(365, 41, 55, 20);
        add(tfPrice);

        ImageIcon img = daoProduct.getProdImg(pId);
        lbProdImg = new JLabel(resizeImg(img));
        lbProdImg.setBounds(606, 70, 249, 279);
        add(lbProdImg);

        JLabel ProdImgBack= new JLabel();
        ProdImgBack.setBounds(606, 70, 249, 279);
        add(ProdImgBack);
        ProdImgBack.setOpaque(true);
        ProdImgBack.setBackground(Color.WHITE);
        Border bevelBorder = new BevelBorder(BevelBorder.RAISED,
                    Color.LIGHT_GRAY, Color.LIGHT_GRAY.darker(),
                    Color.LIGHT_GRAY, Color.LIGHT_GRAY.brighter());
        ProdImgBack.setBorder(bevelBorder);

        JDatePicker dPic = new JDatePicker();
        dPic.setBounds(76, 6, 262, 26);
        add(dPic);

        JTextField tfAmount = new JTextField();
        tfAmount.setBounds(422,41,64,20);
        add(tfAmount);
        tfAmount.setColumns(10);


        cbCate.addActionListener(e -> {
                Object[] oArr = null;
                String cateW = cbCate.getSelectedItem().toString();
                cbProd.removeAllItems();
                try {
                    oArr = daoProduct.getProdList(cateW);
                } catch (Exception e1) { }
                if (oArr.length > 0) {
                    for (int i = 0; i < oArr.length; i++) {
                        cbProd.addItem(oArr[i]);
                    }
                }
            });
        cbProd.addActionListener(e->{
            if (cbProd.getSelectedItem() != null) {
                    String pId1 = cbProd.getSelectedItem().toString().split("/")[0];
                    tfPrice.setText(daoProduct.getProdPrice(pId1));
                    lbProdImg.setIcon(daoProduct.getProdImg(pId1));
            }
            tfAmount.setText("");
            tfTotal.setText("");
        });
    }
    private ImageIcon resizeImg(ImageIcon img){
        int imgW = img.getIconWidth();
        int imgH = img.getIconHeight();
        int dynamicH = imgH*230/imgW;
        Image image = img.getImage();
        Image newimg = image.getScaledInstance(230, dynamicH,
                java.awt.Image.SCALE_SMOOTH);
        return img = new ImageIcon(newimg);
    }
}