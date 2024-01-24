package com.example.netflixuiclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixuiclone.ui.theme.NetflixUICloneTheme
import androidx.compose.material3.ButtonDefaults

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            androidx.compose.foundation.layout.Column (
                modifier = Modifier
                    .fillMaxSize()
                    .background(androidx.compose.ui.graphics.Color.Companion.Black)
                    .verticalScroll(androidx.compose.foundation.rememberScrollState())
            ){
               TopAppSection()
               ContentChooser()
                FeatureMovieSection()

                addMovieList(movieType = "Popular on Netflix")
                addMovieList(movieType = "Continue Watching")
                addMovieList(movieType = "Watch It Again")
                addMovieList(movieType = "New Releases")

            }
        }
    }
    @Composable
    fun TopAppSection(){

        androidx.compose.foundation.layout.Row (
            modifier =Modifier
                .fillMaxWidth()
                .background(androidx.compose.ui.graphics.Color.Companion.Black)
                .padding(top=6.dp),
             horizontalArrangement = Arrangement.SpaceBetween,
             verticalAlignment = Alignment.CenterVertically

        ){
            androidx.compose.foundation.Image(
                painter = androidx.compose.ui.res.painterResource(id = R.drawable.logo),
                contentDescription ="icon",
                modifier = Modifier.size(60.dp)
            )

            androidx.compose.foundation.layout.Row() {
                androidx.compose.foundation.Image(painter = androidx.compose.ui.res.painterResource(id = R.drawable.icon_search),
                   contentDescription ="search",
                   modifier=Modifier.padding(end=12.dp)
                )

                androidx.compose.foundation.Image(painter = androidx.compose.ui.res.painterResource(id = R.drawable.profilelogo),
                    contentDescription ="profile",
                    modifier = Modifier.padding(end=6.dp).
                    size(36.dp)
                )
            }
        }


    }


 @Composable
  fun ContentChooser(){
     androidx.compose.foundation.layout.Row(
         modifier = Modifier
             .fillMaxWidth()
             .background(androidx.compose.ui.graphics.Color.Companion.Black)
             .padding(horizontal = 30.dp, vertical = 12.dp),
         horizontalArrangement = Arrangement.SpaceBetween,
         verticalAlignment = Alignment.CenterVertically

     ) {
          androidx.compose.material3.Text(text = "TV Shows", color = androidx.compose.ui.graphics.Color.Companion.LightGray, fontSize = 20.sp)
         androidx.compose.material3.Text(text = "Movies", color = androidx.compose.ui.graphics.Color.Companion.LightGray, fontSize = 20.sp)

         androidx.compose.foundation.layout.Row (){
             androidx.compose.material3.Text(text = "Categories", color = androidx.compose.ui.graphics.Color.Companion.LightGray, fontSize = 20.sp)
             androidx.compose.foundation.Image(painter = androidx.compose.ui.res.painterResource(id = R.drawable.drop_down_24), contentDescription ="DropDown Icon" )

         }
     }


  }

    @Composable
    fun FeatureMovieSection(){
        androidx.compose.foundation.layout.Column(

            modifier =Modifier
                .fillMaxWidth()
                .background(androidx.compose.ui.graphics.Color.Companion.Black)
                .padding(top =40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
        ){
            androidx.compose.foundation.Image(painter = androidx.compose.ui.res.painterResource(id = R.drawable.popp),
                contentDescription = "",
                modifier = Modifier.size(350.dp)
            )

            androidx.compose.foundation.layout.Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top=60.dp, start = 80.dp, end = 80.dp),
                    horizontalArrangement = Arrangement.SpaceBetween

            ) {
                androidx.compose.material3.Text(text = "Heist", color = androidx.compose.ui.graphics.Color.Companion.White)
                androidx.compose.material3.Text(text = "Action", color = androidx.compose.ui.graphics.Color.Companion.White)
                androidx.compose.material3.Text(text = "Comedy", color = androidx.compose.ui.graphics.Color.Companion.White)
                androidx.compose.material3.Text(text = "Thriller", color = androidx.compose.ui.graphics.Color.Companion.White)
            }

             androidx.compose.foundation.layout.Row (
                    modifier = Modifier.padding(top = 20.dp, start = 80.dp, end = 80.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
             ){
                  androidx.compose.foundation.layout.Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                  ) {
                      androidx.compose.foundation.Image(painter = androidx.compose.ui.res.painterResource(id = R.drawable.add_24),
                        contentDescription = "",
                        )
                      androidx.compose.material3.Text(text = "My List", color = androidx.compose.ui.graphics.Color.Companion.White, fontSize = 10.sp)
                }

                     androidx.compose.material3.Button(onClick = {},
                        colors =ButtonDefaults.buttonColors(androidx.compose.ui.graphics.Color.White),
                         shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)
                 ){
                     androidx.compose.material3.Text(text = "Play", color = androidx.compose.ui.graphics.Color.Companion.Black, fontSize = 18.sp)

                 }

                 androidx.compose.foundation.layout.Column(
                     horizontalAlignment = Alignment.CenterHorizontally
                 ) {
                     androidx.compose.foundation.Image(painter = androidx.compose.ui.res.painterResource(id = R.drawable.info_outline_24),
                         contentDescription = "",
                     )
                     androidx.compose.material3.Text(text = "Info", color = androidx.compose.ui.graphics.Color.Companion.White, fontSize = 10.sp)
                 }



            }

        }

    }
    @Composable
    fun addMovieList(movieType:String){

        androidx.compose.foundation.layout.Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(androidx.compose.ui.graphics.Color.Black)
        ){
            androidx.compose.material3.Text(text = movieType,
                fontSize = 24.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                color = androidx.compose.ui.graphics.Color.LightGray,
                modifier = Modifier.padding(top = 15.dp, start = 10.dp)
            )
            androidx.compose.foundation.lazy.LazyRow(
                modifier = Modifier.padding(top = 4.dp)
            ){
                itemsIndexed(getRandomMovieList()){index, item ->
                    MovieItemUiModel(imageRes = item.image)
                }
            }
        }
    }

    @Composable
    fun MovieItemUiModel(
        imageRes:Int
    ){
        androidx.compose.foundation.Image(painter = androidx.compose.ui.res.painterResource(id = imageRes), contentDescription ="" ,
        modifier = Modifier.height(150.dp).width(132.dp).padding(6.dp)
        )
    }

    fun getRandomMovieList():List<MovieModel>{
        val listofMovies= kotlin.collections.mutableListOf<MovieModel>()
        listofMovies.add(com.example.netflixuiclone.MovieModel(R.drawable.movie1))
        listofMovies.add(com.example.netflixuiclone.MovieModel(R.drawable.mvi3))
        listofMovies.add(com.example.netflixuiclone.MovieModel(R.drawable.movie5))
        listofMovies.add(com.example.netflixuiclone.MovieModel(R.drawable.movie10))
        listofMovies.add(com.example.netflixuiclone.MovieModel(R.drawable.movie9))
        listofMovies.add(com.example.netflixuiclone.MovieModel(R.drawable.m13))
        listofMovies.add(com.example.netflixuiclone.MovieModel(R.drawable.m14))
        listofMovies.add(com.example.netflixuiclone.MovieModel(R.drawable.m15))
        listofMovies.add(com.example.netflixuiclone.MovieModel(R.drawable.m16))
        listofMovies.add(com.example.netflixuiclone.MovieModel(R.drawable.m18))
        listofMovies.add(com.example.netflixuiclone.MovieModel(R.drawable.m19))
        listofMovies.add(com.example.netflixuiclone.MovieModel(R.drawable.m20))

        listofMovies.shuffle()
       return listofMovies
    }
}

data class MovieModel(
    val image:Int

)





