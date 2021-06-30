package Entity.Orders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

class MergeSortTest
{
    ArrayList<Long> vetorDesorganizado = new ArrayList<>();
    ArrayList<Long> vetorOrganizado = new ArrayList<>();

    @BeforeEach
    public void init()
    {
        Collections.addAll(vetorDesorganizado,
                73647824497L, 85825632001L,
                40003221080L, 47471692717L, 37981948331L);

        Collections.addAll(vetorOrganizado,
                37981948331L, 40003221080L,
                47471692717L, 73647824497L, 85825632001L);
    }

    @Test
    void MergeSort()
    {
        MergeSort merge = new MergeSort(vetorDesorganizado);

        assertEquals(vetorOrganizado, merge.sort());
    }
}