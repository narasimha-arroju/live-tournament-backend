package com.narasimha.virtusa.livetournament3.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "CricketScores")
public class CricketScore {

	@Id
	@JsonAlias("unique_id")
	@JsonProperty("unique_id")
	private String _id;
	
	private String stat;
	private String score;
	private String description;
	private boolean matchStarted;
	@JsonAlias("team-1")
	private String team_1;
	@JsonAlias("team-2")
	private String team_2;
	private String v;
	private String ttl;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isMatchStarted() {
		return matchStarted;
	}
	public void setMatchStarted(boolean matchStarted) {
		this.matchStarted = matchStarted;
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
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	public String getTtl() {
		return ttl;
	}
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
}
