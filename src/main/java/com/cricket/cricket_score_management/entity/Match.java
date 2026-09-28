package com.cricket.cricket_score_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String team1;
    private String team2;
    private int team1Runs;
    private int team1Wickets;
    private double overs;
    private String status;
    private String venue;
    private String currentBatsman;
    private String currentBowler;

    public Match() {}

    public Match(String team1, String team2, String venue) {
        this.team1 = team1;
        this.team2 = team2;
        this.venue = venue;
        this.status = "LIVE";
    }

    public Long getId() { return id; }

    public String getTeam1() { return team1; }
    public void setTeam1(String team1) { this.team1 = team1; }

    public String getTeam2() { return team2; }
    public void setTeam2(String team2) { this.team2 = team2; }

    public int getTeam1Runs() { return team1Runs; }
    public void setTeam1Runs(int team1Runs) { this.team1Runs = team1Runs; }

    public int getTeam1Wickets() { return team1Wickets; }
    public void setTeam1Wickets(int team1Wickets) { this.team1Wickets = team1Wickets; }

    public double getOvers() { return overs; }
    public void setOvers(double overs) { this.overs = overs; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public String getCurrentBatsman() { return currentBatsman; }
    public void setCurrentBatsman(String currentBatsman) { this.currentBatsman = currentBatsman; }

    public String getCurrentBowler() { return currentBowler; }
    public void setCurrentBowler(String currentBowler) { this.currentBowler = currentBowler; }
}
