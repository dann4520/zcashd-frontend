package zcashd.frontend

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class DashboardControllerSpec extends Specification implements ControllerUnitTest<DashboardController> {

    def setup() {
    }

    def cleanup() {
    }

    void "does showPeerinfo return peer information"() {
        when:
            def result = controller.showPeerinfo()
        then:
            model.peers.size() != 0
            model.info.size() != 0
    }
}
