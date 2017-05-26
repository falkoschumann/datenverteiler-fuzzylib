/*
 * Copyright (c) 2017 Falko Schumann
 * Licensed under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.fuzzylib;

import com.google.common.math.*;

import java.util.*;

public final class FuzzySet {

    private final String name;
    private final double t1;
    private final double t2;
    private final double t3;
    private final double t4;

    public static FuzzySet singleton(String name, double t) {
        return new FuzzySet(name, t, t, t, t);
    }

    public static FuzzySet dreieck(String name, double t1, double t2, double t3) {
        return new FuzzySet(name, t1, t2, t2, t3);
    }

    public static FuzzySet trapez(String name, double t1, double t2, double t3, double t4) {
        return new FuzzySet(name, t1, t2, t3, t4);
    }

    public static FuzzySet steigendeRampe(String name, double t1, double t2, double t3) {
        return new FuzzySet(name, t1, t2, t3, t3);
    }

    public static FuzzySet fallendeRampe(String name, double t1, double t2, double t3) {
        return new FuzzySet(name, t1, t1, t2, t3);
    }

    private FuzzySet(String name, double t1, double t2, double t3, double t4) {
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

    double zugehoerigkeit(double wert) {
        if (t1 <= wert && wert < t2)
            return LinearTransformation.mapping(t1, 0).and(t2, 1).transform(wert);
        else if (t2 <= wert && wert <= t3)
            return 1.0;
        else if (t3 < wert && wert <= t4)
            return LinearTransformation.mapping(t3, 1).and(t4, 0).transform(wert);

        return 0.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuzzySet fuzzySet = (FuzzySet) o;
        return Double.compare(fuzzySet.t1, t1) == 0 &&
                Double.compare(fuzzySet.t2, t2) == 0 &&
                Double.compare(fuzzySet.t3, t3) == 0 &&
                Double.compare(fuzzySet.t4, t4) == 0 &&
                Objects.equals(name, fuzzySet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, t1, t2, t3, t4);
    }

    @Override
    public String toString() {
        return "FuzzySet{" +
                "name='" + name + '\'' +
                ", t1=" + t1 +
                ", t2=" + t2 +
                ", t3=" + t3 +
                ", t4=" + t4 +
                '}';
    }

}
