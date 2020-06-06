# **Home-ing:house:**


**집에서 하는 챌린지 공유 플랫폼 서비스 :exclamation:** 



## :one: LoginActivity.xml

![image](https://user-images.githubusercontent.com/58849278/83955799-f4435880-a891-11ea-9ad7-285bbaf62afb.png)

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
