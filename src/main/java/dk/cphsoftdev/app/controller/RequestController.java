package dk.cphsoftdev.app.controller;

import dk.cphsoftdev.app.entity.Bank;
import dk.cphsoftdev.app.entity.Loan;

public class RequestController
{
    private Bank mqBank;

    public RequestController( Bank mqBank )
    {
        this.mqBank = mqBank;
    }

    public Loan toLoanObject( String request )
    {
        if( isValid( request ) )
        {
            return new Loan( request );
        }

        return null;
    }

    public boolean isValid( String request )
    {
        String[] values = request.split( "," );
        boolean isLengthValid = values.length == 4;
        boolean isValuesValid = isSSN( values[ 0 ] ) &&
                isCreditScore( values[ 1 ] ) &&
                isAmount( values[ 2 ] ) &&
                isDuration( values[ 3 ] );

        return isLengthValid && isValuesValid;
    }

    private boolean isSSN( String ssn )
    {
        return isNumber( ssn ) && ssn.length() == 10;
    }

    private boolean isCreditScore( String creditScore )
    {
        return isNumber( creditScore ) && Integer.parseInt( creditScore ) >= mqBank.getMinCreditScore();
    }

    private boolean isAmount( String amount )
    {
        return isDouble( amount );
    }

    private boolean isDuration( String duration )
    {
        return isNumber( duration );
    }

    private boolean isDouble( String value )
    {
        try
        {
            double parsedValue = Double.parseDouble( value );
            return parsedValue > 0;
        }
        catch( NumberFormatException e )
        {
            return false;
        }
    }

    private boolean isNumber( String value )
    {
        try
        {
            int parsedValue = Integer.parseInt( value );
            return parsedValue > 0;
        }
        catch( NumberFormatException e )
        {
            return false;
        }
    }

    public static void main( String[] args )
    {
        RequestController c = new RequestController( new Bank( 300, "MQ Bank", "exchange-name" ) );

        System.out.println( c.isSSN( "1209852639" ) );
        System.out.println( c.isCreditScore( "300" ) );
        System.out.println( c.isDouble( "20ed" ) );
        System.out.println( c.isNumber( "3434d" ) );
        System.out.println( c.isNumber( "d3434" ) );
    }
}
