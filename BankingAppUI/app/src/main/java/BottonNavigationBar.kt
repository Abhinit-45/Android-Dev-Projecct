import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

val items= listOf(
    BottonNavigationData(
        tittle ="Home",
        icon=Icons.Rounded.Home
    ),
    BottonNavigationData(
        tittle ="Wallet",
        icon=Icons.Rounded.Wallet
    ),
    BottonNavigationData(
        tittle ="Notifications",
        icon=Icons.Rounded.Notifications
    ),
    BottonNavigationData(
        tittle ="Account",
        icon=Icons.Rounded.AccountCircle
    )

)
@Preview
@Composable

fun BottomNavigationBar(){
    NavigationBar {
       Row (
           modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
       ){
           items.forEachIndexed{index,item ->
               NavigationBarItem(selected =index==0 ,
                   onClick = { },
                   icon = {
                       Icon(
                           imageVector=item.icon,
                           contentDescription=item.tittle,
                           tint=MaterialTheme.colorScheme.onBackground
                       )
                   },
                   label ={
                    Text(text =item.tittle ,
                        color=MaterialTheme.colorScheme.onBackground)

                       }
               )
           }
       }
    }
}