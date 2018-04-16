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

    void "rpcCommand - getinfo"() {
        when:
            def result = service.rpcCommand("getinfo")
        then:
            result instanceof JSONObject
            result.each{
                println it
            }
    }

    void "rpcCommand - getpeerinfo"() {
        when:
            def result = service.rpcCommand("getpeerinfo")
        then:
            result instanceof JSONArray
            result.each{
                println it
            }
    }
}
