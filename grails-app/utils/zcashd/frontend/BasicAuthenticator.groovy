package zcashd.frontend

import com.thetransactioncompany.jsonrpc2.client.ConnectionConfigurator

//https://www.blitter.se/utils/basic-authentication-header-generator/
// https://stackoverflow.com/questions/3283234/http-basic-authentication-in-java-using-httpclient?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa

public class BasicAuthenticator implements ConnectionConfigurator {

    ConfigService configService = new ConfigService()

    public String generateAuth() {
        "Basic " + Base64.getEncoder().encodeToString("${configService.getConfig().rpcusername}:${configService.getConfig().rpcpassword}".bytes)
    }

    public void configure(HttpURLConnection connection) {

        // add custom HTTP header
        connection.addRequestProperty("Authorization", generateAuth())
    }
}
