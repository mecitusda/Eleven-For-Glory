package com.example.springapi;

import com.example.springapi.Game.Team;
import com.example.springapi.Game.baglanti;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.LinkedList;

@SpringBootApplication
public class SpringApiApplication {

    public static ArrayList<String> teams=new ArrayList<>(18);
    static LinkedList<Team> mathupteams=new LinkedList<>();
    static ArrayList<Team>sirala=new ArrayList<>(18);
    public static boolean do_match=false;
    public static String[] team_Names={"Galatasaray","FenerBahçe","Beşiktaş","TrabzonSpor","İstanbul Başakşehir",
            "Alanyaspor","Göztepe","Konyaspor","Kasımpaşa","Antalyaspor","Gaziantep FK","Denizlispor","Gençlerbirliği","Rizespor","Kayserispor","Malatyaspor","AnkaraGücü","Hayatspor"};
    static String[] countrys={"turkey","turkey","turkey","turkey","turkey","turkey","turkey","turkey","turkey","turkey","turkey","turkey","turkey","turkey","turkey","turkey","turkey","turkey"};
    static int[] foundunations={1905,1907,1903,1967,1990,1948,1925,1922,1921,1966,1988,1966,1923,1953,1966,1966,1910,1967};
    static String[] coachs={"Fatih Terim","Erol Bulut","Sergen Yalçın","Abdullah Avcı","Aykut Kocaman","Serdar Akın","Ünal Karaman","Bülent Korkmaz","Hikmet Karaman","Ersun Yanal","Ricardo Sá Pinto","Hakan Kutlu","Ferhat Öztorun","Stjepan Tomas","Robert Prosinecki","Hamza Hamzaoğlu","Mustafa Reşit Akçay","Ömer Erdoğan"};
    public static void prepare_team(){//takımları oluşturup içerisine oyuncuları atıyorum.
        new baglanti().create_Team(team_Names,countrys,foundunations,coachs);
        new baglanti().create_Player();
        new baglanti().add_stats();
        new baglanti().change_stats("Arda Turan","+","balance");
        //  new baglanti().get_futbolcu_stats("Arda Turan");//Oyuncular oluştu.

        for (int i=0;i<18;i++)
            teams.add(team_Names[i]);




    }


    public static void main(String[] args) {
        prepare_team();
        SpringApplication.run(SpringApiApplication.class, args);

    }

}

