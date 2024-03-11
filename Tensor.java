import java.util.Arrays;

public class Tensor<T> {
    T[][] data;
    int nRow, nCol;

    public Tensor(T[][] data) {
        this.data = data;
        this.nRow = data.length;
        this.nCol = data[0].length;
    }

    public int getNumRows() {
        return nRow;
    }

    public int getNumCols() {
        return nCol;
    }

    public T get(int row, int col) throws IndexOutOfBoundsException {
        if (isValidIndex(row, col)) {
            return data[row][col];
        } else {
            throw new IndexOutOfBoundsException("Index (" + row + ", " + col + ") out of bounds");
        }
    }

    public void set(int row, int col, T value) throws IndexOutOfBoundsException {
        if (isValidIndex(row, col)) {
            data[row][col] = value;
        } else {
            throw new IndexOutOfBoundsException("Index (" + row + ", " + col + ") out of bounds");
        }
    }

    public void print() {
        for (int i = 0; i < nRow; i++) {
            System.out.println(Arrays.toString(data[i]));
        }
    }

    public Tensor<T> view(int newRows, int newCols) throws IllegalArgumentException {
        if (nRow * nCol != newRows * newCols) {
            throw new IllegalArgumentException("New shape must have the same number of elements");
        }

        // Create a new view object with same data but adjusted dimensions
        T[][] newData = createSubArray(0, nRow, 0, nCol);
        return new Tensor<>(newData);
    }

    // Helper method to extract a subarray from the data
    private T[][] createSubArray(int startRow, int endRow, int startCol, int endCol) {
        int newRows = endRow - startRow;
        int newCols = endCol - startCol;
        T[][] subArray = (T[][]) new Object[newRows][newCols];
        for (int i = 0; i < newRows; i++) {
            System.arraycopy(data[startRow + i], startCol, subArray[i], 0, newCols);
        }
        return subArray;
    }

    // Check if index is within bounds
    private boolean isValidIndex(int row, int col) {
        return row >= 0 && row < nRow && col >= 0 && col < nCol;
    }

    // You can add other methods specific to your use case, e.g., arithmetic operations, slicing, etc.
}
