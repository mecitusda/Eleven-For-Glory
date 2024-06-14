class TeamModel {
  String? teamId;
  String? teamName;
  String? country;
  String? oynananMac;
  String? galibiyet;
  String? beraberlik;
  String? maglubiyet;
  String? atilanGol;
  String? yenilenGol;
  String? averaj;
  String? puan;
  String? saldiriGucu;
  String? savunmaGucu;
  String? ortasahaGucu;
  String? kaleciGucu;
  String? takimGucu;
  String? foundationYear;
  String? coach;

  TeamModel({
    this.teamId,
    this.teamName,
    this.country,
    this.oynananMac,
    this.galibiyet,
    this.beraberlik,
    this.maglubiyet,
    this.atilanGol,
    this.yenilenGol,
    this.averaj,
    this.puan,
    this.saldiriGucu,
    this.savunmaGucu,
    this.ortasahaGucu,
    this.kaleciGucu,
    this.takimGucu,
    this.foundationYear,
    this.coach,
  });

  factory TeamModel.fromJson(List<dynamic> team) {
    return TeamModel(
        teamId: team[0],
        teamName: team[1],
        country: team[2],
        oynananMac: team[3],
        galibiyet: team[4],
        beraberlik: team[5],
        maglubiyet: team[6],
        atilanGol: team[7],
        yenilenGol: team[8],
        averaj: team[9],
        puan: team[10],
        saldiriGucu: team[11],
        savunmaGucu: team[12],
        ortasahaGucu: team[13],
        kaleciGucu: team[14],
        takimGucu: team[15],
        foundationYear: team[16],
        coach: team[17]
    );
  }
}

