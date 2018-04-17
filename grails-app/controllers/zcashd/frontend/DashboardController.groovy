package zcashd.frontend

import grails.converters.JSON

class DashboardController {

    RpcService rpcService = new RpcService()
    ConfigService configService = new ConfigService()
    def model = [:]

    def populateModel(def model){
        model.refresh = configService.getConfig().refresh
        model.siteTitle = configService.getConfig().siteTitle
        model
    }

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
        model = populateModel(model)
        return render(model:model, view:"home")
    }

    def getInfo() {
        if(request.method == "POST") {
            return render(rpcService.rpcCommand("getinfo") as JSON)
        }

        model = populateModel(model)
        return render(model:model, view:"getInfo")

    }

    def getPeerinfo(){
        if(request.method == "POST") {
            return render(rpcService.rpcCommand("getpeerinfo") as JSON)
        }
        model = populateModel(model)
        return render(model:model, view:"getPeerinfo")
    }
}
