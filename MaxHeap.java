class MaxHeap <T extends Comparable<T>> {
    public T[] _nodeArray;
    public int _numNodes; // public just to make it easier in the tests.


    public MaxHeap (T[] arr, int elemNum) {
        _nodeArray = arr;
        _numNodes = elemNum;

    }

    public T findLargest () {
        return _nodeArray[0];
    }

    public void add (T o) {
        _nodeArray[_numNodes] = o;
        _numNodes++;

        // bubble Up the element just added, that now is at position _numElements -1.
        int i = _numNodes - 1;
        while ((i-1)/2 >= 0 && _nodeArray[i].compareTo(_nodeArray[(i-1)/2]) > 0) {
            swap(i, (i-1)/2);
            i = (i-1)/2;
        }
    }

    public boolean contains (T data) {
        for (int i = 0; i < _numNodes; i++) {
            if (_nodeArray[i].equals(data)) {
                return true;
            }
        }
        return false;
    }


    public void removeLargest () {
        _nodeArray[0] = _nodeArray[_numNodes - 1];
        _nodeArray[_numNodes - 1] = null;
        _numNodes--;
        trickleDown(0);
    }

    private void trickleDown(int index) {
        int iBiggestChild = findIndexBiggestChild(index);

        while (iBiggestChild != -1) {
            swap(index, iBiggestChild);
            iBiggestChild = findIndexBiggestChild(iBiggestChild);
        }
    }


    // findIndexBiggestChild returns -1 if no changes have to be made (if the node at index position is a leaf or it is already larger than
    // its subtree).

    private int findIndexBiggestChild (int index) {
        int iBiggestChild = -1;
        if (_nodeArray[2*index + 1] != null && _nodeArray[2*index + 2] != null) {
            if (_nodeArray[2*index + 1].compareTo(_nodeArray[2*index + 2]) > 0) {
                iBiggestChild = 2*index + 1; // left child is the biggest child
            } else {
                iBiggestChild = 2*index + 2; // right child is the biggest child
            }
        } else if (_nodeArray[2*index + 1] != null && _nodeArray[2*index + 1].compareTo(_nodeArray[index]) > 0) {
            iBiggestChild = 2*index + 1;
        } else if (_nodeArray[2*index + 2] != null && _nodeArray[2*index + 2].compareTo(_nodeArray[index]) > 0) {
            iBiggestChild = 2*index + 2;
        }
        // if none of these of above happen then this means that the node at index position is already a leaf.
        return iBiggestChild;
    }

    private void swap(int pos1, int pos2) {
        T c = _nodeArray[pos1];
        _nodeArray[pos1] = _nodeArray[pos2];
        _nodeArray[pos2] = c;
    }
}