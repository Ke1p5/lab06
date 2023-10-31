package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int LOW = 1_000;
    private static final int HIGH = 2_000;
    private static final int ELEMS = 100_000;



    private static void printTime(final List<Integer> list, final String op, Long time, int number) {
        
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            op + " "
                + number
                + " ints in an ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String[] s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        List<Integer> arr = new ArrayList<>(1000);

        for (int i = LOW; i < HIGH; i++) {
            arr.add(i);
        }


        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

        List<Integer> link = new LinkedList<>(arr);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        final int pHolder = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        arr.set(arr.size() - 1, pHolder);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

        System.out.print("Arr: ");
        for (Integer elem: arr) {
            System.out.print(elem + " ");
        }

        System.out.println();

        System.out.print("Link: ");
        for (Integer elem: link) {
            System.out.print(elem + " ");
        }

        System.out.println();

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

        long timeArr = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            arr.add(0, i);
        }

        printTime(arr, "Adding", timeArr, ELEMS);

        /*
        timeArr = System.nanoTime() - timeArr;
        var millisArr = TimeUnit.NANOSECONDS.toMillis(timeArr);
        System.out.println(// NOPMD
            "Adding "
                + arr.size()
                + " ints in an ArrayList took "
                + timeArr
                + "ns ("
                + millisArr
                + "ms)"
        );
        */
        
        long timeLink = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            link.add(0, i);
        }

        printTime(link, "Adding", timeLink, ELEMS);

        /*
        timeLink = System.nanoTime() - timeLink;
        var millisLink = TimeUnit.NANOSECONDS.toMillis(timeLink);
        System.out.println(// NOPMD
            "Adding "
                + ELEMS
                + " ints in a LinkedList took "
                + timeLink
                + "ns ("
                + millisLink
                + "ms)"
        ); */

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        
        timeArr = System.nanoTime();
        for (int i = 1; i <= LOW; i++) {
            arr.get(arr.size()/2);
        }

        printTime(arr, "Reading", timeArr, LOW);
        
        /*
        timeArr = System.nanoTime() - timeArr;
        millisArr = TimeUnit.NANOSECONDS.toMillis(timeArr);
        System.out.println(// NOPMD
            "Reading "
                + LOW
                + " ints in a ArrayList took "
                + timeArr
                + "ns ("
                + millisArr
                + "ms)"
        );
        */

        timeLink = System.nanoTime();
        for (int i = 1; i <= LOW; i++) {
            link.get(link.size()/2);
        }
        
        printTime(link, "Reading", timeLink, LOW);

        /*
        timeLink = System.nanoTime() - timeLink;
        millisLink = TimeUnit.NANOSECONDS.toMillis(timeLink);
        System.out.println(// NOPMD
            "Reading "
                + LOW
                + " ints in a LinkedList took "
                + timeArr
                + "ns ("
                + millisLink
                + "ms)"
        );
        */

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        final Map<String, Long> continents = new HashMap<>();

        continents.put("Africa", 1_110_635_000L);
        continents.put("Americas", 972_005_000L);
        continents.put("Antarctica", 0L);
        continents.put("Asia", 4_298_723_000L);
        continents.put("Europe", 742_452_000L);
        continents.put("Oceania", 38_304_000L);

        /*
         * 8) Compute the population of the world
         */

        long wp = 0;
        for (Long l: continents.values()) {
            wp += l;
        }

        System.out.println("Total World population is: " + wp);
    }
}
