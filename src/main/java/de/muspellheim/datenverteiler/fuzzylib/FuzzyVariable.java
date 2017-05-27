/*
 * Copyright (c) 2017 Falko Schumann
 * Licensed under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.fuzzylib;

import com.google.common.collect.*;

import java.util.*;

public class FuzzyVariable {

    private final String name;
    private final ImmutableList<FuzzySet> fuzzySets;

    public FuzzyVariable(String name, FuzzySet... fuzzySets) {
        this(name, Arrays.asList(fuzzySets));
    }

    public FuzzyVariable(String name, List<FuzzySet> fuzzySets) {
        this.name = name;
        this.fuzzySets = ImmutableList.copyOf(fuzzySets);
    }

    public String getName() {
        return name;
    }

    public ImmutableList<FuzzySet> getFuzzySets() {
        return fuzzySets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuzzyVariable that = (FuzzyVariable) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(fuzzySets, that.fuzzySets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fuzzySets);
    }

    @Override
    public String toString() {
        return "FuzzyVariable{" +
                "name='" + name + '\'' +
                ", fuzzySets=" + fuzzySets +
                '}';
    }

}
