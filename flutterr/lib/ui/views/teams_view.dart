import 'package:flutter/material.dart';
import 'package:spring/data/model/team_model.dart';
import 'package:spring/ui/views/player.dart';

import '../../repo/takimlar_repository.dart';
import '../../utility.dart';

class TeamsView extends StatefulWidget {
  const TeamsView({super.key});

  @override
  State<TeamsView> createState() => _TeamsViewState();
}

class _TeamsViewState extends State<TeamsView> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: FutureBuilder<List<TeamModel>>(
        future: TeamsRepository().getTeams(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator());
          } else if (snapshot.hasError) {
            return Text('Error: ${snapshot.error}');
          } else if (!snapshot.hasData || snapshot.data!.isEmpty) {
            return const Text('No data found');
          } else {
            return Stack(
              fit: StackFit.expand,
              children: [
                /*FittedBox(
                    fit: BoxFit.fill,
                    child: Image.asset('assets/arkaplan22.jpg')),*/
                Padding(
                  padding: const EdgeInsets.all(15.0),
                  child: SingleChildScrollView(
                    child: DataTable(
                      headingRowColor: WidgetStateProperty.all(Colors.grey[400]),
                      headingTextStyle: TextStyle(fontWeight: FontWeight.bold),
                      border: TableBorder.all(),
                      columns: [
                        DataColumn(label: Text('Takımlar')),
                        DataColumn(label: Text('O')),
                        DataColumn(label: Text('G')),
                        DataColumn(label: Text('B')),
                        DataColumn(label: Text('M')),
                        DataColumn(label: Text('AG')),
                        DataColumn(label: Text('YG')),
                        DataColumn(label: Text('AV')),
                        DataColumn(label: Text('Puan')),
                      ],
                      rows: snapshot.data!.map((team) {
                        return DataRow(cells: [
                          DataCell(GestureDetector(
                            onTap: () => Navigator.push(context, MaterialPageRoute(builder: (context) => PlayerView(id: int.parse(team.teamId!),),)),
                            child: Row(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Image.asset(
                                  Utility.setLogo(team.teamName!),
                                  width: 40,
                                  height: 40,
                                ),
                                SizedBox(width: 20,),
                                Text(team.teamName!)
                              ],
                            ),
                          )),
                          DataCell(Text(team.oynananMac!.toString())),
                          DataCell(Text(team.galibiyet!.toString())),
                          DataCell(Text(team.beraberlik.toString())),
                          DataCell(Text(team.maglubiyet.toString())),
                          DataCell(Text(team.atilanGol.toString())),
                          DataCell(Text(team.yenilenGol.toString())),
                          DataCell(Text(team.averaj.toString())),
                          DataCell(Text(team.puan.toString())),
                        ]);
                      }).toList(),
                    ),
                  ),
                ),
                /*ListView.builder(
                  itemCount: snapshot.data!.length,
                  itemBuilder: (context, index) {
                    var team = snapshot.data![index];
                    return Padding(
                      padding: const EdgeInsets.all( 10.0),
                      child: GestureDetector(
                        onTap: () {
                          Navigator.push(context, MaterialPageRoute(builder: (context) => PlayerView(id: int.parse(team.teamId!),),));
                        },
                        child: ListTile(
                          leading: Image.asset(Utility.setLogo(team.teamName!)),
                          title: Text(team.teamName!, style: TextStyle(color: Colors.white)),
                        ),
                      ),
                    );
                  },
                )*/
              ],
            );
          }
        },
      ),
    );
  }
}
