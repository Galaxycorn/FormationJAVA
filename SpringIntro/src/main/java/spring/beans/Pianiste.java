package spring.beans;

import spring.interfaces.Instrument;
import spring.interfaces.Musicien;

public class Pianiste implements Musicien {

    Instrument instrument;

    public Pianiste() {

    }

    @Override
    public void performer() {
        System.out.println("Pianiste :");
        instrument.jouer();
    }

    public Instrument getInstrument() {
        return this.instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

}
