package main;

import Classes.Action.Action;
import Classes.Action.PlaceCard;
import Classes.Decks;
import Classes.Game;
import Classes.Player;
import Classes.StartGame;
import checker.Checker;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import checker.CheckerConstants;
import com.fasterxml.jackson.databind.node.BaseJsonNode;
import fileio.CardInput;
import fileio.Input;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

/**
 * The entry point to this homework. It runs the checker that tests your implentation.
 */
public final class Main {
    /**
     * for coding style
     */
    private Main() {
    }

    /**
     * DO NOT MODIFY MAIN METHOD
     * Call the checker
     * @param args from command line
     * @throws IOException in case of exceptions to reading / writing
     */
    public static void main(final String[] args) throws IOException {
        File directory = new File(CheckerConstants.TESTS_PATH);
        Path path = Paths.get(CheckerConstants.RESULT_PATH);

        if (Files.exists(path)) {
            File resultFile = new File(String.valueOf(path));
            for (File file : Objects.requireNonNull(resultFile.listFiles())) {
                file.delete();
            }
            resultFile.delete();
        }
        Files.createDirectories(path);

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            String filepath = CheckerConstants.OUT_PATH + file.getName();
            File out = new File(filepath);
            boolean isCreated = out.createNewFile();
            if (isCreated) {
                action(file.getName(), filepath);
            }
        }

        Checker.calculateScore();
    }

    /**
     * @param filePath1 for input file
     * @param filePath2 for output file
     * @throws IOException in case of exceptions to reading / writing
     */
    public static void action(final String filePath1,
                              final String filePath2) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Input inputData = objectMapper.readValue(new File(CheckerConstants.TESTS_PATH + filePath1),
                Input.class);

        ArrayNode output = objectMapper.createArrayNode();

        //TODO add here the entry point to your implementation

        //initialize the two players and the game taking input from the .json files
        Player playerOne = new Player(inputData.getPlayerOneDecks());
        Player playerTwo = new Player(inputData.getPlayerTwoDecks());
        Game game = new Game();

        //we create the decks that the players will use and we mix them
        // Decks deck

        //for the first round of the game, we must add a card to each player's hand and
        //to remove them from the packages

        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        String p;

        for(int i = 0; i < inputData.getGames().size(); i++) {
            game.setCurrentPlayerIdx(inputData.getGames().get(i).getStartGame().getStartingPlayer());
            game.initActionList(inputData.getGames().get(i).getActions());
            game.setStartGame(new StartGame(inputData.getGames().get(i).getStartGame(), playerOne, playerTwo));
            Decks playingPlayer1 = new Decks(playerOne.getDecks().get(game.getStartGame().getPlayerOneDeckIdx()));
            Decks playingPlayer2 = new Decks(playerTwo.getDecks().get(game.getStartGame().getPlayerTwoDeckIdx()));
            Collections.shuffle(playingPlayer1.getCards(), new Random(game.getStartGame().getShuffleSeed()));
            Collections.shuffle(playingPlayer2.getCards(), new Random(game.getStartGame().getShuffleSeed()));
            game.setPlayingPlayerOne(playingPlayer1);
            game.setPlayingPlayerTwo(playingPlayer2);
            playerOne.addInHand(playingPlayer1.getCards().get(0));
            playerOne.setMana(1);
            playerTwo.setMana(1);
            playingPlayer1.getCards().remove(0);
            playerTwo.addInHand(playingPlayer2.getCards().get(0));
            playingPlayer2.getCards().remove(0);
            for(int j = 0; j < game.getActions().size(); j++) {
                // game.getActions().get(j).exec(game, playerOne, playerTwo, playingPlayer1, playingPlayer2);
                if(game.getActions().get(j) instanceof PlaceCard) {
                    if((((PlaceCard) game.getActions().get(j)).getError() != null)) {
                        p = objectWriter.writeValueAsString(game.getActions().get(j));
                        JsonNode n = objectMapper.readTree(p);
                        output.add(n);
                    }
                }
                else if(game.getActions().get(j).getCommand().contains("get")) {
                    p = objectWriter.writeValueAsString(game.getActions().get(j));
                    JsonNode n = objectMapper.readTree(p);
                    output.add(n);
                }
            }
        }
        objectWriter.writeValue(new File(filePath2), output);
    }
}
