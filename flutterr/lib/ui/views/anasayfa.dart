import 'dart:ui';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:spring/data/entity/match.dart';
import 'package:spring/data/entity/takimlar.dart';

import '../../data/model/team_model.dart';

class Anasayfa extends StatefulWidget {
  const Anasayfa({super.key});

  @override
  State<Anasayfa> createState() => _AnasayfaState();
}

class _AnasayfaState extends State<Anasayfa> {
  int matchDay = 1;

  List<Mac> matches = [];

  String setLogo(String teamName) {
    switch(teamName) {
      case 'Fenerbahçe':
        return 'assets/fb.png';
      case 'Alanyaspor':
        return 'assets/alanyaspor.png';
      case 'AnkaraGücü':
        return 'assets/ankaragucu.png';
      case 'Antalya':
        return 'assets/antalya.png';
      case 'İstanbul Başakşehir':
        return 'assets/basaksehir.png';
      case 'Beşiktaş':
        return 'assets/besiktas2.png';
      case 'Denizli':
        return 'assets/denizli.png';
      case 'Göztepe':
        return 'assets/goztepe.png';
      case 'Gençlerbirliği':
        return 'assets/genclerb.png';
      case 'Gaziantep FK':
        return 'assets/gfk.png';
      case 'Galatasaray':
        return 'assets/gs.png';
      case 'Hayatspor':
        return 'Hatayspor.png';
      case 'Kasımpaşa':
        return 'assets/kasimpasa.png';
      case 'Kayserispor':
        return 'assets/kayseri.png';
      case 'Konyaspor':
        return 'assets/konya.png';
      case 'Malatyaspor':
        return 'assets/Malatyaspor.png';
      case 'Rizespor':
        return 'assets/rizespor.png';
      case 'TrabzonSpor':
        return 'assets/ts2.png';
    }
    return '';
  }


  @override
  void initState() {
    super.initState();
    // İlk maç gününü yükle
    updateMatches();

  }

