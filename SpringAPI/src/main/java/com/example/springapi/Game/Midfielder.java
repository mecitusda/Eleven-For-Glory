package com.example.springapi.Game;

public class Midfielder extends Player{

    private double physical_Other_Strengths;
    private double mental_Other_Strengths;
    private double technical_Other_Strengths;
    private double midfielder_Main_Strength;
    private double midfielder_Strength;

    public Midfielder(){
        calculate();
    }

    public void calculate(){//Tanımlarken ilk değeri olmadıkları için sonradan değerlerini hesaplatıyorum.
        physical_Other_Strengths=(physical_Features.getAcceleration()*0.2+physical_Features.getJumping_Reach()*0.2+physical_Features.getStamina()*0.2+physical_Features.getStrength()*0.2)/4;
        mental_Other_Strengths=(mental_Features.getAggression()*0.2+mental_Features.getAnticipation()*0.2+mental_Features.getBravery()*0.2+mental_Features.getConcentration()*0.2+mental_Features.getDecisions()*0.2+mental_Features.getDetermination()*0.2+mental_Features.getFlair()*0.2+mental_Features.getPositioning()*0.2+mental_Features.getVision()*0.2+mental_Features.getWork_Rate()*0.2)/10;
        technical_Other_Strengths=(technical_Features.getCorners()*0.2+technical_Features.getCrossing()*0.2+technical_Features.getDribbling()*0.2+technical_Features.getFinishing()*0.2+technical_Features.getFree_Kick_Taking()*0.2+technical_Features.getLong_Shots()*0.2+technical_Features.getLong_Throws()*0.2+technical_Features.getMarking()*0.2+technical_Features.getPenalty_taking()*0.2+technical_Features.getTackling()*0.2)/10;
        midfielder_Main_Strength=(technical_Features.getFirst_Touch()+technical_Features.getHeading()+technical_Features.getPassing()+technical_Features.getTechnique()+mental_Features.getLeadership()+mental_Features.getOff_The_Ball()+mental_Features.getTeamwork()+mental_Features.getComposure()+physical_Features.getNatural_Fitness()+physical_Features.getPace()+physical_Features.getBalance()+physical_Features.getAgility())/12;
        midfielder_Strength=(physical_Other_Strengths+mental_Other_Strengths+technical_Other_Strengths+midfielder_Main_Strength);
    }
    public double getMidfielder_Strength() {
        return midfielder_Strength;
    }

    public void setMidfielder_Strength(double midfielder_Strength) {
        this.midfielder_Strength = midfielder_Strength;
    }




}
