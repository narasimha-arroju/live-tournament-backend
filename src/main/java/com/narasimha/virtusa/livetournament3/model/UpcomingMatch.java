package com.narasimha.virtusa.livetournament3.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="UpcomingMatches")
public class UpcomingMatch {
	
	@Id
	@JsonAlias("unique_id")
	@JsonProperty("unique_id")
	private String _id;
	private String date;
	private String dateTimeGMT;
	@JsonAlias("team-1")
	private String team_1;
	@JsonAlias("team-2")
	private String team_2;
	private String type;
	private boolean squad;
	private String toss_winner_team;
	private boolean matchStarted;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDateTimeGMT() {
		return dateTimeGMT;
	}
	public void setDateTimeGMT(String dateTimeGMT) {
		this.dateTimeGMT = dateTimeGMT;
	}
	public String getTeam_1() {
		return team_1;
	}
	public void setTeam_1(String team_1) {
		this.team_1 = team_1;
	}
	public String getTeam_2() {
		return team_2;
	}
	public void setTeam_2(String team_2) {
		this.team_2 = team_2;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isSquad() {
		return squad;
	}
	public void setSquad(boolean squad) {
		this.squad = squad;
	}
	public String getToss_winner_team() {
		return toss_winner_team;
	}
	public void setToss_winner_team(String toss_winner_team) {
		this.toss_winner_team = toss_winner_team;
	}
	public boolean isMatchStarted() {
		return matchStarted;
	}
	public void setMatchStarted(boolean matchStarted) {
		this.matchStarted = matchStarted;
	}
	@Override
	public String toString() {
		return "UpcomingMatch [_id=" + _id + ", date=" + date + ", dateTimeGMT=" + dateTimeGMT + ", team_1=" + team_1
				+ ", team_2=" + team_2 + ", type=" + type + ", squad=" + squad + ", toss_winner_team="
				+ toss_winner_team + ", matchStarted=" + matchStarted + "]";
	}

	
}
