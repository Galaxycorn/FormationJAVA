package spring.beans;

import org.springframework.stereotype.Component;

import spring.interfaces.Instrument;
import spring.interfaces.Musicien;

@Component("guitariste")
public class Guitariste implements Musicien {

    Instrument instrument;

    public Guitariste() {

    }

    @Override
    public void performer() {
        System.out.println("Guitariste :");
        instrument.jouer();
    }

    public Instrument getInstrument() {
        return this.instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

}
