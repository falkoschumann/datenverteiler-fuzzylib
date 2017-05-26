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
        FuzzySet fuzzySet = FuzzySet.singleton("Singleton", 20.0);

        assertEquals("Singleton", fuzzySet.getName());
        assertEquals(20.0, fuzzySet.getT1(), 0.001);
        assertEquals(20.0, fuzzySet.getT2(), 0.001);
        assertEquals(20.0, fuzzySet.getT3(), 0.001);
        assertEquals(20.0, fuzzySet.getT4(), 0.001);

        assertTrue(fuzzySet.isSingleton());
        assertFalse(fuzzySet.isDreieck());
        assertFalse(fuzzySet.isTrapez());
        assertFalse(fuzzySet.isAufsteigendeRampe());
        assertFalse(fuzzySet.isAbfallendeRampe());

        assertEquals(0.0, fuzzySet.zugehoerigkeit(19.0), 0.001);
        assertEquals(1.0, fuzzySet.zugehoerigkeit(20.0), 0.001);
        assertEquals(0.0, fuzzySet.zugehoerigkeit(11.0), 0.001);
    }

    @Test
    public void testDreieck() {
        FuzzySet fuzzySet = FuzzySet.dreieck("Dreieck", 20, 30, 40);

        assertEquals("Dreieck", fuzzySet.getName());
        assertEquals(20.0, fuzzySet.getT1(), 0.001);
        assertEquals(30.0, fuzzySet.getT2(), 0.001);
        assertEquals(30.0, fuzzySet.getT3(), 0.001);
        assertEquals(40.0, fuzzySet.getT4(), 0.001);

        assertTrue(fuzzySet.isDreieck());
        assertFalse(fuzzySet.isSingleton());
        assertFalse(fuzzySet.isTrapez());
        assertFalse(fuzzySet.isAufsteigendeRampe());
        assertFalse(fuzzySet.isAbfallendeRampe());

        assertEquals(0.0, fuzzySet.zugehoerigkeit(19.0), 0.001);
        assertEquals(0.0, fuzzySet.zugehoerigkeit(20.0), 0.001);
        assertEquals(0.2, fuzzySet.zugehoerigkeit(22.0), 0.001);
        assertEquals(1.0, fuzzySet.zugehoerigkeit(30.0), 0.001);
        assertEquals(0.5, fuzzySet.zugehoerigkeit(35.0), 0.001);
        assertEquals(0.0, fuzzySet.zugehoerigkeit(40.0), 0.001);
        assertEquals(0.0, fuzzySet.zugehoerigkeit(41.0), 0.001);
    }

    @Test
    public void testTrapez() {
        FuzzySet fuzzySet = FuzzySet.trapez("Trapez", 20, 30, 40, 50);

        assertEquals("Trapez", fuzzySet.getName());
        assertEquals(20.0, fuzzySet.getT1(), 0.001);
        assertEquals(30.0, fuzzySet.getT2(), 0.001);
        assertEquals(40.0, fuzzySet.getT3(), 0.001);
        assertEquals(50.0, fuzzySet.getT4(), 0.001);

        assertTrue(fuzzySet.isTrapez());
        assertFalse(fuzzySet.isSingleton());
        assertFalse(fuzzySet.isDreieck());
        assertFalse(fuzzySet.isAufsteigendeRampe());
        assertFalse(fuzzySet.isAbfallendeRampe());

        assertEquals(0.0, fuzzySet.zugehoerigkeit(19.0), 0.001);
        assertEquals(0.0, fuzzySet.zugehoerigkeit(20.0), 0.001);
        assertEquals(0.2, fuzzySet.zugehoerigkeit(22.0), 0.001);
        assertEquals(1.0, fuzzySet.zugehoerigkeit(30.0), 0.001);
        assertEquals(1.0, fuzzySet.zugehoerigkeit(37.0), 0.001);
        assertEquals(1.0, fuzzySet.zugehoerigkeit(40.0), 0.001);
        assertEquals(0.5, fuzzySet.zugehoerigkeit(45.0), 0.001);
        assertEquals(0.0, fuzzySet.zugehoerigkeit(50.0), 0.001);
        assertEquals(0.0, fuzzySet.zugehoerigkeit(51.0), 0.001);
    }

    @Test
    public void testSteigendeRampe() {
        FuzzySet fuzzySet = FuzzySet.steigendeRampe("Steigende Rampe", 20, 30, 40);

        assertEquals("Steigende Rampe", fuzzySet.getName());
        assertEquals(20.0, fuzzySet.getT1(), 0.001);
        assertEquals(30.0, fuzzySet.getT2(), 0.001);
        assertEquals(40.0, fuzzySet.getT3(), 0.001);
        assertEquals(40.0, fuzzySet.getT4(), 0.001);

        assertTrue(fuzzySet.isAufsteigendeRampe());
        assertFalse(fuzzySet.isDreieck());
        assertFalse(fuzzySet.isSingleton());
        assertFalse(fuzzySet.isTrapez());
        assertFalse(fuzzySet.isAbfallendeRampe());

        assertEquals(0.0, fuzzySet.zugehoerigkeit(19.0), 0.001);
        assertEquals(0.0, fuzzySet.zugehoerigkeit(20.0), 0.001);
        assertEquals(0.2, fuzzySet.zugehoerigkeit(22.0), 0.001);
        assertEquals(1.0, fuzzySet.zugehoerigkeit(30.0), 0.001);
        assertEquals(1.0, fuzzySet.zugehoerigkeit(35.0), 0.001);
        assertEquals(1.0, fuzzySet.zugehoerigkeit(40.0), 0.001);
        assertEquals(0.0, fuzzySet.zugehoerigkeit(41.0), 0.001);
    }

    @Test
    public void testFallendeRampe() {
        FuzzySet fuzzySet = FuzzySet.fallendeRampe("Fallende Rampe", 20, 30, 40);

        assertEquals("Fallende Rampe", fuzzySet.getName());
        assertEquals(20.0, fuzzySet.getT1(), 0.001);
        assertEquals(20.0, fuzzySet.getT2(), 0.001);
        assertEquals(30.0, fuzzySet.getT3(), 0.001);
        assertEquals(40.0, fuzzySet.getT4(), 0.001);

        assertTrue(fuzzySet.isAbfallendeRampe());
        assertFalse(fuzzySet.isDreieck());
        assertFalse(fuzzySet.isSingleton());
        assertFalse(fuzzySet.isTrapez());
        assertFalse(fuzzySet.isAufsteigendeRampe());

        assertEquals(0.0, fuzzySet.zugehoerigkeit(19.0), 0.001);
        assertEquals(1.0, fuzzySet.zugehoerigkeit(20.0), 0.001);
        assertEquals(1.0, fuzzySet.zugehoerigkeit(22.0), 0.001);
        assertEquals(1.0, fuzzySet.zugehoerigkeit(30.0), 0.001);
        assertEquals(0.5, fuzzySet.zugehoerigkeit(35.0), 0.001);
        assertEquals(0.0, fuzzySet.zugehoerigkeit(40.0), 0.001);
        assertEquals(0.0, fuzzySet.zugehoerigkeit(41.0), 0.001);
    }

}
