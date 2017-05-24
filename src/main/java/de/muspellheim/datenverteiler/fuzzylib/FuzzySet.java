/*
 * Copyright (c) 2017 Falko Schumann
 * Licensed under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.fuzzylib;

public class FuzzySet {

    private final String name;
    private final double t1;
    private final double t2;
    private final double t3;
    private final double t4;

    public static FuzzySet erzeugeSingleton(String name, double t) {
        return new FuzzySet(name, t, t, t, t);
    }

    public static FuzzySet erzeugeDreieck(String name, double t1, double t2, double t3) {
        return new FuzzySet(name, t1, t2, t2, t3);
    }

    public static FuzzySet erzeugeTrapez(String name, double t1, double t2, double t3, double t4) {
        return new FuzzySet(name, t1, t2, t3, t4);
    }

    public static FuzzySet erzeugeAufsteigendeRampe(String name, double t1, double t2, double t3) {
        return new FuzzySet(name, t1, t2, t3, t3);
    }

    public static FuzzySet erzeugeAbfallendeRampe(String name, double t1, double t2, double t3) {
        return new FuzzySet(name, t1, t1, t2, t3);
    }

    public FuzzySet(String name, double t1, double t2, double t3, double t4) {
        this.name = name;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
    }

    public String getName() {
        return name;
    }

    public double getT1() {
        return t1;
    }

    public double getT2() {
        return t2;
    }

    public double getT3() {
        return t3;
    }

    public double getT4() {
        return t4;
    }

    public boolean isSingleton() {
        return Double.compare(t1, t2) == 0 && Double.compare(t2, t3) == 0 && Double.compare(t3, t4) == 0;
    }

    public boolean isDreieck() {
        return Double.compare(t1, t2) != 0 && Double.compare(t2, t3) == 0 && Double.compare(t3, t4) != 0;
    }

    public boolean isTrapez() {
        return Double.compare(t1, t2) != 0 && Double.compare(t2, t3) != 0 && Double.compare(t3, t4) != 0;
    }

    public boolean isAufsteigendeRampe() {
        return Double.compare(t1, t2) != 0 && Double.compare(t2, t3) != 0 && Double.compare(t3, t4) == 0;
    }

    public boolean isAbfallendeRampe() {
        return Double.compare(t1, t2) == 0 && Double.compare(t2, t3) != 0 && Double.compare(t3, t4) != 0;
    }

}
