package sample;

import java.sql.*;
public class TableGenerator {

        //This method just creates the tables
        static void createTables(Connection con) throws Exception
        {
            PreparedStatement s;

            //creating students table using SQL script.
            //check constraint is added to restrict the type of data that can be entered in the database
            s = con.prepareStatement("create table if not exists students(studentID int not null primary key , first_name varchar(50) , " +
                    "last_name varchar(50) , " + "sex varchar(1) check (sex in ('M' , 'F')));");
            s.executeUpdate();
            System.out.println("Table Created");

            //creating courses table
            s = con.prepareStatement("create table if not exists courses(courseID int not null primary key auto_increment , " +
                    "courseTitle varchar(50) , " + "department varchar(50));");
            s.executeUpdate();
            System.out.println("Table Created");


            //creating classes table
            //check is a constraint which is added to restrict the type of data that can be entered in the database
            //Here the studentID should be unique and hence unique keyword is applied ot studentID field. The studentID should not be repeated in this table
            s = con.prepareStatement("create table if not exists classes(classCode int not null auto_increment primary key , courseID int references courses(courseID) , studentID int unique references students(studentID) , year int , semester varchar(10) check (semester in ('SPRING')), GPA varchar(1) check (GPA in ('A' , 'B' , 'C' , 'D' , 'F' , 'W')))");
            s.executeUpdate();
            System.out.println("Table Created");
        }

