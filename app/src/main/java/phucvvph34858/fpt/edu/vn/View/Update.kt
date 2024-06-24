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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import phucvvph34858.fpt.edu.vn.Data.phimDB
import phucvvph34858.fpt.edu.vn.Model.Model

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Update (){
    LayoutUpdate(navController = rememberNavController(),id=0)
}

@Composable
fun LayoutUpdate(navController: NavHostController,id:Int){
    val context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        phimDB::class.java,
        "phim"
    ).allowMainThreadQueries().build()

    // Trạng thái của các trường dữ liệu
    var st: Model? = null
    fun getXeHoi() {
        if (id != 0) {
            st = db.phimDAO().getById(id)
        }
    }
    getXeHoi()

    var name by remember { mutableStateOf(st?.name ?: "") }
    var img by remember { mutableStateOf(st?.img ?: "") }
    var ticket by remember { mutableStateOf(st?.ticket?.toString() ?: "") }
    var date by remember { mutableStateOf(st?.date ?: "") }
    var status by remember { mutableStateOf(st?.status?.toString() ?: "") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Update phim $id",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            placeholder = { Text(text = "Tên phim", fontFamily = FontFamily.Serif) },
            textStyle = TextStyle(fontFamily = FontFamily.Serif),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 3.dp, shape = RoundedCornerShape(8.dp)),
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
            value = img,
            onValueChange = { img = it },
            placeholder = { Text(text = "Đường dẫn ảnh", fontFamily = FontFamily.Serif) },
            textStyle = TextStyle(fontFamily = FontFamily.Serif),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 3.dp, shape = RoundedCornerShape(8.dp)),
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
            onValueChange = { ticket = it },
            placeholder = { Text(text = "ticket ", fontFamily = FontFamily.Serif) },
            textStyle = TextStyle(fontFamily = FontFamily.Serif),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 3.dp, shape = RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = date,
            onValueChange = { date = it },
            placeholder = { Text(text = "date", fontFamily = FontFamily.Serif) },
            textStyle = TextStyle(fontFamily = FontFamily.Serif),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 3.dp, shape = RoundedCornerShape(8.dp)),
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
            onValueChange = { status = it },
            placeholder = { Text(text = "Trạng thái", fontFamily = FontFamily.Serif) },
            textStyle = TextStyle(fontFamily = FontFamily.Serif),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 3.dp, shape = RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (name.isNotBlank() && img.isNotBlank() && ticket.isNotBlank() && date.isNotBlank() && status.isNotBlank()) {
                    st?.let {
                        it.name = name
                        it.img = img
                        it.ticket = ticket.toFloatOrNull() ?: 0f
                        it.date = date
                        it.status = status.toBoolean()

                        db.phimDAO().update(it)
                        Toast.makeText(context, "Cập nhật phim thành công", Toast.LENGTH_SHORT).show()
                        navController.navigate(Router.Homee.name) {
                            popUpTo(Router.Updatee.name) { inclusive = true }
                        }
                    }
                } else {
                    Toast.makeText(context, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(text = "Cập nhật", fontFamily = FontFamily.Serif)
        }
    }
}
