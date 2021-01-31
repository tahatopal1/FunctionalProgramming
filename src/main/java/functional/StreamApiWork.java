package functional;

import constants.Game;
import constants.Gender;
import model.Person;
import model.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiWork {
    public static void main(String[] args) {

        List<Player> players = List.of(new Player("Lebron James", 36, Game.BASKETBALL),
                                        new Player("Jimmy Butler", 31, Game.BASKETBALL),
                                        new Player("Cristiano Ronaldo", 35, Game.FOOTBALL),
                                        new Player("Gareth Bale", 32, Game.FOOTBALL),
                                        new Player("Kyrie Irving", 28, Game.BASKETBALL),
                                        new Player("Sami Khedira", 33, Game.FOOTBALL),
                                        new Player("Mohammed Salah", 29, Game.FOOTBALL),
                                        new Player("Anthony Davis", 27, Game.BASKETBALL));


        // Filter
        List<Player> basketballPlayers = players.stream()
                .filter(player -> player.getGame().equals(Game.BASKETBALL))
                .collect(Collectors.toList());

        System.out.println("Here is the basketball players:");
        basketballPlayers.forEach(System.out::println);
        System.out.println();

        // Sort
        System.out.println("Here is the list of players sorted by age");
        players.stream()
                .sorted(Comparator.comparing(Player::getAge).thenComparing(Player::getName).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println();

        // All match
        System.out.print("Are all the players are over 18? ");
        System.out.println(players.stream().allMatch(player -> player.getAge() > 18));
        System.out.println();

        // Any match
        System.out.print("Is there any player under 18? ");
        System.out.println(players.stream().anyMatch(player -> player.getAge() < 18));
        System.out.println();

        // None match
        System.out.print("There is no player named 'John'. Is that true? ");
        System.out.println(players.stream().noneMatch(player -> player.getName().equals("John")));
        System.out.println();

        // Max
        System.out.println("Here is the oldest player in the list:");
        players.stream().max(Comparator.comparing(Player::getAge)).ifPresent(System.out::println);
        System.out.println();

        // Min
        System.out.println("Here is the youngest player in the list:");
        players.stream().max(Comparator.comparing(Player::getAge)).ifPresent(System.out::println);
        System.out.println();

        // Group
        Map<Game, List<Player>> groupByGame = players.stream().collect(Collectors.groupingBy(Player::getGame));

        groupByGame.forEach((game, players1) -> {
            System.out.println(game.name());
            players1.forEach(System.out::println);
            System.out.println();
        });

        // Map
        System.out.println("Here ist the name of oldest basketball player");
        players.stream()
                .filter(player -> player.getGame().equals(Game.BASKETBALL))
                .max(Comparator.comparing(Player::getAge))
                .map(Player::getName)
                .ifPresent(System.out::println);

    }



}
