package zcashd.frontend

class DashboardController {

    RpcService rpcService = new RpcService()

    def showPeerinfo() {
        def peers = rpcService.getInfo("getpeerinfo")
        def info = rpcService.getInfo("getinfo")

        println peers.class
        println info.class

        render model:[peers:peers, info:info], view:"index"
    }
}
