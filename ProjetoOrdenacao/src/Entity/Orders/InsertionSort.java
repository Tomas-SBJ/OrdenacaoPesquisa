package Entity.Orders;

public class InsertionSort extends Ordination {

    @Override
    public ResultOrder Order(long[] entry)
    {
        ResultOrder result = new ResultOrder();

        long initialTime = System.currentTimeMillis();
        long[] returnee = insertionSort(entry);
        long endTime = System.currentTimeMillis();

        result.setTime("Executado em = " + (endTime - initialTime) + " ms");
        result.setResult(returnee);

        return result;
    }

    private static long[] insertionSort(long []vetor)
    {
        long x;
        int j;

        for (int i = 1; i < vetor.length; i++)
        {
            x = vetor[i];
            j = i - 1;

            while(j >= 0 && vetor[j] > x)
            {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = x;
        }
        return vetor;
    }
}