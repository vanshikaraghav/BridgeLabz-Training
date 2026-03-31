package streams;
import java.io.*;

public class StudentDataStream {

    public static void main(String[] args) {
        String fileName = "students.dat";
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);           
            dos.writeUTF("Harshita");       
            dos.writeDouble(8.5);        
            dos.writeInt(102);
            dos.writeUTF("Aman");
            dos.writeDouble(7.9);
            System.out.println("Student data written successfully");
        }catch(IOException e) {
            e.printStackTrace();
        }
        try(DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while(dis.available()>0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll: " + roll +", Name: " + name +", GPA: " + gpa);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
