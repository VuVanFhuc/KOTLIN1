package ph34858.laptrinhkotlin.lab3Ph34858.baitapbuoi5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import coil.compose.rememberImagePainter

class buoi5bai1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            namme()

        }
    }
}

@Preview(heightDp = 900, widthDp = 500)
@Composable
fun namme(trangchu: String = "TRANG CHỦ ", diachi: String = "Nơi nhận địa chỉ ") {
    Column {
        Text(
            text = trangchu,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)

        )
        Text(
            text = diachi,
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold

        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            anhdiachi()
            layoutText()
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(10.dp)
        ) {
            GetTextTitle(title = "")

            GetRowItem(
                color = Color.Yellow,
                linkImage = "https://upload.wikimedia.org/wikipedia/commons/2/20/FPT_Polytechnic.png",
                noidungtext = "paypal"
            )
            GetRowItem(
                color = Color.Cyan,
                linkImage = "https://gcs.tripi.vn/public-tripi/tripi-feed/img/475223TdJ/anh-mo-ta.png",
                noidungtext = "momo"
            )
            GetRowItem(
                color = Color.Magenta,
                linkImage = "https://images2.thanhnien.vn/528068263637045248/2023/2/15/bong-da-sv-2aa-16764457958392020821477.jpg",
                noidungtext = "zalo pay"
            )
            GetRowItem(
                color = Color.DarkGray,
                linkImage = "https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2023/3/20/1159566/Bong-Da-Phui.jpg",
                noidungtext = "vn pay"
            )
        }
        Button(
            onClick = {
                println("Button was clicked!")
            },
            modifier = Modifier.padding(16.dp).fillMaxWidth()
        ) {
            Text("Click Me")
        }
    }
}


@Composable
fun anhdiachi() {
    val urlImage =
        "https://khoinguonsangtao.vn/wp-content/uploads/2022/09/hinh-anh-gai-xinh-cap-2-3.jpg"
    val painter = rememberImagePainter(urlImage)
    Image(
        painter = painter,
        contentDescription = "ảnh vị trí ",
        modifier = Modifier
            .padding(top = 20.dp)
            .size(100.dp)
    )
}

@Composable
fun layoutText(
    chu1: String = "tri | 22222",
    chu2: String = "22/3 đường Trung Mỹ Tây 1",
    chu3: String = "phường tân thới nhất",
    chu4: String = "quận 12, thành phố hồ chí minh"
) {
    Column {
        Text(
            text = chu1,
            modifier = Modifier.padding(top = 20.dp),
            color = Color.Black,
            fontSize = 16.sp,
            textAlign = TextAlign.Start,
        )
        Text(
            text = chu2,
            modifier = Modifier.padding(top = 8.dp),
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
        )
        Text(
            text = chu3,
            modifier = Modifier.padding(top = 8.dp),
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
        )
        Text(
            text = chu4,
            modifier = Modifier.padding(top = 8.dp),
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
        )
    }
}

@Composable
fun GetRowItem(color: Color, linkImage: String, noidungtext: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(5.dp)
            .background(color = color, shape = RoundedCornerShape(15.dp))
            .height(50.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = rememberImagePainter(linkImage),
            contentDescription = null,
            modifier = Modifier
                .padding(5.dp)
                .size(60.dp),
        )

        Text(
            text = noidungtext,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            color = Color.White
        )

        RadioButton(selected = false, onClick = { /*TODO*/ })
    }
}

@Composable
fun GetTextTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        fontSize = 30.sp,
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}


