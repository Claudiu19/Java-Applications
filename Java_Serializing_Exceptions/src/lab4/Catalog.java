package lab4;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.awt.Desktop;
import java.util.Scanner;

public class Catalog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Document> documents = new ArrayList<Document>(30);
	
	public ArrayList<Document> getDocuments()
	{
		return this.documents;
	}
	
	public void setDocuments(ArrayList<Document> list)
	{
		this.documents=list;
	}
	
	public static int numberOfSpaces(String a)
	{
		int count=0;
		for(int i=0;i<a.length();i++)
		{
			if(a.charAt(i)==' ') count++;
		}
		return count;
	}
	
	
	public static void main(String[] args) throws NegativeNumException,NumArgumentsException,InvalidCommandException{
		
		Catalog cat = new Catalog();
		SaveCommand s = new SaveCommand();
		LoadCommand l = new LoadCommand();
		ListCommand lst = new ListCommand();
		OpenCommand o = new OpenCommand();
		AddCommand a = new AddCommand();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			try {
				String input = br.readLine();
				System.out.println(input);
				int count=0;
				if(input.indexOf(' ')<0)
				{
					if(input.equals("quit")) break;
					if(input.equals("list")) lst.list(cat);
					if(!(input.equals("quit")) && !(input.equals("list")))
					{
						if(input == "save" || input == "load" || input == "add" || input == "open")
						{
							throw new NumArgumentsException("Not enough arguments");
						}
						else
						{
							throw new InvalidCommandException("Invalid Command");
						}
					}
				}
				else
				{
					count=numberOfSpaces(input);
					if(count == 1)
					{
						String[] command = input.split(" ",2);
						if(command[0].equals("save"))
						{
							s.save(cat,command[1]);
						}
						else
						{
							if(command[0].equals("load"))
							{
								cat=l.load(cat,command[1]);
							}
							else
							{
								if(command[0].equals("open"))
								{
									int index = Integer.parseInt(command[1]);
									o.open(index,cat);
								}
								else
								{
									if(command[0].equals("quit") || input.equals("add") || input.equals("list")) throw new NumArgumentsException("Not enough arguments");
									else throw new InvalidCommandException("Invalid Command");
								}
							}
							
						}		
					}
					else
					{
						if(count!=0)
						{
							String[] command = input.split(" ",2);
							if(command[0].equals("add"))
							{
								String[] doc = command[1].split(" ",2);
								if(doc[0].equals("book"))
								{
									ArrayList<String> authors=new ArrayList<String>();
									String title,path;
									int year;
									String[] book = doc[1].split(",");
									title=book[0];
									path=book[1];
									year=Integer.parseInt(book[2]);
									for(int i=3;i<book.length;i++)
									{
										authors.add(book[i]);
									}
									cat=a.add(new Book(title,path,year,authors), cat);
								}
								if(doc[0].equals("article"))
								{
									ArrayList<String> authors=new ArrayList<String>();
									String title,path;
									int year;
									String[] article = doc[1].split(",");
									title=article[0];
									path=article[1];
									year=Integer.parseInt(article[2]);
									for(int i=3;i<article.length;i++)
									{
										authors.add(article[i]);
									}
									cat=a.add(new Article(title,path,year,authors), cat);
								}
								if(doc[0].equals("manual"))
								{
									String title,path;
									String[] manual = doc[1].split(",");
									title=manual[0];
									path=manual[1];
									cat=a.add(new Manual(title,path), cat);
								}
								
							}
							else
							{
								throw new InvalidCommandException("Invalid Command");
							}
						}
					}
						
				}
			}
			catch(NegativeNumException e){
				System.err.println("Negative int found");
			}
			catch(NumArgumentsException e) {
				System.err.println("Invalid number of arguments");
			}
			catch(InvalidCommandException e) {
				System.err.println("Invalid command");
			}
			catch(NumberFormatException e)
			{
				System.err.println("Invalid argument");
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.err.println("Invalid number of arguments");
			}
			catch(IOException e){
				System.err.println("Couldn't read from console");
			}
		}
		
	}
}
