package com.example.springapi.Game;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class butonum extends JFrame {
    private JPanel Panel;
    private JButton macYapButton;
    private int mac_sayisi=0;
    String [][]  anlikTakim;
    public static baglanti baglan=new baglanti();
    public static int haftasayac=1;
    public butonum(ArrayList<String> teams){
        add(Panel);
        JTextField textField = new JTextField(20);
        setBounds(650,300,700,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        macYapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                anlikTakim= baglan.team_matching(teams,anlikTakim,haftasayac++);//her maç yap butonuna basıldığında
                //anlık takım pozisyonunu geri döndürüyor.Bu sayede bir sonraki maç karşılaştırmaları yapılabiliyor.
            }
        });
        this.setVisible(true);
    }

}
