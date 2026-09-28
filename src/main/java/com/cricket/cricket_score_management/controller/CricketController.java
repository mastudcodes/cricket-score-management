package com.cricket.cricket_score_management.controller;

import com.cricket.cricket_score_management.entity.*;
import com.cricket.cricket_score_management.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CricketController {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;
    private final MatchEventRepository eventRepository;

    public CricketController(
            TeamRepository teamRepository,
            PlayerRepository playerRepository,
            MatchRepository matchRepository,
            MatchEventRepository eventRepository) {

        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
        this.eventRepository = eventRepository;
    }

    @GetMapping("/health")
    public String health() {
        return "Cricket Score Management API is running!";
    }

    @GetMapping("/teams")
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    @PostMapping("/teams")
    public Team addTeam(@RequestBody Team team) {
        return teamRepository.save(team);
    }

    @GetMapping("/players")
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @GetMapping("/matches")
    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    @PostMapping("/matches")
    public Match addMatch(@RequestBody Match match) {
        return matchRepository.save(match);
    }

    @GetMapping("/matches/{id}")
    public Match getMatch(@PathVariable Long id) {
        return matchRepository.findById(id).orElseThrow();
    }

    @PutMapping("/matches/{id}/score")
    public Match updateScore(
            @PathVariable Long id,
            @RequestParam int runs,
            @RequestParam int wickets,
            @RequestParam double overs) {

        Match match = matchRepository.findById(id).orElseThrow();

        match.setTeam1Runs(runs);
        match.setTeam1Wickets(wickets);
        match.setOvers(overs);

        return matchRepository.save(match);
    }

    @GetMapping("/matches/{id}/events")
    public List<MatchEvent> getEvents(@PathVariable Long id) {
        return eventRepository.findByMatchId(id);
    }

    @PostMapping("/matches/{id}/events")
    public MatchEvent addEvent(
            @PathVariable Long id,
            @RequestBody MatchEvent event) {

        event.setMatchId(id);
        return eventRepository.save(event);
    }
}
