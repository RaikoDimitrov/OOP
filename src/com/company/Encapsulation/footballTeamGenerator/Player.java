package com.company.Encapsulation.footballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
       this.setName(name);
       this.setEndurance(endurance);
       this.setSprint(sprint);
       this.setDribble(dribble);
       this.setPassing(passing);
       this.setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.equals("null")) {
            throw new IllegalArgumentException("Name should not be empty");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        checkStats(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        checkStats(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        checkStats(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        checkStats(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        checkStats(shooting, "Shooting");
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.00;
    }
    private void checkStats(int stats, String statName) {
        if (stats < 0 || stats > 100)
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", statName));
    }
}
