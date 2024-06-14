class Takimlar {
  String takim_name;
  String resim;

  Takimlar({required this.takim_name, required this.resim});

  factory Takimlar.fromJson(Map<String, dynamic> json) {
    return Takimlar(
      takim_name: json['takim_name'],
      resim: json['resim'],
    );
  }
}


