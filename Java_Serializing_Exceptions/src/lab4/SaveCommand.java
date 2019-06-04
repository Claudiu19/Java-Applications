package lab4;
import java.io.*;
public class SaveCommand implements Serializable{
	public void save(Catalog c, String path) {
		try{
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(c);
			out.flush();
			fos.close();
		}
		catch(FileNotFoundException e){
			System.err.println("File " + path + " was not found");
		}
		catch(IOException e){
			System.err.println("Couldn't write to file");
		}
		
	}
}
