class Player {
  String? playerId;
  String? playerName;
  String? teamId;
  String? position;
  String? nationality;

  Player({
    this.playerId,
    this.playerName,
    this.teamId,
    this.position,
    this.nationality,
  });

  factory Player.fromJson(List<dynamic> player) {
    return Player(
      playerId: player[0],
      playerName: player[1],
      teamId: player[2],
      position: player[3],
      nationality: player[4]
    );
  }
}
