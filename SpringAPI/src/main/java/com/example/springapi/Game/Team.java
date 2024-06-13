package com.example.springapi.Game;

import java.util.ArrayList;

public class Team {
    private ArrayList<GoalKeeper> goalKeepers=new ArrayList(3);
    ArrayList<Team> oynanmayan_Takimlar = new ArrayList(5);

    private int goal_Count=0;//gol sayısı.
    private int played_Count=0;//oynanan maç sayısı.
    private int draws_Count=0;//beraberlik.
    private int win_Count=0;//kazanılan maç.
    private int lose_Count=0;//kaybedilen.
    private int goal_agains=0;//yenilen gol sayısı.
    private int av=0;//averaj.
    private int Point=0;//puan.

    private ArrayList<Attacker> attackers=new ArrayList(6);//hücumcular.
    private ArrayList<Midfielder> midfielders=new ArrayList(6);//orta saha.

    public String getTeam_Name() {
        return team_Name;
    }

    private ArrayList<Defender> defenders=new ArrayList(10);//defans.

    private ArrayList<Player> players=new ArrayList(25);//oyuncular.

    private ArrayList<Team> deplasmanda_oynananlar=new ArrayList();//deplasmanda oynananları tutan arraylist.

    private ArrayList<Team> evde_oynananlar=new ArrayList();//evde oynananları tutan arraylist.
    private String team_Name;
    private double average_Goalkeeper_Strength;//takımın ortalama güçleri
    private double average_Defender_Strength;
    private double average_Midfielder_Strength;
    private double average_Attacker_Strength;
    private double team_average_Strength;
    private double Supperter_Strength=(team_average_Strength)%11;//ev sahibi gücü ev sahibine maç sırasında ekleniyor.
    public Team(String team_Name){
        this.team_Name=team_Name;
        calculate();//takıma futbolcular eklendikten sonra takımın güclerini hesaplıyor

    }
    public void calculate(){
        calculate_Attacker_Strength();
        calculate_average_Strength();
        calculate_Defender_Strength();
        calculate_Midfielder_Strength();
        calculate_GoalKeeper_Strength();
    }
    public void calculate_GoalKeeper_Strength(){
        double toplam=0;
        for(GoalKeeper temp:goalKeepers){
            toplam+=temp.getGoalKeeper_Strength();
        }
        average_Goalkeeper_Strength=toplam/3;
    }

    public void calculate_Attacker_Strength(){
        double toplam=0;
        for(Attacker temp:attackers){
            toplam+=temp.getOffensive_Strength();
        }
        average_Attacker_Strength=toplam/6;
    }

    public void calculate_Defender_Strength(){
        double toplam=0;
        for(Defender temp:defenders){
            toplam+=temp.getDefensive_Strength();
        }
        average_Defender_Strength=toplam/10;
    }

    public void calculate_Midfielder_Strength(){
        double toplam=0;
        for(Midfielder temp:midfielders){
            toplam+=temp.getMidfielder_Strength();
        }
        average_Midfielder_Strength=toplam/6;
    }

    public void calculate_average_Strength(){
        team_average_Strength=(average_Attacker_Strength+average_Goalkeeper_Strength+average_Midfielder_Strength+average_Defender_Strength)/4;
    }


    public void setGoalKeepers(GoalKeeper goalKeeper) {
        goalKeepers.add(goalKeeper);
    }



    public void setAttackers(Attacker attacker) {
        attackers.add(attacker);
    }



    public void setMidfielders(Midfielder midfielder) {
        midfielders.add(midfielder);
    }



    public void setDefenders(Defender defender) {
        defenders.add(defender);
    }



    public double getAverage_Goalkeeper_Strength() {
        return average_Goalkeeper_Strength;
    }



    public double getAverage_Defender_Strength() {
        return average_Defender_Strength;
    }



    public double getAverage_Midfielder_Strength() {
        return average_Midfielder_Strength;
    }



    public double getAverage_Attacker_Strength() {
        return average_Attacker_Strength;
    }



    public double getTeam_average_Strength() {
        return team_average_Strength;
    }
    public void add_Supperter_Strength(){
        team_average_Strength+=Supperter_Strength;
    }
    public void remove_Supperter_Strength(){
        team_average_Strength-=Supperter_Strength;
    }




    public int getGoal_Count() {
        return goal_Count;
    }

    public void setGoal_Count(int count) {//gol sayısını arttırıyor ve averajı güncelliyor
        this.goal_Count += count;
        av=this.goal_Count-goal_agains;
    }

    public int getPlayed_Count() {
        return played_Count;
    }

    public void setPlayed_Count(int played_Count) {
        this.played_Count += played_Count;
    }//gol sayısını takıma ekliyor.

    public int getDraws_Count() {
        return draws_Count;
    }

    public void setDraws_Count(int draws_Count) {
        this.draws_Count += draws_Count;// berabere kalma sayısını düzenliyor.
        this.Point+=1;
    }

    public int getWin_Count() {

        return this.win_Count;
    }

    public void setWin_Count(int win_Count) {

        this.win_Count += win_Count;//galibiyet sayısını düzenliyor.
        this.Point+=3;
    }

    public int getLose_Count() {
        return lose_Count;
    }

    public void setLose_Count(int lose_Count) {
        this.lose_Count += lose_Count;//mağlubiyet sayısını düzenliyor
    }

    public int getGoal_agains() {
        return goal_agains;
    }

    public void setGoal_agains(int gol) {

        this.goal_agains += gol;
        av=goal_Count-this.goal_agains;//gol sayısını düzenliyor.
    }

    public int getAv() {
        return av;
    }

    public void setAv(int av) {
        this.av = av;
    }

    public int getPoint() {

        return Point;
    }


    public void addOynanmayan_Takimlar(Team takim) {
        this.oynanmayan_Takimlar.add(takim);//oynanmayanlar arraylist'e takım ekliyor.
    }


    public ArrayList<Team> getDeplasmanda_oynananlar() {
        return deplasmanda_oynananlar;
    }

    public void addDeplasmanda_oynananlar(Team team) {
        this.deplasmanda_oynananlar.add(team);//deplasmanda oynananları Arraylist'e ekliyor.
    }

    public ArrayList<Team> getEvde_oynanlar() {
        return evde_oynananlar;
    }

    public void addEvde_oynananlar(Team team) {
        this.evde_oynananlar.add(team);
    }



}
