package com.example.springapi.Game;

public class Defender extends Player{

    private double physical_Other_Strengths;
    private double mental_Other_Strengths;
    private double technical_Other_Strengths;
    private double defensive_Player_Main_Strength;
    private double defensive_Strength;
    public Defender(){

    }

    public void calculate(){//oyuncu oluştuktan sonra değerlerini hesaplıyorum
        physical_Other_Strengths=(physical_Features.getAcceleration()*0.2+physical_Features.getAgility()*0.2+physical_Features.getNatural_Fitness()*0.2+physical_Features.getPace()*0.2)/4;
        mental_Other_Strengths=(mental_Features.getAggression()*0.2+mental_Features.getConcentration()*0.2+mental_Features.getComposure()*0.2+ mental_Features.getDecisions()*0.2+mental_Features.getConcentration()+mental_Features.getDetermination()*0.2+mental_Features.getFlair()*0.2+mental_Features.getOff_The_Ball()*0.2+mental_Features.getTeamwork()*0.2+mental_Features.getVision()*0.2)/10;
        technical_Other_Strengths=(technical_Features.getCorners()*0.2+technical_Features.getCrossing()*0.2+technical_Features.getDribbling()*0.2+technical_Features.getFinishing()*0.2+technical_Features.getFree_Kick_Taking()*0.2+technical_Features.getLong_Shots()*0.2+technical_Features.getLong_Throws()*0.2+technical_Features.getPassing()*0.2+technical_Features.getPenalty_taking()*0.2+technical_Features.getTechnique()*0.2)/10;
        defensive_Player_Main_Strength=(technical_Features.getFirst_Touch()+technical_Features.getHeading()+technical_Features.getMarking()+technical_Features.getTackling()+mental_Features.getPositioning()+mental_Features.getBravery()+mental_Features.getLeadership()+mental_Features.getAnticipation()+physical_Features.getJumping_Reach()+physical_Features.getBalance()+physical_Features.getStrength()+physical_Features.getStamina())/12;
        defensive_Strength=(physical_Other_Strengths+mental_Other_Strengths+technical_Other_Strengths+defensive_Player_Main_Strength);

    }
    public double getDefensive_Strength() {

        return defensive_Strength;
    }

    public void setDefensive_Strength(double defensive_Strength) {
        this.defensive_Strength = defensive_Strength;
    }
}
