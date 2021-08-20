package ui;

import dao.DaoCustomer;
import dao.DaoProduct;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.Color;

public class PnlSale extends JPanel {
    private JDatePicker dPic;
    private JTextField tfSearch;
    private JTable table;

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

        JLabel lbPdImg = new JLabel("제품 이미지");
        lbPdImg.setBounds(715, 43, 57, 15);
        add(lbPdImg);

        DaoProduct daoProduct = new DaoProduct();
        JComboBox cbPd = new JComboBox(daoProduct.getPdList(cbCate.getSelectedItem().toString()));
        cbPd.setBounds(147, 41, 209, 19);
        add(cbPd);

        tfSearch = new JTextField();
        tfSearch.setBounds(463, 41, 136, 21);
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

        JTextPane tpSum = new JTextPane();
        tpSum.setBackground(Color.GRAY);
        tpSum.setBounds(12, 360, 243, 30);
        add(tpSum);

        JTextPane tpPrice = new JTextPane();
        tpPrice.setBounds(365, 41, 92, 19);
        add(tpPrice);

        JPanel panel = new JPanel();
        panel.setBounds(611, 70, 257, 280);
        add(panel);
        setLayout(null);

        JDatePicker dPic = new JDatePicker();
        dPic.setBounds(76, 6, 262, 26);
        add(dPic);
    }
}
