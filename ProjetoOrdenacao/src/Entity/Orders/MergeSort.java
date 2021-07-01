package Entity.Orders;

import java.util.ArrayList;

/**
 * Classe que ordena um vetor de elementos, utilizando o Merge Sort.
 *
 * @author Anthony de Zutter
*/

public class MergeSort
{
    private ArrayList<Long> vetor;

    public MergeSort(ArrayList<Long> vetor)
    {
        this.vetor = vetor;
    }

    public ArrayList<Long> sort()
    {
        divide(0, vetor.size()-1);

        return vetor;
    }

    private void divide(int startIndex, int endIndex)
    {

        if (startIndex < endIndex && endIndex - startIndex >= 1) {
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

        while (leftIndex <= midIndex && rightIndex <= endIndex) {
            if (vetor.get(leftIndex) <= vetor.get(rightIndex)) {
                mergedSortedArray.add(vetor.get(leftIndex));
                leftIndex++;
            }else {
                mergedSortedArray.add(vetor.get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex <= midIndex) {
            mergedSortedArray.add(vetor.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex <= endIndex) {
            mergedSortedArray.add(vetor.get(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = startIndex;
        while (i < mergedSortedArray.size()) {
            vetor.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }
}
