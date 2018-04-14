package zcashd.frontend

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class RpcServiceSpec extends Specification implements ServiceUnitTest<RpcService>{

    def setup() {
    }

    def cleanup() {
    }

    void "test rcpGetInfo()"() {
        when:"try out the call"
            service.rpcGetInfo()
        then:"blow up"
            false
    }
}
