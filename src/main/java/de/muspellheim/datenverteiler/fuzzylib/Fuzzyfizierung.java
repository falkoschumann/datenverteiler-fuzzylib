/*
 * Copyright (c) 2017 Falko Schumann
 * Licensed under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.fuzzylib;

import java.util.*;

public class Fuzzyfizierung {

    public LinguistischeVariable fuzzyfiziere(FuzzyVariable variable, double wert) {
        List<LinguistischerTerm> terme = new ArrayList<>();
        variable.getFuzzySets().stream()
                .forEach(s -> terme.add(erzeugeTerm(wert, s)));
        return new LinguistischeVariable(variable.getName(), terme);
    }

    private LinguistischerTerm erzeugeTerm(double wert, FuzzySet fuzzySet) {
        return new LinguistischerTerm(fuzzySet.getName(), fuzzySet.zugehoerigkeit(wert));
    }

}
