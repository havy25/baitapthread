import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentList {
    private ArrayList<Student> danhSach;

    public StudentList(ArrayList<Student> danhSach) {
        this.danhSach = danhSach;
    }

    public StudentList() {
        this.danhSach=new ArrayList<Student>();
    }
    public void inDS(){
        for (Student st:danhSach
             ) {
            System.out.println(st);

        }
    }
    public void docFile(File file){
        try {
            InputStream is=new FileInputStream(file);
            ObjectInputStream ois=new ObjectInputStream(is);
            while(is.available()>0){
                Student st=(Student) ois.readObject();
                if(st!=null){
                    this.danhSach.add(st);
                }

            }
            ois.close();
            is.close();


        }
        catch (Exception e){
            e.printStackTrace();
        }



    }
    public void addStudent(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap thong tin sinh vien: ");
        System.out.println("Nhap id: "); String id=sc.nextLine();
        System.out.println("Nhap ten: ");String name=sc.nextLine();
        System.out.println("Nhap dia chi: ");String address=sc.nextLine();
        System.out.println("Nhap ngay sinh dang ng/th/nam: ");String dateOfBirth=sc.nextLine();
        Student st=new Student(id,name,address,dateOfBirth);
        this.danhSach.add(st);
    }
    public void ghiFile(File file){
        try {
            OutputStream os=new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(os);
            for (Student st: danhSach) {
                oos.writeObject(st);

            }
            oos.flush();
            oos.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static boolean ktNgto(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if (n%i==0)
                return false;
        }
        return true;
    }
    public void ngayNgto(){
        for (Student st:danhSach)
        {
            st.kt();
        }
    }
    public  void age(){
        for (Student st:danhSach)
        {
            st.soTuoi();
        }
    }

}
