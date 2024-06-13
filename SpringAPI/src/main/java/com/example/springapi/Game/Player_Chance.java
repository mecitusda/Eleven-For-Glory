package com.example.springapi.Game;

import java.util.Random;

public class Player_Chance {

    private static int esikdeger=1;
    private static int chance;
    private static Random random=new Random();

    public static int high_Chance(){
        while (true) {
            chance=new Random().nextInt(20);

            if(chance>14&&chance<=20) {
                return chance;
            }
        }
    }
    public static int normal_Chance(){
        while (true){
            chance=new Random().nextInt(20);

            if(chance>10&&chance<=14)
                return chance;
        }
    }

    public static int low_Chance(){
        while(true){
            chance=new Random().nextInt(20);

            if(chance>0&&chance<=10)
                return chance;

        }
    }
    //
    //  Algoritma
//
    public static int goal_Chance(int attacker_strength,int defender_strength){
        int gol=0;


        int numberof_attack=random.nextInt(20);//kaç kez saldırıcağımızı buluyoruz.

        double attacker_Goal_rate=attacker_strength/defender_strength;//gol oranı hesaplıyoruz
        for(int i=0;i<numberof_attack;i++) {//saldırı sayısı kadar saldırıyor.
            double attacker_Goal_Chance=random.nextDouble(1+attacker_Goal_rate); // 1 ile 1+oran

            if(attacker_Goal_Chance>1&&attacker_Goal_Chance<(i+attacker_Goal_rate)){
                //gol attı.
                //gol yedi.
                gol++;
            }

        }
        return gol;
    }
    //
    //
    //
}
