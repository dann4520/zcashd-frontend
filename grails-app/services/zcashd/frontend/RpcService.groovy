package zcashd.frontend

import com.thetransactioncompany.jsonrpc2.JSONRPC2Request
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionException

// http://software.dzhuvinov.com/json-rpc-2.0-client.html

class RpcService {
    String server = "http://127.0.0.1:18232/"
    URL serverURL
    JSONRPC2Session mySession
    JSONRPC2Response response
    JSONRPC2Request request
    String method
    int requestID

    def getInfo(String method) {
        this.method = method
        requestID = 0
        request = new JSONRPC2Request(method, requestID)

        serverURL = new URL(server)

        mySession = new JSONRPC2Session(serverURL)
        mySession.setConnectionConfigurator(new BasicAuthenticator())
//        mySession.setRawResponseInspector(new RpcInspector())
        mySession.getOptions().ignoreVersion(true)


        try {
            response = mySession.send(request)
            if (response.indicatesSuccess())
                return response.getResult()
            else
                System.out.println(response.getError().getMessage())
        } catch (JSONRPC2SessionException e) {
            System.err.println(e.getMessage())
        }

    }

}
