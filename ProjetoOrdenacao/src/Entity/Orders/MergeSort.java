package Entity.Orders;

import java.util.ArrayList;

/**
 * Classe que ordena um vetor de elementos, utilizando o MergeSort.
 *
 * @author Anthony de Zutter
*/

public class MergeSort extends Ordination
{
    private long[] vetor;

    @Override
    public ResultOrder Order(long[] entry)
    {
        ResultOrder result = new ResultOrder();

        long initialTime = System.currentTimeMillis();
        long[] returnee = mergeSort(entry);
        long endTime = System.currentTimeMillis();

        result.setTime("Executado em = " + (endTime - initialTime) + " ms");
        result.setResult(returnee);

        return result;
    }


    public long[] mergeSort(long[] vetor)
    {
        this.vetor = vetor;

        divide(0, vetor.length -1);

        return vetor;
    }

    private void divide(int startIndex, int endIndex)
    {
        if (startIndex < endIndex && endIndex - startIndex >= 1)
        {
            int mid = (endIndex + startIndex) / 2;
            divide(startIndex, mid);
            divide(mid+1, endIndex);

            merge(startIndex, mid, endIndex);
        }
    }

    private void merge(int startIndex, int midIndex, int endIndex)
    {
        ArrayList<Long> mergedSortedArray = new ArrayList<>();

        int leftIndex = startIndex;
        int rightIndex = midIndex+1;

        while (leftIndex <= midIndex && rightIndex <= endIndex)
        {
            if (vetor[leftIndex] <= vetor[rightIndex])
            {
                mergedSortedArray.add(vetor[leftIndex]);
                leftIndex++;
            }else
            {
                mergedSortedArray.add(vetor[rightIndex]);
                rightIndex++;
            }
        }

        while (leftIndex <= midIndex)
        {
            mergedSortedArray.add(vetor[leftIndex]);
            leftIndex++;
        }


        while (rightIndex <= endIndex)
        {
            mergedSortedArray.add(vetor[rightIndex]);
            rightIndex++;
        }

        int i = 0;
        int j = startIndex;
        while (i < mergedSortedArray.size())
        {
            vetor[j] = mergedSortedArray.get(i++);
            j++;
        }
    }
}
