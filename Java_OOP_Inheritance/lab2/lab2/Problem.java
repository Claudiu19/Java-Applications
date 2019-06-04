package lab2;

import java.util.Arrays;

public class Problem {

	protected Student[] studenti=new Student[4];
	protected Teacher[] profesori=new Teacher[3];
	
	public void setTeachers(Teacher[] profi)
	{
		System.arraycopy(profi,0,profesori,0,profi.length);
	}
	
	public Teacher[] getTeachers()
	{
		return this.profesori;
	}
	
	public void setStudents(Student[] sclavi)
	{
		System.arraycopy(sclavi,0,studenti,0,sclavi.length);
	}
	
	public Student[] getStudents()
	{
		return this.studenti;
	}
	
	public Person[] getParticipants()
	{
		Person[] participants=new Person[20];
		int i=0;
		int k=0;
		while(i<studenti.length && studenti[i]!=null)
		{
			participants[k]=studenti[i];
			i++;
			k++;
		}
		i=0;
		while(i<profesori.length && profesori[i]!=null)
		{
			participants[k]=profesori[i];
			i++;
			k++;
		}
		return participants;
	}

	
	public static void main(String[] args) {
		
		
		Student s1=new Student("S1", "S1@info.uaic.ro");
		Student s2=new Student("S2", "S2@info.uaic.ro");
		Student s3=new Student("S3", "S3@info.uaic.ro");
		Student s4=new Student("S4", "S4@info.uaic.ro");
		
		
		Teacher t1 = new Teacher("T1", "T1@info.uaic.ro");
		Teacher t2 = new Teacher("T2", "T2@info.uaic.ro");
		Teacher t3 = new Teacher("T3", "T3@info.uaic.ro");
		
		
		Project p1 = t1.createProject("P1", 2);
		Project p2 = t2.createProject("P2", 1);
		Project p3 = t3.createProject("P3", 3);
		
		
		Project[] set1 = {p1,p2,p3};
		s1.setPreferences(set1);
		Project[] set2 = {p1,p3,p2};
		s2.setPreferences(set2);
		Project[] set3 = {p1};
		s3.setPreferences(set3);
		Project[] set4 = {p3,p2,p1};
		s4.setPreferences(set4);
		
		
		Student[] sclavi1 = {s3,s1,s2,s4};
		t1.setPreferences(sclavi1);
		Student[] sclavi2 = {s1,s2,s3,s4};
		t2.setPreferences(sclavi2);
		Student[] sclavi3 = {s4,s3,s1,s2};
		t3.setPreferences(sclavi3);
		
		
		Problem problem = new Problem();
		Student[] sclavi = {s1,s2,s3,s4};
		Teacher[] barosani = {t1,t2,t3};
		problem.setStudents(sclavi);
		problem.setTeachers(barosani);
		Person[] participants=new Person[20];
		System.arraycopy(problem.getParticipants(),0,participants,0,problem.getParticipants().length);
		int i=0;
		System.out.println(problem);
		while(i<participants.length && participants[i]!=null)
		{
			System.out.println(participants[i]);
			i++;
		}
		
		

	}

	@Override
	public String toString() {
		return "Problem [studenti=" + Arrays.toString(studenti) + ", profesori=" + Arrays.toString(profesori) + "]";
	}
}
