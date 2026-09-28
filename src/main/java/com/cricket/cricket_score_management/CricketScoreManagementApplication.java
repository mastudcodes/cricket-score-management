package com.cricket.cricket_score_management;

import com.cricket.cricket_score_management.entity.*;
import com.cricket.cricket_score_management.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CricketScoreManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CricketScoreManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner sampleData(
            TeamRepository teamRepository,
            PlayerRepository playerRepository,
            MatchRepository matchRepository,
            MatchEventRepository eventRepository) {

        return args -> {

            if (matchRepository.count() == 0) {

                Team india = teamRepository.save(
                        new Team("India", "IND"));

                Team australia = teamRepository.save(
                        new Team("Australia", "AUS"));

                playerRepository.save(
                        new Player("Rohit Sharma", "Batsman", india.getId()));

                playerRepository.save(
                        new Player("Virat Kohli", "Batsman", india.getId()));

                playerRepository.save(
                        new Player("Jasprit Bumrah", "Bowler", india.getId()));

                playerRepository.save(
                        new Player("Steve Smith", "Batsman", australia.getId()));

                Match match = new Match(
                        "India",
                        "Australia",
                        "Wankhede Stadium");

                match.setTeam1Runs(126);
                match.setTeam1Wickets(3);
                match.setOvers(18.2);
                match.setCurrentBatsman("Virat Kohli");
                match.setCurrentBowler("Pat Cummins");

                Match savedMatch = matchRepository.save(match);

                eventRepository.save(
                        new MatchEvent(
                                savedMatch.getId(),
                                4,
                                false,
                                "FOUR",
                                "Virat Kohli hits a boundary"));

                eventRepository.save(
                        new MatchEvent(
                                savedMatch.getId(),
                                1,
                                false,
                                "RUN",
                                "Single taken"));

                eventRepository.save(
                        new MatchEvent(
                                savedMatch.getId(),
                                0,
                                true,
                                "WICKET",
                                "Batsman dismissed"));
            }
        };
    }
}
