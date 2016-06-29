package pl.zankowski.algorithm.structures;

/**
 * @author Wojciech Zankowski
 */
public class PoorArrayList<T> {

    public static final int DEFAULT_SIZE = 10;

    private Object[] array;
    private int size = 0;

    public PoorArrayList() {
        array = new Object[DEFAULT_SIZE];
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newLength = array.length * 2;
            Object[] newArray = new Object[newLength];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
    }

    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    public T get(int i) {
        if (i >= size) {
            throw new IndexOutOfBoundsException("Fail.");
        } else {
            return (T) array[i];
        }
    }

    public T remove(int i) {
        if (i >= size) {
            throw new IndexOutOfBoundsException("Fail.");
        } else {
            final T object = (T) array[i];

            internalRemove(i);

            return object;
        }
    }

    private void internalRemove(int i) {
        int length = array.length - (i + 1);
        System.arraycopy(array, i + 1, array, i, length);
        array[--size] = null;
    }

    public boolean remove(T object) {
        for (int i = 0; i < size; i++) {
            if (object.equals(array[i])) {
                internalRemove(i);
                return true;
            }
        }
        return false;
    }

}
