package FilEksempler;

import java.sql.*;

public class DbSQL {
    private Connection connection;
    private Statement stmt;

    DbSQL(){
        connection = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C://sqlite//studerende.db";//Indsæt dit eget databasenavn
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void opretStuderende_tbl() {
        DbSQL mysql = new DbSQL();
        try {
            String sql = "DROP TABLE studerende;";
            Statement stmt = mysql.connection.createStatement();
            stmt.execute(sql);

            sql = "CREATE TABLE IF NOT EXISTS studerende (\n"
                + "	stdnr integer PRIMARY KEY,\n"
                + "	fnavn TEXT NOT NULL,\n"
                + "	enavn TEXT NOT NULL,\n"
                + "	adresse TEXT NOT NULL,\n"
                + "	postnr TEXT NOT NULL,\n"
                + "	mobil TEXT NOT NULL,\n"
                + "	klasse TEXT NOT NULL\n"
                + ");";
            stmt.execute(sql);
            stmt.close();
            mysql.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void opretFag_tbl() {
        DbSQL mysql = new DbSQL();
        try {
            String sql = "DROP TABLE fag;";
            Statement stmt = mysql.connection.createStatement();
            stmt.execute(sql);
            sql = "CREATE TABLE IF NOT EXISTS fag (\n"
                    + "	fagnr integer PRIMARY KEY,\n"
                    + "	fagnavn TEXT NOT NULL\n"
                    + ");";
            stmt.execute(sql);
            stmt.close();
            mysql.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void opretStudFag_tbl() {
        DbSQL mysql = new DbSQL();
        try {
            String sql = "DROP TABLE studfag;";
            Statement stmt = mysql.connection.createStatement();
            stmt.execute(sql);
            sql = "CREATE TABLE IF NOT EXISTS studfag (\n"
                    + "	fagnr integer PRIMARY KEY,\n"
                    + "	stdnr integer NOT NULL\n"
                    + ");";
            stmt.execute(sql);
            stmt.close();
            mysql.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void indsaetstud(Studerende studerende) {
        //Metoden indsætter s i tabellen studerende i din database

        DbSQL mysql = new DbSQL();
        try {
            Statement stmt = mysql.connection.createStatement();
            String sql = "INSERT INTO studerende VALUES(" +
                    studerende.getStdnr() + ",'" +
                    studerende.getFnavn() + "','" +
                    studerende.getEnavn() + "','" +
                    studerende.getAdresse() + "','" +
                    studerende.getPostnr() + "','" +
                    studerende.getMobil() + "','" +
                    studerende.getKlasse() + "')";
            stmt.execute(sql);
            stmt.close();
            mysql.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void opretFag(Fag fag) {
        DbSQL mysql = new DbSQL();
        try {

            Statement stmt = mysql.connection.createStatement();
            String sql = "INSERT INTO fag VALUES(" +
                    fag.getFagnr() + ",'" +
                    fag.getFagnavn() + "')";
            stmt.execute(sql);
            stmt.close();
            mysql.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateStudKlasse(int stdnr,String nyklasse)
    {
        //Metoden opdaterer klassen for den studerende med studienummer stdnr
        DbSQL mysql = new DbSQL();
        try {

            Statement stmt = mysql.connection.createStatement();
/*            UPDATE table_name
            SET column1 = value1, column2 = value2, ...
            WHERE condition;*/
            String sql = "UPDATE studerende " +
                    "SET Klasse=" + "'" + nyklasse +"'" +
                    "WHERE stdnr=" + "'" + stdnr + "'";
            stmt.execute(sql);
            stmt.close();
            mysql.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Studerende soegstud(int stdnr)
    {
        //Metoden returnerer den studerende med studienummer stdnr
        String fnavn="",enavn="",adresse="",postnr="",mobil="",klasse="";
        DbSQL mysql = new DbSQL();
        try {
            Statement stmt = mysql.connection.createStatement();
            String sql = "SELECT * FROM studerende " +
                    "WHERE stdnr=" + "'" + stdnr + "'";
            ResultSet resultset = stmt.executeQuery(sql);
            while (resultset.next()) {
                //int stdnr = resultset.getInt("stdnr");
                fnavn = resultset.getString("fnavn");
                enavn = resultset.getString("enavn");
                adresse = resultset.getString("adresse");
                postnr = resultset.getString("postnr");
                mobil = resultset.getString("mobil");
                klasse = resultset.getString("klasse");
            }
            stmt.close();
            mysql.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Studerende stud = new Studerende(stdnr,fnavn,enavn,adresse,postnr,mobil,klasse);
        return stud;
    }

    public static StudContainer soegStudEnavn(String enavn) {
        StudContainer sc = new StudContainer();
        DbSQL mysql = new DbSQL();
        try {
            Statement stmt = mysql.connection.createStatement();
            String sql = "SELECT * FROM studerende WHERE enavn='" + enavn + "'";

            ResultSet resultset = stmt.executeQuery(sql);
            sc.antal=0;
            int i=0;
            while (resultset.next()) {
                sc.array[i].setStdnr(resultset.getInt("stdnr"));
                sc.array[i].setFnavn(resultset.getString("fnavn"));
                sc.array[i].setEnavn(resultset.getString("enavn"));
                sc.array[i].setKlasse(resultset.getString("klasse"));
                i++;
            }

            sc.antal=i;
            /*
            for(i=0;i<sc.antal;i++) {
                System.out.format("\n%d %s %s %s", sc.array[i].getStdnr(), sc.array[i].getFnavn(), sc.array[i].getEnavn(), sc.array[i].getKlasse());
            }*/

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sc;
    }

}