package zcashd.frontend

import com.thetransactioncompany.jsonrpc2.client.RawResponse;
import com.thetransactioncompany.jsonrpc2.client.RawResponseInspector;


public class RpcInspector implements RawResponseInspector {

    public void inspect(RawResponse response) {

        // print the HTTP status code
        System.out.println("HTTP status: " + response.getStatusCode())
        // print the value of the "Date" HTTP header
        System.out.println("Date: " + response.getHeaderField("Date"))
        // print the HTTP status code
        System.out.println("HTTP content: " + response.getContent())

    }
}
