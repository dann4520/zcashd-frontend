package zcash.frontend

import com.thetransactioncompany.jsonrpc2.JSONRPC2Request
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionException

class RpcService {
    String server = "http://127.0.0.1:18232/"
    URL serverURL
    JSONRPC2Session mySession
    JSONRPC2Response response
    JSONRPC2Request request
    String method
    int requestID

    def rpcGetInfo() {
        try {
            serverURL = new URL(server)
        } catch(MalformedURLException ex) {
            System.err.println(ex.getMessage())
        }

        mySession = new JSONRPC2Session(serverURL)
        mySession.setConnectionConfigurator(new BasicAuthenticator())
        mySession.getOptions().setAllowedResponseContentTypes("text/plain" as String[])


        method = "getinfo"
        requestID = 0
        request = new JSONRPC2Request(method, requestID)


        try {
            response = mySession.send(request)

            if (response.indicatesSuccess())
                System.out.println(response.getResult())
            else
                System.out.println(response.getError().getMessage())

        } catch(JSONRPC2SessionException ex){
            System.err.println(ex.getMessage())
        }

    }
}
