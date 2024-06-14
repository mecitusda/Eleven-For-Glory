import 'package:flutter/material.dart';
import 'package:spring/data/model/player_stats.dart';

import '../../data/model/constant.dart';
import '../../data/model/player.dart';
import '../../repo/takimlar_repository.dart';

class FutbolcuBilgi extends StatefulWidget {
  const FutbolcuBilgi({super.key, required this.player});

  final Player player;

  @override
  State<FutbolcuBilgi> createState() => _FutbolcuBilgiState();
}

class _FutbolcuBilgiState extends State<FutbolcuBilgi> {


  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    //TeamsRepository().getPlayerStats(widget.player.playerName!);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      extendBodyBehindAppBar: true,
      appBar: PreferredSize(
        preferredSize: Size.fromHeight(100),
        child: AppBar(
          title: Column(
            children: [
              Center(
                child: Text(
                  'Futbolcu Kariyer Modu',
                  style: TextStyle(color: Colors.white),
                ),
              ),
            ],
          ),
          centerTitle: true,
          backgroundColor: Colors.transparent,
          elevation: 0,
        ),
      ),
      body: Stack(
        children: [
          // Background image
          Container(
            decoration: BoxDecoration(
              image: DecorationImage(
                image: AssetImage('assets/arkaplanfutbl.jpg'),
                fit: BoxFit.cover,
              ),
            ),
          ),
          FutureBuilder<PlayerStats>(
            future: TeamsRepository().getPlayerStats(widget.player.playerName!),
            builder: (context, snapshot) {
              if (snapshot.connectionState == ConnectionState.waiting) {
                return Center(child: CircularProgressIndicator());
              } else if (snapshot.hasError) {
                return Text('Error: ${snapshot.error}');
              } else if (!snapshot.hasData) {
                return Text('No teams found');
              } else {
                return ListView.builder(
                  itemCount: snapshot.data!.stats.length,
                  itemBuilder: (context, index) {
                    var info = snapshot.data!.stats[index];
                    var header = headers[index];

                    return  _buildSkillRow(
                        header, info);
                  },
                );
              }
            },
          ),

          // Foreground content
          /*SingleChildScrollView(
            child: Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  SizedBox(height: 90), // Space for the AppBar
                  _buildSkillRow(
                      'Hız', speed, (value) => setState(() => speed = value)),
                  _buildSkillRow('Dribbling', dribbling,
                      (value) => setState(() => dribbling = value)),
                  _buildSkillRow('Şut', shooting,
                      (value) => setState(() => shooting = value)),
                  _buildSkillRow('Agresiflik', aggression,
                      (value) => setState(() => aggression = value)),
                  _buildSkillRow('Defans', defense,
                      (value) => setState(() => defense = value)),
                ],
              ),
            ),
          ),*/
        ],
      ),
    );
  }

  Widget _buildSkillRow(String skill, String info) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 10.0),
      child: Container(
        width: double.infinity,
        margin: const EdgeInsets.symmetric(horizontal: 20),
        padding: const EdgeInsets.all(10.0),
        decoration: BoxDecoration(
          color: Colors.black.withOpacity(0.4), // Semi-transparent background
          borderRadius: BorderRadius.circular(10),
        ),
        child: Column(
          children: [
            Text(
              '$skill\n $info ',
              textAlign: TextAlign.center,
              style: TextStyle(
                color: Colors.white,
                fontSize: 15,
                fontWeight: FontWeight.bold,
              ),
            ),

          ],
        ),
      ),
    );
  }
}
