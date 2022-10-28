import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Postgres {
    public static void main(String[] args) throws SQLException, IOException {
        Connection c;
        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/document",
                "postgres", "pg@abi123");
        PreparedStatement stmt = c.prepareStatement("SELECT * FROM student");
        ResultSet rs = stmt.executeQuery();
        String s3 = null;
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
               list.add(s +"," +s1 +"," +s2 +","+active+","+name);
                System.out.println(s);
                System.out.println(name);
                System.out.println(s1);
                System.out.println(s2);
                System.out.println(active);
            }
        }
        String loc = "C:\\Users\\User\\Downloads\\post11.txt";
        File first = new File(loc);
        FileWriter write = new FileWriter(first);
        write.write(String.valueOf(list));
        write.flush();
        write.close();

    }
}
