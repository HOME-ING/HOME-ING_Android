package org.techtown.homeing.ui.login

data class ResponseLogin(
    val status : Int,
    val success : Boolean,
    val message : String,
    val responsedata : SomeData?
)

data class SomeData(
    val jwt: String
)