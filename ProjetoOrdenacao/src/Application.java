import Entity.Orders.*;
import Entity.Searches.ResultSearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Application
{
    public static void main(String[] args)
    {
        try
        {
            //"C:\\Users\\tomas\\Downloads\\NumerosOrdenarArquivo1.txt"
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Informe o caminho do arquivo");
            String path = keyboard.nextLine();
            long[] file = carregarDados(path);

            Ordination ordination;
            System.out.println("""
                    Informe um método de ordenação:
                    1 - QuickSort
                    2 - InsertionSort
                    3 - MergeSort
                    """);

            int option = keyboard.nextInt();

            switch (option)
            {
                case 1 ->
                {
                    ordination = new QuickSort();
                }

                case 2 ->
                {
                    ordination = new InsertionSort();
                }

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

            System.out.println("Informe o valor a ser pesquisado:");
            long value = keyboard.nextLong();

            BinarySearch binarySearch = new BinarySearch();
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
        }
        catch (IOException e)
        {
            System.out.println("Erro no arquivo selecionado.");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            System.out.println("Processo finalizada");
        }
    }

    private static long[] carregarDados(String route) throws IOException {
        Path path = Paths.get(route);
        return Files.lines(path).mapToLong(Long::parseLong).toArray();
    }
}