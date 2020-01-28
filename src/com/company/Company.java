package com.company;

import java.awt.*;
import javax.crypto.Mac;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    private int count = 0;
    private ArrayList<Bird> birds;
    private int Mcount=-1; // реализация костыля для динамического определения размера птицы
    private int Pcount=-1;
    private int Scount=-1;

    private int PMinX=9999; // буферные хранилища координат, нужно для поиска углов рамки (ПИНГВИН)
    private int PMinY=9999;
    private int PMaxX=0;
    private int PMaxY=0;

    private int MMinX=9999; // ПОПУГАЙ
    private int MMinY=9999;
    private int MMaxX=0;
    private int MMaxY=0;

    private int SMinX=9999; // ВОРОБЕЙ
    private int SMinY=9999;
    private int SMaxX=0;
    private int SMaxY=0;

    private String type;
    private boolean i = true;
    Scanner x = new Scanner(System.in);
    private String names[] = {"Петя","Гоша","Кеша"};

    public Company()
    {
        birds = new ArrayList<>();
        System.out.println("Кого вы хотите добавить?");
        while (i == true)
        {
            System.out.println(type = x.nextLine());
//            type = x.nextLine();
            switch (type)
            {
                case "пингвина":
                    birds.add(new Penguin());
                    count++;
                    break;
                case "попугая":
                    birds.add(new Macaw());
                    count++;
                    break;
                case "воробья":
                    birds.add(new Sparrow());
                    count++;
                    break;
                default:
                    i = false;
                    break;
            }
        }
    }
    public void Count()
    {
        System.out.println("Всего " + count + " птиц");
    }
    public void Fly(){
        for(int i = 0; i < birds.size(); i++)
        {
            int j = i + 1;
            System.out.println("Птица " + j + " взлетела");
//            if (type == "пингвина")
//            {
//                System.out.println("пингвин " + j + " не взлетел");
//            }
//            else { System.out.println("попугай " + j + " Взлетел");}

        }
    }
    public void Names()
    {
        int a = 0;
        int b = birds.size();

        for(int i = 0; i < birds.size(); i++)
        {
            int j = i+1;
            int random = a + (int) (Math.random() * b);
            System.out.println("Птицу "+ j +" зовут " + names[random]);

        }
    }
    public void draw(Graphics g) {
        for (int i = 0; i < birds.size(); i++) {

            System.out.println("итерация: " + i); // строка отладки

            birds.get(i).draw(g); // отрисовка i-ой птицы


            // поиск минимальных и максимальных координат для рамок

            type = birds.get(i).vid; // считываем вид i-ой птицы

            System.out.println("Вид птицы: " + type); // строка отладки

            if (type=="Пингвин") {
                Pcount = i; // реализация динамического выбора цвета и размера, а также проверка на наличие такого вида птиц

                System.out.println("Пингвин Pcount: " + Pcount); // строка отладки

                if (birds.get(i).x < PMinX) { // поиск размеров
                    PMinX = birds.get(i).x;
                }
                if (birds.get(i).x > PMaxX) {
                    PMaxX = birds.get(i).x;
                }
                if (birds.get(i).y < PMinY) {
                    PMinY = birds.get(i).y;
                }
                if (birds.get(i).y > PMaxY) {
                    PMaxY = birds.get(i).y;
                }
            }
            if (type == "Воробей") {
                Scount = i;
                System.out.println("Воробей Scount: " + Scount);
                if (birds.get(i).x < SMinX) {
                    SMinX = birds.get(i).x;
                }
                if (birds.get(i).x > SMaxX) {
                    SMaxX = birds.get(i).x;
                }
                if (birds.get(i).y < SMinY) {
                    SMinY = birds.get(i).y;
                }
                if (birds.get(i).y > SMaxY) {
                    SMaxY = birds.get(i).y;
                }
            }
            if (type=="Попугай") {
                Mcount = i;
                System.out.println("Попугай Mcount: " + Mcount);
                if (birds.get(i).x < MMinX) {
                    MMinX = birds.get(i).x;
                }
                if (birds.get(i).x > MMaxX) {
                    MMaxX = birds.get(i).x;
                }
                if (birds.get(i).y < MMinY) {
                    MMinY = birds.get(i).y;
                }
                if (birds.get(i).y > MMaxY) {
                    MMaxY = birds.get(i).y;
                }
            }
        }

        // реализация больших рамок:

        if(Mcount>-1) { //проверка, есть ли такие птицы вообще
            g.setColor(birds.get(Mcount).color); // выбор цвета
            g.drawRect(MMinX, MMinY, MMaxX - MMinX + birds.get(Mcount).size, MMaxY - MMinY + birds.get(Mcount).size); // сама рамка


            System.out.println("Попугай: "); // данные отладки
            System.out.println(Mcount);
            System.out.println("Начало X: " + (MMinX) + "Начало Y: " + (MMinY));
            System.out.println("Ширина: "+ (MMaxX-MMinX+birds.get(Mcount).size)+ "Высота: " + (MMaxY-MMinY+ birds.get(Mcount).size));

        }

        if(Scount>-1) {
            g.setColor(birds.get(Scount).color);
            g.drawRect(SMinX, SMinY, SMaxX-SMinX+birds.get(Scount).size,SMaxY-SMinY+ birds.get(Scount).size);


            System.out.println("Воробей: ");
            System.out.println(Scount);
            System.out.println("Начало X: " + (SMinX) + "Начало Y: " + (SMinY));
            System.out.println("Ширина: "+ (SMaxX-SMinX+birds.get(Scount).size)+ "Высота: " + (SMaxY-SMinY+ birds.get(Scount).size));

        }

        if(Pcount>-1) {
            g.setColor(birds.get(Pcount).color);
            g.drawRect(PMinX, PMinY, PMaxX-PMinX+birds.get(Pcount).size,PMaxY-PMinY+ birds.get(Pcount).size);


            System.out.println("Пингвин: ");
            System.out.println(Pcount);
            System.out.println("Начало X: " + (PMinX) + "Начало Y: " + (PMinY));
            System.out.println("Ширина: "+ (PMaxX-PMinX+birds.get(Pcount).size)+ "Высота: " + (PMaxY-PMinY+ birds.get(Pcount).size));
        }
    }

}