  void updateMatches() {
    // Burada her maç günü için maç listelerini ayarlayabilirsiniz
    // Örnek olarak, matchDay'e göre farklı maç listeleri oluşturuyorum
    if (matchDay == 1) {
      matches = [
        Mac(homeTeam: Takimlar(takim_name: 'Galatasaray', resim: setLogo('Galatasaray')), awayTeam: Takimlar(takim_name: 'Fenerbahçe', resim: setLogo('Fenerbahçe'))),
        Mac(homeTeam: Takimlar(takim_name: 'Beşiktaş', resim: 'assets/besiktas2.png'), awayTeam: Takimlar(takim_name: 'Trabzonspor', resim: 'assets/ts2.png')),
        Mac(homeTeam: Takimlar(takim_name: 'İstanbul Başakşehir', resim: 'assets/basaksehir.png'), awayTeam: Takimlar(takim_name: 'Alanyaspor', resim: 'assets/alanyaspor.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Göztepe', resim: 'assets/goztepe.png'), awayTeam: Takimlar(takim_name: 'Konyaspor', resim: 'assets/konya.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Kasımpaşa', resim: 'assets/kasimpasa.png'), awayTeam: Takimlar(takim_name: 'Antalyaspor', resim: 'assets/antalya.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Gaziantep FK', resim: 'assets/gfk.png'), awayTeam: Takimlar(takim_name: 'Denizlispor', resim: 'assets/denizli.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Gençlerbirliği', resim: 'assets/genclerb.png'), awayTeam: Takimlar(takim_name: 'Rizespor', resim: 'assets/rizespor.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Kayserispor', resim: 'assets/kayseri.png'), awayTeam: Takimlar(takim_name: 'Malatyaspor', resim: 'assets/Malatyaspor.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Ankaragücü', resim: 'assets/ankaragucu.png'), awayTeam: Takimlar(takim_name: 'Hatayspor', resim: 'assets/Hatayspor.png')),
      ];
    } else if (matchDay == 2) {
      matches = [
        Mac(homeTeam: Takimlar(takim_name: 'Galatasaray', resim: 'assets/gs.png'), awayTeam: Takimlar(takim_name: 'Fenerbahçe', resim: 'assets/fb.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Beşiktaş', resim: 'assets/besiktas2.png'), awayTeam: Takimlar(takim_name: 'Trabzonspor', resim: 'assets/ts2.png')),
        Mac(homeTeam: Takimlar(takim_name: 'İstanbul Başakşehir', resim: 'assets/basaksehir.png'), awayTeam: Takimlar(takim_name: 'Alanyaspor', resim: 'assets/alanyaspor.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Göztepe', resim: 'assets/goztepe.png'), awayTeam: Takimlar(takim_name: 'Konyaspor', resim: 'assets/konya.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Kasımpaşa', resim: 'assets/kasimpasa.png'), awayTeam: Takimlar(takim_name: 'Antalyaspor', resim: 'assets/antalya.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Gaziantep FK', resim: 'assets/gfk.png'), awayTeam: Takimlar(takim_name: 'Denizlispor', resim: 'assets/denizli.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Gençlerbirliği', resim: 'assets/genclerb.png'), awayTeam: Takimlar(takim_name: 'Rizespor', resim: 'assets/rizespor.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Kayserispor', resim: 'assets/kayseri.png'), awayTeam: Takimlar(takim_name: 'Malatyaspor', resim: 'assets/Malatyaspor.png')),
      ];
    } else if (matchDay == 3) {
      matches = [
        Mac(homeTeam: Takimlar(takim_name: 'Galatasaray', resim: 'assets/gs.png'), awayTeam: Takimlar(takim_name: 'Fenerbahçe', resim: 'assets/fb.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Beşiktaş', resim: 'assets/besiktas2.png'), awayTeam: Takimlar(takim_name: 'Trabzonspor', resim: 'assets/ts2.png')),
        Mac(homeTeam: Takimlar(takim_name: 'İstanbul Başakşehir', resim: 'assets/basaksehir.png'), awayTeam: Takimlar(takim_name: 'Alanyaspor', resim: 'assets/alanyaspor.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Göztepe', resim: 'assets/goztepe.png'), awayTeam: Takimlar(takim_name: 'Konyaspor', resim: 'assets/konya.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Kasımpaşa', resim: 'assets/kasimpasa.png'), awayTeam: Takimlar(takim_name: 'Antalyaspor', resim: 'assets/antalya.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Gaziantep FK', resim: 'assets/gfk.png'), awayTeam: Takimlar(takim_name: 'Denizlispor', resim: 'assets/denizli.png')),
        Mac(homeTeam: Takimlar(takim_name: 'Gençlerbirliği', resim: 'assets/genclerb.png'), awayTeam: Takimlar(takim_name: 'Rizespor', resim: 'assets/rizespor.png')),
      ];
    }
  }

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      backgroundColor: Colors.black,
      appBar: AppBar(
        backgroundColor: Colors.black,
        title: Text(
          "Maç Günü $matchDay",
          style: GoogleFonts.julee(
              textStyle: const TextStyle(fontSize: 30), color: Colors.white),
        ),
        centerTitle: true,
      ),
      body: Stack(
        children: [
          Positioned.fill(
              child: Image.asset(
                "assets/arkaplan22.jpg",
                fit: BoxFit.cover,
              )),
          Positioned.fill(
            child: ImageFiltered(
              imageFilter: ImageFilter.blur(sigmaX: 5.0, sigmaY: 5.0),
              child: Container(
                decoration: BoxDecoration(
                  color: Color(0xFFFFFF0),
                  borderRadius: BorderRadius.all(const Radius.circular(16.0)),
                  border: Border.all(
                      color: Color(0xFFFFFF0),
                      width: 0.8,
                      style: BorderStyle.solid),
                ),
              ),
            ),
          ),
          Column(
            children: [
              Expanded(child: MatchList(matches: matches)),
              Padding(
                padding: const EdgeInsets.all(8.0),
                child: Container(
                  decoration: BoxDecoration(
                    color: Colors.black,
                    borderRadius: BorderRadius.circular(10.0),
                    border: Border.all(color: Colors.white),
                  ),
                  child: Row(
                    mainAxisSize: MainAxisSize.min,
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      IconButton(
                        icon: Icon(Icons.arrow_upward, color: Colors.white),
                        onPressed: () {
                          setState(() {
                            if (matchDay > 1) matchDay--;
                            updateMatches();
                          });
                        },
                      ),
                      IconButton(
                        icon: Icon(Icons.arrow_downward, color: Colors.white),
                        onPressed: () {
                          setState(() {
                            matchDay++;
                            updateMatches();
                          });
                        },
                      ),
                    ],
                  ),
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}

class MatchList extends StatelessWidget {
  final List<Mac> matches;
  final ScrollController _scrollController = ScrollController();

  MatchList({super.key, required this.matches});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: SingleChildScrollView(
        controller: _scrollController,
        child: Column(
          children: [
            Container(
              decoration: BoxDecoration(
                border: Border.all(color: Colors.white),
              ),
              child: Table(
                columnWidths: {
                  0: FixedColumnWidth(50.0),  // home team logo
                  1: FlexColumnWidth(3.0),   // home team name
                  2: FixedColumnWidth(50.0), // home team score
                  3: FixedColumnWidth(25.0), // separator
                  4: FixedColumnWidth(50.0), // away team score
                  5: FlexColumnWidth(3.0),   // away team name
                  6: FixedColumnWidth(50.0), // away team logo
                },
                defaultVerticalAlignment: TableCellVerticalAlignment.middle,
                children: matches.map((mac) {
                  return TableRow(
                    children: [
                      Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: Image.asset(mac.homeTeam.resim, width: 50, height: 50),
                      ),
                      Container(
                        color: Colors.black54.withOpacity(0.2), // Home team row background
                        padding: const EdgeInsets.all(8.0),
                        child: Text(
                          mac.homeTeam.takim_name,
                          style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
                          textAlign: TextAlign.left,
                        ),
                      ),
                      Container(
                        color: Colors.black54.withOpacity(0.2), // Home team score background
                        padding: const EdgeInsets.all(8.0),
                        child: Text("0"

                          ,
                          style: TextStyle(color: Colors.white),

                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: Text(
                          ' - ',
                          style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
                          textAlign: TextAlign.center,
                        ),
                      ),
                      Container(
                        color: Colors.black54.withOpacity(0.2), // Away team score background
                        padding: const EdgeInsets.all(8.0),
                        child: Text("0"
                          ,
                          style: TextStyle(color: Colors.white),

                        ),
                      ),
                      Container(
                        color: Colors.black54.withOpacity(0.2), // Away team row background
                        padding: const EdgeInsets.all(8.0),
                        child: Text(
                          mac.awayTeam.takim_name,
                          style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
                          textAlign: TextAlign.right,
                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: Image.asset(mac.awayTeam.resim, width: 50, height: 50),
                      ),
                    ],
                  );
                }).toList(),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
