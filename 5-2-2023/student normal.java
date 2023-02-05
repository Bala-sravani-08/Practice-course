 import java.io.*;
import java.util.*;
class Student 
{
    private String name;
    private int rollno;
    private int year;
    private String branch;
    private List<Integer> marks=new ArrayList<>();
  private double avg=0.0;
    private double divide=0.0;
    public Student(String name,int rollno,String branch,int year)
    {
        this.name=name;
        this.rollno=rollno;
        this.year=year;
        this.branch=branch;
    }
    
    public void setMarks(int mark)
    {
        marks.add(mark);
    }
    
    public String getName()
    {
        return name;
    }
    public int getRollno()
    {
        return rollno;
    }
    public int getYear()
    {
        return year;
    }
    public String getBranch()
    {
        return branch;
    }
    public List<Integer> getMarks()
    {
      return marks;
    }
    
    public Double compute()
    {
        for(int i=0;i<marks.size();i++)
        {
            avg+=marks.get(i);
                divide=(i+1)*100.0;
        }
        return (avg/(divide)*100.0);
    } 
            

    public String toString()
    {
        String res = String.format("%.2f",compute());
        return (getRollno()+" "+getName()+" "+getBranch()+" "+getYear()+"\n"+getRollno()+" "+res);
        
        
    }
    public boolean equals(Object obj)
    {
        if(obj instanceof Student)
        {
            Student s=(Student)obj;
            if(this.rollno==s.getRollno())
            {return true; }
            
        }
     return false;
    }
    public int hashCode()
    {
        return this.rollno;
    } 
}

class StudComp implements Comparator<Student>{
    public int compare(Student one, Student two){
       int comp=(int)(one.compute()-two.compute());
        return comp;
    }

}
class StudCompbyrollno implements Comparator<Student>
{
     public int compare(Student one, Student two)
     {
     if (!one.getBranch().equals(two.getBranch()))
     {
     return one.getRollno() - two.getRollno();     
     }
     return one.getBranch().compareTo(two.getBranch());
     }
}

public class Solution {

    public static void main(String[] args) {
        
        Scanner in=new Scanner(System.in);
        HashSet<Student> set=new HashSet<>();
        List<Student> list=new ArrayList<>();
        int noOfEntries=in.nextInt();
        in.nextLine();
        for(int i=0;i<noOfEntries;i++)
        {
            String [] arr=in.nextLine().split(" ");
            Student obj=new Student(arr[0],Integer.parseInt(arr[1]),arr[2],Integer.parseInt(arr[3]));
           list.add(obj);
           String [] marks=in.nextLine().split(" ");
                for(int j=0;j<marks.length;j++)
                {
                    obj.setMarks(Integer.parseInt(marks[j]));
                }
           System.out.println(obj); 
           set.add(obj);
        }
       
      System.out.println("NoOfStudents="+set.size());
        List<Student> li =new ArrayList<>(set);
 
        

       
    }
}
