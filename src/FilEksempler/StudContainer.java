package FilEksempler;

import java.util.Arrays;

public class StudContainer {
    public int antal;
    public Studerende[] array;

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public Studerende[] getArray() {
        return array;
    }

    public void setArray(Studerende[] array) {
        this.array = array;
    }

    StudContainer(){
        antal=0;
        array=new Studerende[100];
        for(int i=0;i<100;i++) {
            array[i] = new Studerende();
            antal++;
        }
    }

    public int hentantal(){
        return antal;
    }

    public Studerende[] hentarray(){
        return array;
    }

    @Override
    public String toString() {
        return "StudContainer{" +
                "antal=" + hentantal() +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}