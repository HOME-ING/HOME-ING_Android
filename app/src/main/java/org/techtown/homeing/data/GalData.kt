package org.techtown.homeing.data

data class GalData(
    val data : List<Data>
){
    data class Data(
        val challegeUrl : String,
        val likes : String,
        val shared : String,
        val title : String,
        val description : String
    )
}