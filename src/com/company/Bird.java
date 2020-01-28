package com.company;

import java.awt.*;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Bird {

    public static int num = 0;
    public Bird() {
        System.out.println("Я птица");
        num++;
        System.out.println(x);
        System.out.println(y);
        System.out.println(size);
    }

    public void Fly()
    {
        System.out.println("Я могу летать");
    }
    public String vid;
    protected Calendar cal1 = new GregorianCalendar();
    protected Date date = new Date();
    SimpleDateFormat format1;
    protected int a = 0;
    protected int b = 900;
    //при бОльших значениях b иногда перестают отображаться птицы, так как x+size или y+size выходят за пределы рабочей области, нужно прописать условие зависимости и проверки на правильность генерации птицы
    //(Т.Е. связь size с x и y)
    protected int x = a+ (int)(Math.random()*b);
    protected int y = a+ (int)(Math.random()*(b));
    public int size = 70;
    public Color color = Color.BLUE;
    public void Numb()
    {
        System.out.println(num);
    }

    public void draw(Graphics g)
    {
        //код для самой "птицы"
        g.setColor(color);
        g.fillOval(x,y,size,size);

        // код для рамки вокруг каждой птицы
        //g.setColor(Color.BLACK);
        //g.drawRect(x,y,size,size);
    }
    public void time() {
        format1 = new SimpleDateFormat("HH:mm");
        System.out.println(format1.format(date));
        int hour = cal1.get(Calendar.HOUR_OF_DAY);
        if(hour>6 && hour <10){System.out.println("Утро");}
        else if(hour >=10 && hour <=16){System.out.println("День");}
        else if(hour >16 && hour <=23){System.out.println("Вечер");}
        else if(hour <23 && hour <=6){System.out.println("Ночь");}
    }


}
