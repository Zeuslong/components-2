package cn.vxnm.component.jdk11.collections;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;

public class CollectionPrinterTest {

    @Test
    public void printArray() {

        CollectionPrinter.printArray(null, new Function<Object, String>() {
            @Override
            public String apply(Object o) {
                return o.toString();
            }
        });

        CollectionPrinter.printArray(new Object[]{}, new Function<Object, String>() {
            @Override
            public String apply(Object o) {
                return o.toString();
            }
        });

        String[] strings = {"a", "b", "c", "d"};
        CollectionPrinter.printArray(strings, new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        });

        Integer[] integers = {1, 2, 3, 4, 5};
        CollectionPrinter.printArray(integers, new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer.toString();
            }
        });
    }

    @Test
    public void printList() {

        CollectionPrinter.printArray(null, new Function<Object, String>() {
            @Override
            public String apply(Object o) {
                return o.toString();
            }
        });

        CollectionPrinter.printList(new ArrayList<String>(), new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        });

        String[] strings = {"a", "b", "c", "d"};
        List<String> stringList = Arrays.asList(strings);
        CollectionPrinter.printList(stringList, new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        });

        Integer[] integers = {1, 2, 3, 4, 5};
        List<Integer> integerList = Arrays.asList(integers);
        CollectionPrinter.printList(integerList, new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer.toString();
            }
        });
    }

    @Test
    public void printMap() {
        CollectionPrinter.printMap(null, Object::toString, Object::toString);

        Map<String, Integer> map = new HashMap<>(0);

        CollectionPrinter.printMap(map, Object::toString, Object::toString);

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        CollectionPrinter.printMap(map, Object::toString, Object::toString);
    }

    @Test
    public void printSet() {
        CollectionPrinter.printSet(null, Object::toString);

        Set<String> set = new HashSet<>(0);

        CollectionPrinter.printSet(set);

        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        CollectionPrinter.printSet(set, Objects::toString);
    }

    @Test
    public void printQueue() {
        CollectionPrinter.printQueue(null, Object::toString);

        Queue<String> queue = new LinkedList<String>();

        CollectionPrinter.printQueue(queue);

        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");

        CollectionPrinter.printQueue(queue);
    }

    @Test
    public void printStack() {
        CollectionPrinter.printStack(null, Object::toString);

        Stack<String> stack = new Stack<>();

        CollectionPrinter.printStack(stack, Object::toString);

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        CollectionPrinter.printStack(stack);

        stack.push("afasdfasdhe hbcvndhnxc");
        stack.push("bcvnsrdhdgxfbxcvnsdfgsdfgsdfg");
        stack.push("cvbxcvnrsths");
        stack.push("dbsdfh serg wer gedsgsd gs df");

        CollectionPrinter.printStack(stack);
    }
}