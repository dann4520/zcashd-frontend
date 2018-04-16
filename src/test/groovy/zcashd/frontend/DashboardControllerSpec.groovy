package zcashd.frontend

import grails.testing.web.controllers.ControllerUnitTest
import groovy.json.JsonSlurper
import spock.lang.Specification

class DashboardControllerSpec extends Specification implements ControllerUnitTest<DashboardController> {

    def setup() {
    }

    def cleanup() {
    }

    void "does getPeerinfo get peer infomation"() {
        when:
            controller.getPeerinfo()
        then:
        def slurp = new JsonSlurper().parse(response.getJson().toString().bytes)
        slurp.size() != 0
    }

    void "does getinfo get node information"() {
        when:
        controller.getInfo()
        then:
        def slurp = new JsonSlurper().parse(response.getJson().toString().bytes)
        response.getJson().collect().size() != 0
        slurp.protocolversion == 170005
        slurp.testnet
    }
}
