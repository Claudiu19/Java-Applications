package lab4;

import java.util.ArrayList;

public class AddCommand {
	public Catalog add(Document doc, Catalog c){
		ArrayList<Document> documents=c.getDocuments();
		documents.add(doc);
		c.setDocuments(documents);
		return c;
	}
}
