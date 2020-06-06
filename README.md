# **Home-ing:house:**


**집에서 하는 챌린지 공유 플랫폼 서비스 :exclamation:** 

<br>

## 로그인
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
    
    
### 로그인 이후 화면 -> 뷰페이저와 bottomnavigation을 이용해 전체적인 레이아웃을 잡음.
```kotlin
        main_bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.menu_main -> main_viewpager.currentItem = 0

                R.id.menu_contents -> main_viewpager.currentItem = 1

                R.id.menu_add -> Toast.makeText(this,"hello",Toast.LENGTH_LONG).show()

                R.id.menu_story -> main_viewpager.currentItem = 3

                R.id.menu_my_page -> main_viewpager.currentItem = 4


            }
            true
        }
```
## 홈
화살표 버튼을 클릭하면 상세 컨텐츠를 보여주는 창으로 이동한다.
리사이클러뷰 사용
1. 반복될 뷰 하나 만들기
2. 배치 방향 정하기
3. viewholder
4. viewadapter


## search
ContentsFragment가 두번째 search에 해당하는 프레그먼트이다.
비규칙적인 그리드 형식으로 유저들의 챌린지를 보여준다.   
- ContentsFragment.kt
```kotlin
    private fun initContents(v : View){
        var contentsAdapter = GalAdapter(v.context)
        val manager = SpannedGridLayoutManager( orientation = SpannedGridLayoutManager.Orientation.VERTICAL, spans = 3)

        manager.spanSizeLookup = SpannedGridLayoutManager.SpanSizeLookup{ position ->
            if(position %12 == 0 || position%12 == 7){
                SpanSize(2,2)
            }
            else{
                SpanSize(1,1)
            }

        }
```


### <뷰홀더>
- GalVH.kt
```kotlin
class GalVH (view : View) : RecyclerView.ViewHolder(view){

    val img = view.findViewById<ImageView>(R.id.contents_img)
    fun onBind(data : GalData.Data){
        Glide.with(itemView).load(data.challegeUrl).into(img)
    }
}
```

- HashVH.kt
``` kotlin
class HashVH (view : View) : RecyclerView.ViewHolder(view){
    val title = view.findViewById<TextView>(R.id.hashtag_text)

    fun onBind(data : HashData){
        title.text = data.title
    }
}
```


### <어댑터>
- GalAdapter.kt
```kotlin
class GalAdapter (private val context : Context) : RecyclerView.Adapter<GalVH>(){
    val data = listOf<GalData.Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalVH {
        val view = LayoutInflater.from(context).inflate(R.layout.search_contents_item, parent, false)

        return GalVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: GalVH, position: Int) {
        holder.onBind(data[position])
    }
}
```

- HashAdapter.kt
```kotlin
class HashAdapter (private val context : Context) : RecyclerView.Adapter<HashVH>(){
    var data = listOf<HashData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HashVH {
        val view = LayoutInflater.from(context).inflate(R.layout.search_hashtag_item, parent, false)

        return HashVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: HashVH, position: Int) {
        holder.onBind(data[position])
    }
}
```

### <서버통신>
#### 1. 라이브러리 추가
#### 2. API문서 보고 객체 설계

- HashData
챌린지제목이 들어감. (String)   

```kotlin
data class HashData(
    val title : String
)
```

- GalData
챌린지이미지, 좋아요수, 공유수, 챌린지제목, 챌린지설명이 들어간다. (String)   
```kotlin
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
```


#### 3. Retrofit Interface 설계
- ContentsService.kt
```kotlin
interface ContentsService {
    @GET("/challenge/contents")
    fun getContents(): Call<GalData>
}
```

#### 4. Retrofit Interface 실제 구현체 만들고 통신
- ContentsServicelmpl.kt
```kotlin
object ContentsServiceImpl {
    private const val BASE_URL ="http://52.79.90.119:3004"

    private val interceptor = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val newRequest = chain.request().newBuilder().addHeader("Content-Type","application/json")
                .build()

            return chain.proceed(newRequest)
        }
    }

    private val client = OkHttpClient.Builder().apply {
        interceptors().add(interceptor)
    }.build()

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val service = retrofit.create(ContentsService::class.java)
}
```
