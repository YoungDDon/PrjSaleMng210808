package ui;

import javax.swing.*;
import java.awt.*;

public abstract class BasicFrm extends JFrame{
    private int width, height;

    public BasicFrm(int width, int height, String title) {
        super(title);
        this.width = width;
        this.height = height;
        //아래 세 줄은 각각의 메서드 호출하는거임 ㅇㅇ
        init();//초기화
        arrange();//배치
        inflate();
    }
    public abstract void init();
    public abstract void arrange();
    public void inflate(){
        //        super(); //(항상 첫번째 줄에 가 있어야함) 조상기본생성자가 생략되어있음
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫고 프로그램을 종료합니다. 따로선언해줘야함
        setSize(width, height); //프로그램의 사이즈 가로세로를 설정함
//        setBounds(100, 100,500,300); // 프로그램 뜨는위치 x,y 좌표와 ,width, height를 한번에 설정함 이거로하면 size따로 줄필요없음
        setLocationRelativeTo(this); //창이 가운데 뜨게끔 함
        setVisible(true); //true로 해줘야함
    }
}