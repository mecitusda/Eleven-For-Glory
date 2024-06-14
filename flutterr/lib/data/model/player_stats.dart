class PlayerStats {
  List<String> stats;

  PlayerStats({required this.stats});

  factory PlayerStats.fromJson(List<dynamic> stats){
    List<String> data = [];
    stats.forEach((element) => data.add(element),);
    return PlayerStats(stats: data);
  }
}


/*
String playerId;
String playerName;
String acceleration;
String agility;
String balance;
String jumpingReach;
String naturalFitness;
String pace;
String stamina;
String strength;
String corners;
String crossing;
String dribbling;
String finishing;
String firstTouch;
String freeKickTaking;
String heading;
String longShots;
String longThrows;
String marking;
String passing;
String penaltyTaking;
String tackling;
String technique;
String aggression;
String anticipation;
String bravery;
String composure;
String concentration;
String decisions;
String determination;
String flair;
String leadership;
String offTheBall;
String positioning;
String teamwork;
String vision;
String workRate;
String aerialReach;
String commandOfArea;
String communication;
String eccentricity;
String handling;
String kicking;
String oneOnOnes;
String punching;
String reflexes;
String rushingOut;
String throwing;

PlayerStats(
    {required this.playerId,
      required this.playerName,
      required this.acceleration,
      required this.agility,
      required this.balance,
      required this.jumpingReach,
      required this.naturalFitness,
      required this.pace,
      required this.stamina,
      required this.strength,
      required this.corners,
      required this.crossing,
      required this.dribbling,
      required this.finishing,
      required this.firstTouch,
      required this.freeKickTaking,
      required this.heading,
      required this.longShots,
      required this.longThrows,
      required this.marking,
      required this.passing,
      required this.penaltyTaking,
      required this.tackling,
      required this.technique,
      required this.aggression,
      required this.anticipation,
      required this.bravery,
      required this.composure,
      required this.concentration,
      required this.decisions,
      required this.determination,
      required this.flair,
      required this.leadership,
      required this.offTheBall,
      required this.positioning,
      required this.teamwork,
      required this.vision,
      required this.workRate,
      required this.aerialReach,
      required this.commandOfArea,
      required this.communication,
      required this.eccentricity,
      required this.handling,
      required this.kicking,
      required this.oneOnOnes,
      required this.punching,
      required this.reflexes,
      required this.rushingOut,
      required this.throwing});

factory PlayerStats.fromJson(List<dynamic> ps) {
return PlayerStats(
playerId: ps[0],
playerName: ps[1],
acceleration: ps[2],
agility: ps[3],
balance: ps[4],
jumpingReach: ps[5],
naturalFitness: ps[6],
pace: ps[7],
stamina: ps[8],
strength: ps[9],
corners: ps[10],
crossing: ps[11],
dribbling: ps[12],
finishing: ps[13],
firstTouch: ps[14],
freeKickTaking: ps[15],
heading: ps[16],
longShots: ps[17],
longThrows: ps[18],
marking: ps[19],
passing: ps[20],
penaltyTaking: ps[21],
tackling: ps[22],
technique: ps[23],
aggression: ps[24],
anticipation: ps[25],
bravery: ps[26],
composure: ps[27],
concentration: ps[28],
decisions: ps[29],
determination: ps[30],
flair: ps[31],
leadership: ps[32],
offTheBall: ps[33],
positioning: ps[34],
teamwork: ps[35],
vision: ps[36],
workRate: ps[37],
aerialReach: ps[38],
commandOfArea: ps[39],
communication: ps[40],
eccentricity: ps[41],
handling: ps[42],
kicking: ps[43],
oneOnOnes: ps[44],
punching: ps[45],
reflexes: ps[46],
rushingOut: ps[47],
throwing: ps[48],
);
}
*/