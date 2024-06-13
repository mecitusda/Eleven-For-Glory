package com.example.springapi.Game;

import java.sql.*;
import java.util.*;


public class baglanti {
    private String kullanici_Adi = "root";
    private String sifre = "";
    private String db_Name = "futbolgame";
    private String host_Name = "localhost";
    private int port = 3306;
    private static Connection con = null;
    private static Statement statement = null;

    public static boolean first=false;
    Map<String, String> match_yapacaklar = new LinkedHashMap<String, String>(9);//takımları eşleştirmede kullanıyorum
    private ArrayList<String> teams = new ArrayList<>(18);
    static int satir = 0;  //satır ve stün kaç takım olursa ona göre matrix yükseklik ve genişliğini tutucak.
    static int sutun = 0;//


    public baglanti() {
        String url = "jdbc:mysql://" + host_Name + ":" + port + "/" + db_Name;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            con = DriverManager.getConnection(url, kullanici_Adi, sifre);
            System.out.println("Başarıyla bağlanıldı...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void create_Player(){//Player tablosuna hazır oyuncuları koyar.
        try {
            statement = con.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        // SQL sorgusun;;u hazırlama
        try {


            int oyuncutablo=statement.executeUpdate("CREATE TABLE player (\n" +
                    "    player_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    player_name VARCHAR(255) NOT NULL,\n" +
                    "    team_id INT,\n" +
                    "    position VARCHAR(100),\n" +
                    "    nationality VARCHAR(100),\n" +
                    "    FOREIGN KEY (team_id) REFERENCES Team(team_id)\n" +
                    ");");



            int oyuncuekle=statement.executeUpdate("INSERT INTO player (player_name, team_id, position, nationality) VALUES  " +
                    "    ('Arda Turan', 1, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Ryan Babel', 1, 'Forvet', 'Netherlands'),\n" +
                    "    ('Omar Elabdellaoui', 1, 'Defans', 'Norway'),\n" +
                    "    ('Fernando Muslera', 1, 'Kaleci', 'Uruguay'),\n" +
                    "    ('Emre Kılınç', 1, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Kerem Aktürkoğlu', 1, 'Forvet', 'Turkey'),\n" +
                    "    ('Christian Luyindama', 1, 'Defans', 'Congo'),\n" +
                    "    ('Marcão', 1, 'Defans', 'Brazil'),\n" +
                    "    ('Halil Dervişoğlu', 1, 'Forvet', 'Turkey'),\n" +
                    "    ('Ömer Bayram', 1, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Marcao', 1, 'Defans', 'Brazil');\n");

            oyuncuekle += statement.executeUpdate(  "INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Mesut Özil', 2, 'Orta Saha', 'Germany'),\n" +
                    "    ('Ozan Tufan', 2, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Mert Hakan Yandaş', 2, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Altay Bayındır', 2, 'Kaleci', 'Turkey'),\n" +
                    "    ('İrfan Can Kahveci', 2, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Bright Osayi-Samuel', 2, 'Forvet', 'Nigeria'),\n" +
                    "    ('Serhat Ahmetoğlu', 2, 'Forvet', 'Turkey'),\n" +
                    "    ('Diego Perotti', 2, 'Defans', 'Argentina'),\n" +
                    "    ('Attila Szalai', 2, 'Defans', 'Hungary'),\n" +
                    "    ('Luiz Gustavo', 2, 'Orta Saha', 'Brazil'),\n" +
                    "    ('Caner Erkin', 2, 'Defans', 'Turkey');");

            oyuncuekle += statement.executeUpdate( "INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Vincent Aboubakar', 3, 'Orta Saha', 'Cameroon'),\n" +
                    "    ('Cyle Larin', 3, 'Forvet', 'Canada'),\n" +
                    "    ('Domagoj Vida', 3, 'Defans', 'Croatia'),\n" +
                    "    ('Utku Yuvakuran', 3, 'Kaleci', 'Turkey'),\n" +
                    "    ('Alex Teixeira', 3, 'Orta Saha', 'Brazil'),\n" +
                    "    ('Rıdvan Yılmaz', 3, 'Defans', 'Turkey'),\n" +
                    "    ('Serdar Saatçi', 3, 'Defans', 'Turkey'),\n" +
                    "    ('Adem Ljajic', 3, 'Orta Saha', 'Serbia'),\n" +
                    "    ('Bernard Mensah', 3, 'Orta Saha', 'Ghana'),\n" +
                    "    ('Valentin Rosier', 3, 'Defans', 'France'),\n" +
                    "    ('Cenk Tosun', 3, 'Forvet', 'Turkey')");


            oyuncuekle += statement.executeUpdate( "    INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Caleb Ekuban', 4, 'Forvet', 'Ghana'),\n" +
                    "    ('Djaniny', 4, 'Forvet', 'Cape Verde'),\n" +
                    "    ('Serkan Asan', 4, 'Forvet', 'Turkey'),\n" +
                    "    ('Edgar Ié', 4, 'Defans', 'Portugal'),\n" +
                    "    ('Abdülkadir Ömür', 4, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Ahmet Canbaz', 4, 'Kaleci', 'Turkey'),\n" +
                    "    ('Yusuf Sarı', 4, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Hüseyin Türkmen', 4, 'Defans', 'Turkey'),\n" +
                    "    ('Marlon', 4, 'Defans', 'Brazil'),\n" +
                    "    ('Kamil Ahmet Çörekçi', 4, 'Defans', 'Turkey'),\n" +
                    "    ('Flávio', 4, 'Orta Saha', 'Brazil');");

            oyuncuekle += statement.executeUpdate(  "INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Vincent Aboubakar', 5, 'Forvet', 'Cameroon'),\n" +
                    "    ('Cyle Larin', 5, 'Forvet', 'Canada'),\n" +
                    "    ('Domagoj Vida', 5, 'Defans', 'Croatia'),\n" +
                    "    ('Utku Yuvakuran', 5, 'Kaleci', 'Turkey'),\n" +
                    "    ('Alex Teixeira', 5, 'Orta Saha', 'Brazil'),\n" +
                    "    ('Rıdvan Yılmaz', 5, 'Defans', 'Turkey'),\n" +
                    "    ('Serdar Saatçi', 5, 'Defans', 'Turkey'),\n" +
                    "    ('Adem Ljajic', 5, 'Orta Saha', 'Serbia'),\n" +
                    "    ('Bernard Mensah', 5, 'Orta Saha', 'Ghana'),\n" +
                    "    ('Valentin Rosier', 5, 'Defans', 'France'),\n" +
                    "    ('Cenk Tosun', 5, 'Forvet', 'Turkey');\n");


            oyuncuekle += statement.executeUpdate( "INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Edin Višća', 6, 'Orta Saha', 'Bosnia and Herzegovina'),\n" +
                    "    ('Deniz Türüç', 6, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Kerim Frei', 6, 'Orta Saha', 'Switzerland'),\n" +
                    "    ('Mehmet Topal', 6, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Aziz Behich', 6, 'Defans', 'Australia'),\n" +
                    "    ('Rafael', 6, 'Defans', 'Brazil'),\n" +
                    "    ('Nacer Chadli', 6, 'Defans', 'Belgium'),\n" +
                    "    ('Gael Clichy', 6, 'Defans', 'France'),\n" +
                    "    ('Andrija Balić', 6, 'Kaleci', 'Croatia'),\n" +
                    "    ('Boli Bolingoli-Mbombo', 6, 'Forvet', 'Belgium'),\n" +
                    "    ('Giuliano', 6, 'Forvet', 'Brazil');");




            oyuncuekle += statement.executeUpdate( "INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Salih Uçan', 7, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Khouma Babacar', 7, 'Forvet', 'Senegal'),\n" +
                    "    ('Ufuk Ceylan', 7, 'Kaleci', 'Turkey'),\n" +
                    "    ('Steven Caulker', 7, 'Defans', 'England'),\n" +
                    "    ('Federico Fernández', 7, 'Defans', 'Argentina'),\n" +
                    "    ('Efkan Bekiroğlu', 7, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Bekir İrtegün', 7, 'Forvet', 'Turkey'),\n" +
                    "    ('Tayfur Bingöl', 7, 'Defans', 'Turkey'),\n" +
                    "    ('Ahmet Gülay', 7, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Tayfur Bingöl', 7, 'Defans', 'Turkey'),\n" +
                    "    ('Davidson', 7, 'Orta Saha', 'Brazil');\n");

            oyuncuekle += statement.executeUpdate( "INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Halil Akbunar', 8, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Adis Jahovic', 8, 'Forvet', 'Macedonia'),\n" +
                    "    ('İrfan Can Eğribayat', 8, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Eray Birniçan', 8, 'Kaleci', 'Turkey'),\n" +
                    "    ('Alpaslan Öztürk', 8, 'Defans', 'Turkey'),\n" +
                    "    ('Atınç Nukan', 8, 'Defans', 'Turkey'),\n" +
                    "    ('Chidozie Awaziem', 8, 'Defans', 'Nigeria'),\n" +
                    "    ('Brown Ideye', 8, 'Forvet', 'Nigeria'),\n" +
                    "    ('Güray Vural', 8, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Zlatko Tripic', 8, 'Orta Saha', 'Norway'),\n" +
                    "    ('Cameron Jerome', 8, 'Forvet', 'England');\n");

            oyuncuekle += statement.executeUpdate(   "INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Farouk Miya', 9, 'Orta Saha', 'Uganda'),\n" +
                    "    ('Erdon Daci', 9, 'Forvet', 'Albania'),\n" +
                    "    ('Anıl Karaer', 9, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Oğuz Kağan Güçtekin', 9, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Muammer Zülfikar Yıldırım', 9, 'Defans', 'Turkey'),\n" +
                    "    ('Deni Milošević', 9, 'Defans', 'Croatia'),\n" +
                    "    ('Alper Uludağ', 9, 'Defans', 'Turkey'),\n" +
                    "    ('Evgeniy Shakhov', 9, 'Orta Saha', 'Russia'),\n" +
                    "    ('Marko Jevtović', 9, 'Orta Saha', 'Serbia'),\n" +
                    "    ('Amir Hadžiahmetović', 9, 'Orta Saha', 'Bosnia and Herzegovina'),\n" +
                    "    ('Adil Demirbağ', 9, 'Kaleci', 'Turkey');\n" );



            oyuncuekle += statement.executeUpdate(  "    INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Gökdeniz Bayrakdar', 10, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Fredy', 10, 'Forvet', 'Brazil'),\n" +
                    "    ('Hakan Özmert', 10, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Samuel Inkoom', 10, 'Defans', 'Ghana'),\n" +
                    "    ('Vladimir Broun Tavares', 10, 'Forvet', 'Cape Verde'),\n" +
                    "    ('Gustavo Blanco Leschuk', 10, 'Forvet', 'Uruguay'),\n" +
                    "    ('Eren Albayrak', 10, 'Defans', 'Turkey'),\n" +
                    "    ('Ufuk Akyol', 10, 'Defans', 'Turkey'),\n" +
                    "    ('Yasin Öztekin', 10, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Naldo', 10, 'Defans', 'Brazil'),\n" +
                    "    ('Serkan Kırıntılı', 10, 'Kaleci', 'Turkey');\n");


            oyuncuekle += statement.executeUpdate( "INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Jefferson', 11, 'Kaleci', 'Brazil'),\n" +
                    "    ('Júnior Morais', 11, 'Defans', 'Brazil'),\n" +
                    "    ('Ibrahim Sangaré', 11, 'Orta Saha', 'Ivory Coast'),\n" +
                    "    ('Serginho', 11, 'Forvet', 'Brazil'),\n" +
                    "    ('Júnior Brandão', 11, 'Forvet', 'Brazil'),\n" +
                    "    ('Bradley Diallo', 11, 'Defans', 'France'),\n" +
                    "    ('Kana-Biyik', 11, 'Defans', 'Cameroon'),\n" +
                    "    ('Papy Djilobodji', 11, 'Defans', 'Senegal'),\n" +
                    "    ('Pierre-Yves Polomat', 11, 'Defans', 'France'),\n" +
                    "    ('Yalçın Kılınç', 11, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Adama Traoré', 11, 'Orta Saha', 'Mali');\n");

            oyuncuekle += statement.executeUpdate(   "INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Aaron Boupendza', 12, 'Forvet', 'Gabon'),\n" +
                    "    ('Akintola Akintunde', 12, 'Forvet', 'Nigeria'),\n" +
                    "    ('Bayram Emirhan', 12, 'Defans', 'Turkey'),\n" +
                    "    ('Hugo Rodallega', 12, 'Forvet', 'Colombia'),\n" +
                    "    ('Jean-Claude Billong', 12, 'Defans', 'Cameroon'),\n" +
                    "    ('Mame Biram Diouf', 12, 'Kaleci', 'Senegal'),\n" +
                    "    ('Selim Ilgaz', 12, 'Defans', 'Turkey'),\n" +
                    "    ('Soner Örnek', 12, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Strahil Popov', 12, 'Defans', 'Bulgaria'),\n" +
                    "    ('Yusuf Abdioğlu', 12, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Muhammed Atakan Üner', 12, 'Orta Saha', 'Turkey');\n");


            oyuncuekle += statement.executeUpdate(   "    INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Stephen Sama', 13, 'Defans', 'Cameroon'),\n" +
                    "    ('Fabio Borini', 13, 'Forvet', 'Italy'),\n" +
                    "    ('Abdulkadir Parmak', 13, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Oğuzhan Çapar', 13, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Emre Nefiz', 13, 'Kaleci', 'Turkey'),\n" +
                    "    ('Ertuğrul Ersoy', 13, 'Defans', 'Turkey'),\n" +
                    "    ('Ufuk Budak', 13, 'Defans', 'Turkey'),\n" +
                    "    ('Zeki Yavru', 13, 'Defans', 'Turkey'),\n" +
                    "    ('Kamil Ahmet Çörekçi', 13, 'Defans', 'Turkey'),\n" +
                    "    ('Berkay Samancı', 13, 'Forvet', 'Turkey'),\n" +
                    "    ('Dorukhan Toköz', 13, 'Orta Saha', 'Turkey');\n");

            oyuncuekle += statement.executeUpdate(  "INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Youssouf Ndayishimiye', 14, 'Orta Saha', 'Burundi'),\n" +
                    "    ('Yasin Palaz', 14, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Mert Sarı', 14, 'Kaleci', 'Turkey'),\n" +
                    "    ('Nascimento Amilton', 14, 'Forvet', 'Brazil'),\n" +
                    "    ('Berk Yıldız', 14, 'Defans', 'Turkey'),\n" +
                    "    ('Emre Uğur Uruç', 14, 'Defans', 'Turkey'),\n" +
                    "    ('Vieirinha', 14, 'Orta Saha', 'Portugal'),\n" +
                    "    ('Raphael Aholou', 14, 'Orta Saha', 'Ivory Coast'),\n" +
                    "    ('Salih Uçan', 14, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Yakup Demir', 14, 'Defans', 'Turkey'),\n" +
                    "    ('Mehmet Akyüz', 14, 'Forvet', 'Turkey');\n");

            oyuncuekle += statement.executeUpdate( "INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Federico Piovaccari', 15, 'Forvet', 'Italy'),\n" +
                    "    ('Bernard Mensah', 15, 'Orta Saha', 'Ghana'),\n" +
                    "    ('Nurettin Korkmaz', 15, 'Defans', 'Turkey'),\n" +
                    "    ('Bernard Mensah', 15, 'Orta Saha', 'Ghana'),\n" +
                    "    ('Melih Okutan', 15, 'Kaleci', 'Turkey'),\n" +
                    "    ('Nurettin Korkmaz', 15, 'Defans', 'Turkey'),\n" +
                    "    ('Samed Karakoç', 15, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Gökhan Değirmenci', 15, 'Defans', 'Turkey'),\n" +
                    "    ('Yasir Subaşı', 15, 'Forvet', 'Turkey'),\n" +
                    "    ('Yasir Subaşı', 15, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Hakan Bilgiç', 15, 'Defans', 'Turkey');\n");


            oyuncuekle += statement.executeUpdate(  "    INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Fayçal Fajr', 16, 'Orta Saha', 'Morocco'),\n" +
                    "    ('Mustapha Yatabaré', 16, 'Forvet', 'Mali'),\n" +
                    "    ('Mamadou Samassa', 16, 'Kaleci', 'Mali'),\n" +
                    "    ('Erdoğan Yeşilyurt', 16, 'Defans', 'Turkey'),\n" +
                    "    ('Ziya Erdal', 16, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Caner Osmanpaşa', 16, 'Defans', 'Turkey'),\n" +
                    "    ('Muammer Yıldırım', 16, 'Defans', 'Turkey'),\n" +
                    "    ('Uğur Çiftçi', 16, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Aaron Appindangoyé', 16, 'Defans', 'Gabon'),\n" +
                    "    ('Claude Gonçalves', 16, 'Orta Saha', 'Portugal'),\n" +
                    "    ('Sergiy Rybalka', 16, 'Forvet', 'Ukraine');\n" );


            oyuncuekle += statement.executeUpdate( "INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Umut Bulut', 17, 'Forvet', 'Turkey'),\n" +
                    "    ('Adem Büyük', 17, 'Forvet', 'Turkey'),\n" +
                    "    ('Olcay Şahan', 17, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Erkan Kaş', 17, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Eray İşcan', 17, 'Kaleci', 'Turkey'),\n" +
                    "    ('Issam Chebake', 17, 'Defans', 'Morocco'),\n" +
                    "    ('Ahmet Çalık', 17, 'Defans', 'Turkey'),\n" +
                    "    ('Feghouli', 17, 'Orta Saha', 'Algeria'),\n" +
                    "    ('Christian Cueva', 17, 'Orta Saha', 'Peru'),\n" +
                    "    ('Wallace', 17, 'Defans', 'Brazil'),\n" +
                    "    ('Lucas Biglia', 17, 'Orta Saha', 'Argentina');\n");

            oyuncuekle += statement.executeUpdate(  "INSERT INTO Player (player_name, team_id, position, nationality) VALUES\n" +
                    "    ('Bilal Başacıkoğlu', 18, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Fabrício Baiano', 18, 'Defans', 'Brazil'),\n" +
                    "    ('Montassar Talbi', 18, 'Defans', 'Tunisia'),\n" +
                    "    ('Doğan Erdoğan', 18, 'Kaleci', 'Turkey'),\n" +
                    "    ('Mykola Moroziuk', 18, 'Defans', 'Ukraine'),\n" +
                    "    ('Yasin Pehlivan', 18, 'Orta Saha', 'Austria'),\n" +
                    "    ('Andreas Beck', 18, 'Defans', 'Germany'),\n" +
                    "    ('Dario Melnjak', 18, 'Defans', 'Croatia'),\n" +
                    "    ('Loic Rémy', 18, 'Forvet', 'France'),\n" +
                    "    ('Ridvan Yilmaz', 18, 'Orta Saha', 'Turkey'),\n" +
                    "    ('Aminu Umar', 18, 'Forvet', 'Nigeria');");





        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void add_stats(){//player_stats tablosunu rasgele istenilen şans oranlarıyla rasgele doldurur(Create_Player sınıfında şansları düzenleyebilirsiniz).
        try {
            statement = con.createStatement();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {

            boolean check=false;
            ResultSet fs = statement.executeQuery("show tables");
            while(fs.next()){
                if("playerstats".equals(fs.getString(1))){
                    check=true;
                }
            }
            if(check){//önceki oyundan kalma team tablosu varsa sil
                int as=statement.executeUpdate("drop table playerstats");
            }
            int ds=statement.executeUpdate("CREATE TABLE PlayerStats (\n" +
                    "    player_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    player_name VARCHAR(255),\n" +
                    "    acceleration INT,\n" +
                    "    agility INT,\n" +
                    "    balance INT,\n" +
                    "    jumping_Reach INT,\n" +
                    "    natural_Fitness INT,\n" +
                    "    pace INT,\n" +
                    "    stamina INT,\n" +
                    "    strength INT,\n" +
                    "    corners INT,\n" +
                    "    crossing INT,\n" +
                    "    dribbling INT,\n" +
                    "    finishing INT,\n" +
                    "    first_Touch INT,\n" +
                    "    free_Kick_Taking INT,\n" +
                    "    heading INT,\n" +
                    "    long_Shots INT,\n" +
                    "    long_Throws INT,\n" +
                    "    marking INT,\n" +
                    "    passing INT,\n" +
                    "    penalty_taking INT,\n" +
                    "    tackling INT,\n" +
                    "    technique INT,\n" +
                    "    aggression INT,\n" +
                    "    anticipation INT,\n" +
                    "    bravery INT,\n" +
                    "    composure INT,\n" +
                    "    concentration INT,\n" +
                    "    decisions INT,\n" +
                    "    determination INT,\n" +
                    "    flair INT,\n" +
                    "    leadership INT,\n" +
                    "    off_The_Ball INT,\n" +
                    "    positioning INT,\n" +
                    "    teamwork INT,\n" +
                    "    vision INT,\n" +
                    "    work_Rate INT,\n" +
                    "    aerial_Reach INT,\n" +
                    "    command_Of_Area INT,\n" +
                    "    communication INT,\n" +
                    "    eccentricity INT,\n" +
                    "    handling INT,\n" +
                    "    kicking INT,\n" +
                    "    one_On_Ones INT,\n" +
                    "    punching INT,\n" +
                    "    reflexes INT,\n" +
                    "    rushing_Out INT,\n" +
                    "    throwing INT\n" +
                    ");");


            ResultSet rs=statement.executeQuery("SELECT * from player");

            String []positions=new String[get_count_satir()];
            String []names=new String[get_count_satir()];
            int i=0;
            int j=0;

            while(rs.next()){
                positions[i++]=rs.getString("position");
                names[j++]=rs.getString("player_name");

            }

            for(int l=0;l<get_count_satir();l++){

                if("Kaleci".equals(positions[l])){
                    GoalKeeper kaleci=Create_Player.Create(new GoalKeeper());
                    System.out.println("Kaleci oluştu!");
                    int kalecistats = statement.executeUpdate("INSERT INTO playerstats (player_name,acceleration,agility,balance,jumping_Reach,natural_Fitness,pace,stamina,strength,corners,crossing,dribbling,finishing, first_Touch,free_Kick_Taking,heading,long_Shots,long_Throws,marking,passing,penalty_taking,tackling,technique,aggression,anticipation,bravery,composure,concentration,decisions,determination,flair,leadership,off_The_Ball,positioning,teamwork,vision,work_Rate,aerial_Reach,command_Of_Area,communication,eccentricity,handling,kicking,one_On_Ones,punching,reflexes,rushing_Out,throwing) VALUES ('"+names[l]+ "','"+ kaleci.physical_Features.getAcceleration() + "','" + kaleci.physical_Features.getAgility() + "','" + kaleci.physical_Features.getBalance() + "','" + kaleci.physical_Features.getJumping_Reach() + "','" + kaleci.physical_Features.getNatural_Fitness() + "','" + kaleci.physical_Features.getPace() + "','" + kaleci.physical_Features.getStamina() + "','" + kaleci.physical_Features.getStrength()+ "','" + 0+ "','" +0+ "','" + 0+"','" + kaleci.technical_Features.getFinishing() + "','" + 0+ "','" + 0 + "','" + 0 + "','"+0 + "','" + 0 + "','" + 0 + "','" + 0+ "','" + 0+"','" +0 + "','" + kaleci.technical_Features.getTechnique() + "','" + kaleci.mental_Features.getAggression()+ "','" + kaleci.mental_Features.getAnticipation() + "','" + kaleci.mental_Features.getBravery() + "','" + kaleci.mental_Features.getComposure() + "','" + kaleci.mental_Features.getConcentration() + "','" + kaleci.mental_Features.getDecisions() + "','" + kaleci.mental_Features.getDetermination() + "','" + kaleci.mental_Features.getFlair() + "','" + kaleci.mental_Features.getLeadership() + "','" + kaleci.mental_Features.getOff_The_Ball() + "','" + kaleci.mental_Features.getPositioning() + "','" + kaleci.mental_Features.getTeamwork() + "','" + kaleci.mental_Features.getVision()+"','" +kaleci.mental_Features.getWork_Rate() + "','" + kaleci.goal_Keeping.getAerial_Reach() + "','" + kaleci.goal_Keeping.getCommand_Of_Area() + "','"+kaleci.goal_Keeping.getCommunication()+"','" + kaleci.goal_Keeping.getEccentricity() + "','" + kaleci.goal_Keeping.getHandling() + "','" + kaleci.goal_Keeping.getKicking() + "','" + kaleci.goal_Keeping.getOne_On_Ones() + "','" + kaleci.goal_Keeping.getPunching() + "','" + kaleci.goal_Keeping.getPassing() + "','" + kaleci.goal_Keeping.getRushing_Out() + "','" + kaleci.goal_Keeping.getThrowing() +"')");

                }

                else if("Forvet".equals(positions[l])){
                    System.out.println("Forvet oluştu!");
                    Attacker forvet=Create_Player.Create(new Attacker());
                    int forverstats = statement.executeUpdate("INSERT INTO playerstats (player_name,acceleration,agility,balance,jumping_Reach,natural_Fitness,pace,stamina,strength,corners,crossing,dribbling,finishing, first_Touch,free_Kick_Taking,heading,long_Shots,long_Throws,marking,passing,penalty_taking,tackling,technique,aggression,anticipation,bravery,composure,concentration,decisions,determination,flair,leadership,off_The_Ball,positioning,teamwork,vision,work_Rate,aerial_Reach,command_Of_Area,communication,eccentricity,handling,kicking,one_On_Ones,punching,reflexes,rushing_Out,throwing) VALUES ('"+names[l]+ "','"+ forvet.physical_Features.getAcceleration() + "','" + forvet.physical_Features.getAgility() + "','" + forvet.physical_Features.getBalance() + "','" + forvet.physical_Features.getJumping_Reach() + "','" + forvet.physical_Features.getNatural_Fitness() + "','" + forvet.physical_Features.getPace() + "','" + forvet.physical_Features.getStamina() + "','" + forvet.physical_Features.getStrength()+ "','" + forvet.technical_Features.getCorners() + "','" + forvet.technical_Features.getCrossing() + "','" + forvet.technical_Features.getDribbling()+"','" + forvet.technical_Features.getFinishing() + "','" + forvet.technical_Features.getFirst_Touch() + "','" + forvet.technical_Features.getFree_Kick_Taking() + "','" + forvet.technical_Features.getHeading() + "','"+forvet.technical_Features.getLong_Shots() + "','" + forvet.technical_Features.getLong_Throws() + "','" + forvet.technical_Features.getMarking() + "','" + forvet.technical_Features.getPassing() + "','" + forvet.technical_Features.getPenalty_taking()+"','" +forvet.technical_Features.getTackling() + "','" + forvet.technical_Features.getTechnique() + "','" + forvet.mental_Features.getAggression()+ "','" + forvet.mental_Features.getAnticipation() + "','" + forvet.mental_Features.getBravery() + "','" + forvet.mental_Features.getComposure() + "','" + forvet.mental_Features.getConcentration() + "','" + forvet.mental_Features.getDecisions() + "','" + forvet.mental_Features.getDetermination() + "','" + forvet.mental_Features.getFlair() + "','" + forvet.mental_Features.getLeadership() + "','" + forvet.mental_Features.getOff_The_Ball() + "','" + forvet.mental_Features.getPositioning() + "','" + forvet.mental_Features.getTeamwork() + "','" + forvet.mental_Features.getVision()+"','" +forvet.mental_Features.getWork_Rate() + "','" + 0 + "','" + 0 + "','"+0+"','" + 0 + "','" + 0 + "','" + 0 + "','" +0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 +"')");

                }

                else if("Orta Saha".equals(positions[l])){
                    System.out.println("Orta Saha oluştu!");
                    Midfielder ortasaha=Create_Player.Create(new Midfielder());
                    int ortasahastats = statement.executeUpdate("INSERT INTO playerstats (player_name,acceleration,agility,balance,jumping_Reach,natural_Fitness,pace,stamina,strength,corners,crossing,dribbling,finishing, first_Touch,free_Kick_Taking,heading,long_Shots,long_Throws,marking,passing,penalty_taking,tackling,technique,aggression,anticipation,bravery,composure,concentration,decisions,determination,flair,leadership,off_The_Ball,positioning,teamwork,vision,work_Rate,aerial_Reach,command_Of_Area,communication,eccentricity,handling,kicking,one_On_Ones,punching,reflexes,rushing_Out,throwing) VALUES ('"+names[l]+ "','"+ ortasaha.physical_Features.getAcceleration() + "','" + ortasaha.physical_Features.getAgility() + "','" + ortasaha.physical_Features.getBalance() + "','" + ortasaha.physical_Features.getJumping_Reach() + "','" + ortasaha.physical_Features.getNatural_Fitness() + "','" + ortasaha.physical_Features.getPace() + "','" + ortasaha.physical_Features.getStamina() + "','" + ortasaha.physical_Features.getStrength()+ "','" + ortasaha.technical_Features.getCorners() + "','" + ortasaha.technical_Features.getCrossing() + "','" + ortasaha.technical_Features.getDribbling()+"','" + ortasaha.technical_Features.getFinishing() + "','" + ortasaha.technical_Features.getFirst_Touch() + "','" + ortasaha.technical_Features.getFree_Kick_Taking() + "','" + ortasaha.technical_Features.getHeading() + "','"+ortasaha.technical_Features.getLong_Shots() + "','" + ortasaha.technical_Features.getLong_Throws() + "','" + ortasaha.technical_Features.getMarking() + "','" + ortasaha.technical_Features.getPassing() + "','" + ortasaha.technical_Features.getPenalty_taking()+"','" +ortasaha.technical_Features.getTackling() + "','" + ortasaha.technical_Features.getTechnique() + "','" + ortasaha.mental_Features.getAggression()+ "','" + ortasaha.mental_Features.getAnticipation() + "','" + ortasaha.mental_Features.getBravery() + "','" + ortasaha.mental_Features.getComposure() + "','" + ortasaha.mental_Features.getConcentration() + "','" + ortasaha.mental_Features.getDecisions() + "','" + ortasaha.mental_Features.getDetermination() + "','" + ortasaha.mental_Features.getFlair() + "','" + ortasaha.mental_Features.getLeadership() + "','" + ortasaha.mental_Features.getOff_The_Ball() + "','" + ortasaha.mental_Features.getPositioning() + "','" + ortasaha.mental_Features.getTeamwork() + "','" + ortasaha.mental_Features.getVision()+"','" +ortasaha.mental_Features.getWork_Rate() + "','" + 0 + "','" + 0 + "','"+0+"','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" + 0 + "','" +0 + "','" + 0 + "','" + 0 +"')");

                }

                else {
                    System.out.println("Defans oluştu!");
                    Defender defans=Create_Player.Create(new Defender());
                    int defansstats = statement.executeUpdate("INSERT INTO playerstats (player_name,acceleration,agility,balance,jumping_Reach,natural_Fitness,pace,stamina,strength,corners,crossing,dribbling,finishing, first_Touch,free_Kick_Taking,heading,long_Shots,long_Throws,marking,passing,penalty_taking,tackling,technique,aggression,anticipation,bravery,composure,concentration,decisions,determination,flair,leadership,off_The_Ball,positioning,teamwork,vision,work_Rate,aerial_Reach,command_Of_Area,communication,eccentricity,handling,kicking,one_On_Ones,punching,reflexes,rushing_Out,throwing) VALUES ('"+names[l]+ "','"+ defans.physical_Features.getAcceleration() + "','" + defans.physical_Features.getAgility() + "','" + defans.physical_Features.getBalance() + "','" + defans.physical_Features.getJumping_Reach() + "','" + defans.physical_Features.getNatural_Fitness() + "','" + defans.physical_Features.getPace() + "','" + defans.physical_Features.getStamina() + "','" + defans.physical_Features.getStrength()+ "','" + defans.technical_Features.getCorners() + "','" + defans.technical_Features.getCrossing() + "','" + defans.technical_Features.getDribbling()+"','" + defans.technical_Features.getFinishing() + "','" + defans.technical_Features.getFirst_Touch() + "','" + defans.technical_Features.getFree_Kick_Taking() + "','" + defans.technical_Features.getHeading() + "','"+defans.technical_Features.getLong_Shots() + "','" + defans.technical_Features.getLong_Throws() + "','" + defans.technical_Features.getMarking() + "','" + defans.technical_Features.getPassing() + "','" + defans.technical_Features.getPenalty_taking()+"','" +defans.technical_Features.getTackling() + "','" + defans.technical_Features.getTechnique() + "','" + defans.mental_Features.getAggression()+ "','" + defans.mental_Features.getAnticipation() + "','" + defans.mental_Features.getBravery() + "','" + defans.mental_Features.getComposure() + "','" + defans.mental_Features.getConcentration() + "','" + defans.mental_Features.getDecisions() + "','" + defans.mental_Features.getDetermination() + "','" + defans.mental_Features.getFlair() + "','" + defans.mental_Features.getLeadership() + "','" + defans.mental_Features.getOff_The_Ball() + "','" + defans.mental_Features.getPositioning() + "','" + defans.mental_Features.getTeamwork() + "','" + defans.mental_Features.getVision()+"','" +defans.mental_Features.getWork_Rate() + "','" +0 + "','" +0 + "','"+0+"','" + 0 + "','" + 0 + "','" +0 + "','" + 0 + "','" + 0 + "','" +0 + "','" +0 + "','" + 0 +"')");

                }
            }
            String [][] pozisyonlar=new String[198][2];
            ResultSet as= statement.executeQuery("Select * from player");
            int x=0;

            while (as.next()){
                pozisyonlar[x][0]=as.getString("player_id");
                pozisyonlar[x++][1]=as.getString("position");

            }

            int saldirigucu=0;
            int savunmagucu=0;
            int ortasahagucu=0;
            int kalecigucu=0;
            int [][] takimgucleri=new int[18][5];
            String [] teamnames=new String[18];
            ResultSet gk= statement.executeQuery("SELECT  * from team");
            int o=0;
            while (gk.next()){
                teamnames[o++]=gk.getString("team_name");
            }
            for(int k=0;k<18;k++){

                for(int l=0;l<11;l++) {
                    if (pozisyonlar[get_futbolcu_stats(names[(k*11)+l]).get("player_id") - 1][1].equals("Forvet")) {
                        System.out.println("girdi1");
                        saldirigucu += (get_futbolcu_stats(names[(k*11)+l]).get("acceleration") + get_futbolcu_stats(names[(k*11)+l]).get("agility") + get_futbolcu_stats(names[(k*11)+l]).get("balance") + get_futbolcu_stats(names[(k*11)+l]).get("jumping_Reach") + get_futbolcu_stats(names[(k*11)+l]).get("natural_Fitness") + get_futbolcu_stats(names[(k*11)+l]).get("pace") + get_futbolcu_stats(names[(k*11)+l]).get("stamina") + get_futbolcu_stats(names[(k*11)+l]).get("strength") + get_futbolcu_stats(names[(k*11)+l]).get("corners") + get_futbolcu_stats(names[(k*11)+l]).get("crossing") + get_futbolcu_stats(names[(k*11)+l]).get("dribbling") + get_futbolcu_stats(names[(k*11)+l]).get("finishing") + get_futbolcu_stats(names[(k*11)+l]).get("first_Touch") + get_futbolcu_stats(names[(k*11)+l]).get("free_Kick_Taking") + get_futbolcu_stats(names[(k*11)+l]).get("heading") + get_futbolcu_stats(names[(k*11)+l]).get("long_Shots") + get_futbolcu_stats(names[(k*11)+l]).get("marking") + get_futbolcu_stats(names[(k*11)+l]).get("long_Throws") + get_futbolcu_stats(names[(k*11)+l]).get("passing") + get_futbolcu_stats(names[(k*11)+l]).get("penalty_taking") + get_futbolcu_stats(names[(k*11)+l]).get("tackling") + get_futbolcu_stats(names[(k*11)+l]).get("technique") + get_futbolcu_stats(names[(k*11)+l]).get("aggression") + get_futbolcu_stats(names[(k*11)+l]).get("anticipation") + get_futbolcu_stats(names[(k*11)+l]).get("bravery") + get_futbolcu_stats(names[(k*11)+l]).get("composure") + get_futbolcu_stats(names[(k*11)+l]).get("concentration") + get_futbolcu_stats(names[(k*11)+l]).get("decisions") + get_futbolcu_stats(names[(k*11)+l]).get("determination") + get_futbolcu_stats(names[(k*11)+l]).get("flair") + get_futbolcu_stats(names[(k*11)+l]).get("leadership") + get_futbolcu_stats(names[(k*11)+l]).get("off_The_Ball") + get_futbolcu_stats(names[(k*11)+l]).get("positioning") + get_futbolcu_stats(names[(k*11)+l]).get("teamwork") + get_futbolcu_stats(names[(k*11)+l]).get("work_Rate") + get_futbolcu_stats(names[(k*11)+l]).get("vision") + get_futbolcu_stats(names[(k*11)+l]).get("aerial_Reach") + get_futbolcu_stats(names[(k*11)+l]).get("command_Of_Area") + get_futbolcu_stats(names[(k*11)+l]).get("communication") + get_futbolcu_stats(names[(k*11)+l]).get("eccentricity") + get_futbolcu_stats(names[(k*11)+l]).get("handling") + get_futbolcu_stats(names[(k*11)+l]).get("kicking") + get_futbolcu_stats(names[(k*11)+l]).get("one_On_Ones") + get_futbolcu_stats(names[(k*11)+l]).get("punching") + get_futbolcu_stats(names[(k*11)+l]).get("reflexes") + get_futbolcu_stats(names[(k*11)+l]).get("rushing_Out") + get_futbolcu_stats(names[(k*11)+l]).get("throwing"));

                    } else if (pozisyonlar[get_futbolcu_stats(names[k+l]).get("player_id") - 1][1].equals("Orta Saha")) {
                        ortasahagucu += (get_futbolcu_stats(names[(k*11)+l]).get("acceleration") + get_futbolcu_stats(names[(k*11)+l]).get("agility") + get_futbolcu_stats(names[(k*11)+l]).get("balance") + get_futbolcu_stats(names[(k*11)+l]).get("jumping_Reach") + get_futbolcu_stats(names[(k*11)+l]).get("natural_Fitness") + get_futbolcu_stats(names[(k*11)+l]).get("pace") + get_futbolcu_stats(names[(k*11)+l]).get("stamina") + get_futbolcu_stats(names[(k*11)+l]).get("strength") + get_futbolcu_stats(names[(k*11)+l]).get("corners") + get_futbolcu_stats(names[(k*11)+l]).get("crossing") + get_futbolcu_stats(names[(k*11)+l]).get("dribbling") + get_futbolcu_stats(names[(k*11)+l]).get("finishing") + get_futbolcu_stats(names[(k*11)+l]).get("first_Touch") + get_futbolcu_stats(names[(k*11)+l]).get("free_Kick_Taking") + get_futbolcu_stats(names[(k*11)+l]).get("heading") + get_futbolcu_stats(names[(k*11)+l]).get("long_Shots") + get_futbolcu_stats(names[(k*11)+l]).get("marking") + get_futbolcu_stats(names[(k*11)+l]).get("long_Throws") + get_futbolcu_stats(names[(k*11)+l]).get("passing") + get_futbolcu_stats(names[(k*11)+l]).get("penalty_taking") + get_futbolcu_stats(names[(k*11)+l]).get("tackling") + get_futbolcu_stats(names[(k*11)+l]).get("technique") + get_futbolcu_stats(names[(k*11)+l]).get("aggression") + get_futbolcu_stats(names[(k*11)+l]).get("anticipation") + get_futbolcu_stats(names[(k*11)+l]).get("bravery") + get_futbolcu_stats(names[(k*11)+l]).get("composure") + get_futbolcu_stats(names[(k*11)+l]).get("concentration") + get_futbolcu_stats(names[(k*11)+l]).get("decisions") + get_futbolcu_stats(names[(k*11)+l]).get("determination") + get_futbolcu_stats(names[(k*11)+l]).get("flair") + get_futbolcu_stats(names[(k*11)+l]).get("leadership") + get_futbolcu_stats(names[(k*11)+l]).get("off_The_Ball") + get_futbolcu_stats(names[(k*11)+l]).get("positioning") + get_futbolcu_stats(names[(k*11)+l]).get("teamwork") + get_futbolcu_stats(names[(k*11)+l]).get("work_Rate") + get_futbolcu_stats(names[(k*11)+l]).get("vision") + get_futbolcu_stats(names[(k*11)+l]).get("aerial_Reach") + get_futbolcu_stats(names[(k*11)+l]).get("command_Of_Area") + get_futbolcu_stats(names[(k*11)+l]).get("communication") + get_futbolcu_stats(names[(k*11)+l]).get("eccentricity") + get_futbolcu_stats(names[(k*11)+l]).get("handling") + get_futbolcu_stats(names[(k*11)+l]).get("kicking") + get_futbolcu_stats(names[(k*11)+l]).get("one_On_Ones") + get_futbolcu_stats(names[(k*11)+l]).get("punching") + get_futbolcu_stats(names[(k*11)+l]).get("reflexes") + get_futbolcu_stats(names[(k*11)+l]).get("rushing_Out") + get_futbolcu_stats(names[(k*11)+l]).get("throwing"));
                        ///ortasahagucu+=
                    } else if (pozisyonlar[get_futbolcu_stats(names[k+l]).get("player_id") - 1][1].equals("Defans")) {
                        System.out.println("girdi3");

                        savunmagucu +=(get_futbolcu_stats(names[(k*11)+l]).get("acceleration") + get_futbolcu_stats(names[(k*11)+l]).get("agility") + get_futbolcu_stats(names[(k*11)+l]).get("balance") + get_futbolcu_stats(names[(k*11)+l]).get("jumping_Reach") + get_futbolcu_stats(names[(k*11)+l]).get("natural_Fitness") + get_futbolcu_stats(names[(k*11)+l]).get("pace") + get_futbolcu_stats(names[(k*11)+l]).get("stamina") + get_futbolcu_stats(names[(k*11)+l]).get("strength") + get_futbolcu_stats(names[(k*11)+l]).get("corners") + get_futbolcu_stats(names[(k*11)+l]).get("crossing") + get_futbolcu_stats(names[(k*11)+l]).get("dribbling") + get_futbolcu_stats(names[(k*11)+l]).get("finishing") + get_futbolcu_stats(names[(k*11)+l]).get("first_Touch") + get_futbolcu_stats(names[(k*11)+l]).get("free_Kick_Taking") + get_futbolcu_stats(names[(k*11)+l]).get("heading") + get_futbolcu_stats(names[(k*11)+l]).get("long_Shots") + get_futbolcu_stats(names[(k*11)+l]).get("marking") + get_futbolcu_stats(names[(k*11)+l]).get("long_Throws") + get_futbolcu_stats(names[(k*11)+l]).get("passing") + get_futbolcu_stats(names[(k*11)+l]).get("penalty_taking") + get_futbolcu_stats(names[(k*11)+l]).get("tackling") + get_futbolcu_stats(names[(k*11)+l]).get("technique") + get_futbolcu_stats(names[(k*11)+l]).get("aggression") + get_futbolcu_stats(names[(k*11)+l]).get("anticipation") + get_futbolcu_stats(names[(k*11)+l]).get("bravery") + get_futbolcu_stats(names[(k*11)+l]).get("composure") + get_futbolcu_stats(names[(k*11)+l]).get("concentration") + get_futbolcu_stats(names[(k*11)+l]).get("decisions") + get_futbolcu_stats(names[(k*11)+l]).get("determination") + get_futbolcu_stats(names[(k*11)+l]).get("flair") + get_futbolcu_stats(names[(k*11)+l]).get("leadership") + get_futbolcu_stats(names[(k*11)+l]).get("off_The_Ball") + get_futbolcu_stats(names[(k*11)+l]).get("positioning") + get_futbolcu_stats(names[(k*11)+l]).get("teamwork") + get_futbolcu_stats(names[(k*11)+l]).get("work_Rate") + get_futbolcu_stats(names[(k*11)+l]).get("vision") + get_futbolcu_stats(names[(k*11)+l]).get("aerial_Reach") + get_futbolcu_stats(names[(k*11)+l]).get("command_Of_Area") + get_futbolcu_stats(names[(k*11)+l]).get("communication") + get_futbolcu_stats(names[(k*11)+l]).get("eccentricity") + get_futbolcu_stats(names[(k*11)+l]).get("handling") + get_futbolcu_stats(names[(k*11)+l]).get("kicking") + get_futbolcu_stats(names[(k*11)+l]).get("one_On_Ones") + get_futbolcu_stats(names[(k*11)+l]).get("punching") + get_futbolcu_stats(names[(k*11)+l]).get("reflexes") + get_futbolcu_stats(names[(k*11)+l]).get("rushing_Out") + get_futbolcu_stats(names[(k*11)+l]).get("throwing"));

                    } else if(pozisyonlar[get_futbolcu_stats(names[(k*11)+l]).get("player_id") - 1][1].equals("Kaleci")) {
                        System.out.println("girdi4");
                        kalecigucu += (get_futbolcu_stats(names[(k*11)+l]).get("acceleration") + get_futbolcu_stats(names[(k*11)+l]).get("agility") + get_futbolcu_stats(names[(k*11)+l]).get("balance") + get_futbolcu_stats(names[(k*11)+l]).get("jumping_Reach") + get_futbolcu_stats(names[(k*11)+l]).get("natural_Fitness") + get_futbolcu_stats(names[(k*11)+l]).get("pace") + get_futbolcu_stats(names[(k*11)+l]).get("stamina") + get_futbolcu_stats(names[(k*11)+l]).get("strength") + get_futbolcu_stats(names[(k*11)+l]).get("corners") + get_futbolcu_stats(names[(k*11)+l]).get("crossing") + get_futbolcu_stats(names[(k*11)+l]).get("dribbling") + get_futbolcu_stats(names[(k*11)+l]).get("finishing") + get_futbolcu_stats(names[(k*11)+l]).get("first_Touch") + get_futbolcu_stats(names[(k*11)+l]).get("free_Kick_Taking") + get_futbolcu_stats(names[(k*11)+l]).get("heading") + get_futbolcu_stats(names[(k*11)+l]).get("long_Shots") + get_futbolcu_stats(names[(k*11)+l]).get("marking") + get_futbolcu_stats(names[(k*11)+l]).get("long_Throws") + get_futbolcu_stats(names[(k*11)+l]).get("passing") + get_futbolcu_stats(names[(k*11)+l]).get("penalty_taking") + get_futbolcu_stats(names[(k*11)+l]).get("tackling") + get_futbolcu_stats(names[(k*11)+l]).get("technique") + get_futbolcu_stats(names[(k*11)+l]).get("aggression") + get_futbolcu_stats(names[(k*11)+l]).get("anticipation") + get_futbolcu_stats(names[(k*11)+l]).get("bravery") + get_futbolcu_stats(names[(k*11)+l]).get("composure") + get_futbolcu_stats(names[(k*11)+l]).get("concentration") + get_futbolcu_stats(names[(k*11)+l]).get("decisions") + get_futbolcu_stats(names[(k*11)+l]).get("determination") + get_futbolcu_stats(names[(k*11)+l]).get("flair") + get_futbolcu_stats(names[(k*11)+l]).get("leadership") + get_futbolcu_stats(names[(k*11)+l]).get("off_The_Ball") + get_futbolcu_stats(names[(k*11)+l]).get("positioning") + get_futbolcu_stats(names[(k*11)+l]).get("teamwork") + get_futbolcu_stats(names[(k*11)+l]).get("work_Rate") + get_futbolcu_stats(names[(k*11)+l]).get("vision") + get_futbolcu_stats(names[(k*11)+l]).get("aerial_Reach") + get_futbolcu_stats(names[(k*11)+l]).get("command_Of_Area") + get_futbolcu_stats(names[(k*11)+l]).get("communication") + get_futbolcu_stats(names[(k*11)+l]).get("eccentricity") + get_futbolcu_stats(names[(k*11)+l]).get("handling") + get_futbolcu_stats(names[(k*11)+l]).get("kicking") + get_futbolcu_stats(names[(k*11)+l]).get("one_On_Ones") + get_futbolcu_stats(names[(k*11)+l]).get("punching") + get_futbolcu_stats(names[(k*11)+l]).get("reflexes") + get_futbolcu_stats(names[(k*11)+l]).get("rushing_Out") + get_futbolcu_stats(names[(k*11)+l]).get("throwing"));

                    }

                }
                int temp=statement.executeUpdate("UPDATE team " +
                        "SET saldiri_gucu ="+saldirigucu+", " +
                        "    savunma_gucu = "+savunmagucu+", " +
                        "    ortasaha_gucu =" +ortasahagucu+", " +
                        "    kaleci_gucu = "+kalecigucu+", " +
                        "    takim_gucu = "+(saldirigucu+savunmagucu+ortasahagucu+kalecigucu)+" " +
                        "WHERE team_name = '"+teamnames[k]+"';");
                saldirigucu=0;
                savunmagucu=0;
                ortasahagucu=0;
                kalecigucu=0;

            }

            int takimgucu=saldirigucu+savunmagucu+kalecigucu+ortasahagucu;




        }catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void create_Team(String[] name,String[] country,int[] foundation_Year,String[] Coach){//takımları oluşturur.
        try {
            statement = con.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {

            boolean check2=false;
            ResultSet fs = statement.executeQuery("show tables");
            while(fs.next()){
                if("player".equals(fs.getString(1))){
                    check2=true;
                }
            }
            if(check2){//önceki oyundan kalma team tablosu varsa sil
                int as=statement.executeUpdate("drop table player");
            }


            boolean check=false;
            ResultSet rs = statement.executeQuery("show tables");
            while(rs.next()){
                if("team".equals(rs.getString(1))){
                    check=true;
                }
            }
            if(check){//önceki oyundan kalma team tablosu varsa sil
                int as=statement.executeUpdate("drop table team");
            }
            int ds=statement.executeUpdate("CREATE TABLE team (\n" +
                    "    team_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    team_name VARCHAR(255) NOT NULL,\n" +
                    "    country VARCHAR(100),\n" +
                    "    oynanan_mac INT,\n" +
                    "    Galibiyet INT,\n" +
                    "    Beraberlik VARCHAR(100),\n" +
                    "    Maglubiyet INT,\n" +
                    "    Atilan_gol VARCHAR(100),\n" +
                    "    Yenilen_gol INT,\n" +
                    "    Averaj VARCHAR(100),\n" +
                    "    Puan INT,\n" +
                    "    saldiri_gucu INT,\n" +
                    "    savunma_gucu INT,\n" +
                    "    ortasaha_gucu INT,\n" +
                    "    kaleci_gucu INT,\n" +
                    "    takim_gucu INT,\n" +
                    "    foundation_year INT,\n" +
                    "    coach VARCHAR(100)\n" +
                    ");");

            for(int i=0;i<name.length;i++){

                int as = statement.executeUpdate("INSERT INTO team (team_name,country,oynanan_mac,Galibiyet,Beraberlik,Maglubiyet,Atilan_gol,Yenilen_gol,Averaj,puan,saldiri_gucu,savunma_gucu,ortasaha_gucu,kaleci_gucu,takim_gucu,foundation_year,coach) VALUES ('"+name[i] +"','"+country[i]+"',0,0,0,0,0,0,0,0,0,0,0,0,0,'"+foundation_Year[i]+"','"+Coach[i]+"')");
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void change_stats(String player_Name,String artis_Eksi_1,String degisicek_stats_ismi)  {//Seçilen değeri artırma ve azaltma işlemi yapar.Bu oyundaki statsların
        //Arttırımında ve azaltımında kullanılacaktır.
        try {
            statement = con.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet rs= null;
        try {
            rs = statement.executeQuery("select * from playerstats where player_name ='"+player_Name+"'; ");
            while (rs.next()){
                System.out.println(rs.getInt(degisicek_stats_ismi));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try{
            if(artis_Eksi_1.equals("+")){

                int temp=statement.executeUpdate("UPDATE playerstats SET "+degisicek_stats_ismi+"="+degisicek_stats_ismi+" + 1 WHERE player_name = '"+player_Name+"';");}
            else{
                int temp=statement.executeUpdate("UPDATE playerstats SET "+degisicek_stats_ismi+"="+degisicek_stats_ismi+" - 1 WHERE player_name = '"+player_Name+"';");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String get_position(String name){//pozisyonu verilen oyuncunun pozisyonunu verir.

        try {
            statement = con.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql = "SELECT position FROM player WHERE player_name = ?";

        // SQL sorgusunu hazırlama
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,name); // Aranan oyuncunun adı

            // Sorguyu çalıştırma ve sonuçları alıp işleme
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("position");

            } else {
                return "Oyuncu bulunamadı.";
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void first_arrangement() {//takımları başlangıç olarak rasgele eşleştiriyoruz.

        while (teams.size() != 0) {
            Collections.shuffle(List.of(teams));
            String team1 = teams.get(1);
            String team2 = teams.get(0);
            if (team1 != team2) {
                match_yapacaklar.put(team1, team2);
                teams.remove(team1);
                teams.remove(team2);
            } else {

            }
        }

    }

    public String[][] rotate(String[][] array, int countsatir, int countsutun, String reteam) {//reteam=fonksiyonu çağıran fonksiyon hangi takımı temsil
        //ediyorsa o takımdır(countsatir,counsutun array'deki takımı temsil eder.).
        if (countsatir == 0 && countsutun == 0)//0 0 indexsinde ise 0 1 indexine git.
            rotate(array, 0, 1, null);

        else if (countsatir == 0 && countsutun == 1) {//0 1 index'inde ise o indexteki takımı bir sonraki check fonksiyonuna
            rotate(array, countsatir + 1, countsutun - 1, array[0][1]);//iletiyoruz.
        }

        else if ((countsatir != 0 && countsutun == 0) && countsatir < satir - 1) {//0 stununda fakat 0 satırında değilsek
            String nextreteam = array[countsatir][countsutun];                     //sonraki değeri tutuyoruz ve önceki değeri atıyoruz.
            array[countsatir][countsutun] = reteam;
            rotate(array, countsatir + 1, countsutun, nextreteam);
        }

        else if ((countsatir == satir - 1) && countsutun == 0) {//0 stunu bittiyse 1 stununun son satırına geçiş yapıyoruz.
            //atama işlemleri aynen devam ediyor.
            String nextreteam = array[countsatir][countsutun];
            array[countsatir][countsutun] = reteam;
            rotate(array, countsatir, 1, nextreteam);
        }


        else if (countsatir > 1 && countsutun == 1) {//1 sutunun sonunda başlayıp 1. satıra gelene kadar çağrılıyor.
            //(1,1)'e kadar.
            String nextreteam = array[countsatir][countsutun];
            array[countsatir][countsutun] = reteam;
            rotate(array, countsatir - 1, countsutun, nextreteam);
        }

        else {//(1,1)'e geldi demektir. son 2 işlemi yapıyoruz.(1,1) ve (0,1) takımlarını yerlerine atıyoruz.
            String nextreteam = array[countsatir][countsutun];
            array[countsatir][countsutun] = reteam;//buradaki countsatir ve countsutun 1'dir.
            array[0][1] = nextreteam;
            return array;
        }

        return array;

    }

    public String[][] rematch(Map<String, String> teams) {//arraylist'i array'e atıyoruz.
        String[][] array = new String[9][9];

        for (Map.Entry<String, String> s : teams.entrySet()) {
            array[satir][sutun++] = s.getKey();
            array[satir++][sutun++] = s.getValue();
            sutun = 0;
        }
        //printarray(array);
        return array;
    }

    public String[][] team_matching(ArrayList<String> team,String[][] array,int hafta) {
        String[][] teamsarray=array;
        if(!first) {
            teams=team;
            first_arrangement();
            first=true;
            teamsarray=rematch(match_yapacaklar);
        }

        for (int i = 0; i < 9; i++) {//Maç özellikleri burada atanacak gol ws.
            //yapılacaklar:takımların bilgilerini al(saldırı gucu savunma gucu vb) bunları Player_changede kullanarak gol sayısı belirle.Ona göre takım bilgilerini güncelle.
            //

            int T1=0;
            int T2=0;
            for(int k=0;k<1;k++){
                T1=Player_Chance.goal_Chance(get_Team_stats(teamsarray[i][0],"saldiri_gucu"),get_Team_stats( teamsarray[i][1],"savunma_gucu"));//1.takımın gol sayısı
                T2=Player_Chance.goal_Chance(get_Team_stats(teamsarray[i][1],"saldiri_gucu"),get_Team_stats( teamsarray[i][0],"savunma_gucu"));//2.takımın gol sayısı

                set_team_stats(teamsarray[i][0],"oynanan_mac",1);
                set_team_stats(teamsarray[i][1],"oynanan_mac",1);

                set_team_stats(teamsarray[i][0],"Atilan_gol",T1);
                set_team_stats(teamsarray[i][0],"Yenilen_gol",T2);

                set_team_stats(teamsarray[i][1],"Atilan_gol",T2);
                set_team_stats(teamsarray[i][1],"Yenilen_gol",T1);

                if (T1 > T2) {
                    set_team_stats(teamsarray[i][0],"Galibiyet",1);
                    set_team_stats(teamsarray[i][1],"Maglubiyet",1);

                } else if (T1 < T2) {
                    set_team_stats(teamsarray[i][0],"Maglubiyet",1);
                    set_team_stats(teamsarray[i][1],"Galibiyet",1);
                } else {
                    set_team_stats(teamsarray[i][0],"Beraberlik",1);
                    set_team_stats(teamsarray[i][1],"Beraberlik",1);
                }


            } System.out.println( hafta+". maç " + teamsarray[i][0] + " " + T1 + "-" + T2 + " " + teamsarray[i][1]);
            //  System.out.println(teamsarray[i][0] + "-" +teamsarray[i][1]);
        }
        update_points();
        System.out.println("--------------Sonraki hafta ------------\n\n");
        return teamsarray=rotate(teamsarray,0,0,null);//sonraki hafta için takımları rotate yapıyorum.
    }

    public void set_team_stats(String team,String name_stats,int artismiktari){
        try {
            statement = con.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            int st=statement.executeUpdate("Update team set "+name_stats+"="+name_stats+"+"+artismiktari+" where team_name='"+team+"';");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int get_Team_stats(String team, String stats_name){
        try {
            statement = con.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {

            ResultSet rs=statement.executeQuery("SELECT * FROM team where team_name= '"+team+"';");

            // System.out.println("\n\n\n"+footballer_name+" isimli futbolcunun stats'ları çekildi!\n\t\t|\n\t\t|\n\t\tV");
            int result=0;
            while (rs.next()){
                result=rs.getInt(stats_name);

            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Map<String,Integer> get_futbolcu_stats(String footballer_name){
        Map<String,Integer> degerler=new HashMap<>(48);
        try {
            statement = con.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            String[] columnName= new String[48];
            ResultSet rs=statement.executeQuery("SELECT * FROM playerstats where player_name ='"+ footballer_name+"';");

            String [] stats={"player_id","acceleration", "agility",  "balance", "jumping_Reach", "natural_Fitness", "pace", "stamina", "strength", "corners", "crossing", "dribbling", "finishing", "first_Touch", "free_Kick_Taking", "heading", "long_Shots", "long_Throws", "marking", "passing", "penalty_taking", "tackling", "technique", "aggression", "anticipation", "bravery", "composure", "concentration", "decisions", "determination", "flair", "leadership", "off_The_Ball", "positioning", "teamwork", "vision", "work_Rate", "aerial_Reach", "command_Of_Area", "communication", "eccentricity", "handling", "kicking", "one_On_Ones", "punching", "reflexes", "rushing_Out", "throwing"};
            // System.out.println("\n\n\n"+footballer_name+" isimli futbolcunun stats'ları çekildi!\n\t\t|\n\t\t|\n\t\tV");
            while (rs.next()){
                for(int i=0;i<48;i++){
                    //System.out.println(stats[i]+":"+rs.getInt(stats[i]));
                    degerler.put(stats[i],rs.getInt(stats[i]));
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return degerler;
    }
    public int get_count_satir() {//Veritabanındaki oyuncu sayısını verir.
        try {
            statement = con.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet as = statement.executeQuery("SELECT COUNT(*) AS satir_sayisi FROM player");
            int i = 0;
            while (as.next()) {
                return as.getInt("satir_sayisi");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
    public void update_points(){
        try {
            statement = con.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            int [][] point=new int[18][2];
            ResultSet as = statement.executeQuery("SELECT * from team");
            int i=0,j=0;
            while (as.next()){
                point[i][j++]=as.getInt("Galibiyet");
                point[i++][j--]=as.getInt("Beraberlik");
            }
            String[] team_names =new String[18];
            ResultSet fs = statement.executeQuery("SELECT * from team");
            int p=0;
            while (fs.next()){
                team_names[p++]=fs.getString("team_name");
            }
            for(int k=0;k<18;k++) {

                int rs = statement.executeUpdate("Update team set Puan =" + (Math.multiplyExact(point[k][0],3)+ (point[k][1]))+" where team_name= '"+team_names[k]+"';");
                int hs = statement.executeUpdate("Update team set Averaj =" +(point[k][0]-point[k][1])+";");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public String[][] get_players(){

        String [][] players=new String[198][5];
        try {
            statement = con.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet rs = statement.executeQuery("SELECT player_id, player_name, team_id, position, nationality FROM player");
            while(rs.next())
            {
                int playerId = rs.getInt("player_id");

                players[playerId-1][0]= String.valueOf(playerId);
                players[playerId-1][1]=rs.getString("player_name");
                players[playerId-1][2]= String.valueOf(rs.getInt("team_id"));
                players[playerId-1][3]=rs.getString("position");
                players[playerId-1][4]=rs.getString("nationality");


            }

            return players;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public String[][] get_teams() {
        String [][] teams=new String[18][18];
        try {
            statement = con.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet rs = statement.executeQuery("SELECT team_id, team_name, country, oynanan_mac, Galibiyet,Beraberlik,Maglubiyet,Atilan_gol,Yenilen_gol,Averaj,Puan,Saldiri_gucu,savunma_gucu,ortasaha_gucu,kaleci_gucu,takim_gucu,foundation_year,coach FROM team");

            while(rs.next()){
                int teamId = rs.getInt("team_id");
                teams[teamId-1][0]= String.valueOf(teamId);
                teams[teamId-1][1]=rs.getString("team_name");
                teams[teamId-1][2]=rs.getString("country");
                teams[teamId-1][3]=rs.getString("oynanan_mac");
                teams[teamId-1][4]=rs.getString("Galibiyet");
                teams[teamId-1][5]=rs.getString("Beraberlik");
                teams[teamId-1][6]=rs.getString("Maglubiyet");
                teams[teamId-1][7]=rs.getString("Atilan_gol");
                teams[teamId-1][8]=rs.getString("Yenilen_gol");
                teams[teamId-1][9]=rs.getString("Averaj");
                teams[teamId-1][10]=rs.getString("Puan");
                teams[teamId-1][11]=rs.getString("Saldiri_gucu");
                teams[teamId-1][12]=rs.getString("savunma_gucu");
                teams[teamId-1][13]=rs.getString("ortasaha_gucu");
                teams[teamId-1][14]=rs.getString("kaleci_gucu");
                teams[teamId-1][15]=rs.getString("takim_gucu");
                teams[teamId-1][16]=rs.getString("foundation_year");
                teams[teamId-1][17]=rs.getString("coach");
            }
            return teams;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String get_player_stat(String name,String statsname){
        try {
            statement = con.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet rs = statement.executeQuery("SELECT * from playerstats where player_name= '"+name+"';");
            if(rs.next())
                return String.valueOf(rs.getInt(statsname));
            else {
                return "Böyle bir oyuncu yok.";
            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String [] get_player_stats(String name){
        String[] player=new String[49];
        try {
            statement = con.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {

            ResultSet rs = statement.executeQuery("SELECT * from playerstats where player_name= '"+name+"';");
            if(rs.next()){
                player[0]= String.valueOf(rs.getInt("player_id"));
                player[1]= rs.getString("player_name");
                player[2]= rs.getString("acceleration");
                player[3]= rs.getString("agility");
                player[4]= rs.getString("balance");
                player[5]= rs.getString("jumping_Reach");
                player[6]= rs.getString("natural_Fitness");
                player[7]= rs.getString("pace");
                player[8]= rs.getString("stamina");
                player[9]= rs.getString("strength");
                player[10]= rs.getString("corners");
                player[11]= rs.getString("crossing");
                player[12]= rs.getString("dribbling");
                player[13]= rs.getString("finishing");
                player[14]= rs.getString("first_Touch");
                player[15]= rs.getString("free_Kick_Taking");
                player[16]= rs.getString("heading");
                player[17]= rs.getString("long_Shots");
                player[18]= rs.getString("long_Throws");
                player[19]= rs.getString("marking");
                player[20]= rs.getString("passing");
                player[21]= rs.getString("penalty_taking");
                player[22]= rs.getString("tackling");
                player[23]= rs.getString("technique");
                player[24]= rs.getString("aggression");
                player[25]= rs.getString("anticipation");
                player[26]= rs.getString("bravery");
                player[27]= rs.getString("composure");
                player[28]= rs.getString("concentration");
                player[29]= rs.getString("decisions");
                player[30]= rs.getString("determination");
                player[31]= rs.getString("flair");
                player[32]= rs.getString("leadership");
                player[33]= rs.getString("off_The_Ball");
                player[34]= rs.getString("positioning");
                player[35]= rs.getString("teamwork");
                player[36]= rs.getString("vision");
                player[37]= rs.getString("work_Rate");
                player[38]= rs.getString("aerial_Reach");
                player[39]= rs.getString("command_Of_Area");
                player[40]= rs.getString("communication");
                player[41]= rs.getString("eccentricity");
                player[42]= rs.getString("handling");
                player[43]= rs.getString("kicking");
                player[44]= rs.getString("one_On_Ones");
                player[45]= rs.getString("punching");
                player[46]= rs.getString("reflexes");
                player[47]= rs.getString("rushing_Out");
                player[48]= rs.getString("throwing");

                return player;
                }
            else {
                return new String[]{"Böyle bir oyuncu yok."};
            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

