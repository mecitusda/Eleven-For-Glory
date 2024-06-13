package com.example.springapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.example.springapi.Game.butonum.baglan;
import static com.example.springapi.SpringApiApplication.teams;

@Service
public class GameService {
public static int haftasayac=1;

    public String[][] Mac_Yap(String[][] teamsanlik) {//Buraya anlık takımlar verilecek.
        teamsanlik= baglan.team_matching(teams,teamsanlik,haftasayac++);
        return teamsanlik;
        //Burada bir değişken tutulacaktır.Bu değişken her hafta artarak hafta sayısını tutacaktır.Bu ekrana yazmak için koyulmuştur.Flutterda 17 maç oynandığında oyun biter.

    }


}
