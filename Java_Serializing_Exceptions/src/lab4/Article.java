package lab4;

import java.io.Serializable;
import java.util.ArrayList;

public class Article extends Document implements Serializable{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Article(String title, String path, int year, ArrayList<String> authors) throws NegativeNumException{
		super(title, path, year, authors);
	}

}
