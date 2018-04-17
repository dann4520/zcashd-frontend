package zcashd.frontend

import grails.converters.JSON

class DashboardController {

    RpcService rpcService = new RpcService()
    ConfigService configService = new ConfigService()

    def home(){
        if(request.method == "POST") {
            String zcashUrlWebsite = configService.getConfig().zcashUrl.toURL().text
            def slurp = new XmlSlurper().parseText(zcashUrlWebsite)

//        println XmlUtil.serialize(slurp)

            def rss = [:]
            def zcashRss = []

            slurp.channel.children().each {
                if (it.title.text()) {
                    rss.title = it.title.text()
                    rss.link = it.link.text()
                    rss.pubDate = it.pubDate.text()
                    rss.guid = it.guid.text()
                    rss.description = it.description.text()
                    zcashRss << rss
                    rss = [:]
                }
            }
            return render([success:true, zcashRss:zcashRss] as JSON)
        }
    }

    def getInfo() {
        render rpcService.rpcCommand("getinfo") as JSON
    }

    def getPeerinfo(){
        render rpcService.rpcCommand("getpeerinfo") as JSON
    }
}
