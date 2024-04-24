package spring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.beans.Guitariste;
import spring.beans.Pianiste;
import spring.beans.Piano;
import spring.interfaces.Instrument;
import spring.interfaces.Musicien;

@Component
@Aspect
public class Spectateur {

    @Autowired
    private Musicien pianiste;

    public void insalle() {
        System.out.println("Les spectateurs s'installent et eteignent leur téléphone");
    }

    public void fin() {
        System.out.println("Standing ovation");
    }

    // // V1
    @Pointcut("execution(* spring.beans.*.performer())")
    public void interceptionAll() {

    }

    @Pointcut("execution(* spring.beans.guitariste.performer())")
    public void performeGutariste() {

    }

    @Pointcut("execution(* spring.beans.pianiste.performer())")
    public void performepianiste() {

    }

    @Before("interceptionAll()")
    public void avantDebutPerformance() {
        System.out.println("Les spectateurs s'installent et eteignent leur téléphone");
    }

    @After("interceptionAll()")
    public void finPerformanceToutEstOk() {
        System.out.println("On se casse");
    }

    @AfterThrowing("interceptionAll()")
    public void finPerformanceProbleme() {
        System.out.println("RENTRE CHEZ TA MERE LE NULLOS");
    }

    // V2

    @Pointcut("execution(* spring.beans.Guitariste.performer())")
    public void catchGuitare() {

    }

    // @Around("catchGuitare()")
    // public void finTout(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    // {
    // if (proceedingJoinPoint.getTarget() instanceof Guitariste) {
    // proceedingJoinPoint.proceed();
    // fin();
    // Pianiste pianiste = new Pianiste();
    // pianiste.setInstrument(new Piano());
    // pianiste.performer();
    // fin();
    // }
    // }
    @After("performeGuitariste()")
    public void suivant() {
        pianiste.performer();
    }

}