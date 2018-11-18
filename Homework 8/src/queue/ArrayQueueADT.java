package queue;

/**
 * Created by Nikolay Yarlychenko on 18/11/2018
 */
public class ArrayQueueADT {
    private int head = 0;
    private int tail = 0;
    private Object[] elements = new Object[5];

    public static void enqueue(ArrayQueueADT queue, Object element) {
        assert element != null;

        ensureCapacity(queue, size(queue) + 1);
        queue.elements[queue.tail] = element;
        queue.tail = (queue.tail + 1) % queue.elements.length;
    }

    private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
        if (capacity < queue.elements.length) {
            return;
        }
        Object[] newElements = new Object[2 * capacity];
        int currentId = 0;
        if (queue.tail < queue.head) {
            for (int i = queue.head; i < queue.elements.length; i++) {
                newElements[currentId++] = queue.elements[i];
            }
            for (int i = 0; i < queue.tail; i++) {
                newElements[currentId++] = queue.elements[i];
            }
        } else {
            for (int i = queue.head; i < queue.tail; i++) {
                newElements[currentId++] = queue.elements[i];
            }
        }
        queue.head = 0;
        queue.tail = currentId;
        queue.elements = newElements;
    }

    public static Object element(ArrayQueueADT queue) {
        assert size(queue) > 0;
        return queue.elements[queue.head];
    }

    public static Object dequeue(ArrayQueueADT queue) {
        assert size(queue) > 0;
        Object element = queue.elements[queue.head];
        queue.head = (queue.head + 1) % queue.elements.length;
        return element;
    }


    public static int size(ArrayQueueADT queue) {
        if (queue.head > queue.tail) {
            return queue.elements.length - queue.head + queue.tail;
        } else {
            return queue.tail - queue.head;
        }
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.head == queue.tail;
    }

    public static void clear(ArrayQueueADT queue) {
        queue.head = 0;
        queue.tail = 0;
    }
}