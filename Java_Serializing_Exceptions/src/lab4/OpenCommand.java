package lab4;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class OpenCommand {
	void open(int i, Catalog c)
	{
		ArrayList<Document> documents = c.getDocuments();
		try {
			Desktop desktop = Desktop.getDesktop();
			File file = new File(documents.get(i).getPath());
			desktop.open(file);
		} catch (IOException e) {
			System.err.println("I/O Exception");
			e.printStackTrace();
		}
	}
}
