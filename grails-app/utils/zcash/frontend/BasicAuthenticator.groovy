package zcash.frontend

import com.thetransactioncompany.jsonrpc2.client.ConnectionConfigurator

//https://www.blitter.se/utils/basic-authentication-header-generator/

public class BasicAuthenticator implements ConnectionConfigurator {

    public void configure(HttpURLConnection connection) {

        // add custom HTTP header
        connection.addRequestProperty("Authorization", "Basic emNhc2g6emNhc2g=")
    }
}
