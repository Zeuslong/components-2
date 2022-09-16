package cn.vxnm.component.jdk11.collections;

import java.util.*;
import java.util.function.Function;

/**
 * 集合打印工具
 */
public class CollectionPrinter {

    public static int FLUSH_LIMIT = 1024;

    public static String SEPARATOR = "========";

    public static <T> void printArray(T[] array) {
        printArray(array, Objects::toString);
    }

    /**
     * 打印数组
     * <p>
     * | id: 1 | id: 2 | id: 3 |
     * <p>
     * eg:
     * String[] strings = {"a", "b", "c", "d"};
     * CollectionPrinter.printArray(strings, Object::toString);
     *
     * @param array 需要打印的数组
     * @param <T>   数组元素类型
     * @param f     调用该方法来转化对象为数据并打印这些数据
     */
    public static <T> void printArray(T[] array, Function<T, String> f) {

        if (array == null) {
            System.out.println("null array");
            return;
        } else if (array.length == 0) {
            System.out.println("empty array");
            return;
        }

        // 这里拷贝出来不影响原来数据
        T[] arrayCopy = Arrays.copyOf(array, array.length);

        String itemFormatter = "| %s ";
        StringBuilder printBuff = new StringBuilder(FLUSH_LIMIT);

        System.out.println(SEPARATOR);

        for (T t : array) {
            String item = f.apply(t);
            String printArgs = String.format(itemFormatter, item);
            printBuff.append(printArgs);

            if (printBuff.length() >= FLUSH_LIMIT) {
                System.out.print(printBuff.toString());
                printBuff.delete(0, printBuff.length());
            }
        }

        System.out.print(printBuff.toString());
        System.out.print("|\n");
    }

    public static <T> void printList(List<T> list) {
        printList(list, Objects::toString);
    }

    /**
     * 打印 List
     * <p>
     * | id: 1 | -- | id: 2 | -- | id: 3 |
     * <p>
     * eg:
     * String[] strings = {"a", "b", "c", "d"};
     * List<String> stringList = Arrays.asList(strings);
     * CollectionPrinter.printList(stringList, Object::toString);
     *
     * @param list 需要打印的列表
     * @param <T>  数组元素类型
     * @param f    调用该方法来转化对象为数据并打印这些数据
     */
    public static <T> void printList(List<T> list, Function<T, String> f) {
        if (list == null) {
            System.out.println("null list");
            return;
        } else if (list.size() == 0) {
            System.out.println("empty list");
            return;
        }

        List<T> listCopy = List.copyOf(list);

        String itemFormatter = "| %s |";
        String next = " -- ";
        StringBuilder printBuff = new StringBuilder(FLUSH_LIMIT);

        System.out.println(SEPARATOR);

        int counter = 0;
        for (T t : listCopy) {
            String item = f.apply(t);

            if (counter == 0) {
                printBuff.append(String.format(itemFormatter, item));
            } else {
                printBuff.append(next).append(String.format(itemFormatter, item));
            }

            counter++;

            if (printBuff.length() >= FLUSH_LIMIT) {
                System.out.print(printBuff.toString());
                printBuff.delete(0, printBuff.length());
            }
        }

        System.out.print(printBuff.toString());
        System.out.print("\n");
    }

    public static <K, V> void printMap(Map<K, V> map) {
        printMap(map, Object::toString, Objects::toString);
    }

    /**
     * 打印 Map
     * <p>
     * | key | -> | value |
     * | key | -> | value |
     * | key | -> | value |
     * <p>
     * eg:
     * Map<String, Integer> map = new HashMap<>(3);
     * map.put("A", 1);
     * map.put("B", 2);
     * map.put("C", 3);
     * CollectionPrinter.printMap(map, Object::toString, Object::toString);
     *
     * @param map    需要被打印的数据
     * @param keyF   序列化 key 的函数
     * @param valueF 序列化 value 的函数
     * @param <K>    key 的泛型
     * @param <V>    value 的泛型
     */
    public static <K, V> void printMap(Map<K, V> map, Function<K, String> keyF, Function<V, String> valueF) {
        if (map == null) {
            System.out.println("null map");
            return;
        } else if (map.size() == 0) {
            System.out.println("empty map");
            return;
        }

        Map<K, V> mapCopy = Map.copyOf(map);

        String itemFormatter = "| %s | -> | %s |\n";
        StringBuilder printBuff = new StringBuilder(FLUSH_LIMIT);

        Map<K, V> readView = Map.copyOf(map);
        Set<Map.Entry<K, V>> readViewSet = readView.entrySet();

        System.out.println(SEPARATOR);

        for (Map.Entry<K, V> entry : readViewSet) {
            String key = keyF.apply(entry.getKey());
            String value = valueF.apply(entry.getValue());
            String printArgs = String.format(itemFormatter, key, value);
            printBuff.append(printArgs);

            if (printBuff.length() >= FLUSH_LIMIT) {
                System.out.print(printBuff.toString());
                printBuff.delete(0, printBuff.length());
            }
        }

        System.out.print(printBuff.toString());
    }

