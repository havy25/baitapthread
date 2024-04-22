import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class Student implements Serializable {
    private String id;
    private String name;
    private String address;
    private String dateOfBirth;

    public Student(String id, String name, String address, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
    public static boolean ktNgto(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if (n%i==0)
                return false;
        }
        return true;
    }
    public void kt(){
        String chuoi[]=this.dateOfBirth.split("/");
        int tong=0;
        for (int i=0;i<chuoi.length;i++){

            int so=Integer.parseInt(chuoi[i]);

            if(i==chuoi.length-1){
                int nam=0;
                while(so!=0){
                    nam+=so%10;
                    so/=10;
                }
                tong+=nam;
            }
            else
                tong+=so;

        }
        if(ktNgto(tong)){
            System.out.println("Ngay sinh cua SV "+this.getId()+" la so ngto");

        }
        else
            System.out.println("Ngay sinh cua SV "+this.getId()+" Khong la so nguyen to");




    }
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash)
    {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
    public void soTuoi(){
        LocalDateTime today=LocalDateTime.now();
        int date= today.getDayOfMonth();
        int month= today.getMonthValue();
        int year=today.getYear();
        String chuoi[]=this.getDateOfBirth().split("/");
        int so[] = new int[10];
        for (int i=0;i< chuoi.length;i++){
            so[i]=Integer.parseInt(chuoi[i]);
        }
        int soNgay=date-so[0];
        int soThang=month-so[1];
        int soNam=year-so[2];
        if(soNgay<0){
            soThang=month-(so[1]+1);
            soNgay=30-so[0];

        }
        if(soThang<0){
            soNam=year-(so[2]+1);
            soThang=12-so[1];

        }
        String maHoa=String.valueOf(soNgay)+String.valueOf(soThang)+String.valueOf(soNam);
        try{

            String s4 = "Ha vy";
            System.out.println("\n" + maHoa + " : " + toHexString(getSHA(s4)));
        }
        catch(NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }

    }

    }


