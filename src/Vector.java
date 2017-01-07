/**
 * Created by uzu on 1/7/17.
 */
public class Vector {
    private int elements[];
    private int capacity;
    private int size;

    public Vector() {
        elements = new int[1];
        capacity = 1;
        size = 0;
    }

    public Vector(int[] elements) {
        this();

        while (elements.length > capacity) {
            doubleSize();
        }
        this.elements = elements;
        size = elements.length;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public int at(int position) {
        return elements[position];
    }

    public void doubleSize() {
        capacity *= 2;
        int[] newElements = new int[capacity];
        System.arraycopy(elements, 0, newElements, 0, getSize());
        elements = newElements;
        System.out.println("Size doubled to: " + getCapacity());
    }

    public void halfSize() {
        capacity /= 2;
        int[] newElements = new int[capacity];
        System.arraycopy(elements, 0, newElements, 0, getSize());
        elements = newElements;
        System.out.println("Size halved to: " + getCapacity());
    }

    public void append(int newElement) {
        if (capacity == size) {
            doubleSize();
        }
        elements[size] = newElement;
        size++;
        System.out.println("Element added: " + newElement);
    }

    public void insert(int newElement, int position) {
        position = position % size;
        if (position < 0) {
            position += size;
        }
        if (capacity == size) {
            doubleSize();
        }
        int[] newElements = new int[capacity];
        System.arraycopy(elements, 0, newElements, 0, position);
        newElements[position] = newElement;
        System.arraycopy(elements, position, newElements, position + 1, size - position);
        size++;
        elements = newElements;
        System.out.println("Element added: " + newElement);
    }

    public void remove(int position) {
        position = position % size;
        if (position < 0) {
            position += size;
        }
        int[] newElements = new int[capacity];
        System.arraycopy(elements, 0, newElements, 0, position);
        System.arraycopy(elements, position + 1, newElements, position, size - position - 1);
        elements = newElements;
        size--;
        System.out.println("Element removed at position: " + position);
        if (capacity / 4 == size) {
            halfSize();
        }
    }

    public void printElements() {
        System.out.print("Elements of the vector are:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + elements[i]);

        }
        System.out.print("\n");
    }

}
