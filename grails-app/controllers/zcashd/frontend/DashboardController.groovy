package zcashd.frontend

import grails.converters.JSON

class DashboardController {

    RpcService rpcService = new RpcService()

    def home(){

    }

    def getInfo() {
        render rpcService.rpcCommand("getinfo") as JSON
    }

    def getPeerinfo(){
        render rpcService.rpcCommand("getpeerinfo") as JSON
    }
}
