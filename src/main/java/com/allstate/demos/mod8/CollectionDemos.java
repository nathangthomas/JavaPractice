package com.allstate.demos.mod8;

import java.util.*;

public class CollectionDemos {

    public static <K, V extends Comparable<V>> Map<K, V>
    valueSort(final Map<K, V> map) {
        // Static Method with return type Map and
        // extending comparator class which compares values
        // associated with two keys
        Comparator<K> valueComparator = new Comparator<K>() {

            // return comparison results of values of
            // two keys
            public int compare(K k1, K k2) {
                int comp = map.get(k1).compareTo(
                        map.get(k2));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }
        };

        // SortedMap created using the comparator
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }

    public static void main(String[] args) {
        List lst1 = new ArrayList();
        lst1.add(12);
        lst1.add("Dee");

        for (Object item: lst1) {
            System.out.println(item);
        }

        //##################
        List<String> lst2 = new <String> ArrayList();
        lst2.add("Ann");
        lst2.add("Dee");
        lst2.add("Dee");
        lst2.add("Bill");

        for (String item: lst2) {
            System.out.println(item);
        }

        List<String> lst3 = new <String>LinkedList();
        lst3.add("Ann");
        lst3.add("Dee");
        lst3.add("Dee");
        lst3.add("Bill");
        for (String item: lst3) {
            System.out.println(item);
        }

        //###########SETS##########
        Set<String> set1 = new <String>TreeSet();
        set1.add("Ann");
        set1.add("Dee");
        set1.add("Dee");
        set1.add("Bill");
        for (String item: set1)
        {
            System.out.println("TS" + item);
        }

        //##############maps####
        Map<Integer,String> map1 = new <Integer,String>HashMap();
        map1.put(1,"Ann");
        map1.put(5,"Dee");
        map1.put(3,"Dee");
        map1.put(4,"Bill");

        Set<Map.Entry<Integer, String>> items = map1.entrySet();
        Iterator<Map.Entry<Integer, String>> iter = items.iterator();

        while (iter.hasNext()) {
            Map.Entry<Integer, String> entry = iter.next();
            int number  = entry.getKey();
            String name = entry.getValue();
            System.out.println(number + "\t: " + name);
        }

        System.out.println(map1);

        Map<Integer,String> map2 = new <Integer,String>TreeMap();
        map2.put(1,"Ann");
        map2.put(2,"Dee");
        map2.put(4,"Jill");
        map2.put(3,"Dee");
        map2.put(1,"Bill");
        map2.put(5,"Alex");

        // Calling the method valueSort
        Map sortedMap = valueSort(map2);

        // Get a set of the entries on the sorted map
        Set set = sortedMap.entrySet();

        // Get an iterator
        Iterator i = set.iterator();

        // Display elements
        while (i.hasNext()) {
            Map.Entry mp = (Map.Entry)i.next();
            System.out.print(mp.getKey() + ": ");
            System.out.println(mp.getValue());
        }

        testm(map1);
    }

    static void testm(Map mymap) {
    }
}