import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        // jdbc is a protocol
        // jdbc:[type of sql db]:///[ip adrees with port]/db_name
        // in http world
        // authenticate the user it goes through access token
        // A VERY SMALL DEPENDENCY
        // MAVEN IS NOT A FRAMEWORK
        // MAVEN IS NOT A PROGRAMMING LANGUAGE
        // MAVEN IS A BUILD TOOL,DEPENDENCY MANNAGEMENT
        // ( SOMETHING LIKE PIP , NPM)
        String connectionString = "jdbc:mysql://localhost:5402/gfgDB";
        Connection connection = DriverManager.getConnection(connectionString,"luffy","onepiece");
        Statement statement = connection.createStatement();
        String query = "create table jbdl_58_results " +
                "(" +
                "name VARCHAR(200)," +
                "user_id int primary key" +
                ") ";
        statement.execute(query);
        // 1) PRIMARY REASON TO USE MAVEN
        // WE DONT CARE ABOUT SURFING OVER THE INTERNET AND INSTALL OUR JAR FILES
        // OUR DEPENDENCIES
        // WE ALSO DONT NEED TO ADD IT TO OUR CLASS PATH
        // MAVEN DOES IT FOR YOU
        // 2)
        // MAVEN RECURSIVELY DOWNLOADS ALL THE DEPENDENCIES//
        //
    }




/**
 * when you execute your java code
 * does your application get terminated or it stays alive?
 *
 * YOUR SERVER IS ACTUALLY SOME JAVA CODE APPLICATION
 * YOUR SEVER SHOULD STAY ALIVE FOREVER OR SHOULD IT BE TERMINATED
 *
 * how to write server level applications in java
 *
 *
 *  API consists of
 *  1) Protocol -> http/http/s
 *  2) Base URL -> which organization is this request for
 *  3) Path/EndPoint -> API end point
 *  4) Query Params -> what data your server has to look for
 *  5) Request Params -> usually used in post requests or maybe when your query params get long
 https://www.google.com/complete/search?
 q
 pq=one%20piece
USING SPRING  BOOT FRAMEWORK YOU GET AN EMBEDEDD TOMCAT/JETTY SERVER IN YOUR APPLICATION


       // 4 BYTES OF MEMORY
       // MVX EAX 4 2047

 int  x  = 0;


 // ytn JNTE PORT 3028
 // L 3028
 Socket s = new Socket(3028)


list/students DU North Campus wesbite
your server is independent of java


@GET(/list/students)
list<students> studentFecther(request r){
    // read r
    // do some processing
    return response
}







 servlet
 tomcat
 integrate tomacat with java

 class Reader{

 servel s = new Socket(46478);
 s.topOf(tomcat_server);
 while(1){
    List<bytes> list = s.listen();
    convert these bytes to maybe character
    /list/studnents
    f();
 // read chars
 then reponse
 }


 }
 */















}
