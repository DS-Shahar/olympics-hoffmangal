package test;
public class Athlete {
	
	private String name;
	private Grade[] grades; 
	private int count;
	
	public Athlete (String name, int count)
	{
		this.name=name;
		this.grades=new Grade[count];
		this.count=count;
	}
	public Athlete(Athlete t)
	{
		name= this.name;
		grades=this.grades;
		count = this.count;
	}

	
	
	public Athlete(String name, Grade[] grades, int count)
	{
		this.name=name;
		this.grades=grades;
		this.count=grades.length;
	}
	public boolean addGrade(String apparatus, double score)
	{
		for(int i = 0; i <this.grades.length;i++)
		{
			if (this.grades[i]==null)
			{
				this.grades[i] = new Grade(apparatus, score);
				this.count=count+1;
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteGrade (String apparatus)
	{
		for(int i =0; i<this.grades.length;i++)
		{
			if(this.grades[i].getApparatus()==apparatus)
			{
				this.grades[i].setApparatus(null);
				this.count= count-1;
				return true;
			}
		}
		return false;
	}
	public double avarage ()
	{
		double sum = 0;
		for (int i = 0; i<this.grades.length; i++)
		{
			sum=+this.grades[i].getScore();
		}
		return sum/this.count;
	}
	public boolean allGradesAbove (double bar)
	{
		for(int  i = 0 ; i<this.grades.length;i++)
		{
			if(bar>this.grades[i].getScore())
			{
				return false;
			}
		}
		return true;
	}
	public boolean isBetter (Athlete a)
	{
		for (int i = 0; i<this.grades.length; i++)
		{
			String ap = this.grades[i].getApparatus();
			for(int  j =0;j<a.grades.length; j++)
			{
				if(this.grades[i].getApparatus().contentEquals(a.grades[j].getApparatus())&& a.grades[j].getScore()>this.grades[i].getScore())
				{
					return false;
				}
			}
		}
	}
	public class Grade {
	private String apparatus;
	private double score;
	public Grade(String apparatus, double score) {
		this.apparatus = apparatus;
		this.score = score;
	}
	
	public String getApparatus() {
		return apparatus;
	}
	public void setApparatus(String apparatus) {
		this.apparatus = apparatus;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Grade [apparatus=" + apparatus + ", score=" + score + "]";
	}
	
}
  public class Group {
	private String name;
	private Athlete[] athletes;
	
	public Group(String name,int len) {
		this.name = name;
		athletes=new Athlete[len];
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Athlete[] getAthletes() {
		return athletes;
	}
	public void setAthletes(Athlete[] athletes) {
		this.athletes = athletes;
	}
	
	public boolean addAthlete(Athlete a) {
		for(int i=0;i<athletes.length;i++) {
			if(athletes[i]==null) {
				athletes[i]=a;
				return true;
			}
		}
		return false;
	}
	public boolean deleteAthlete(String name) {
		for(int i=0;i<athletes.length;i++) {
			if(athletes[i].getName().equals(name)) {
				athletes[i]=null;
				return true;
			}
		}
		return false;
	}
	public String getBestAthleteName() {
		double max=0;
		String maxName="";
		for(int i=1;i<athletes.length;i++) {
			if(athletes[i].average()>max) {
				max=athletes[i].average();
				maxName=athletes[i].getName();
			}
		}
		return maxName;
	}
	public boolean addGrade(String name,String apparatus,double grade) {
		for(int i=0;i<athletes.length;i++) {
			if(athletes[i]!=null&&athletes[i].equals(name)) {
				return athletes[i].addGrade(apparatus, grade);
			}
		}
		return false;
	}
	
}

	
	
}
