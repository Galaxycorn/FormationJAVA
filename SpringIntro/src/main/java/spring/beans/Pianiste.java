package spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import spring.interfaces.Instrument;
import spring.interfaces.Musicien;

public class Pianiste implements Musicien {

    @Autowired
    @Qualifier("piano")
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
