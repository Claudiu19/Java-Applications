package lab4;

import java.io.Serializable;

public class Manual extends Document implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Manual(String title, String path){
		super(title, path);
	}

}
