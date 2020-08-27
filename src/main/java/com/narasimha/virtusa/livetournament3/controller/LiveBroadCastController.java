package com.narasimha.virtusa.livetournament3.controller;

import com.narasimha.virtusa.livetournament3.model.CricketScore;
import com.narasimha.virtusa.livetournament3.model.CricketSummary;
import com.narasimha.virtusa.livetournament3.model.UpcomingMatch;
import com.narasimha.virtusa.livetournament3.service.GetService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
@EnableScheduling
public class LiveBroadCastController {

	private final SimpMessagingTemplate simpMessagingTemplate;
	
	private final GetService getService;

	public LiveBroadCastController(SimpMessagingTemplate simpMessagingTemplate, GetService getService) {
		this.simpMessagingTemplate = simpMessagingTemplate;
		this.getService = getService;
	}

	public void sendCricketScore(CricketScore cricketScore) {
		System.out.println("In sendCricketScore()");
		simpMessagingTemplate.convertAndSend("/cricket/scores/"+cricketScore.get_id(),cricketScore);
	}
	
	public void sendCricketSummary(CricketSummary cricketSummary) {
		System.out.println("In sendCricketSummary()");
		simpMessagingTemplate.convertAndSend("/cricket/summary/"+cricketSummary.get_id(),cricketSummary);
	}
	
	@Scheduled(fixedRate=2000)
	public void sendMatches() {
		System.out.println("In sendMatches()");
		simpMessagingTemplate.convertAndSend("/cricket/matches", getService.getMatches());
	}
	
	@Scheduled(fixedRate = 2000)
	private void sendCricketScores() {
		for(UpcomingMatch upcomingMatch:getService.getMatches()) {
			if(getService.getCricketScore(upcomingMatch.get_id()).isPresent())
				simpMessagingTemplate.convertAndSend("/cricket/scores/"+upcomingMatch.get_id(),getService.getCricketScore(upcomingMatch.get_id()));
		}
		System.out.println("In sendCricketScores()");
	}
	@Scheduled(fixedRate = 2000)
	public void sendCricketSummary() {
		for(UpcomingMatch upcomingMatch:getService.getMatches()) {
			if(upcomingMatch.isMatchStarted() && getService.getCricketScore(upcomingMatch.get_id()).isPresent())
				simpMessagingTemplate.convertAndSend("/cricket/summary/"+upcomingMatch.get_id(),getService.getCricketSummary(upcomingMatch.get_id()));
		}
		System.out.println("In sendCricketSummary()");
	}
}
