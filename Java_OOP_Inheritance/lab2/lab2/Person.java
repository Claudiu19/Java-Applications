package lab2;


public class Person {
	protected String name;
	protected String email;
	
	public Person(String name, String email)
	{
		this.name=name;
		this.email=email;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setEmail(String email)
	{
		this.email=email;
	}
	
	public static void main(String[] args)
	{
		System.out.println("Hello World");
		Person a = new Person("s1","s1@gmail.com");
		a.setName("Claudiu");
		a.setEmail("s1@yahoo.com");
		System.out.println(a.getName() + " " + a.getEmail());
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + "]";
	}
	
}
