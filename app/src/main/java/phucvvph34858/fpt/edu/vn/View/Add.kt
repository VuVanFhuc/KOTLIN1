package phucvvph34858.fpt.edu.vn.View

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import phucvvph34858.fpt.edu.vn.Data.phimDB
import phucvvph34858.fpt.edu.vn.Model.Model


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Add(){
    LayoutAdd(navController = rememberNavController())
}

@Composable
fun LayoutAdd(navController: NavHostController){
    val context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        phimDB::class.java,
        "phim"
    ).allowMainThreadQueries().build()

    var img by remember {
        mutableStateOf("")
    }

    var name by remember {
        mutableStateOf("")
    }

    var ticket by remember {
        mutableStateOf("")
    }

    var date by remember {
        mutableStateOf("")
    }

    var status by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Thêm phim mới",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Serif,
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = img,
            onValueChange = {
                img = it
            },
            placeholder = {
                Text(
                    text = "Đường dẫn ảnh",
                    fontFamily = FontFamily.Serif,
                )
            },
            textStyle = TextStyle(
                fontFamily = FontFamily.Serif
            ),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 3.dp,
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            placeholder = {
                Text(
                    text = "Tên phim",
                    fontFamily = FontFamily.Serif,
                )
            },
            textStyle = TextStyle(
                fontFamily = FontFamily.Serif
            ),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 3.dp,
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = ticket,
            onValueChange = {
                ticket = it
            },
            placeholder = {
                Text(
                    text = "ticket",
                    fontFamily = FontFamily.Serif,
                )
            },
            textStyle = TextStyle(
                fontFamily = FontFamily.Serif
            ),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 3.dp,
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = date,
            onValueChange = {
                date = it
            },
            placeholder = {
                Text(
                    text = "date",
                    fontFamily = FontFamily.Serif,
                )
            },
            textStyle = TextStyle(
                fontFamily = FontFamily.Serif
            ),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 3.dp,
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = status,
            onValueChange = {
                status = it
            },
            placeholder = {
                Text(
                    text = "Trạng thái",
                    fontFamily = FontFamily.Serif,
                )
            },
            textStyle = TextStyle(
                fontFamily = FontFamily.Serif
            ),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 3.dp,
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                try {
                    if (
                        name.isNotBlank()
                        && ticket.isNotBlank()
                        && date.isNotBlank()
                        && status.isNotBlank()
                    ) {
                        db.phimDAO().insert(
                            Model(
                                name = name,
                                img = img,
                                ticket = ticket.toFloat(),
                                date = date,
                                status = status.toBoolean()
                            )
                        )
                        Toast.makeText(
                            context,
                            "Thêm phim thành công",
                            Toast.LENGTH_SHORT
                        ).show()
                        navController.navigate(Router.Homee.name) {
                            popUpTo(Router.Addd.name) { inclusive = true }
                        }

                    } else {
                        Toast.makeText(
                            context,
                            "Vui lòng nhập đầy đủ thông tin",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(
                        context,
                        "ticket phải là số",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            )
        ) {
            Text(
                text = "Thêm",
                fontFamily = FontFamily.Serif
            )
        }
    }
}