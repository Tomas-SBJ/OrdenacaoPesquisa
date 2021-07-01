package Entity.Orders;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest
{
    long[] vetorDesorganizado = { 5, 1, 6, 2, 3, 4 };
    long[] vetorOrganizado = { 1, 2, 3, 4, 5, 6 };

    @Test
    void MergeSort()
    {
        MergeSort merge = new MergeSort();
        long[] result = merge.mergeSort(vetorDesorganizado);

        assertArrayEquals(vetorOrganizado, result);
    }
}