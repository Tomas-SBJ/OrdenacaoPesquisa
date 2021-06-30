package Entidades.Pesquisas;

public class BinarySearch extends Research {

    @Override
    public ResultadoPesquisa Pesquisa(long[] entrada, long valor) {

        ResultadoPesquisa resultado = new ResultadoPesquisa();

        long tempoInicial = System.currentTimeMillis();

        int retorno = pesquisaBinaria(entrada,0,entrada.length-1,valor);

        long tempoFinal = System.currentTimeMillis();

        resultado.setTempo("Executado em = " + (tempoFinal - tempoInicial) + " ms");

        resultado.setResultado(retorno);

        return resultado;
    }


    private int pesquisaBinaria(long[] vetor, int esquerda, int direita, long valor) {
        if(direita >= esquerda) {
            int indice = (esquerda + (direita-esquerda)/2);
            if(vetor[indice]==valor) {
                return indice;
            }
            if(vetor[indice] > valor) {
                return pesquisaBinaria(vetor,esquerda,indice-1,valor);
            }
            return pesquisaBinaria(vetor, indice+1, direita, valor);
        }
        return-1;
    }

}
