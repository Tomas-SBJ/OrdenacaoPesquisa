package Entity.Orders;

public class InsertionSort extends Ordination {
    
    public ResultadoOrdenacao Ordena(long[] entrada) {
           ResultadoOrdenacao resultado = new ResultadoOrdenacao();

           long tempInicial = System.currentTimeMillis();
           long [] retorno = InsertionSort(entrada);
           long tempFinal = System.currentTimeMillis();

           resultado.setTempo ("Executado em= " (tempFinal - tempInicial + "ms"))
           resultado.setResultado (retorno);

}

    private static long[] insertionSort(long []vetor){
        long x;
        int j;
        for (int i=1; i< vetor.length; i++){
            x= vetor[i];
            j= i-1;
            while((j>0) && vetor[j] >x) {
                vetor[j+i] = vetor[j];
                j= j-1; }
            vetor[j+1]=x;
            return vetor;
        }
    }
}