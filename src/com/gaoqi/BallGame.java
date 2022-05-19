package com.gaoqi;

import javax.swing.*;
import java.awt.*;

public class BallGame extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("image/ball.jpg");
    Image desk = Toolkit.getDefaultToolkit().getImage("image/catjpg.jpg");

    double x = 100;//小球的横坐标
    double y = 100;//小球的纵坐标

    double degree = 3.14/3;//弧度，此处时60度


    //画窗口的方法
    public void paint(Graphics g) {
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int)x, (int)y, null);

        x = x + 10 * Math.cos(degree);
        y = y + 10 * Math.sin(degree);

        //碰到上下边界
        if(y > 500 - 40 -30||y < 40 + 40) {//500是窗口高度，40是桌子边框，30是球直径，最后一个40是标题栏的高度
            degree = -degree;
        }

        //碰到左右边界
        if(x < 40||x > 856 - 40 - 30) {
            degree = 3.14 - degree;
        }
    }

    //窗口加载
    void launchFrame() {
        setSize(856,500);
        setLocation(50,50);
        setVisible(true);

        //重画窗口,每秒画25次
        while(true) {
            repaint();
            try {
                Thread.sleep(40);//40ms, 1m = 1000ms,大约一秒画25次窗口
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

    }


    //main方法是程序执行的入口
    public static void main(String[] args) {
        BallGame game = new BallGame();
        game.launchFrame();
    }
}

