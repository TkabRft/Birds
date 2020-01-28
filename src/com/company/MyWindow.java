package com.company;
import javax.swing.*;
import java.awt.*;
public class MyWindow extends JFrame {
    private Company f;
    public MyWindow()
    {
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public MyWindow(Company f)
    {
        this();
        this.f = f;
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.translate(getWidth()/2,getHeight()/2); // Смещение точки начала координат

        // g.setColor(new Color(0,0,0));
        g.drawLine(-getWidth()/2, 0 ,getWidth()/2, 0);
        // g.setColor(new Color(0,0,0));
        g.drawLine(0,-getHeight()/2,0,getHeight()/2);
        // g.translate(-getWidth()/2,-getHeight()/2);

        g.translate(-getWidth()/2,-getHeight()/2); // Возврат точки начала координат в исходное значение (нужно для положительных значений генерирующихся координат "птиц" и их отображения на экране)
        f.draw(g);

    }

}
