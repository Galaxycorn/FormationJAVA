package spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.interfaces.Instrument;
import spring.interfaces.Musicien;

@Component
public class Guitariste implements Musicien {

    @Autowired
    @Qualifier("guitare")
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
