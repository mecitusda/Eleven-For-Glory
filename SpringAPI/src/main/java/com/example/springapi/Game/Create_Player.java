package com.example.springapi.Game;


import java.util.Random;

public  class Create_Player {


    //şans yelpazesinin genişlemesi için şansları biraz daha genişletiyorum
    public static int HighChance(){
        Random random=new Random();
        int sans=random.nextInt(100);///
        if(sans>55&&sans<61){//güçlü yetenek.

            return new Player_Chance().high_Chance();
        }
        else if(sans>10&&sans<16){
            return new Player_Chance().low_Chance();
        }
        else{//orta yetenek
            return new Player_Chance().normal_Chance();
        }
    }

    public static int normal_or_lowChance(){//şans yelpazesinin genişlemesi için şansları biraz daha genişletiyorum
        Random random=new Random();
        int sans=random.nextInt(100);

        if(sans>20&&sans<41){//normal yetenek
            return new Player_Chance().normal_Chance();
        }
        else if(sans==70){
            return new Player_Chance().high_Chance();
        }
        else{//düşük yetenek
            return new Player_Chance().low_Chance();
        }

    }


    public static GoalKeeper Create(GoalKeeper player){
        player.technical_Features.setFree_Kick_Taking(normal_or_lowChance());
        player.technical_Features.setPenalty_taking(normal_or_lowChance());
        player.technical_Features.setTechnique(normal_or_lowChance());
        //Mental
        player.mental_Features.setAggression(normal_or_lowChance());
        player.mental_Features.setAnticipation(HighChance());
        player.mental_Features.setBravery(normal_or_lowChance());
        player.mental_Features.setComposure(normal_or_lowChance());
        player.mental_Features.setConcentration(normal_or_lowChance());
        player.mental_Features.setDecisions(HighChance());
        player.mental_Features.setDetermination(normal_or_lowChance());
        player.mental_Features.setFlair(HighChance());
        player.mental_Features.setLeadership(normal_or_lowChance());
        player.mental_Features.setOff_The_Ball(normal_or_lowChance());
        player.mental_Features.setPositioning(HighChance());
        player.mental_Features.setTeamwork(normal_or_lowChance());
        player.mental_Features.setVision(normal_or_lowChance());
        player.mental_Features.setWork_Rate(normal_or_lowChance());
        //Physical
        player.physical_Features.setAcceleration(normal_or_lowChance());
        player.physical_Features.setAgility(HighChance());
        player.physical_Features.setBalance(HighChance());
        player.physical_Features.setJumping_Reach(HighChance());
        player.physical_Features.setNatural_Fitness(normal_or_lowChance());
        player.physical_Features.setPace(normal_or_lowChance());
        player.physical_Features.setStamina(normal_or_lowChance());
        player.physical_Features.setStrength(HighChance());
        //GoalKeeping
        player.goal_Keeping.setAerial_Reach(HighChance());
        player.goal_Keeping.setCommand_Of_Area(HighChance());
        player.goal_Keeping.setCommunication(normal_or_lowChance());
        player.goal_Keeping.setEccentricity(normal_or_lowChance());
        player.goal_Keeping.setFirst_Touch(normal_or_lowChance());
        player.goal_Keeping.setHandling(normal_or_lowChance());
        player.goal_Keeping.setKicking(normal_or_lowChance());
        player.goal_Keeping.setOne_On_Ones(HighChance());
        player.goal_Keeping.setPassing(normal_or_lowChance());
        player.goal_Keeping.setPunching(normal_or_lowChance());
        player.goal_Keeping.setReflexes(HighChance());
        player.goal_Keeping.setRushing_Out(normal_or_lowChance());
        player.goal_Keeping.setThrowing(normal_or_lowChance());
        player.calculate();
        return player;


    }
    public static Midfielder Create(Midfielder player){

        //Technical
        player.technical_Features.setCorners(normal_or_lowChance());
        player.technical_Features.setCrossing(normal_or_lowChance());
        player.technical_Features.setDribbling(normal_or_lowChance());
        player.technical_Features.setFinishing(normal_or_lowChance());
        player.technical_Features.setFirst_Touch(HighChance());
        player.technical_Features.setFree_Kick_Taking(normal_or_lowChance());
        player.technical_Features.setHeading(HighChance());
        player.technical_Features.setLong_Shots(normal_or_lowChance());
        player.technical_Features.setLong_Throws(normal_or_lowChance());
        player.technical_Features.setMarking(normal_or_lowChance());
        player.technical_Features.setPassing(HighChance());
        player.technical_Features.setPenalty_taking(normal_or_lowChance());
        player.technical_Features.setTackling(normal_or_lowChance());
        player.technical_Features.setTechnique(HighChance());
        //Mental
        player.mental_Features.setAggression(normal_or_lowChance());
        player.mental_Features.setAnticipation(normal_or_lowChance());
        player.mental_Features.setBravery(normal_or_lowChance());
        player.mental_Features.setComposure(HighChance());
        player.mental_Features.setConcentration(normal_or_lowChance());
        player.mental_Features.setDecisions(normal_or_lowChance());
        player.mental_Features.setDetermination(normal_or_lowChance());
        player.mental_Features.setFlair(normal_or_lowChance());
        player.mental_Features.setLeadership(HighChance());
        player.mental_Features.setOff_The_Ball(HighChance());
        player.mental_Features.setPositioning(normal_or_lowChance());
        player.mental_Features.setTeamwork(HighChance());
        player.mental_Features.setVision(normal_or_lowChance());
        player.mental_Features.setWork_Rate(normal_or_lowChance());
        //Physical
        player.physical_Features.setAcceleration(normal_or_lowChance());
        player.physical_Features.setAgility(HighChance());
        player.physical_Features.setBalance(HighChance());
        player.physical_Features.setJumping_Reach(normal_or_lowChance());
        player.physical_Features.setNatural_Fitness(HighChance());
        player.physical_Features.setPace(HighChance());
        player.physical_Features.setStamina(normal_or_lowChance());
        player.physical_Features.setStrength(normal_or_lowChance());
        player.calculate();
        return player;

    }


