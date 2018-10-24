package ba.unsa.etf.rpr.tutorijal02;

import java.util.Objects;

public class Interval {
    private double pocTacka, krajTacka;
    private boolean pocPripada, krajPripada;
    public Interval(double v, double v1, boolean b, boolean b1) {
        if(v > v1) throw new IllegalArgumentException("Krajnija tacka veca od pocetna");
        pocTacka = v;
        krajTacka = v1;
        pocPripada = b;
        krajPripada = b1;
    }

    public Interval() {
        pocTacka  = 0;
        krajTacka = 0;
        pocPripada  = false;
        krajPripada = false;
    }

    public static Interval intersect(Interval i, Interval i2) {
        Interval rez = new Interval();
        if(i.pocTacka > i2.pocTacka) {
            rez.pocTacka = i.pocTacka;
            rez.pocPripada = i.pocPripada;
        }
        else if(i.pocTacka == i2.pocTacka) {
            rez.pocTacka = i.pocTacka;
            rez.pocPripada = i.pocPripada && i2.pocPripada;
        }
        else {
            rez.pocTacka = i2.pocTacka;
            rez.pocPripada = i2.pocPripada;
        }

        if(i.krajTacka < i2.krajTacka) {
            rez.krajTacka = i.krajTacka;
            rez.krajPripada = i.krajPripada;
        }
        else if(i.krajTacka == i2.krajTacka) {
            rez.krajTacka = i.krajTacka;
            rez.krajPripada = i.krajPripada && i2.krajPripada;
        }
        else {
            rez.krajTacka = i2.krajTacka;
            rez.krajPripada = i2.krajPripada;
        }
        return rez;
    }

    public boolean isIn(double v) {
        return ( pocPripada && krajPripada  && v >= pocTacka && v <= krajTacka) ||
                ( pocPripada && !krajPripada && v >= pocTacka && v < krajTacka)  ||
                (!pocPripada && krajPripada  && v > pocTacka && v <= krajTacka)  ||
                (!pocPripada && !krajPripada && v > pocTacka && v < krajTacka);
    }

    public boolean isNull() {
        return  (pocTacka == 0 && krajTacka == 0 && !pocPripada && !krajPripada);
    }

    @Override
    public String toString() {
        if(isNull()) return "()";
        return  (pocPripada ? "[" : "(") + pocTacka + "," + krajTacka + (krajPripada ? "]" : ")");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return Double.compare(interval.pocTacka, pocTacka) == 0 &&
                Double.compare(interval.krajTacka, krajTacka) == 0 &&
                pocPripada == interval.pocPripada &&
                krajPripada == interval.krajPripada;
    }

    public Interval intersect(Interval i) {
        Interval rez = new Interval();
        if(i.pocTacka > pocTacka) {
            rez.pocTacka = i.pocTacka;
            rez.pocPripada = i.pocPripada;
        }
        else if(i.pocTacka == pocTacka) {
            rez.pocTacka = i.pocTacka;
            rez.pocPripada = i.pocPripada && pocPripada;
        }
        else {
            rez.pocTacka = pocTacka;
            rez.pocPripada = pocPripada;
        }

        if(i.krajTacka < krajTacka) {
            rez.krajTacka = i.krajTacka;
            rez.krajPripada = i.krajPripada;
        }
        else if(i.krajTacka == krajTacka) {
            rez.krajTacka = i.krajTacka;
            rez.krajPripada = i.krajPripada && krajPripada;
        }
        else {
            rez.krajTacka = krajTacka;
            rez.krajPripada = krajPripada;
        }
        return rez;
    }
}

