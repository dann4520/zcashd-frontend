package zcashd.frontend

import javax.servlet.ServletContext

class ConfigService {

    def config = null

    def getConfig() {
        if(!config){
            config = new ConfigSlurper().parse(this.class.classLoader.getResource("zcashd-frontend.config"))
            if (config) log.info "successfully loaded config zcashd-frontend.config from application!"
        }
        config
    }
}
