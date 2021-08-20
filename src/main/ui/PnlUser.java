package ui;

import dao.DaoUser;
import vo.UserVO;

import javax.swing.*;
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
    public PnlUser() {
        setLayout(null);
        DaoUser dao = new DaoUser();

        JLabel lblNewLabel = new JLabel("\uC0AC\uC6A9\uC790 \uBAA9\uB85D");
        lblNewLabel.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
        lblNewLabel.setBounds(518, 10, 113, 37);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
        lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(63, 57, 62, 28);
        add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("ID");
        lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 17));
        lblNewLabel_2.setBounds(63, 135, 57, 15);
        add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Paswword");
        lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 17));
        lblNewLabel_3.setBounds(63, 203, 88, 15);
        add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("RePass");
        lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 17));
        lblNewLabel_4.setToolTipText("");
        lblNewLabel_4.setBounds(63, 286, 57, 15);
        add(lblNewLabel_4);

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
                dao.registUser(new UserVO(name, id, pw));
            }
        });
        btnRegi.setBounds(68, 342, 211, 23);
        add(btnRegi);

        JLabel lblNewLabel_5 = new JLabel("\uC0AC\uC6A9\uC790 \uB4F1\uB85D");
        lblNewLabel_5.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 20));
        lblNewLabel_5.setBounds(148, 10, 113, 37);
        add(lblNewLabel_5);

        tfSearch = new JTextField();
        tfSearch.setColumns(10);
        tfSearch.setBounds(515, 62, 116, 21);
        add(tfSearch);

        JButton btnSearch = new JButton("New button");
        btnSearch.setBounds(676, 61, 97, 23);
        add(btnSearch);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(344, 109, 496, 253);
        add(scrollPane);

        table = new JTable();
        scrollPane.setColumnHeaderView(table);
    }
}
