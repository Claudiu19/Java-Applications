package lab4;

import java.util.ArrayList;
import java.io.Serializable;

public class Document implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String title;
	protected String path;
	protected int year;
	protected ArrayList<String> authors = new ArrayList<String>(10);
	
	public Document(String title, String path, int year, ArrayList<String> authors) throws NegativeNumException{
		this.title = title;
		//this.path = Paths.get(path);
		this.path = path;
		this.year = year;
		if (year < 0) throw new NegativeNumException("Negative year");
		for(int i=0; i<authors.size(); i++)
				this.authors.add(authors.get(i));
	}
	
	Document(String title, String path){
		this.title = title;
		this.path = path;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getPath(){
		return this.path;
	}
	
	public int getYear(){
		return this.year;
	}
	
	ArrayList<String> getAuthors(){
		return this.authors;
	}
	
	void copy(Document doc){
		this.title = doc.getTitle();
		this.path = doc.getPath();
		this.year = doc.getYear();
		this.authors = doc.getAuthors();
	}

}

