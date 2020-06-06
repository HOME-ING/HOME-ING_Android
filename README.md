# **Home-ing:house:**


**집에서 하는 챌린지 공유 플랫폼 서비스 :exclamation:** 



## :one: LoginActivity.xml

<img src ="https://user-images.githubusercontent.com/56873136/83956085-21453a80-a895-11ea-8c12-6d3e576351ba.png" width = "30%">

## :two: Home-ing LoginActivity
 1. Client와 Server의 로그인 정보 통신 
 2. 라이브러리, Request/Response 객체 설계 
 3. Retrofit Interface 구현 
 4. Callback 등록 후 통신 

## :three: Home-ing RequestLogin

 
 

	    data class RequestLogin(  
	    val id:String,  
		val password : String  
		)
## :four: Home-ing RequestInterface

    interface RequestInterface{  
    @POST("/user/signin")  
    fun requestLogin(@Body body: RequestLogin) : Call<ResponseLogin>  
}
## :five: Home-ing ResponseLogin

    data class ResponseLogin(  
    val status : Int,  
	val success : Boolean,  
	val message : String,  
	val responsedata : SomeData?  
	)  
	  data class SomeData(  
      val jwt: String  
	)
## :six: Home-ing RequestToServer

    object RequestToServer {  
    var retrofit = Retrofit.Builder()  
        .baseUrl("http://52.79.90.119:3004")  
        .addConverterFactory(GsonConverterFactory.create())  
        .build()  
  
    var service:RequestInterface = retrofit.create(RequestInterface::class.java)  }
