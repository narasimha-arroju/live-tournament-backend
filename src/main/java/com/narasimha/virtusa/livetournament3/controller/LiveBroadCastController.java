package com.narasimha.virtusa.livetournament3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.narasimha.virtusa.livetournament3.model.CricketScore;
import com.narasimha.virtusa.livetournament3.model.CricketSummary;
import com.narasimha.virtusa.livetournament3.model.UpcomingMatch;
import com.narasimha.virtusa.livetournament3.service.GetService;

@Controller
@EnableScheduling
public class LiveBroadCastController {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@Autowired
	private GetService getService;
	
	public void sendCricketScore(CricketScore cricketScore) throws Exception{
		System.out.println("In sendCricketScore()");
		simpMessagingTemplate.convertAndSend("/cricket/scores/"+cricketScore.get_id(),cricketScore);
	}
	
	public void sendCricketSummary(CricketSummary cricketSummary) throws Exception{
		System.out.println("In sendCricketSummary()");
		simpMessagingTemplate.convertAndSend("/cricket/summary/"+cricketSummary.get_id(),cricketSummary);
	}
	
	@Scheduled(fixedRate=2000)
	public void sendMatches() throws Exception{
		System.out.println("In sendMatches()");
		simpMessagingTemplate.convertAndSend("/cricket/matches", getService.getMatches());
	}
	
	@Scheduled(fixedRate = 2000)
	private void sendCricketScores() throws Exception{
		for(UpcomingMatch upcomingMatch:getService.getMatches()) {
			if(getService.getCricketScore(upcomingMatch.get_id())!=null)
				simpMessagingTemplate.convertAndSend("/cricket/scores/"+upcomingMatch.get_id(),getService.getCricketScore(upcomingMatch.get_id()));
		}
		System.out.println("In sendCricketScores()");
	}
	@Scheduled(fixedRate = 2000)
	public void sendCricketSummarys() throws Exception{
		for(UpcomingMatch upcomingMatch:getService.getMatches()) {
			if(upcomingMatch.isMatchStarted() && getService.getCricketScore(upcomingMatch.get_id())!=null)
				simpMessagingTemplate.convertAndSend("/cricket/summary/"+upcomingMatch.get_id(),getService.getCricketSummary(upcomingMatch.get_id()));
		}
		System.out.println("In sendCricketSummarys()");
	}
}
