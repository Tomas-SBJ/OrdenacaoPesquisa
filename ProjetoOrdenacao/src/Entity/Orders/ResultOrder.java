package Entity.Orders;

/**
 * Classe ResultOrder
 *
 * @author Eduardo Machado de Medeiros
 */

public class ResultOrder
{
    private String Time;
    private long [] Result;

    public String getTime()
    {
        return Time;
    }

    public void setTime(String tempo)
    {
        Time = tempo;
    }

    public long[] getResult()
    {
        return Result;
    }

    public void setResult(long[] result)
    {
        Result = result;
    }
}