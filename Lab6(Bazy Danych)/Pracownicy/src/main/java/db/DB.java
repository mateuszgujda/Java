package db;


import Pracownik.*;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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


    public List<Pracownik> getAllWorkers(){
        List<Pracownik> pracownicy = new LinkedList<Pracownik>();
        try {
            connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM pracownicy ");

            // Wyciagamy wszystkie pola z kolumny name
            // znajdujące się w tabeli users
            rs = ps.executeQuery();


            while(rs.next()){
                String pesel = rs.getString(1);
                Double wynagrodzenie = rs.getDouble(2);
                PracownikEtatowy doDodania = new PracownikEtatowy(wynagrodzenie);
                doDodania.PESEL = new Pesel(pesel);
                pracownicy.add(doDodania);
            }


        }catch (SQLException ex){
            // handle any errors

        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            dropConnection();
            return pracownicy;
        }

    }


    private void printQuery() throws SQLException {
        while(rs.next()){

            String pesel = rs.getString(1);
            Double wynagrodzenie = rs.getDouble(2);
            System.out.println("Nr pesel :" + pesel + "Wynagrodzenie: "+wynagrodzenie);
        }
    }
}

