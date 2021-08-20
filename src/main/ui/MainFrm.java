package ui;

import controller.MainController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrm extends BasicFrm {
    private JPanel pnlNorth, pnlCenter;
    private CardLayout cardLayout;
    private String[] menus;
    private JLabel[] lbArr;
    private ImageIcon[] icons;
    private JPanel[] pnls;

    public MainFrm() {
        super(900, 600, "님 환영합니다.");
        String msg = MainController.getInstance().getSession().getUserName() + "님 환영합니다.";
        setTitle(msg);
    }

    @Override
    public void init() {
        menus = new String[] {"sale","report","product","customer","user"};
//        Color[] colors = {Color.red,Color.ORANGE,Color.yellow,Color.green,Color.blue};
        lbArr= new JLabel[5];
        icons = new ImageIcon[5];
        pnls = new JPanel[]{new PnlSale(), new PnlReport(), new PnlProduct(), new PnlCustomer(), new PnlUser()};
        pnlNorth = new JPanel();
        cardLayout = new CardLayout(10,10);
        pnlCenter = new JPanel(cardLayout);
        pnlNorth.setBackground(Color.white);
        pnlNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlCenter.setBackground(Color.pink); //생략가능 코드

        for (int i = 0; i < lbArr.length; i++) {
            icons[i] = new ImageIcon("images/"+menus[i]+".png");
            icons[i] = resizeImg(icons[i]);
            lbArr[i] = new JLabel(icons[i]);
            pnlNorth.add(lbArr[i]);
            pnlCenter.add(menus[i],pnls[i]);
//            pnls[i].setBackground(colors[i]);
            final int tmp = i;
            lbArr[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    cardLayout.show(pnlCenter,menus[tmp]);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    lbArr[tmp].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            });
        }
    }

    @Override
    public void arrange() {
        add(pnlNorth,"North");
        add(pnlCenter,"Center");
    }
    private ImageIcon resizeImg(ImageIcon img){
        int imgW = img.getIconWidth();
        int imgH = img.getIconHeight();
        int dynamicH = imgH*230/imgW;
        Image image = img.getImage();
        Image newImg = image.getScaledInstance(230, dynamicH,
                java.awt.Image.SCALE_SMOOTH);
        return img = new ImageIcon(newImg);
    }
    public static void main(String[] args) {
        new MainFrm();
    }
}