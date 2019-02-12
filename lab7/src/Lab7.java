import java.sql.*;

public class Lab7
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
          ResultSet rs = statement.executeQuery(("SELECT * FROM customers "));
          while(rs.next()){
              System.out.print("CustID: " + rs.getObject(1));
              System.out.print("; Name: " + rs.getObject(2));
              System.out.println("; Email; " + rs.getObject(3));}

              System.out.println(" ");

              ResultSet ord = statement.executeQuery(("SELECT * FROM orders "));
              while(ord.next()){
                  if((double) ord.getObject(4) > 10 && (double) ord.getObject(4) < 40 ){
                  System.out.print("OrderID: " + ord.getObject(1));
                  System.out.print("; CustID: " + ord.getObject(2));
                  System.out.print("; Goods; " + ord.getObject(3));
                  System.out.println("; Price: " + ord.getObject(4));}

          }
      }catch(SQLException e){

      }
  }
}