    public static  Attacker Create(Attacker player){

        //Technical
        player.technical_Features.setCorners(normal_or_lowChance());
        player.technical_Features.setCrossing(normal_or_lowChance());
        player.technical_Features.setDribbling(HighChance());
        player.technical_Features.setFinishing(normal_or_lowChance());
        player.technical_Features.setFirst_Touch(HighChance());
        player.technical_Features.setFree_Kick_Taking(normal_or_lowChance());
        player.technical_Features.setHeading(normal_or_lowChance());
        player.technical_Features.setLong_Shots(normal_or_lowChance());
        player.technical_Features.setLong_Throws(normal_or_lowChance());
        player.technical_Features.setMarking(normal_or_lowChance());
        player.technical_Features.setPassing(HighChance());
        player.technical_Features.setPenalty_taking(normal_or_lowChance());
        player.technical_Features.setTackling(normal_or_lowChance());
        player.technical_Features.setTechnique(HighChance());
        //Mental
        player.mental_Features.setAggression(normal_or_lowChance());
        player.mental_Features.setAnticipation(HighChance());
        player.mental_Features.setBravery(normal_or_lowChance());
        player.mental_Features.setComposure(HighChance());
        player.mental_Features.setConcentration(normal_or_lowChance());
        player.mental_Features.setDecisions(normal_or_lowChance());
        player.mental_Features.setDetermination(normal_or_lowChance());
        player.mental_Features.setFlair(HighChance());
        player.mental_Features.setLeadership(normal_or_lowChance());
        player.mental_Features.setOff_The_Ball(normal_or_lowChance());
        player.mental_Features.setPositioning(normal_or_lowChance());
        player.mental_Features.setTeamwork(normal_or_lowChance());
        player.mental_Features.setVision(HighChance());
        player.mental_Features.setWork_Rate(normal_or_lowChance());
        //Physical
        player.physical_Features.setAcceleration(normal_or_lowChance());
        player.physical_Features.setAgility(normal_or_lowChance());
        player.physical_Features.setBalance(HighChance());
        player.physical_Features.setJumping_Reach(normal_or_lowChance());
        player.physical_Features.setNatural_Fitness(HighChance());
        player.physical_Features.setPace(HighChance());
        player.physical_Features.setStamina(normal_or_lowChance());
        player.physical_Features.setStrength(HighChance());
        player.calculate();
        return player;

    }

