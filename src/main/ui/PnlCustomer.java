package ui;

import javax.swing.*;

public class PnlCustomer extends JPanel {
    private JTextField textField;
    private JTextField tfCusLocal;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfCusAds;
    private JTextField tfCusNum;
    private JTable table;
    public PnlCustomer() {
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 149, 846, 201);
        add(scrollPane);

        table = new JTable();
        scrollPane.setColumnHeaderView(table);

        JButton btnAdd = new JButton("\uCD94\uAC00");
        btnAdd.setBounds(543, 360, 97, 30);
        add(btnAdd);

        JButton btnInsert = new JButton("\uC218\uC815");
        btnInsert.setBounds(652, 360, 97, 30);
        add(btnInsert);

        JButton btnDelete = new JButton("\uC0AD\uC81C");
        btnDelete.setBounds(761, 360, 97, 30);
        add(btnDelete);

        JLabel lbCusId = new JLabel("ID");
        lbCusId.setBounds(12, 47, 57, 15);
        add(lbCusId);

        JLabel lbCusLocal = new JLabel("\uC9C0\uC5ED");
        lbCusLocal.setBounds(12, 101, 57, 15);
        add(lbCusLocal);

        textField = new JTextField();
        textField.setBounds(81, 44, 116, 21);
        add(textField);
        textField.setColumns(10);

        tfCusLocal = new JTextField();
        tfCusLocal.setBounds(81, 98, 116, 21);
        add(tfCusLocal);
        tfCusLocal.setColumns(10);

        JLabel lbCusName = new JLabel("\uACE0\uAC1D \uC774\uB984");
        lbCusName.setBounds(209, 47, 57, 15);
        add(lbCusName);

        tfFirstName = new JTextField();
        tfFirstName.setBounds(278, 44, 116, 21);
        add(tfFirstName);
        tfFirstName.setColumns(10);

        tfLastName = new JTextField();
        tfLastName.setBounds(406, 44, 116, 21);
        add(tfLastName);
        tfLastName.setColumns(10);

        JLabel lbCusAds = new JLabel("\uACE0\uAC1D \uC8FC\uC18C");
        lbCusAds.setBounds(479, 101, 57, 15);
        add(lbCusAds);

        tfCusAds = new JTextField();
        tfCusAds.setBounds(543, 98, 116, 21);
        add(tfCusAds);
        tfCusAds.setColumns(10);

        JLabel lbCusNum = new JLabel("\uC804\uD654\uBC88\uD638");
        lbCusNum.setBounds(209, 101, 57, 15);
        add(lbCusNum);

        tfCusNum = new JTextField();
        tfCusNum.setBounds(278, 98, 189, 21);
        add(tfCusNum);
        tfCusNum.setColumns(10);
    }
}
