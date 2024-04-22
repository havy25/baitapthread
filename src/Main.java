import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentList dssv=new StudentList();
        Scanner sc=new Scanner(System.in);
        System.out.println("Hay nhap danh sach sinh vien de luu vao file student.xml");
        int kt=1;
        do{
            if(kt!=0){
                dssv.addStudent();
            }
            System.out.println("Nhan 0 de ket thuc, nhan 1 de tiep tuc ");
            kt=sc.nextInt();
            sc.nextLine();
        }
        while(kt!=0);
        String tenFile="C:\\Users\\Lenovo\\IdeaProjects\\SinhVien\\src\\student.xml";
        File file=new File(tenFile);
        dssv.ghiFile(file);
        Thread t1=new Luong1();
        t1.start();
        Thread t3=new Luong3();
        t3.start();
        Thread t2=new Luong2();
        t2.start();

    }
}