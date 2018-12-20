
import java.sql.*;

public class DB{
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void connect(){
        int attemptsNumber =0;
        while(attemptsNumber<3)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/mgujda",
                            "mgujda","eaN4Veh2Qdn8adLc");
            break;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            attemptsNumber++;
        }catch(Exception e){
            e.printStackTrace();
            attemptsNumber++;
        }
    }

    public void listNames(){
        try {
            connect();
            stmt = conn.createStatement();

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = stmt.executeQuery("SELECT * FROM books");

            printQuery();
        }catch (SQLException ex){
            // handle any errors

        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            dropConnection();
        }
    }

    private void dropConnection() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) { } // ignore
            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) { } // ignore

            stmt = null;
        }
    }

    public void selectByAuthor(String surname){
        try {
            connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM books WHERE author like(?)");
            ps.setObject(1,"% "+surname);

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = ps.executeQuery();

            printQuery();
        }catch (SQLException ex){
            // handle any errors

        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            dropConnection();
        }
    }
    public void selectByISBN(String isbn){
        try {
            connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM books WHERE isbn=?");
            ps.setObject(1,isbn);

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = ps.executeQuery();

            printQuery();
        }catch (SQLException ex){
            // handle any errors

        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            dropConnection();
        }
    }

    public void addBook(String isbn,String title, String author, String year){
        connect();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO books(isbn,title, author, year) VALUES(?,?,?,?)");
            ps.setObject(1, isbn);
            ps.setObject(2, title);
            ps.setObject(3, author);
            ps.setObject(4, year);
            ps.executeUpdate();
        } catch(SQLException e){

        } finally {
            dropConnection();
        }
    }

    private void printQuery() throws SQLException {
        while(rs.next()){
            String isbn = rs.getString(1);
            String title = rs.getString(2);
            String author = rs.getString(3);
            String year = rs.getString(4);
            System.out.println(isbn + " " +title +" " + author+ " "+ year);
        }
    }
}

