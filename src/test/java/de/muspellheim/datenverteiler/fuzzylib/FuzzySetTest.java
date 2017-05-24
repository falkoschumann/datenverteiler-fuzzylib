/*
 * Copyright (c) 2017 Falko Schumann
 * Licensed under the terms of the MIT License.
 */

package de.muspellheim.datenverteiler.fuzzylib;

import org.junit.*;

import static org.junit.Assert.*;

public class FuzzySetTest {

    @Test
    public void testSingleton() {
        FuzzySet x = FuzzySet.erzeugeSingleton("Singleton", 3);

        assertTrue(x.isSingleton());
        assertFalse(x.isDreieck());
        assertFalse(x.isTrapez());
        assertFalse(x.isAufsteigendeRampe());
        assertFalse(x.isAbfallendeRampe());
    }

    @Test
    public void testDreieck() {
        FuzzySet x = FuzzySet.erzeugeDreieck("Dreieck", 3, 5, 7);

        assertTrue(x.isDreieck());
        assertFalse(x.isSingleton());
        assertFalse(x.isTrapez());
        assertFalse(x.isAufsteigendeRampe());
        assertFalse(x.isAbfallendeRampe());
    }

    @Test
    public void testTrapez() {
        FuzzySet x = FuzzySet.erzeugeTrapez("Trapez", 3, 5, 7, 9);

        assertTrue(x.isTrapez());
        assertFalse(x.isSingleton());
        assertFalse(x.isDreieck());
        assertFalse(x.isAufsteigendeRampe());
        assertFalse(x.isAbfallendeRampe());
    }

    @Test
    public void testAufsteigendeRampe() {
        FuzzySet x = FuzzySet.erzeugeAufsteigendeRampe("Aufsteigende Rampe", 3, 5, 7);

        assertTrue(x.isAufsteigendeRampe());
        assertFalse(x.isDreieck());
        assertFalse(x.isSingleton());
        assertFalse(x.isTrapez());
        assertFalse(x.isAbfallendeRampe());
    }

    @Test
    public void testAbfallendeRampe() {
        FuzzySet x = FuzzySet.erzeugeAbfallendeRampe("Abfallende Rampe", 3, 5, 7);

        assertTrue(x.isAbfallendeRampe());
        assertFalse(x.isDreieck());
        assertFalse(x.isSingleton());
        assertFalse(x.isTrapez());
        assertFalse(x.isAufsteigendeRampe());
    }

}
