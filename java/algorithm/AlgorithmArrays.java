package algorithm;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zgh19
 */
public class AlgorithmArrays {

    public static void main(String[] args) {



        Item[] array = new Item[5];
        init(array);
        
        // Test
        System.out.println("The random item is " + randomAccess(array).name);

        insert(array, 2, new Item(333, "三"));
        printArray(array);

        delete(array, 5);
        printArray(array);

        taverse(array);

        System.out.println("The index is " + find(array,333));

        System.out.println("The new array's length is " + extend(array, 5).length);
    }

    // Initialize the array
    public static void init(Item[] array) {
        array[0] = new Item(1, "one");
        array[1] = new Item(2, "two");
        array[2] = new Item(3, "three");
        array[3] = new Item(4, "four");
        array[4] = new Item(5, "five");
    }

    // Random access the array
    public static Item randomAccess(Item[] array) {
        int index = ThreadLocalRandom.current().nextInt(0, array.length);
        return array[index];
    }

    // Insert an element into the array
    public static void insert(Item[] array, int index, Item aItem) {
        for (int i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = aItem;
    }

    // Delete an element from the array
    public static void delete(Item[] array, int index) {
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
    }

    // Taverse the array
    public static void taverse(Item[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("We are arriving at " + array[i].name);
        }
    }

    // Find an element in the array
    public static int find(Item[] array, int id) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].id == id) {
                return i;
            }
        }
        return -1;
    }

    // Extend the array
    public static Item[] extend(Item[] array, Integer addSize) {
        Item[] newArray = new Item[array.length + addSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    // Definition of item
    public static class Item {
        public Integer id;
        public String name;

        public Item(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    // print util
    private static void printArray(AlgorithmArrays.Item[] array) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i].name);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");

        System.out.println(sb);
    }
}