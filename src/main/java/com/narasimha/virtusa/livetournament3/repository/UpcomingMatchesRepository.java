package com.narasimha.virtusa.livetournament3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.narasimha.virtusa.livetournament3.model.UpcomingMatch;

@RepositoryRestResource(collectionResourceRel ="UpcomingMatches")
public interface UpcomingMatchesRepository extends MongoRepository<UpcomingMatch,String>{

}
