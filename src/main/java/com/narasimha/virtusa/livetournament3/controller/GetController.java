package com.narasimha.virtusa.livetournament3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.narasimha.virtusa.livetournament3.model.CricketScore;
import com.narasimha.virtusa.livetournament3.model.CricketSummary;
import com.narasimha.virtusa.livetournament3.model.UpcomingMatch;
import com.narasimha.virtusa.livetournament3.service.GetService;


@RepositoryRestController
@RequestMapping("/cricket")
public class GetController {

	@Autowired
    private GetService getService;

    @GetMapping("/live")
    private @ResponseBody Optional<List<CricketSummary>> getCricketSummary(){
        return Optional.of(getService.getCricketSummary());
    }
    
    @GetMapping("/live/{unique_id}")
    private @ResponseBody Optional<CricketSummary> getCricketLiveScores(@PathVariable String unique_id){
    	return getService.getCricketSummary(unique_id);
    }
    
    @GetMapping("/matches")
    private @ResponseBody List<UpcomingMatch> getUpcomingMatches(){
    	return getService.getMatches();
    }
    
    @GetMapping("/matches/{unique_id}")
    private @ResponseBody Optional<UpcomingMatch> getUpcomingMatches(@PathVariable String unique_id){
    	return getService.getMatches(unique_id);
    }
    
    @GetMapping("/scores/{unique_id}")
    private @ResponseBody Optional<CricketScore> getCricketScore(@PathVariable String unique_id){
    	return getService.getCricketScore(unique_id);
    }
}
