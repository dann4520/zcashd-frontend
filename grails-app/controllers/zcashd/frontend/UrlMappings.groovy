package zcashd.frontend

class UrlMappings {

    static mappings = {

        "/"(controller:'Dashboard', action: 'home')
        "/getInfo"(controller:'Dashboard', action:'getInfo')
        "/getPeerinfo"(controller:'Dashboard', action:'getPeerinfo')
    }
}
