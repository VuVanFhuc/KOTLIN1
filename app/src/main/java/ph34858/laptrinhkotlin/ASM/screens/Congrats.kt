package ph34858.laptrinhkotlin.ASM.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ph34858.laptrinhkotlin.R

class Congrats : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            congratsScreen()
        }
    }

    @Preview
    @Composable
    fun congratsScreen() {
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            contentAlignment = Alignment.Center) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "SUCCESS!",
                    fontFamily = FontFamily.Serif,
                    fontSize = 36.sp,
                    color = Color(0xff909090)
                )
                Image(
                    painter = painterResource(id = R.drawable.ggg),
                    contentDescription = null,
                    modifier = Modifier.size(300.dp, 200.dp)
                )

                Text(
                    text = "Your order will be delivered soon.\n" +
                            "Thank you for choosing our app!",
                    fontFamily = FontFamily.Serif,
                    fontSize = 22.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 20.dp) // Thêm khoảng cách phía trên
                )

                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier.padding(top = 70.dp) // Thêm khoảng cách phía trên
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp)
                            .shadow(
                                elevation = 3.dp,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff242424)
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "SUBMIT ORDER", fontFamily = FontFamily.Serif, fontWeight =
                            FontWeight(600)
                        )
                    }
                }

                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier.padding(top = 20.dp) // Thêm khoảng cách phía trên
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp)
                            .shadow(
                                elevation = 3.dp,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .border(
                                width = 2.dp, // Tăng độ dày của vòng bao
                                color = Color.Black,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "BACK TO HOME", fontFamily = FontFamily.Serif, fontWeight =
                            FontWeight(600), color = Color.Black
                        )
                    }
                }

            }
        }
    }
}