    public static Defender Create(Defender player){
        //Technical
        player.technical_Features.setCorners(normal_or_lowChance());
        player.technical_Features.setCrossing(normal_or_lowChance());
        player.technical_Features.setDribbling(normal_or_lowChance());
        player.technical_Features.setFinishing(normal_or_lowChance());
        player.technical_Features.setFirst_Touch(HighChance());
        player.technical_Features.setFree_Kick_Taking(normal_or_lowChance());
        player.technical_Features.setHeading(HighChance());
        player.technical_Features.setLong_Shots(normal_or_lowChance());
        player.technical_Features.setLong_Throws(normal_or_lowChance());
        player.technical_Features.setMarking(HighChance());
        player.technical_Features.setPassing(normal_or_lowChance());
        player.technical_Features.setPenalty_taking(normal_or_lowChance());
        player.technical_Features.setTackling(HighChance());
        player.technical_Features.setTechnique(normal_or_lowChance());
        //Mental
        player.mental_Features.setAggression(normal_or_lowChance());
        player.mental_Features.setAnticipation(HighChance());
        player.mental_Features.setBravery(HighChance());
        player.mental_Features.setComposure(normal_or_lowChance());
        player.mental_Features.setConcentration(normal_or_lowChance());
        player.mental_Features.setDecisions(normal_or_lowChance());
        player.mental_Features.setDetermination(normal_or_lowChance());
        player.mental_Features.setFlair(normal_or_lowChance());
        player.mental_Features.setLeadership(HighChance());
        player.mental_Features.setOff_The_Ball(normal_or_lowChance());
        player.mental_Features.setPositioning(HighChance());
        player.mental_Features.setTeamwork(normal_or_lowChance());
        player.mental_Features.setVision(normal_or_lowChance());
        player.mental_Features.setWork_Rate(normal_or_lowChance());
        //Physical
        player.physical_Features.setAcceleration(normal_or_lowChance());
        player.physical_Features.setAgility(normal_or_lowChance());
        player.physical_Features.setBalance(HighChance());
        player.physical_Features.setJumping_Reach(HighChance());
        player.physical_Features.setNatural_Fitness(normal_or_lowChance());
        player.physical_Features.setPace(normal_or_lowChance());
        player.physical_Features.setStamina(HighChance());
        player.physical_Features.setStrength(HighChance());
        player.calculate();
        return player;
    }








    //////////////////////////////////////////////////////////////////////////////////////////// Alt kısım eski projenin