    public static <T> void printSet(Set<T> set) {
        printSet(set, Object::toString);
    }

    /**
     * 打印 Set
     * <p>
     * | id: 1 | id: 2 | id: 3 |
     * <p>
     * Set<String> set = new HashSet<>(4);
     * set.add("a");
     * set.add("b");
     * set.add("c");
     * set.add("d");
     * CollectionPrinter.printSet(set, Objects::toString);
     *
     * @param set 需要被打印的数据
     * @param f   序列化元素的函数
     */
    public static <T> void printSet(Set<T> set, Function<T, String> f) {
        if (set == null) {
            System.out.println("null set");
            return;
        } else if (set.size() == 0) {
            System.out.println("empty set");
            return;
        }

        Set<T> setCopy = Set.copyOf(set);

        String itemFormatter = "| %s ";
        StringBuilder printBuff = new StringBuilder(FLUSH_LIMIT);
        T[] ts = (T[]) set.toArray();

        System.out.println(SEPARATOR);

        for (T t : ts) {
            String item = f.apply(t);
            String printArgs = String.format(itemFormatter, item);
            printBuff.append(printArgs);

            if (printBuff.length() >= FLUSH_LIMIT) {
                System.out.print(printBuff.toString());
                printBuff.delete(0, printBuff.length());
            }
        }

        System.out.print(printBuff.toString());
        System.out.print("|\n");
    }

    public static <T> void printQueue(Queue<T> queue) {
        printQueue(queue, Objects::toString);
    }

    /**
     * 打印队列
     * <p>
     * <- | id: 1 | id: 2 | id: 3 | <-
     * <p>
     * Queue<String> queue = new LinkedList<String>();
     * queue.offer("a");
     * queue.offer("b");
     * queue.offer("c");
     * queue.offer("d");
     * CollectionPrinter.printQueue(queue);
     *
     * @param queue 需要被打印的队列
     * @param f     序列化元素的函数
     * @param <T>   容器内元素的泛型
     */
    public static <T> void printQueue(Queue<T> queue, Function<T, String> f) {
        if (queue == null) {
            System.out.println("Null queue");
            return;
        } else if (queue.size() == 0) {
            System.out.println("Empty Queue");
            return;
        }

        T[] queueCopy = (T[]) Arrays.copyOf(queue.toArray(), queue.size());

        String itemFormatter = "| %s ";
        StringBuilder printBuff = new StringBuilder(FLUSH_LIMIT);

        System.out.println(SEPARATOR);
        System.out.printf("<- ");

        for (T t : queueCopy) {
            String item = f.apply(t);
            String printArgs = String.format(itemFormatter, item);
            printBuff.append(printArgs);

            if (printBuff.length() >= FLUSH_LIMIT) {
                System.out.print(printBuff.toString());
                printBuff.delete(0, printBuff.length());
            }
        }

        System.out.print(printBuff.toString());
        System.out.print("| <-");
        System.out.println();
    }

    public static <T> void printStack(Stack<T> stack) {
        printStack(stack, Objects::toString);
    }

    /**
     * 打印栈信息
     * <p>
     *    ↓  ↑
     * | id: 1 |
     * ---------
     * | id: 2 |
     * ---------
     * | id: 3 |
     * ---------
     *
     * @param stack 需要被打印的栈
     * @param f     序列化元素的函数
     * @param <T>   容器内元素的泛型
     */
    public static <T> void printStack(Stack<T> stack, Function<T, String> f) {
        if (stack == null) {
            System.out.println("Null stack");
            return;
        }
        else if (stack.isEmpty()) {
            System.out.println("Empty stack");
            return;
        }

        Stack<T> stackCopy = (Stack<T>) stack.clone();
        List<String> stackList = new ArrayList<>(stackCopy.size());


        int maxLength = 0;
        for (T t : stackCopy) {
            String item = f.apply(t);
            stackList.add(item);
            if (item.length() > maxLength) {
                maxLength = item.length();
            }
        }

        System.out.println();

        System.out.println(SEPARATOR);

        for (String s : stackList) {
            int startLength = Math.floorDiv(maxLength - s.length(), 2);
            int endLength = maxLength - s.length() - startLength;
            System.out.println("| " + String.valueOf(' ').repeat(startLength) + s + String.valueOf(' ').repeat(endLength) + " |");
            System.out.println(String.valueOf('-').repeat(maxLength + 4));
        }
    }
}
