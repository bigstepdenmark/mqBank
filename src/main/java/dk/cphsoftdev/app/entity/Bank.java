package dk.cphsoftdev.app.entity;

public class Bank
{
    private int minCreditScore;
    private String name;
    private String id;

    public Bank( int minCreditScore, String name, String id )
    {
        this.minCreditScore = minCreditScore;
        this.name = name;
        this.id = id;
    }

    public int getMinCreditScore()
    {
        return minCreditScore;
    }

    public void setMinCreditScore( int minCreditScore )
    {
        this.minCreditScore = minCreditScore;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Bank{" +
                "minCreditScore=" + minCreditScore +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
