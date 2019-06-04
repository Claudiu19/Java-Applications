package lab4;

import java.util.ArrayList;

public class ListCommand {
	public void list(Catalog c){
		ArrayList<Document> documents = c.getDocuments();
		for(int i=0; i<documents.size(); i++)
		{
			System.out.print(documents.get(i).getTitle() + " | " + documents.get(i).getPath());
			if(documents.get(i).getYear() != 0)
				System.out.print(" | " + documents.get(i).getYear() + " | ");
			if(!documents.get(i).getAuthors().isEmpty())
				System.out.print(documents.get(i).getAuthors());
			System.out.println("");
		}
	}
}
