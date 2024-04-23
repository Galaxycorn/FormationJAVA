package spring.beans;

import org.springframework.stereotype.Component;

import spring.interfaces.Instrument;

@Component
public class Piano implements Instrument {

    public Piano() {

    }

    public void jouer() {
        System.out.println("joue piano");
    }

}
