package com.company;

import java.awt.*;

public class Penguin extends Bird {
    public Penguin()
    {
        System.out.println("Я пингвин");
        vid = "Пингвин";
        num++;
        this.time();
        this.color = Color.BLACK; //черный цвет
        this.size = 60;
    }
    @Override
    public void Fly()
    {
        System.out.println("Я не могу летать");
    }
    public void draw (Graphics g)
    {
        g.setColor(color);
        g.fillOval(this.x,this.y,this.size,this.size);
        g.setColor(new Color(255,255,255));
        g.fillOval(this.x+5, this.y+6,this.size/2,this.size/2);
        g.setColor(color);

        //специфика пингвина: из за дополнительного круга внутри, нужно отдельно выводить рамку (устарело)
        //g.setColor(color);
        //g.drawRect(this.x,this.y,this.size,this.size);

    }

}
