package com.example.springapi.api.controller;

import com.example.springapi.Game.baglanti;

import com.example.springapi.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class gamecontroller {
    //Altta olduğu gibi oyunda 2 fonksiyon var.Birisi maçı yapar.Diğeri oyuncu özelliğini veritabanında günceller.Geri kalan kısımlar Flutterda veritabanından direk çekilebilir.
    //maç herkes birbiriyle maçını tamamladığında bitecek.Yane 17 hafta sürecek.
    private GameService gameService;

    @Autowired
    public gamecontroller(GameService gameService){
        this.gameService=gameService;
    }

    @GetMapping("/macYap")//Maç yap butonu içinde çağrılıcak maçı yapan fonksiyon.
    public String [][] MacYap(@RequestBody String[][] AnlikTeams){
        for(int i=0;i<AnlikTeams.length;i++){
            for(int j=0;j<AnlikTeams[i].length;j++){
                System.out.println(AnlikTeams[i][j]);
            }
        }
       return gameService.Mac_Yap(AnlikTeams);
    }



    /*
    ***Örnek Maç sorgusu:
    * [

    ["Galatasaray","FenerBahçe"],
    ["Beşiktaş","TrabzonSpor"],
    ["İstanbul Başakşehir","Alanyaspor"],
    ["Göztepe","Konyaspor"],
    ["Kasımpaşa","Antalyaspor"],
    ["Gaziantep FK","Denizlispor"],
    ["Gençlerbirliği","Rizespor"],
    ["Kayserispor","Malatyaspor"],
    ["AnkaraGücü","Hayatspor"]

    ]

   Bu fonksiyonun döndürdüğü Arrey tekrar parametre olarak kendisine verilmelidir(Bir sonraki maç eşleştirmesini yapabilmesi için).


    */


    @GetMapping("/get_players")//Oyuncu tablosu döndürür.
    public String[][] get_Player_Stats(){
           return new baglanti().get_players();

    }

    @GetMapping("/get_Teams")//Takım tablosunu döndürür.
    public String[][] get_Team_Stats(){
        return new baglanti().get_teams();
    }

    @GetMapping("/get_Player_Stats")//oyuncu ismi ve oyuncunun hangi niteliğini parametre olarak vererek istenilen değeri alıyoruz.
    public String[] get_Player_stat(@RequestParam String player_name){
                return new baglanti().get_player_stats(player_name);
    }

    @GetMapping("/change_stats")// !! DİKKAT Sorgu yollanırken + işareti yerine %2B yollanmalı. - kısmı farketmıyor çünkü if else ile yapılmıştır.
    public void change_Player_stats(@RequestParam String player_Name,String arti_Eksi_1,String degisecek_stats_ismi){
       new baglanti().change_stats(player_Name,arti_Eksi_1,degisecek_stats_ismi);
       System.out.println(player_Name+" adli oyuncunun "+degisecek_stats_ismi+" özelliği "+arti_Eksi_1+"1");
    }



}
