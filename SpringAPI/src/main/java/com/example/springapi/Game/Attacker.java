package com.example.springapi.Game;

public class Attacker extends Player{
    private double physical_Other_Strengths;
    private double mental_Other_Strengths;
    private double technical_Other_Strengths;
    private double offensive_Player_Main_Strength;
        private double offensive_Strength;
    public Attacker(){

    }
    public void calculate(){//ortalama gücleri hesaplıyor
        physical_Other_Strengths=(physical_Features.getAcceleration()*0.2+physical_Features.getAgility()*0.2+physical_Features.getJumping_Reach()*0.2+physical_Features.getStamina()*0.2)/4;
        mental_Other_Strengths=(mental_Features.getAggression()*0.2+mental_Features.getBravery()*0.2+mental_Features.getConcentration()*0.2+mental_Features.getDecisions()*0.2+mental_Features.getDetermination()*0.2+mental_Features.getLeadership()*0.2+mental_Features.getOff_The_Ball()*0.2+mental_Features.getPositioning()*0.2+mental_Features.getTeamwork()*0.2+mental_Features.getWork_Rate()*0.2)/10;
        technical_Other_Strengths=(technical_Features.getCorners()*0.2+technical_Features.getCrossing()*0.2+technical_Features.getFinishing()*0.2+technical_Features.getFree_Kick_Taking()*0.2+technical_Features.getHeading()*0.2+technical_Features.getLong_Shots()*0.2+technical_Features.getLong_Throws()*0.2+technical_Features.getMarking()*0.2+technical_Features.getPenalty_taking()*0.2+technical_Features.getTackling()*0.2)/10;
        offensive_Player_Main_Strength=(technical_Features.getDribbling()+technical_Features.getTechnique()+technical_Features.getPassing()+technical_Features.getFirst_Touch()+mental_Features.getFlair()+mental_Features.getVision()+mental_Features.getAnticipation()+mental_Features.getComposure()+physical_Features.getBalance()+physical_Features.getNatural_Fitness()+physical_Features.getStrength()+physical_Features.getPace())/12;
        offensive_Strength=(physical_Other_Strengths+mental_Other_Strengths+technical_Other_Strengths+offensive_Player_Main_Strength);
    }

    public double getOffensive_Strength() {
        return offensive_Strength;
    }


}
