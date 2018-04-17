package zcashd.frontend

import spock.lang.Specification

class BasicAuthenticatorSpec extends Specification {

    def "does basic authenticator generate username and password from config"(){
        when:
        def result = new BasicAuthenticator().generateAuth()
        then:
        result == "Basic emNhc2g6emNhc2g="
    }
}
