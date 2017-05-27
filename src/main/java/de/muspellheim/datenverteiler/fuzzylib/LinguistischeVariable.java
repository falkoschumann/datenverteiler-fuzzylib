/*
 * Copyright (c) 2017 Falko Schumann
 * Licensed under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.fuzzylib;

import com.google.common.collect.*;

import java.util.*;

public class LinguistischeVariable {

    private final String name;
    private final ImmutableList<LinguistischerTerm> terme;

    public LinguistischeVariable(String name, LinguistischerTerm... LinguistischeVariable) {
        this(name, Arrays.asList(LinguistischeVariable));
    }

    public LinguistischeVariable(String name, List<LinguistischerTerm> terme) {
        this.name = name;
        this.terme = ImmutableList.copyOf(terme);
    }

    public String getName() {
        return name;
    }

    public ImmutableList<LinguistischerTerm> getTerme() {
        return terme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguistischeVariable that = (LinguistischeVariable) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(terme, that.terme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, terme);
    }

    @Override
    public String toString() {
        return "LinguistischeVariable{" +
                "name='" + name + '\'' +
                ", terme=" + terme +
                '}';
    }

}
