
import java.util.ArrayList;

public class University2 {
     String uname;
     ArrayList<Students> studentlist = new ArrayList<Students>();
     ArrayList<Departments> deptlist= new ArrayList<Departments>();

     University2(String uname, String[] dname,String[] sname){
         this.uname=uname;

         for(int i=0; i< dname.length; i++){
             deptlist.add(new Departments(dname[i]));
         }
         for(int j=0; j< sname.length; j++){
             studentlist.add(new Students(sname[j]));
         }
     }

     Departments getDepartment(String dname){
         for(int i=0; i<deptlist.size(); i++) {
             if (deptlist.get(i).dname.equals(dname)){
                 return deptlist.get(i);
             }
             else return null;
         }
         }

    Students getStudent(String sname) {
        for (int i = 0; i < studentlist.size(); i++) {
            if (studentlist.get(i).sname.equals(sname)) {
                return studentlist.get(i);
            }
            else return null;
        }
    }

    class Students {
        String sname;
        Departments sdept;

        Students(String sname) {
            this.sname = sname;

        }

        void display() {
            System.out.println("Student name is : " + sname);
            System.out.println("department of " + sname + " is " + sdept.dname);
        }
     }


    class Departments {
        String dname;
        ArrayList<Students> studentsenroll = new ArrayList<>();

        Departments(String dname) {
            this.dname = dname; }
          void display(){
            System.out.println("department name is : " + dname);
            for (int i = 0; i < studentsenroll.size(); i++) {
                System.out.println("Students names are : " + studentsenroll.get(i));
            }
        }
    }
             public void enrollsIn (Departments d, Students s){
                 s.sdept = d;
                 d.studentsenroll.add(s);
             }

    void displaystudents(Departments d) {
        d.display();
    }


    }


 class Demo{
     public static void main(String[] args) {
         String[] sname ={"ali","ahmed","mohsin","zakir"};
         String[] depts= {"SW","CS","ELDC","CIVIL"};
         University2 muet = new University2("muet",depts,sname);
         muet.enrollsIn(muet.getDepartment("SW"),muet.getStudent("ali"));
         muet.enrollsIn(muet.getDepartment("CS"),muet.getStudent("ahmed"));
         muet.enrollsIn(muet.getDepartment("ELDC"),muet.getStudent("zakir"));
         muet.enrollsIn(muet.getDepartment("CIVIL"),muet.getStudent("mohsin"));

     }
 }
