package com.zafar.javapractice.arrays;

import junit.framework.TestCase;

public class ArraysExampleTest extends TestCase {

    ArraysExample ae = new ArraysExample();
    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }


    public void testArrayUpperCase() {
        String[] animals = new String[]{"dog", "cat", "fish"};
        ae.makeUpperCase(animals);
//        assertArrayEquals(new String[]{"DOG", "CAT", "FISH"}, animals);
    }
}