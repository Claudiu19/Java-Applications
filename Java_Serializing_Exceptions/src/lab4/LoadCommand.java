package lab4;
import java.io.*;
public class LoadCommand implements Serializable{
	public Catalog load(Catalog c, String path)
	{
		try{
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fis);
			Catalog cat;
			cat = (Catalog)in.readObject();			
			fis.close();
			return cat;
		}
		catch(FileNotFoundException e){
			System.err.println("File " + path + " was not found");
			return c;
		}
		catch(IOException e){
			System.err.println("Couldn't read from file");
			return c;
		}
		catch(ClassNotFoundException e){
			System.err.println("Class [Document] not found");
			return c;
		}
	}
}
