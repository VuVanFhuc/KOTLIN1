package ph34858.laptrinhkotlin.lab3Ph34858.baitapbuoi5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import dalvik.annotation.optimization.CriticalNative
import ph34858.laptrinhkotlin.R
import androidx.compose.foundation.layout.Spacer as Spacer1
import androidx.compose.material3.Text as Text1
import ph34858.laptrinhkotlin.lab3Ph34858.baitapbuoi5.anhdiachi as anhdiachi1
import ph34858.laptrinhkotlin.lab3Ph34858.baitapbuoi5.layoutText as layoutText1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bai5()
            View()
        }
    }
}

@Composable
fun Bai5() {
    GetLayout()
}

@Composable
fun GetLayout(title: String = "Trang chu") {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(10.dp)
    ) {
        GetTextTitle(title = title)

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

@Composable
fun anhdiachi() {
    val urlImage =
        "https://khoinguonsangtao.vn/wp-content/uploads/2022/09/hinh-anh-gai-xinh-cap-2-3.jpg"
    val painter = rememberImagePainter(urlImage)
    Image(
        painter = painter,
        contentDescription = "ảnh vị trí ",
        modifier = Modifier
            .padding(top = 390.dp)
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
        Text1(
            text = chu1,
            modifier = Modifier.padding(top = 390.dp),
            color = Color.Black,
            fontSize = 16.sp,
            textAlign = TextAlign.Start,
        )
        Text1(
            text = chu2,
            modifier = Modifier.padding(top = 8.dp),
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
        )
        Text1(
            text = chu3,
            modifier = Modifier.padding(top = 8.dp),
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
        )
        Text1(
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
fun View(diachi: String = "nơi nhận địa chỉ") {
    Text(
        text = diachi,
        modifier = Modifier.padding(top = 330.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold

    )
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        anhdiachi1()
        Spacer1(modifier = Modifier.width(16.dp))
        layoutText1()
    }
}