    public static void createNewStudent(Connection connection, int studentID, String first_name, String last_name, String sex) {
        ResultSet rs = null;
        String sql = "INSERT INTO students(studentID,first_name,last_name,sex) " + "VALUES(?,?,?,?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, studentID);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.setString(4, sex);

            int rowAffected = pstmt.executeUpdate();
            if(rowAffected == 1) {
                rs = pstmt.getGeneratedKeys();
                if(rs.next())
                    System.out.println("Successfully added student " + rs.getInt(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if(rs != null)  rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Allows to update students name and sex. Student id should stay the same//
    public static void updateStudent(Connection connection, int studentID, String first_name, String last_name) {
        String sqlUpdate = "UPDATE students " + "SET first_name = ?, last_name = ? " + "WHERE studentID = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sqlUpdate);
            pstmt.setString(1,first_name);
            pstmt.setString(2, last_name);
            pstmt.setInt(3, studentID);

            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Deletes row from students
    public static void deleteStudentsRow(Connection connection, int studentID){
        String sql = "DELETE FROM students " + "WHERE studentID = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, studentID);

            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Print all the students
    public static void readStudentsList(Connection connection){
        String sql = "SELECT * FROM students";

        try {
            Statement stmt  = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString("studentID") + "\t" + rs.getString("first_name") +
                        "\t" + rs.getString("last_name") + "\t" + rs.getString("sex"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

        //This method is used for entering data into the students table
        static void studentsInfo(Connection con) throws Exception
        {
            PreparedStatement s1;
            String insertion;

            insertion = "insert into students(studentID, first_name , last_name , sex) values('23734892' , 'AKASH' , 'AHUJA ---> ME' , 'M')";
            s1 = con.prepareStatement(insertion);
            s1.executeUpdate();

            insertion = "insert into students(studentID, first_name , last_name , sex) values('23364959' , 'NAMAN' , 'PUJARI' , 'M')";
            s1 = con.prepareStatement(insertion);
            s1.executeUpdate();

            insertion = "insert into students(studentID, first_name , last_name , sex) values('23364906' , 'KARTIK' , 'TYAGI' , 'M')";
            s1 = con.prepareStatement(insertion);
            s1.executeUpdate();

            insertion = "insert into students(studentID, first_name , last_name , sex) values('23366782' , 'SACHIN' , 'TENDULKAR' , 'M')";
            s1 = con.prepareStatement(insertion);
            s1.executeUpdate();

            insertion = "insert into students(studentID, first_name , last_name , sex) values('23364908' ,'AJAY' , 'PATEL' , 'M')";
            s1 = con.prepareStatement(insertion);
            s1.executeUpdate();

            insertion = "insert into students(studentID, first_name , last_name , sex) values('23364909' ,'RUDY' , 'ROY' , 'F')";
            s1 = con.prepareStatement(insertion);
            s1.executeUpdate();

            insertion = "insert into students(studentID, first_name , last_name , sex) values('23364910' ,'JOSH' , 'HART' , 'F')";
            s1 = con.prepareStatement(insertion);
            s1.executeUpdate();

            insertion = "insert into students(studentID, first_name , last_name , sex) values('23355990' ,'VIRAT' , 'KOHLI' , 'M')";
            s1 = con.prepareStatement(insertion);
            s1.executeUpdate();

            insertion = "insert into students(studentID, first_name , last_name , sex) values('23364915' ,'MITHALI' , 'RAJ' , 'F')";
            s1 = con.prepareStatement(insertion);
            s1.executeUpdate();
        }

        //This method is used for entering data in the courses table
        static void coursesTable(Connection con) throws Exception {
            PreparedStatement s;
            String insertion;

            insertion = "insert into courses(courseTitle, department) values('CS221' , 'CS');";
            s = con.prepareStatement(insertion);
            s.executeUpdate();
        }

//            insertion = "insert into courses(courseID , courseTitle, department) values('CS221' ,'SOFTWARE DESIGN', 'CS');";
//            s = con.prepareStatement(insertion);
//            s.executeUpdate();
//
//            insertion = "insert into courses(courseID , courseTitle, department) values('CS221' ,'SOFTWARE DESIGN', 'CS');";
//            s = con.prepareStatement(insertion);
//            s.executeUpdate();
//
//            insertion = "insert into courses(courseID , courseTitle, department) values('CS221' ,'SOFTWARE DESIGN', 'CS');";
//            s = con.prepareStatement(insertion);
//            s.executeUpdate();
//
//            insertion = "insert into courses(courseID , courseTitle, department) values('CS221' , 'SOFTWARE DESIGN','CS');";
//            s = con.prepareStatement(insertion);
//            s.executeUpdate();
//
//            insertion = "insert into courses(courseID ,courseTitle, department) values('CS221' ,'SOFTWARE DESIGN', 'CS');";
//            s = con.prepareStatement(insertion);
//            s.executeUpdate();
//
//            insertion = "insert into courses(courseID , courseTitle, department) values('CS221' ,'SOFTWARE DESIGN', 'CS');";
//            s = con.prepareStatement(insertion);
//            s.executeUpdate();
//        }

        //This method is used for entering data in the classes table
        static void classesTable(Connection con) throws Exception
        {
            String insertion;
            PreparedStatement s;

            insertion = "insert into classes(courseID , studentID , year , semester , GPA) values(1 , 23734892 , 2020 , 'SPRING' , 'D')";
            s = con.prepareStatement(insertion);
            s.executeUpdate();

            insertion = "insert into classes(courseID , studentID , year , semester , GPA) values(1 , 23364959 , 2020 , 'SPRING' , 'B')";
            s = con.prepareStatement(insertion);
            s.executeUpdate();

            insertion = "insert into classes(courseID , studentID , year , semester , GPA) values(1 , 23364906 , 2020 , 'SPRING' , 'C')";
            s = con.prepareStatement(insertion);
            s.executeUpdate();

            insertion = "insert into classes(courseID , studentID , year , semester , GPA) values(1 , 23366782 , 2020 , 'SPRING' , 'A')";
            s = con.prepareStatement(insertion);
            s.executeUpdate();

            insertion = "insert into classes(courseID , studentID , year , semester , GPA) values(1 , 23364908 , 2020 , 'SPRING' , 'W')";
            s = con.prepareStatement(insertion);
            s.executeUpdate();

            insertion = "insert into classes(courseID , studentID , year , semester , GPA) values(1 , 23364909 , 2020 , 'SPRING' , 'D')";
            s = con.prepareStatement(insertion);
            s.executeUpdate();

            insertion = "insert into classes(courseID , studentID , year , semester , GPA) values(1 , 23364910 , 2020 , 'SPRING' , 'B')";
            s = con.prepareStatement(insertion);
            s.executeUpdate();

            insertion = "insert into classes(courseID , studentID , year , semester , GPA) values(1 , 23355990 , 2020 , 'SPRING' , 'C')";
            s = con.prepareStatement(insertion);
            s.executeUpdate();

            insertion = "insert into classes(courseID , studentID , year , semester , GPA) values(1 , 23364915 , 2020 , 'SPRING' , 'W')";
            s = con.prepareStatement(insertion);
            s.executeUpdate();
        }

    }

