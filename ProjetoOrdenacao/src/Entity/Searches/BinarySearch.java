package Entity.Searches;

/**
 * Classe de pesquisa, utilizando o BinarySearch.
 *
 * @author Gabriel Puziski Machado
 */

public class BinarySearch extends Search
{
    @Override
    public ResultSearch Researching(long[] entry, long value)
    {
        ResultSearch result = new ResultSearch();

        long initialTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        int returnee = binarySearch(entry, 0, entry.length-1, value);

        result.setTime("Executado em = " + (endTime - initialTime) + " ms");
        result.setResult(returnee);

        return result;
    }

    private int binarySearch(long[] vetor, int esquerda, int direita, long valor)
    {
        if(direita >= esquerda)
        {
            int indice = (esquerda + (direita-esquerda)/2);

            if(vetor[indice]==valor)
            {
                return indice;
            }

            if(vetor[indice] > valor)
            {
                return binarySearch(vetor,esquerda,indice-1,valor);
            }
            return binarySearch(vetor, indice+1, direita, valor);
        }
        return -1;
    }
}
