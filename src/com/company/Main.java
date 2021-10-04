package com.company;
import java.util.Scanner;
import java.util.TreeSet;

class terretory { //пробуем ответвления12
    double space;
    String nameofspace;
    int people;
    static int art=1;
    int idterretory;
    terretory(String a,double b,int s){
        this.nameofspace=a;
        this.space=b;
        this.people=s;
    }
    void print(){
        idterretory=art++;
        System.out.println("На данный момент созданно территорий "+idterretory);
        System.out.println("Численность населения составляет - "+people);
        System.out.println("Плотность населения проживающего на территории площадью "+space+" составляет "+people/space);

    }

}
class City extends terretory implements Comparable<City>{
    int hs;
    String namesize;
    City(String nameofspace,double space,int people){
        super(nameofspace,space,people);
        int q=people/50000;
        if (q>=1){
            hs=q;
        }
        if (people<50000){
            namesize="малым городам";
        }
        else if(people<100000 ){
            namesize="средним городам";
        }
        else if(people<250000 ){
            namesize="большим городам";
        }
        else if(people<1000000 ){
            namesize="крупным городам";
        }
        else if(people<3000000 ){
            namesize="крупнейшим городам";
        }
        else {
            namesize="сверхкрупным городам";
        }
    }
    void print(){
        super.print();
        System.out.println("Эта территория относится к "+namesize);
        if (hs!=0){
            if (hs>0 && hs<5)
                System.out.println("В данном городе есть "+hs+" вуза");
            else
                System.out.println("В данном городе есть "+hs+" вузов");
        }
        System.out.println();
    }
    String getName(){return nameofspace;}
    public int compareTo(City a){

        return nameofspace.compareTo(a.getName());
    }
}
class Selo extends terretory{
    String namesize;

    Selo(String nameofspace,double space,int people){
        super(nameofspace,space,people);
        if(people<200){
            namesize="малым сельским поселеним";
        }
        else if(people<1000 ){
            namesize="средним сельским поселеним";
        }
        else if(people<5000 ){
            namesize="большим сельским поселеним";
        }
        else {
            namesize="крупным сельским поселеним";
        }
    }

    void print(){
        super.print();
        System.out.println("Эта территория относится к "+namesize);
        System.out.println();

    }

}


public class Main {


    public static void main(String[] args) {

        TreeSet<City> test=new TreeSet<City>();

        terretory a=new terretory("Москва",123.4,209);
        a.print();
        terretory b=new terretory("Москва",123.4,209);
        b.print();
        City nam=new City("Senct",124500,12300000);
        City nam1=new City("Moscow",124500,12300000);
        City nam3=new City("Orenburg",124500,12300000);
        nam.print();
        Selo av=new Selo("orenburg", 284,145);
        av.print();
        test.add(nam);
        test.add(nam1);
        test.add(nam3);
        for(City h:test){
            System.out.println(h);
        }
    }
}