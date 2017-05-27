/*
 * Copyright (c) 2017 Falko Schumann
 * Licensed under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.fuzzylib;

import java.util.*;

public final class LinguistischerTerm {

    private final String name;
    private final double zugehoerigkeit;

    public LinguistischerTerm(String name, double zugehoerigkeit) {
        this.name = name;
        this.zugehoerigkeit = zugehoerigkeit;
    }

    public String getName() {
        return name;
    }

    public double getZugehoerigkeit() {
        return zugehoerigkeit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguistischerTerm that = (LinguistischerTerm) o;
        return Double.compare(that.zugehoerigkeit, zugehoerigkeit) == 0 &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, zugehoerigkeit);
    }

    @Override
    public String toString() {
        return "LinguistischerTerm{" +
                "name='" + name + '\'' +
                ", zugehoerigkeit=" + zugehoerigkeit +
                '}';
    }

}
