package Entity.Orders;

/**
 * Classe que ordena um vetor de elementos, utilizando o QuickSort.
 *
 * @author Reinaldo dos Santos Junior
 */

public class QuickSort extends Ordination
{
    @Override
    public ResultOrder Order(long[] entrada)
    {
        ResultOrder result = new ResultOrder();

        long initialTime = System.currentTimeMillis();
        long[] returnee = quickSort(entrada,0,entrada.length-1);
        long endTime = System.currentTimeMillis();

        result.setTime("Executado em = " + (endTime - initialTime) + " ms");

        result.setResult(returnee);

        return result;
    }

    private static long[] quickSort(long[] vetor, int initial, int end)
    {
        if (initial < end)
        {
            int posicaoPivo = split(vetor, initial, end);
            quickSort(vetor, initial, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, end);
        }
        return vetor;
    }

    private static int split(long[] vetor, int initial, int end)
    {
        long pivo = vetor[initial];
        int i = initial + 1, f = end;
        while (i <= f)
        {
            if (vetor[i] <= pivo)
            {
                i++;
            } else if (pivo < vetor[f])
            {
                f--;
            } else
            {
                long trade = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = trade;
                i++;
                f--;
            }
        }
        vetor[initial] = vetor[f];
        vetor[f] = pivo;
        return f;
    }
}