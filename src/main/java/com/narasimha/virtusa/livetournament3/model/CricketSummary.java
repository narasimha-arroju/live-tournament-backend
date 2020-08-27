package com.narasimha.virtusa.livetournament3.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.minidev.json.JSONObject;


@Document(collection="CricketSummaries")
public class CricketSummary {
	
	@Id
	@JsonAlias("unique_id")
	@JsonProperty("unique_id")
	private String _id;
	
	@Field
	private JSONObject summary;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public JSONObject getSummary() {
		return summary;
	}

	public void setSummary(JSONObject summary) {
		this.summary = summary;
	}
}
