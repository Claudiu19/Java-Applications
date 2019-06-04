package lab7;

import java.util.*;

public class Player implements Runnable {
    private String name;
    private Game game;
    private int score;
    private int index;
    public void setIndex(int index) {
		this.index = index;
	}
    public Player(String name)
    {
    	this.name=name;
    	this.score = 0;
    }
    private boolean createSubmitWord() throws InterruptedException {
        List<Character> extracted = game.getBag().extractLetters(1);
        if (extracted.isEmpty()) {
        	return false;
        }
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            word.append(extracted.get(0));
        }
        game.getBoard().addWord(this, word.toString());
        Thread.sleep(300);
        return true;
	}
    //implement the run() method, that will repeatedly create and submit words
    //implement the toString() method
    public void run()
    {
    	boolean over = false;
    	while(!(this.game.getBag().getLetters().isEmpty()))
    	{
    		if(this.index == this.game.getBoard().getPlayerIndex())
    		{
    			try
            	{
            		if(this.createSubmitWord() == false)
            		{
            			over = true;
            			System.out.println(this.getName() + " is out with the score " + this.score + "!");
            			System.out.println("");
            		}
            		else
            		{
            			score = score + 5;
            		}
            	}
            	catch(InterruptedException e)
            	{
            		System.out.println(this.getName() + " is out with the score " + this.score + "!");
            	}
    		}
    	}
    	if(!(over))
    	{
    		System.out.println(this.getName() + " is out with the score " + this.score + "!");
    		System.out.println("");
    	}
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	@Override
	public String toString() {
		return name + ": " + score;
	}
}
