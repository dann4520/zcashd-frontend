package zcashd.frontend

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ConfigServiceSpec extends Specification implements ServiceUnitTest<ConfigService>{

    def setup() {
    }

    def cleanup() {
    }

    void "can the config be feteched"() {
        when:
            def config = service.getConfig()
        then:
            config instanceof ConfigObject
            config.server == "http://127.0.0.1:18232"
            config.rpcusername == "zcash"
            config.rpcpassword == "zcash"
            config.zcashUrl == "https://blog.z.cash/feed"
    }
}
