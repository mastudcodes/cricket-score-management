package com.cricket.cricket_score_management.entity;

import jakarta.persistence.*;

@Entity
public class MatchEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long matchId;
    private int runs;
    private boolean wicket;
    private String eventType;
    private String description;

    public MatchEvent() {}

    public MatchEvent(Long matchId, int runs, boolean wicket,
                      String eventType, String description) {
        this.matchId = matchId;
        this.runs = runs;
        this.wicket = wicket;
        this.eventType = eventType;
        this.description = description;
    }

    public Long getId() { return id; }

    public Long getMatchId() { return matchId; }
    public void setMatchId(Long matchId) { this.matchId = matchId; }

    public int getRuns() { return runs; }
    public void setRuns(int runs) { this.runs = runs; }

    public boolean isWicket() { return wicket; }
    public void setWicket(boolean wicket) { this.wicket = wicket; }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
