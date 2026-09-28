async function loadMatch() {

    const response = await fetch('/api/matches');
    const matches = await response.json();

    if (matches.length === 0) {
        return;
    }

    const match = matches[0];

    document.getElementById('teams').textContent =
        `${match.team1} vs ${match.team2}`;

    document.getElementById('runs').textContent =
        match.team1Runs;

    document.getElementById('wickets').textContent =
        match.team1Wickets;

    document.getElementById('overs').textContent =
        `${match.overs} overs`;

    document.getElementById('status').textContent =
        match.status;

    document.getElementById('venue').textContent =
        match.venue;

    document.getElementById('batsman').textContent =
        match.currentBatsman;

    document.getElementById('bowler').textContent =
        match.currentBowler;

    loadEvents(match.id);
}

async function loadEvents(matchId) {

    const response =
        await fetch(`/api/matches/${matchId}/events`);

    const events = await response.json();

    const container =
        document.getElementById('events');

    container.innerHTML = '';

    events.forEach(event => {

        const div = document.createElement('div');

        div.className = 'event';

        div.textContent =
            `${event.eventType}: ${event.description} (${event.runs} runs)`;

        container.appendChild(div);
    });
}

loadMatch();

// Refresh score every 5 seconds
setInterval(loadMatch, 5000);
