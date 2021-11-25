package FilEksempler;

public class Studerende {
    private int stdnr;
    private String fnavn;
    private String enavn;
    private String adresse;
    private String postnr;
    private String mobil;
    private String klasse;

    @Override
    public String toString() {
        return "Studerende{" +
                "stdnr=" + stdnr +
                ", fnavn='" + fnavn + '\'' +
                ", enavn='" + enavn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", postnr='" + postnr + '\'' +
                ", mobil='" + mobil + '\'' +
                ", klasse='" + klasse + '\'' +
                '}';
    }

    public int getStdnr() {
        return stdnr;
    }

    public void setStdnr(int stdnr) {
        this.stdnr = stdnr;
    }

    public String getFnavn() {
        return fnavn;
    }

    public void setFnavn(String fnavn) {
        this.fnavn = fnavn;
    }

    public String getEnavn() {
        return enavn;
    }

    public void setEnavn(String enavn) {
        this.enavn = enavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPostnr() {
        return postnr;
    }

    public void setPostnr(String postnr) {
        this.postnr = postnr;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    public Studerende(int stdnr, String fnavn, String enavn, String adresse, String postnr, String mobil, String klasse) {
        this.stdnr = stdnr;
        this.fnavn = fnavn;
        this.enavn = enavn;
        this.adresse = adresse;
        this.postnr = postnr;
        this.mobil = mobil;
        this.klasse = klasse;
    }

    public Studerende() {
    }
}

 /*   Opgaveark Databaser 25/11-21

        Opgave 1)
        Opret en klasse studerende:
public class studerende {
    private int stdnr;
    private String fnavn;
    private String enavn;
    private String adresse;
    private String postnr;
    private String mobil;
    private String klasse;
}

    Opret en klasse fag:
public class fag {
    private int fagnr;
    private String fagnavn;
}

    Opret en klasse studfag:
public class studfag {
    private int stdnr;
    private int fagnr;
}

    Programmer konstruktør/konstruktører samt set og get metoder til hver af de 3 klasse.


        Opgave 2)
        Opret en klasse DbSql:

public class DbSql {
    private Connection connection;
    private Statement stmt;

    DbSql(){
        connection = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C://sqlite/studadm.db";//Indsæt dit eget databasenavn
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


Opgave 3)
        Indsæt 3 metoder i DbSql, som kan oprette hver af de 3 tabeller i den database du arbejder med. Det er de tabeller som vi arbejdede med sidste gang, som nu skal oprettes fra Java-program:

        studerende
        fag
        studfag

        Kald disse 3 metoder i Main for at oprette hver af de 3 tabeller i din database.




        Opgave 4)
        Lav en metode indsaetstud i DbSql-klassen, som kan indsætte en studerende i tabellen studerende.

public void indsaetstud(studerende s)
        {
        //Metoden indsætter s i tabellen studerende i din database
        }

        Opret et objekt af klassen studerende i Main.
        Indsæt værdier for den studerende.

        Kald metoden indsaetstud i Main for at indsætte den studerende i databasen.

        Opret nogle flere studerende i databasen på samme måde.


        Opgave 5)
        Lav en metode indsaetfag i DbSql-klassen, som kan indsætte et fag i tabellen fag.

public void indsaetfag(fag f)
        {
        //Metoden indsætter f i tabellen fag i din database
        }

        Opret et objekt af klassen fag i Main.
        Indsæt værdier for faget.

        Kald metoden indsaetfag i Main.

        Opret nogle flere fag i databasen på samme måde.


        Opgave 6)
        Lav en metode updatestudklasse i DbSql-klassen, som kan opdatere en studerendes klasse.

public void updatestudklasse(int stdnr,String nyklasse)
        {
        //Metoden opdaterer klassen for den studerende med studienummer stdnr
        }

        Kald metoden i Main.


        Opgave 7)
        Lav en metode soegstud i DbSql-klassen, som kan returnere den studerende der søges på.

public studerende soegstud(int stdnr)
        {
        //Metoden returnerer den studerende med studienummer stdnr
        }

        Kald metoden i Main og udskriv data for den studerende.


        Opgave 8)
        Opret en klasse studcontainer:

public class studcontainer {
    public int antal;
    public studerende [] array;

    studcontainer(){
        antal=0;
        array=new studerende[100];
        for(int i=0;i<100;i++)
            array[i]=new studerende();
    }

    public int hentantal(){
        return antal;
    }

    public studerende[] hentarray(){
        return array;
    }
}
    Opret en studcontainer i main og indsæt et par studerende:
        Udskriv indholdet af denne studcontainer til skærm.

        Opgave 9)
        Lav en metode soegnavn i DbSql-klassen, som returnerer en studcontainer med de studerende med et givet efternavn.

public studcontainer soeg(String enavn) {
        studcontainer sc=new studcontainer();
        try{
        String sql = "select * from studerende where enavn=’”+enavn+”’”;
        Statemant stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        sc.antal=0;
        int i=0;
        while (rs.next()) {
        sc.array[i].stdnr=rs.getInt(1);
        sc.array[i].fnavn=rs.getString(2);
        sc.array[i].enavn=rs.getString(2);
        i++;
        }

        sc.antal=i;
        for(i=0;i<sc.antal;i++)
        System.out.format("\n%d %s %s %d",sc.array[i].s.stdnr,sc.array[i].s.fnavn,sc.array[i].s.enavn,sc.array[i].f.fagnr);

        System.out.println("Connection to SQLite has been established.");

        } catch (SQLException throwables) {
        throwables.printStackTrace();
        }
        return sc;
        }



        Kald metoden i Main:
        studcontainer sc;
        DbSql forespoergsel=new DbSql();
        sc=forespoergsel.soeg(“Jensen”);

        for(int i=0;i<sc.antal;i++)
        System.out.format(“%d %s %s”,sc.array[i].stdnr,sc.array[i].fnavn,sc.array[i].enavn):




*/