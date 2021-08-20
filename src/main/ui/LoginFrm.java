package ui;

import controller.MainController;
import dao.DaoSet;
import dao.DaoUser;
import ui.MainFrm;
import vo.UserVO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginFrm extends BasicFrm implements ActionListener {

    private JLabel lbId, lbPw;
    private JTextField tfId;
    private JPasswordField pfPw;
    private JButton btnLogin, btnCancel, btnJoin;
    private JPanel pnlN, pnlC, pnlS;

    public LoginFrm() {
        super(300,150,"Login");
    }

    @Override
    public void init() {
        setResizable(false);
        pnlN = new JPanel();
        pnlC = new JPanel();
        pnlS = new JPanel();
        lbId = new JLabel("ID");
        lbPw = new JLabel("PW");
        lbPw.setFont(new Font("consols",Font.BOLD,20));
        lbId.setFont(new Font("consols",Font.BOLD,20));
        lbId.setBackground(Color.BLACK);
        lbPw.setBackground(Color.BLACK);
        tfId = new JTextField(10);
        pfPw = new JPasswordField(10);
        tfId.setText("ADMIN");
        pfPw.setText("1");
        btnLogin = new JButton("로그인");
        btnCancel = new JButton("취소");
        btnJoin = new JButton("가입");
        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);
        btnJoin.addActionListener(this);
    }
    @Override
    public void arrange() {
        pnlN.add(lbId);
        pnlN.add(tfId);
        pnlC.add(lbPw);
        pnlC.add(pfPw);
        pnlS.add(btnLogin);
        pnlS.add(btnCancel);
        pnlS.add(btnJoin);
        add(pnlN, BorderLayout.NORTH);
        add(pnlC, BorderLayout.CENTER);
        add(pnlS, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = tfId.getText();
        String pw = new String(pfPw.getPassword());

        if(e.getSource() == btnLogin) {
            if(id == null || id.equals("")) {
                JOptionPane.showMessageDialog(null,"ID를 입력하세요.");
                tfId.requestFocus();
                return;
            }
            if(pw == null || pw.equals("")) {
                JOptionPane.showMessageDialog(null,"PW를 입력하세요.");
                pfPw.requestFocus();
                return;
            }
            UserVO userVO = new DaoUser().checkLogin(id,pw);
            if (userVO == null){
                JOptionPane.showMessageDialog(null,"없는 아이디 입니다.");
                tfId.setText("");
                pfPw.setText("");
                tfId.requestFocus();
                return;
            }
            dispose();
            MainController.forwardControl("Main");

        } else if (e.getSource() == btnCancel) {
        } else if (e.getSource() == btnJoin) {

        }
    }

}