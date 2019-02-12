import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import static javax.swing.DropMode.INSERT;

public class Lab8
{ public static void main(String[] args)
  {
	Connection connection = null;

    try
    {
	  Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver loaded");
      connection = DriverManager.getConnection("jdbc:mysql://localhost/orderdb?useSSL=false", "root", null);
      // past experience has shown that using the one-argument version of getConnection doesn't work for some students
    }
    catch (ClassNotFoundException e)
    {
	  System.out.println("driver not found");
      System.exit(1);
    }
    catch (SQLException e)
    { System.out.println("failed to connect to database");
      System.exit(1);
    }

    Statement statement = null;

    try{
		statement = connection.createStatement();
    }
    catch (SQLException e)
	{
	  System.out.println("failed to access database");
      System.exit(1);
    }

    queryDatabase(statement);

    try
    {
	  statement.close();
      connection.close();
      System.out.println("Connection closed");
	}
	catch (SQLException e)
	{
	  System.out.println("problems closing connection");
	  System.exit(1);
    }
  }

  static void queryDatabase(Statement statement)
  {

      try{
          //statement.executeUpdate("INSERT INTO orders VALUES (8,3,'desktop pc',375.75)");
          //statement.executeUpdate("INSERT INTO orders VALUES (9,3,'dell laptop',449.99)");
          //statement.executeUpdate("INSERT INTO orders VALUES (10,3,'gamer juice',375.75)")

              ResultSet cust = statement.executeQuery(("SELECT * FROM customers "));
              Vector<String> v = new Vector();
              while(cust.next()){
                 v.add( cust.getObject(2).toString());
                  }
               ResultSet ord = statement.executeQuery(("SELECT * FROM orders "));

              while(ord.next()){
                    if(((double) ord.getObject(4)) > 20){
                        System.out.println("Good: " + ord.getObject(3) +", ordered by: "+ v.get(((int)ord.getObject(2)-1)));


                    }
              }
      }catch(SQLException e){

      }
  }
}
