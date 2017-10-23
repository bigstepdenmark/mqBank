package dk.cphsoftdev.app.controller;

import dk.cphsoftdev.app.entity.Loan;

public class ResponseController
{
    public String generateResponse( Loan loan )
    {
        return getInterestRate( loan ) + "," + loan.getSsn();
    }

    private double getInterestRate( Loan loan )
    {
        double monthlyPayment = loan.getAmount() / loan.getDuration();
        double rate = 4.45;

        if( monthlyPayment > 0 && monthlyPayment <= 500 )
            rate = 25.00;
        else if( monthlyPayment > 500 && monthlyPayment <= 2000 )
            rate = 15.00;
        else if( monthlyPayment > 2000 && monthlyPayment <= 4500 )
            rate = 10.00;

        return rate;
    }
}
