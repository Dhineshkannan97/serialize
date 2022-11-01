import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Deserialize extends Postgres{
     public Deserializem(int id,
    String name,
    double cgpa,
    int age,
    boolean active) throws IOException, ClassNotFoundException {
         String loc = "C:\\Users\\User\\Downloads\\post12.txt";
         ObjectInputStream fin = new ObjectInputStream(new FileInputStream(loc));
         ArrayList<String> listin = new ArrayList<String>();
       Deserialize p= (Deserialize) fin.readObject();
       System.out.println(p.id+","+p.age+","+p.cgpa+","+p.name+","+p.active);
     }

    public Deserialize() {
        super(fin.readObject());
    }
}
