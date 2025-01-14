package Encapsulation.footballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Team> teams = new LinkedHashMap<>();
        String input = reader.readLine();

        while (!input.equals("END")) {
            String[] commandParts = input.split(";");
            String command = commandParts[0];
            String teamName = commandParts[1];
            try {
                switch (command) {
                    case "Team":
                        teams.putIfAbsent(teamName, new Team(teamName));
                        break;
                    case "Add":
                        String playerName = commandParts[2];
                        int endurance = Integer.parseInt(commandParts[3]);
                        int sprint = Integer.parseInt(commandParts[4]);
                        int dribble = Integer.parseInt(commandParts[5]);
                        int passing = Integer.parseInt(commandParts[6]);
                        int shooting = Integer.parseInt(commandParts[7]);
                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        if (teams.containsKey(teamName)) {
                            teams.get(teamName).addPlayer(player);
                        } else System.out.printf("Team %s does not exist%n", teamName);
                        break;
                    case "Remove":
                        String removedPlayer = commandParts[2];
                        teams.get(teamName).removePlayer(removedPlayer);
                        break;
                    case "Rating":
                        if (teams.containsKey(teamName)) {
                            double rating = Math.round(teams.get(teamName).getRating());
                            System.out.printf("%s - %.0f%n", teamName, rating);
                        } else {
                            System.out.printf("Team %s does not exist.%n", teamName);
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = reader.readLine();
        }

    }
}
