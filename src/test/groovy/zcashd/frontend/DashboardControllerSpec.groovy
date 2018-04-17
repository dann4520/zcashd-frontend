package zcashd.frontend

import grails.testing.web.controllers.ControllerUnitTest
import groovy.json.JsonSlurper
import groovy.xml.XmlUtil
import spock.lang.Specification

class DashboardControllerSpec extends Specification implements ControllerUnitTest<DashboardController> {

    def setup() {
    }

    def cleanup() {
    }

    void "does getPeerinfo POST return getpeerinfo json"() {
        when:
        request.method = "POST"
            controller.getPeerinfo()
        then:
        def slurp = new JsonSlurper().parse(response.getJson().toString().bytes)
        slurp.size() != 0
    }

    void "does getinfo POST return getinfo json"() {
        when:
        request.method = "POST"
        controller.getInfo()
        then:
        def slurp = new JsonSlurper().parse(response.getJson().toString().bytes)
        response.getJson().collect().size() != 0
        slurp.protocolversion == 170005
        slurp.testnet
    }

    void "does home get zcash rss feed"(){
        when:
        request.method = "POST"
        controller.home()
        then:
        def slurp = new JsonSlurper().parseText(response.getJson().toString())
        slurp.zcashRss.size() != 0
        slurp.zcashRss.each{
            it.title != ""
        }
    }
}
