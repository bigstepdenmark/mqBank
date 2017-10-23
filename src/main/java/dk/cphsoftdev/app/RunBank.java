package dk.cphsoftdev.app;

import dk.cphsoftdev.app.controller.ReceiveController;
import dk.cphsoftdev.app.controller.RequestController;
import dk.cphsoftdev.app.controller.ResponseController;
import dk.cphsoftdev.app.entity.Bank;

public class RunBank
{
    public static void main( String[] args )
    {
        ReceiveController receiver = new ReceiveController( "no-queue-exchange" );
        RequestController request = new RequestController( new Bank( 300, "MQ Bank", "exchange-name" ) );
        ResponseController response = new ResponseController();

        for( String message : receiver.getMessages() )
        {
            response.generateResponse( request.toLoanObject( message ) );
        }
    }
}
