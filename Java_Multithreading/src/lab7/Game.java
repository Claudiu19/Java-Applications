package lab7;

import java.util.*;

public class Game extends Thread{
    private Bag bag;
    private Board board;
    private Dictionary dictionary;
    private final List<Player> players = new ArrayList<>();
    public void addPlayer(Player player) {
        players.add(player);
        board.newPlayer();
        player.setIndex(board.getNumPlayers()-1);
        player.setGame(this);
    }
    
    //Create getters and setters
    //Create the method that will start the game: start one thread for each player
	public Bag getBag() {
		return bag;
	}
	public void setBag(Bag bag) {
		this.bag = bag;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Dictionary getDictionary() {
		return dictionary;
	}
	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
	public List<Player> getPlayers() {
		return players;
	}
	
	public void start()
	{
		for(int i = 0;i<players.size();i++)
		{
			new Thread(this.players.get(i)).start();
		}
	}
	
	public static void main(String args[]) {
        Game game = new Game();
        game.setBag(new Bag());
        game.setBoard(new Board(game));
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.addPlayer(new Player("Player 4"));
        game.start();
    }
}
