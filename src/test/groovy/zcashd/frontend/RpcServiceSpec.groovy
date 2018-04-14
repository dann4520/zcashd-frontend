package zcashd.frontend

import grails.testing.services.ServiceUnitTest
import net.minidev.json.JSONArray
import net.minidev.json.JSONObject
import spock.lang.Specification

class RpcServiceSpec extends Specification implements ServiceUnitTest<RpcService>{

    def setup() {
    }

    def cleanup() {
    }

    void "test getInfo() - getinfo"() {
        when:
            def result = service.getInfo("getinfo")
        then:
            result instanceof JSONObject
            result.each{
                println it
            }
    }

    void "test getInfo() - getpeerinfo"() {
        when:
            def result = service.getInfo("getpeerinfo")
        then:
            result instanceof JSONArray
            result.each{
                println it
            }
    }
}