    /*

    //Oyuncuların değerlerini rastgele oluşturuyorum
    public static GoalKeeper Create(GoalKeeper player){
        player.technical_Features.setFree_Kick_Taking(normal_or_lowChance());
        player.technical_Features.setPenalty_taking(normal_or_lowChance());
        player.technical_Features.setTechnique(normal_or_lowChance());
        //Mental
        player.mental_Features.setAggression(normal_or_lowChance());
        player.mental_Features.setAnticipation(HighChance());
        player.mental_Features.setBravery(normal_or_lowChance());
        player.mental_Features.setComposure(normal_or_lowChance());
        player.mental_Features.setConcentration(normal_or_lowChance());
        player.mental_Features.setDecisions(HighChance());
        player.mental_Features.setDetermination(normal_or_lowChance());
        player.mental_Features.setFlair(HighChance());
        player.mental_Features.setLeadership(normal_or_lowChance());
        player.mental_Features.setOff_The_Ball(normal_or_lowChance());
        player.mental_Features.setPositioning(HighChance());
        player.mental_Features.setTeamwork(normal_or_lowChance());
        player.mental_Features.setVision(normal_or_lowChance());
        player.mental_Features.setWork_Rate(normal_or_lowChance());
        //Physical
        player.physical_Features.setAcceleration(normal_or_lowChance());
        player.physical_Features.setAgility(HighChance());
        player.physical_Features.setBalance(HighChance());
        player.physical_Features.setJumping_Reach(HighChance());
        player.physical_Features.setNatural_Fitness(normal_or_lowChance());
        player.physical_Features.setPace(normal_or_lowChance());
        player.physical_Features.setStamina(normal_or_lowChance());
        player.physical_Features.setStrength(HighChance());
        //GoalKeeping
        player.goal_Keeping.setAerial_Reach(HighChance());
        player.goal_Keeping.setCommand_Of_Area(HighChance());
        player.goal_Keeping.setCommunication(normal_or_lowChance());
        player.goal_Keeping.setEccentricity(normal_or_lowChance());
        player.goal_Keeping.setFirst_Touch(normal_or_lowChance());
        player.goal_Keeping.setHandling(normal_or_lowChance());
        player.goal_Keeping.setKicking(normal_or_lowChance());
        player.goal_Keeping.setOne_On_Ones(HighChance());
        player.goal_Keeping.setPassing(normal_or_lowChance());
        player.goal_Keeping.setPunching(normal_or_lowChance());
        player.goal_Keeping.setReflexes(HighChance());
        player.goal_Keeping.setRushing_Out(normal_or_lowChance());
        player.goal_Keeping.setThrowing(normal_or_lowChance());
        player.calculate();
        return player;


    }
    public static Midfielder Create(Midfielder player){

        //Technical
        player.technical_Features.setCorners(normal_or_lowChance());
        player.technical_Features.setCrossing(normal_or_lowChance());
        player.technical_Features.setDribbling(normal_or_lowChance());
        player.technical_Features.setFinishing(normal_or_lowChance());
        player.technical_Features.setFirst_Touch(HighChance());
        player.technical_Features.setFree_Kick_Taking(normal_or_lowChance());
        player.technical_Features.setHeading(HighChance());
        player.technical_Features.setLong_Shots(normal_or_lowChance());
        player.technical_Features.setLong_Throws(normal_or_lowChance());
        player.technical_Features.setMarking(normal_or_lowChance());
        player.technical_Features.setPassing(HighChance());
        player.technical_Features.setPenalty_taking(normal_or_lowChance());
        player.technical_Features.setTackling(normal_or_lowChance());
        player.technical_Features.setTechnique(HighChance());
        //Mental
        player.mental_Features.setAggression(normal_or_lowChance());
        player.mental_Features.setAnticipation(normal_or_lowChance());
        player.mental_Features.setBravery(normal_or_lowChance());
        player.mental_Features.setComposure(HighChance());
        player.mental_Features.setConcentration(normal_or_lowChance());
        player.mental_Features.setDecisions(normal_or_lowChance());
        player.mental_Features.setDetermination(normal_or_lowChance());
        player.mental_Features.setFlair(normal_or_lowChance());
        player.mental_Features.setLeadership(HighChance());
        player.mental_Features.setOff_The_Ball(HighChance());
        player.mental_Features.setPositioning(normal_or_lowChance());
        player.mental_Features.setTeamwork(HighChance());
        player.mental_Features.setVision(normal_or_lowChance());
        player.mental_Features.setWork_Rate(normal_or_lowChance());
        //Physical
        player.physical_Features.setAcceleration(normal_or_lowChance());
        player.physical_Features.setAgility(HighChance());
        player.physical_Features.setBalance(HighChance());
        player.physical_Features.setJumping_Reach(normal_or_lowChance());
        player.physical_Features.setNatural_Fitness(HighChance());
        player.physical_Features.setPace(HighChance());
        player.physical_Features.setStamina(normal_or_lowChance());
        player.physical_Features.setStrength(normal_or_lowChance());
        player.calculate();
        return player;

    }


    public static  Attacker Create(Attacker player){

        //Technical
        player.technical_Features.setCorners(normal_or_lowChance());
        player.technical_Features.setCrossing(normal_or_lowChance());
        player.technical_Features.setDribbling(HighChance());
        player.technical_Features.setFinishing(normal_or_lowChance());
        player.technical_Features.setFirst_Touch(HighChance());
        player.technical_Features.setFree_Kick_Taking(normal_or_lowChance());
        player.technical_Features.setHeading(normal_or_lowChance());
        player.technical_Features.setLong_Shots(normal_or_lowChance());
        player.technical_Features.setLong_Throws(normal_or_lowChance());
        player.technical_Features.setMarking(normal_or_lowChance());
        player.technical_Features.setPassing(HighChance());
        player.technical_Features.setPenalty_taking(normal_or_lowChance());
        player.technical_Features.setTackling(normal_or_lowChance());
        player.technical_Features.setTechnique(HighChance());
        //Mental
        player.mental_Features.setAggression(normal_or_lowChance());
        player.mental_Features.setAnticipation(HighChance());
        player.mental_Features.setBravery(normal_or_lowChance());
        player.mental_Features.setComposure(HighChance());
        player.mental_Features.setConcentration(normal_or_lowChance());
        player.mental_Features.setDecisions(normal_or_lowChance());
        player.mental_Features.setDetermination(normal_or_lowChance());
        player.mental_Features.setFlair(HighChance());
        player.mental_Features.setLeadership(normal_or_lowChance());
        player.mental_Features.setOff_The_Ball(normal_or_lowChance());
        player.mental_Features.setPositioning(normal_or_lowChance());
        player.mental_Features.setTeamwork(normal_or_lowChance());
        player.mental_Features.setVision(HighChance());
        player.mental_Features.setWork_Rate(normal_or_lowChance());
        //Physical
        player.physical_Features.setAcceleration(normal_or_lowChance());
        player.physical_Features.setAgility(normal_or_lowChance());
        player.physical_Features.setBalance(HighChance());
        player.physical_Features.setJumping_Reach(normal_or_lowChance());
        player.physical_Features.setNatural_Fitness(HighChance());
        player.physical_Features.setPace(HighChance());
        player.physical_Features.setStamina(normal_or_lowChance());
        player.physical_Features.setStrength(HighChance());
        player.calculate();
        return player;

    }

    public static Defender Create(Defender player){
        //Technical
        player.technical_Features.setCorners(normal_or_lowChance());
        player.technical_Features.setCrossing(normal_or_lowChance());
        player.technical_Features.setDribbling(normal_or_lowChance());
        player.technical_Features.setFinishing(normal_or_lowChance());
        player.technical_Features.setFirst_Touch(HighChance());
        player.technical_Features.setFree_Kick_Taking(normal_or_lowChance());
        player.technical_Features.setHeading(HighChance());
        player.technical_Features.setLong_Shots(normal_or_lowChance());
        player.technical_Features.setLong_Throws(normal_or_lowChance());
        player.technical_Features.setMarking(HighChance());
        player.technical_Features.setPassing(normal_or_lowChance());
        player.technical_Features.setPenalty_taking(normal_or_lowChance());
        player.technical_Features.setTackling(HighChance());
        player.technical_Features.setTechnique(normal_or_lowChance());
        //Mental
        player.mental_Features.setAggression(normal_or_lowChance());
        player.mental_Features.setAnticipation(HighChance());
        player.mental_Features.setBravery(HighChance());
        player.mental_Features.setComposure(normal_or_lowChance());
        player.mental_Features.setConcentration(normal_or_lowChance());
        player.mental_Features.setDecisions(normal_or_lowChance());
        player.mental_Features.setDetermination(normal_or_lowChance());
        player.mental_Features.setFlair(normal_or_lowChance());
        player.mental_Features.setLeadership(HighChance());
        player.mental_Features.setOff_The_Ball(normal_or_lowChance());
        player.mental_Features.setPositioning(HighChance());
        player.mental_Features.setTeamwork(normal_or_lowChance());
        player.mental_Features.setVision(normal_or_lowChance());
        player.mental_Features.setWork_Rate(normal_or_lowChance());
        //Physical
        player.physical_Features.setAcceleration(normal_or_lowChance());
        player.physical_Features.setAgility(normal_or_lowChance());
        player.physical_Features.setBalance(HighChance());
        player.physical_Features.setJumping_Reach(HighChance());
        player.physical_Features.setNatural_Fitness(normal_or_lowChance());
        player.physical_Features.setPace(normal_or_lowChance());
        player.physical_Features.setStamina(HighChance());
        player.physical_Features.setStrength(HighChance());
        player.calculate();
        return player;
    }
    */

}
