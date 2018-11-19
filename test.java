import org.junit.Test;
import static org.junit.Assert.*;


public class test {

    @Test
    public void heapTest() {
        int n = 8;
        Integer[] arr = new Integer[n];
        arr[0] = 5;
        arr[1] = 4;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 1;

        MaxHeap<Integer> mh = new MaxHeap<>(arr, 5);

        System.out.println("-----------Initial heap contents:---------");

        for (int i = 0; i < mh._numNodes; i++) {

            System.out.println(mh._nodeArray[i]);
        }

        mh.add(8);

        System.out.println("-----------After adding 8:---------");

        for (int i = 0; i < mh._numNodes; i++) {

            System.out.println(mh._nodeArray[i]);
        }

        mh.removeLargest();

        System.out.println("-----------After removing largest:---------");
        for (int i = 0; i < mh._numNodes; i++) {

            System.out.println(mh._nodeArray[i]);
        }

        boolean contains5 = mh.contains(5);
        assertTrue(contains5);

        boolean contains8 = mh.contains(8);
        assertFalse(contains8);

    }
}
