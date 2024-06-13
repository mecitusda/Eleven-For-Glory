package com.example.springapi.Game;

public class GoalKeeper extends Player{
    GoalKeeping goal_Keeping=new GoalKeeping();
    private double physical_Other_Strengths;
    private double mental_Other_Strengths;
    private double goalKeeping_Other_Strengths;
    private double technical_Strengths;
    private double goalKeeper_Main_Strength;
    private double goalKeeper_Strength;

    public GoalKeeper(){

    }

    public void calculate(){//oyuncu oluştuktan sonra değerlerini hesaplatıyorum.
        mental_Other_Strengths=(mental_Features.getAggression()*0.2+mental_Features.getBravery()*0.2+mental_Features.getComposure()*0.2+mental_Features.getConcentration()*0.2+mental_Features.getDetermination()*0.2+mental_Features.getLeadership()*0.2+mental_Features.getOff_The_Ball()*0.2+mental_Features.getTeamwork()*0.2+mental_Features.getVision()*0.2+mental_Features.getWork_Rate()*0.2)/10;
        goalKeeping_Other_Strengths=(goal_Keeping.getCommunication()*0.2+goal_Keeping.getEccentricity()*0.2+goal_Keeping.getFirst_Touch()*0.2+goal_Keeping.getHandling()*0.2+goal_Keeping.getKicking()*0.2+goal_Keeping.getPassing()*0.2+goal_Keeping.getPunching()*0.2+goal_Keeping.getRushing_Out()*0.2+goal_Keeping.getThrowing()*0.2)/9;
        technical_Strengths=technical_Features.getTechnique()*0.2;
        physical_Other_Strengths=(physical_Features.getAcceleration()*0.2+physical_Features.getNatural_Fitness()*0.2+physical_Features.getPace()*0.2+physical_Features.getStamina()*0.2)/4;
        goalKeeper_Main_Strength=(goal_Keeping.getAerial_Reach()+goal_Keeping.getCommand_Of_Area()+goal_Keeping.getOne_On_Ones()+goal_Keeping.getReflexes()+mental_Features.getAnticipation()+mental_Features.getDecisions()+mental_Features.getFlair()+mental_Features.getPositioning()+physical_Features.getAgility()+physical_Features.getBalance()+physical_Features.getJumping_Reach()+physical_Features.getStrength())/12;
        goalKeeper_Strength=(physical_Other_Strengths + mental_Other_Strengths + goalKeeper_Main_Strength + technical_Strengths + goalKeeping_Other_Strengths);

    }
    public double getGoalKeeper_Strength() {
        return goalKeeper_Strength;
    }

    public void setGoalKeeper_Strength(double goalKeeper_Strength) {
        this.goalKeeper_Strength = goalKeeper_Strength;
    }

}
