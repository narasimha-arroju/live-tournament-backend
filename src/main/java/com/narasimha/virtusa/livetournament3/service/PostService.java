package com.narasimha.virtusa.livetournament3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.narasimha.virtusa.livetournament3.model.CricketScore;
import com.narasimha.virtusa.livetournament3.model.CricketSummary;
import com.narasimha.virtusa.livetournament3.model.UpcomingMatch;
import com.narasimha.virtusa.livetournament3.repository.CricketScoresRepository;
import com.narasimha.virtusa.livetournament3.repository.CricketSummaryRepository;
import com.narasimha.virtusa.livetournament3.repository.UpcomingMatchesRepository;

@Service
public class PostService {

    @Autowired
    private CricketSummaryRepository cricketSummaryRepository;

    public void addCricketSummary(CricketSummary cricketSummary){
        cricketSummaryRepository.save(cricketSummary); 
    }

    @Autowired
    private UpcomingMatchesRepository upcomingMatchesRepository;
    
	public void addMatches(UpcomingMatch upcomingMatch) {
		upcomingMatchesRepository.save(upcomingMatch);
	}

	@Autowired
	private CricketScoresRepository cricketScoresRepository;
	
	public void addCricketScore(CricketScore cricketScore) {		
		cricketScoresRepository.save(cricketScore);
	}

}
