package FilEksempler;

public class StudFag {
    private int stdnr;
    private int fagnr;

    public int getStdnr() {
        return stdnr;
    }

    public void setStdnr(int stdnr) {
        this.stdnr = stdnr;
    }

    public int getFagnr() {
        return fagnr;
    }

    public void setFagnr(int fagnr) {
        this.fagnr = fagnr;
    }

    public StudFag(int stdnr, int fagnr) {
        this.stdnr = stdnr;
        this.fagnr = fagnr;
    }

    public StudFag() {
    }
}