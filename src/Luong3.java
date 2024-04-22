import java.io.File;

public class Luong3 extends Thread{
    private StudentList dssv;

    @Override
    public void run() {
        dssv = new StudentList();
        String tenFile = "C:\\Users\\Lenovo\\IdeaProjects\\SinhVien\\src\\student.xml";
        File file = new File(tenFile);
        dssv.docFile(file);
        dssv.ngayNgto();
    }
}
