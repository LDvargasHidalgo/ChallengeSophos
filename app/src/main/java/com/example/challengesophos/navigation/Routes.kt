package com.example.challengesophos.navigation

sealed class Routes(val route:String) {
    object ScreenLogin:Routes("screenLogin")
    //object ScreenMain:Routes("screenMain")
    object ScreenSendDocuments:Routes("ScreenSendDocuments")
    object ScreenConsultDocument:Routes("ScreenConsultDocument")
}