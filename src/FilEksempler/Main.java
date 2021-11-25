package FilEksempler;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // Sletter og opretter tabeller
        DbSQL.opretStuderende_tbl();
        DbSQL.opretFag_tbl();
        DbSQL.opretStudFag_tbl();

        // Opretter studerende
        Studerende stud1 = new Studerende(11111, "Kristoffer", "Hansen", "Næstvedvej 35", "4700", "42344106", "DAT1");
        Studerende stud2 = new Studerende(11112, "Jens", "Jensen", "Næstvedvej 32", "4400", "41235466", "DAT2");
        Studerende stud3 = new Studerende(11113, "Peter", "Hansi", "Fensmarkvej 12", "4670", "42341233", "FØN1");
        Studerende stud4 = new Studerende(11114, "Kristine", "Gert", "Lærkevej 5", "4684", "88888888", "FØN2");
        Studerende stud5 = new Studerende(11115, "Kartofel", "Petersen", "Knudvej 1", "4100", "33444106", "DAT1");
        Studerende stud6 = new Studerende(11116, "Per", "Olsen", "Pedersensvej 69", "4200", "44441106", "BYG1");
        Studerende stud7 = new Studerende(11117, "Olemor", "Hansen", "Sejerejevej 420", "4402", "09876543", "BYG1");
        Studerende stud8 = new Studerende(11118, "karin", "Thomsen", "Cedervej 188", "4320", "12345678", "BYG2");
        Studerende stud9 = new Studerende(11119, "Kaj", "Kajsen", "Pilevej 22", "5211", "12458291", "BYG1");
        Studerende stud10 = new Studerende(11120, "Kris", "Kristoffersen", "Tjørnevej 83", "9100", "32229877", "DAT1");
        // studerende Array
        Studerende[] studerendeArray = new Studerende[10];
        studerendeArray = new Studerende[]{stud1, stud2, stud3, stud4, stud5, stud6, stud7, stud8, stud9, stud10};
        // indsæt studerende i SQL
        for (Studerende stud : studerendeArray) {
            DbSQL.indsaetstud(stud);
        }
        //DbSQL.indsaetstud(stud1);

        // Opret fag
        Fag fag1 = new Fag(1, "DAT1");
        Fag fag2 = new Fag(2, "DAT2");
        Fag fag3 = new Fag(3, "ØKO1");
        Fag fag4 = new Fag(4, "ØKO2");
        Fag fag5 = new Fag(5, "BYG1");
        Fag fag6 = new Fag(6, "BYG2");

        // Opret fag i SQL
        Fag[] alleFag = new Fag[]{fag1, fag2, fag3, fag4, fag5, fag6};
        for (Fag fag : alleFag) {
            DbSQL.opretFag(fag);
        }

        // Update record
        DbSQL.updateStudKlasse(11111, "BYG2");

        // Søg stdnr
        Studerende studSoegt = DbSQL.soegstud(11112);
        System.out.println(studSoegt.toString());

        // Brug af StudContainer til resultset
        StudContainer studcontainer = new StudContainer();
        studcontainer.array = new Studerende[]{stud1,stud2,stud3};
        System.out.println(studcontainer.toString());
        System.out.println("");

        StudContainer studcontainer2 = DbSQL.soegStudEnavn("Hansen");
        System.out.println("Studerende med efternavnet Hansen:");
        for (int i = 0; i < studcontainer2.antal; i++) {
            System.out.println(studcontainer2.array[i].toString());
        }

        //DbSQL.soegStudEnavn("Hansen").toString();

    }
}
        /*Connection connection = null;
        Statement stmt=null;
        try {
            studerende[] array = new studerende[10];
            for (int j = 0; j < 10; j++)
                array[j] = new studerende();

            String url = "jdbc:sqlite:C://sqlite/bowie.db";
            connection = DriverManager.getConnection(url);
           // stmt = connection.createStatement();
            //int antal=laesTxtFil(array);
            //indsaetListe(array,antal);
           // indsaetRecord(connection, stmt);
           *//* System.out.println("Indtast stdnr, fornavn og efternavn");
            int stdnr;
            String fnavn, enavn;
            Scanner scan = new Scanner(System.in);
            stdnr = scan.nextInt();
            fnavn = scan.next();
            enavn = scan.next();
            String sql = "INSERT INTO kont (id,fornavn,efternavn) VALUES(" +
                    String.valueOf(stdnr) + ",'" + fnavn + "','" + enavn + "')";

            stmt=connection.createStatement();
            stmt.execute(sql);*//*

          //  indsaetRecord(connection,stmt);
          //  sletRecord(connection,stmt);
            updateRecord(connection,stmt);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/




    /*public static void indsaetListe(Studerende[] array, int antal, Connection connection) {
        try{
                for (int i = 0; i < antal; i++) {
                String sql = "INSERT INTO kont (id,fornavn,efternavn) VALUES(" +
                        String.valueOf(array[i].getStdnr()) + ",'" +
                        array[i].getFnavn() + "','" + array[i].getEnavn() + "')";
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Connection to SQLite has been established.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void indsaetRecord(Connection connection,Statement stmt) {
            try {
                System.out.println("Indtast stdnr, fornavn og efternavn");
                int stdnr;
                String fnavn, enavn;
                Scanner scan = new Scanner(System.in);
                stdnr = scan.nextInt();
                fnavn = scan.next();
                enavn = scan.next();
                String sql = "INSERT INTO kont (id,fornavn,efternavn) VALUES(" +
                        String.valueOf(stdnr) + ",'" + fnavn + "','" + enavn + "')";
                stmt=connection.createStatement();
                stmt.execute(sql);
                System.out.println("Connection to SQLite has been established.");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }



    public static void sletRecord(Connection connection,Statement stmt) {
        try {
            System.out.println("Indtast stdnr på den der skal slettes ");
            int stdnr;
            Scanner scan = new Scanner(System.in);
            stdnr = scan.nextInt();
            String sql = "DELETE FROM kont WHERE id="+String.valueOf(stdnr);
            stmt=connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateRecord(Connection connection,Statement stmt) {
        try {
            System.out.println("Indtast stdnr på den der skal opdateres ");
            int stdnr;
            Scanner scan = new Scanner(System.in);
            stdnr = scan.nextInt();
            String fnavn, enavn;
            System.out.println("Indtast nyt efternavn ");
            enavn = scan.next();
            String sql = "UPDATE kont SET efternavn ='"+enavn+ "' WHERE id="+String.valueOf(stdnr);
            stmt=connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static int laesTxtFil(Studerende[] array) throws FileNotFoundException {
        Studerende s=new Studerende();
        File bestilling = new File("studerende.txt");
        Scanner input = new Scanner(bestilling);
        int i = 0;
        while (input.hasNext()) {
            array[i].setStdnr((input.nextInt()));
            array[i].setFnavn((input.next()));
            array[i].setEnavn((input.next()));
            i++;
        }
        return i;
    }

    public static void connect() {
      //  Connection conn = null;
        }
    */

