package com.example.challengesophos.navigation

sealed class Routes(val route:String) {
    object ScreenLogin:Routes("ScreenLogin")
    object ScreenMain:Routes("screenMain/{name}"){
        fun createRoute(name:String)="screenMain/$name"
    }
    object ScreenSendDocument:Routes("screenSendDocument")
    object ScreenConsultDocuments:Routes("screenConsultDocuments")
    object ScreenOfficeMap:Routes("screenOfficeMap")

}