package lab7;

import java.util.*;

public class Board {
	int numberOfPlayers;
	int playerIndex;
	Game game;
	private ArrayList<String> words = new ArrayList<>(100);

	public ArrayList<String> getWords() {
		return words;
	}

	public void setWords(ArrayList<String> words) {
		this.words = words;
	}
	
	public synchronized void addWord(Player player, String word)
	{
		System.out.println( "Board - next player: " + game.getPlayers().get( playerIndex ).getName());
		words.add(word);
		System.out.println(player.getName() + " added the word \"" + word + "\"");
		System.out.println();
		setNextPlayer();
	}
	public Board(Game game)
	{
		numberOfPlayers = 0;
		playerIndex = 0;
		this.game = game;
	}
	
	public void newPlayer()
	{
		numberOfPlayers = numberOfPlayers + 1;
	}
	
	public int getNumPlayers()
	{
		return numberOfPlayers;
	}
	
	private void setNextPlayer()
    {
        playerIndex++;
        if ( playerIndex == numberOfPlayers )
            playerIndex = 0;
    }
	
	public int getPlayerIndex()
	{
		return playerIndex;
	}
}
