package lab2;


public class Project {
	protected String name;
	protected int capacity;
	
	public Project(String name, int capacity)
	{
		this.name=name;
		this.capacity=capacity;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setCapacity(int cap)
	{
		this.capacity=cap;
	}
	
	public int getCapacity()
	{
		return this.capacity;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public String toString() {
		return "Project [name=" + name + ", capacity=" + capacity + "]";
	}

}
