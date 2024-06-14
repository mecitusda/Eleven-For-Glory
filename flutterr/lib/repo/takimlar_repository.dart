import 'dart:convert';

import 'package:dio/dio.dart';
import '../data/model/player.dart';
import '../data/model/player_stats.dart';
import '../data/model/team_model.dart';

class TeamsRepository {
  final dio = Dio();

  Future<List<TeamModel>> getTeams() async {
    try {
      final response = await dio.get('http://localhost:8080/get_Teams');
      if (response.statusCode == 200) {
        // response.data'nın JSON olduğundan emin olun
        final json = response.data as List<dynamic>;
        return json.map((e) => TeamModel.fromJson(e)).toList();
      } else {
        throw Exception('Failed to load data: ${response.statusCode}');
      }
    } catch (e) {
      print('Error: ${e.toString()}');
      throw Exception('Failed to load data: $e');
    }
  }

  Future<List<Player>> getPlayers(int id) async {
    List<Player> players = [];
    try {
      final response = await dio.get('http://localhost:8080/get_players');
      if (response.statusCode == 200) {
        // response.data'nın JSON olduğundan emin olun
        final json = response.data as List<dynamic>;
        players = json.map((e) => Player.fromJson(e)).toList();
        return players.where((element) => element.teamId! == id.toString(),).toList();
      } else {
        throw Exception('Failed to load data: ${response.statusCode}');
      }
    } catch (e) {
      print('Error: ${e.toString()}');
      throw Exception('Failed to load data: $e');
    }
  }

   Future<PlayerStats> getPlayerStats(String name) async {
    List<PlayerStats> players = [];
    try {
      final response = await dio.get('http://127.0.0.1:8080/get_Player_Stats?player_name=$name');
      if (response.statusCode == 200) {
        // response.data'nın JSON olduğundan emin olun
        final json = response.data as List<dynamic>;
        //players = json.map((e) => PlayerStats.fromJson(e)).toList();
        return PlayerStats.fromJson(json);
      } else {
        throw Exception('Failed to load data: ${response.statusCode}');
      }
    } catch (e) {
      print('Error: ${e.toString()}');
      throw Exception('Failed to load data: $e');
    }
  }
}
