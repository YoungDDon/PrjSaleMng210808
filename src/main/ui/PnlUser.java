package ui;

import dao.DaoUser;
import vo.UserVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PnlUser extends JPanel {
    private JTextField tfName;
    private JTextField tfId;
    private JPasswordField tfPw;
    private JPasswordField rePw;
    private JTextField tfSearch;
    private JTable table;
    private  DefaultTableModel model;

    public PnlUser() {
        setLayout(null);
        DaoUser dao = new DaoUser();
//        USER_NAME           VARCHAR2(100)
//        PASSWORD            VARCHAR2(4000)
//        CREATED_ON          DATE
//        QUOTA               NUMBER
//        PRODUCTS            CHAR(1)
//        EXPIRES_ON          DATE
//        ADMIN_USER          CHAR(1)
//        ID                  VARCHAR2(20)
        model = new DefaultTableModel(new String[]{"USER_ID","ID","이름","입사일","QUOTA","상품유무",
                "퇴사일","관리자 여부"}, 0);

        JLabel lbUserList = new JLabel("\uC0AC\uC6A9\uC790 \uBAA9\uB85D");
        lbUserList.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
        lbUserList.setBounds(300, 25, 113, 37);
        add(lbUserList);

        JLabel lbName= new JLabel("\uC774\uB984");
        lbName.setFont(new Font("굴림", Font.PLAIN, 17));
        lbName.setBounds(63, 57, 62, 28);
        add(lbName);

        JLabel lbId = new JLabel("ID");
        lbId.setFont(new Font("굴림", Font.PLAIN, 17));
        lbId.setBounds(63, 135, 57, 15);
        add(lbId);

        JLabel lbPw = new JLabel("Paswword");
        lbPw.setFont(new Font("굴림", Font.PLAIN, 17));
        lbPw.setBounds(63, 203, 88, 15);
        add(lbPw);

        JLabel rePassW = new JLabel("RePass");
        rePassW.setFont(new Font("굴림", Font.PLAIN, 17));
        rePassW.setToolTipText("");
        rePassW.setBounds(63, 286, 57, 15);
        add(rePassW);

        tfName = new JTextField();
        tfName.setBounds(163, 61, 116, 21);
        add(tfName);
        tfName.setColumns(10);

        tfId = new JTextField();
        tfId.setBounds(163, 133, 116, 21);
        add(tfId);
        tfId.setColumns(10);

        tfPw = new JPasswordField();
        tfPw.setBounds(163, 200, 116, 21);
        add(tfPw);
        tfPw.setColumns(10);

        rePw = new JPasswordField();
        rePw.setBounds(163, 283, 116, 21);
        add(rePw);
        rePw.setColumns(10);

        JButton btnRegi = new JButton("\uB4F1\uB85D");
        btnRegi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = tfId.getText();
                String name = tfName.getText();
                String pw = new String(tfPw.getText());
                String rePass = new String(rePw.getText());

                if(name.equals("")) {

                    return;
                }
                if(id.equals("")) return;
                if(pw.equals("")) return;
                if(rePw.equals("")) return;
                if(!pw.equals(rePass)) return;
                dao.registUser(new UserVO(name, id, pw));}
        });
        btnRegi.setBounds(68, 342, 211, 23);
        add(btnRegi);

        JLabel lbUserRegi = new JLabel("\uC0AC\uC6A9\uC790 \uB4F1\uB85D");
        lbUserRegi.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
        lbUserRegi.setBounds(148, 10, 120, 37);
        add(lbUserRegi);

        tfSearch = new JTextField();
        tfSearch.setColumns(10);
        tfSearch.setBounds(300, 62, 140, 21);
        add(tfSearch);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(505, 61, 130, 23);
        add(btnSearch);


        table = new JTable(new DefaultTableModel());
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(300, 109, 550, 253);
        add(scrollPane);


        btnSearch.addActionListener(e -> {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            while(table.getRowCount() > 0) {
                model.removeRow(0);
            }
            String srch = tfSearch.getText();
            model = dao.getUserList(model, srch);
            table.setModel(model);
            model.fireTableDataChanged();
        });
    }
}
