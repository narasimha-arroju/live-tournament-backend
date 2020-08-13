package com.narasimha.virtusa.livetournament3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narasimha.virtusa.livetournament3.model.CricketScore;
import com.narasimha.virtusa.livetournament3.model.CricketSummary;
import com.narasimha.virtusa.livetournament3.model.UpcomingMatch;
import com.narasimha.virtusa.livetournament3.repository.CricketScoresRepository;
import com.narasimha.virtusa.livetournament3.repository.CricketSummaryRepository;
import com.narasimha.virtusa.livetournament3.repository.UpcomingMatchesRepository;


@Service
public class GetService {
	
	@Autowired
	private CricketSummaryRepository cricketSummaryRepository;

	public List<CricketSummary> getCricketSummary() {
		return cricketSummaryRepository.findAll();
	}
	
	public Optional<CricketSummary> getCricketSummary(String unique_id) {
		return cricketSummaryRepository.findById(unique_id);
	}

	@Autowired
	private UpcomingMatchesRepository upcomingMatchesRepository;
	public List<UpcomingMatch> getMatches() {
		return upcomingMatchesRepository.findAll();
	}

	public Optional<UpcomingMatch> getMatches(String unique_id) {
		return upcomingMatchesRepository.findById(unique_id);
	}

	@Autowired
	private CricketScoresRepository cricketScoreRepository;
	
	public Optional<CricketScore> getCricketScore(String unique_id) {
		// TODO Auto-generated method stub
		return cricketScoreRepository.findById(unique_id);
	}
	
}
