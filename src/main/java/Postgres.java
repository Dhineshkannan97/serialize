import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class Postgres {

    int id;
    String name;
    double cgpa;
    int age;
    boolean active;

    public Postgres(Object readObject) {
    }

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Connection c;
        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/document",
                "postgres", "pg@abi123");
        PreparedStatement stmt = c.prepareStatement("SELECT * FROM student");
        ResultSet rs = stmt.executeQuery();
        ArrayList<String> list = new ArrayList<String>();
        while (rs.next()) {

            var active = rs.getBoolean("active");
            if (active) {
                var id = rs.getInt("id");
                var s = Integer.toString(id);
                var age = rs.getInt("age");
                var s1 = Integer.toString(age);
                var cgpa = rs.getDouble("cgpa");
                var s2 = Double.toString(cgpa);
                var name = rs.getString("name");
                list.add(s + "," + s1 + "," + s2 + "," + active + "," + name);
//                list.
//                System.out.println(s);
//                System.out.println(name);
//                System.out.println(s1);
//                System.out.println(s2);
//                System.out.println(active);
            }
        }
        String loc = "C:\\Users\\User\\Downloads\\post12.txt";
        FileOutputStream first = new FileOutputStream(loc);
        ObjectOutputStream out = new ObjectOutputStream(first);
        out.writeObject(list);

        ObjectInputStream fin = new ObjectInputStream(new FileInputStream(loc));
//        ArrayList<String> listin = new ArrayList<String>();
        Postgres p = new Postgres(fin.readObject());
//        Postgres p= (Postgres) fin.readObject();
        System.out.println(p.id + "," + p.age + "," + p.cgpa + "," + p.name + "," + p.active);
        out.flush();
        out.close();
//        FileWriter write = new FileWriter(first);
//        write.write(String.valueOf(list));
//        write.flush();
//        write.close();
    }
}
