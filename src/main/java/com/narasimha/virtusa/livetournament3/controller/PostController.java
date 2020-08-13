package com.narasimha.virtusa.livetournament3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.narasimha.virtusa.livetournament3.model.CricketScore;
import com.narasimha.virtusa.livetournament3.model.CricketSummary;
import com.narasimha.virtusa.livetournament3.model.UpcomingMatch;
import com.narasimha.virtusa.livetournament3.model.UpcomingMatchesObject;
import com.narasimha.virtusa.livetournament3.service.PostService;

@RepositoryRestController
@RequestMapping("/admin")
public class PostController {
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private LiveBroadCastController liveBroadCastController;

    @RequestMapping(method= {RequestMethod.POST,RequestMethod.PUT},value="/cricket/summary")
    private ResponseEntity<?> CricketSummary(@RequestBody CricketSummary cricketSummary) throws Exception{
        postService.addCricketSummary(cricketSummary);
        liveBroadCastController.sendCricketSummary(cricketSummary);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(method= {RequestMethod.POST,RequestMethod.PUT},value="/cricket/matches")
    private ResponseEntity<?> CricketMatches(@RequestBody UpcomingMatchesObject upcomingMatchesObject){
    	for(int i=0;i<upcomingMatchesObject.getMatches().size();i++) {
    		UpcomingMatch upcomingMatch=(UpcomingMatch) upcomingMatchesObject.getMatches().get(i);
    		postService.addMatches(upcomingMatch);
    		//System.out.println(upcomingMatch.toString());
    	}
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT},value="/cricket/score")
    private ResponseEntity<?> CricketScores(@RequestBody CricketScore cricketScore) throws Exception{
    	postService.addCricketScore(cricketScore);
    	liveBroadCastController.sendCricketScore(cricketScore);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
}
