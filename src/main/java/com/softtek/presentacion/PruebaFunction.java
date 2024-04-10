package com.softtek.presentacion;

import com.softtek.modelo.Stats;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

public class PruebaFunction {


    public void metodo1(){
        Function<ArrayList<Integer>,ArrayList<Integer>> fx = x -> {
            ArrayList<Integer> res= new ArrayList<>();
            for (int i = 0; i < x.size(); i++) {
                if(x.get(i)%2==0&&x.get(i)!=0){
                    res.add(x.get(i));
                }
            }
            return res;
        };
        ArrayList<Integer> num= new ArrayList<>();
        num.add(1);
        num.add(2);
        num.add(0);
        num.add(4);
        ArrayList<Integer> rpta = fx.apply(num);
        System.out.println(rpta);
    }

    public void metodo2(){
        Function<ArrayList<Integer>, Stats> fx = x ->{
            int min=0;
            int max=0;
            double media=0;
            for (int i = 0; i < x.size(); i++) {
                if(i==0||x.get(i)<min){
                    min=x.get(i);
                }
                if(i==0||x.get(i)>max){
                    max=x.get(i);
                }
                media+=x.get(i);
            }
            return new Stats(min,max,media/x.size());
        };

        ArrayList<Integer> num= new ArrayList<>();
        num.add(1);
        num.add(2);
        num.add(3);
        num.add(4);
        Stats rpta = fx.apply(num);
        System.out.println(rpta);
    }

    public void metodo3() {
        Function<String, Boolean> lon = x -> x.length()>8;
        Function<String, Boolean> mayus = x -> x.chars().anyMatch(Character::isUpperCase);
        Function<String, Boolean> minus = x -> x.chars().anyMatch(Character::isLowerCase);
        Function<String, Boolean> num = x -> x.chars().anyMatch(Character::isDigit);
        Function<String, Boolean> especial = x -> x.chars().anyMatch(c -> "ºª!$%&/()=?¿^*Ç¨_:;-.,´ç+`¡'|@#[]{}<>".indexOf(c)!=-1);
        String prueba = "Buenas123@";
        boolean res=lon.apply(prueba)&&mayus.apply(prueba)&&minus.apply(prueba)&&num.apply(prueba)&&especial.apply(prueba);
        System.out.println(res);
    }


    public static void main(String[] args) {
        PruebaFunction p =new PruebaFunction();
        p.metodo1();
        p.metodo2();
        p.metodo3();
    }
}

