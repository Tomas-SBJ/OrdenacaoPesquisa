import Entity.Orders.*;
import Entity.Searches.BinarySearch;
import Entity.Searches.ResultSearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

/**
 * Classe main da aplicação
 *
 * @author Tomás Schaefer Borges de Jesus
 */

public class Application
{
    public static void main(String[] args)
    {
        //Método de ordenação por InsertionSort demora aproximadamente 70.000 ms.
        //Método de ordenação por QuickSort demora aproximadamente 79 ms.
        //Método de ordenação por MergeSort demora aproximadamente ????????????????????????????

        //"C:\\Users\\tomas\\Downloads\\NumerosOrdenarArquivoLong.txt"
        //"C:\\Users\\tomas\\Downloads\\NumerosOrdenarArquivoShort.txt"
        int option;
        long value;
        String loop;

        BinarySearch binarySearch = new BinarySearch();
        Ordination ordination;

        Scanner keyboard = new Scanner(System.in);

        try
        {
            System.out.println("Informe o caminho do arquivo");
            String path = keyboard.nextLine();
            long[] file = loadData(path);

            System.out.println("""
                    Informe um método de ordenação:
                    1 - QuickSort
                    2 - InsertionSort
                    3 - MergeSort
                    """);

            option = keyboard.nextInt();

            switch (option)
            {
                case 1 -> ordination = new QuickSort();

                case 2 -> ordination = new InsertionSort();

                /* case 3 ->
                {
                    ordination = new MergeSort();
                }
                */
                default -> throw new Exception("Opção inválida.");
            }

            ResultOrder orderedList = ordination.Order(file);

            for (int i = 0; i < orderedList.getResult().length; i++)
            {
                System.out.println(orderedList.getResult()[i]);
            }

            System.out.println(orderedList.getTime());

            do
            {
                System.out.println("Informe o valor a ser pesquisado:");
                value = keyboard.nextLong();

                ResultSearch resultSearch = binarySearch.Researching(orderedList.getResult(), value);

                if (resultSearch.getResult() != -1)
                {
                    System.out.println("Valor encontrado na posição: " + resultSearch.getResult());
                }
                else
                {
                    System.out.println("Valor não encontrado.");
                }

                System.out.println(resultSearch.getTime());

                System.out.println("""
                                   Deseja pesquisar outro número ? 
                                   Se deseja continuar digite "SIM",
                                   caso não queira continuar, digite qualquer coisa.
                                   """);
                loop = keyboard.next().toLowerCase(Locale.ROOT);
            } while(loop.equals("sim"));
        }
        catch (IOException ex)
        {
            System.out.println("Erro no arquivo selecionado.");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally
        {
            System.out.println("Processo finalizada");
        }
    }

    private static long[] loadData(String route) throws IOException {
        Path path = Paths.get(route);
        return Files.lines(path).mapToLong(Long::parseLong).toArray();
    }
}