package phucvvph34858.fpt.edu.vn.View

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import androidx.room.util.query
import coil.compose.rememberImagePainter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Route
import phucvvph34858.fpt.edu.vn.Data.phimDB
import phucvvph34858.fpt.edu.vn.Model.Model
import phucvvph34858.fpt.edu.vn.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Home() {
    LayoutHome(navController = rememberNavController())
}

@SuppressLint("RememberReturnType", "CoroutineCreationDuringComposition")
@Composable
fun LayoutHome(navController: NavHostController) {
    val context = LocalContext.current

    val db = Room.databaseBuilder(
        context,
        phimDB::class.java,
        "phim"
    ).allowMainThreadQueries().build()

    val initialCars = listOf(
        Model(
            name = "phim 1",
            img = "https://media1.nguoiduatin.vn/media/luong-quoc-tiep/2020/12/31/nhung-bo-phim-truyen-hinh-viet-nam-noi-bat-nhat-nam-2020-1.jpeg",
            ticket = 200f,
            date = "18/6/2004",
            status = true
        ),
        Model(
            name = "phim 2",
            img = "https://media1.nguoiduatin.vn/media/luong-quoc-tiep/2020/12/31/nhung-bo-phim-truyen-hinh-viet-nam-noi-bat-nhat-nam-2020-1.jpeg",
            ticket = 300f,
            date = "18/6/2004",
            status = true
        ),
        Model(
            name = "phim 3",
            img = "https://media1.nguoiduatin.vn/media/luong-quoc-tiep/2020/12/31/nhung-bo-phim-truyen-hinh-viet-nam-noi-bat-nhat-nam-2020-1.jpeg",
            ticket = 250f,
            date = "18/6/2004",
            status = false
        ),
        Model(
            name = "phim 4",
            img = "https://media1.nguoiduatin.vn/media/luong-quoc-tiep/2020/12/31/nhung-bo-phim-truyen-hinh-viet-nam-noi-bat-nhat-nam-2020-1.jpeg",
            ticket = 220f,
            date = "18/6/2004",
            status = true
        ),
        Model(
            name = "kẻ hủy diệt",
            img = "https://media1.nguoiduatin.vn/media/luong-quoc-tiep/2020/12/31/nhung-bo-phim-truyen-hinh-viet-nam-noi-bat-nhat-nam-2020-1.jpeg",
            ticket = 280f,
            date = "18/6/2004",
            status = false
        )
    )

    // Insert initial cars if database is empty
    if (db.phimDAO().getAll().isEmpty()) {
        CoroutineScope(Dispatchers.IO).launch {
            db.phimDAO().insert(*initialCars.toTypedArray())
        }
    }

    var list by remember {
        mutableStateOf(db.phimDAO().getAll())
    }

    var isShowDeleteDialog by remember {
        mutableStateOf(false)
    }

    var carToDelete by remember {
        mutableStateOf<Model?>(null)
    }

    var isShowDetailDialog by remember {
        mutableStateOf(false)
    }

    var carToShowDetails by remember {
        mutableStateOf<Model?>(null)
    }
    var searchQuery by remember {
        mutableStateOf("")
    }

    if (isShowDeleteDialog) {
        DialogCompose(
            onConfim = {
                carToDelete?.let {
                    db.phimDAO().deleteById(it.id)
                    isShowDeleteDialog = false
                    Toast.makeText(
                        context,
                        "Delete phim  successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    list = db.phimDAO().getAll()
                }
            },
            onClose = { isShowDeleteDialog = false },
            title = "Thông báo !",
            mess = "Bạn có chắc chắn muốn xóa không?",

            )
    }

    if (isShowDetailDialog) {
        carToShowDetails?.let { fim ->
            DetailDialog(
                fim = fim,
                onClose = { isShowDetailDialog = false }
            )
        }
    }

    Column {
        // Tìm Kiếm Ở Đây
        TextField(
            value = searchQuery, onValueChange = { query ->
                searchQuery = query
                list = if (query.isEmpty()) {
                    db.phimDAO().getAll()
                } else {
                    db.phimDAO().search("%$query%")
                }
            },
            label = {
                Text(text = " search ... ")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
//        Nút Tăng ,Giảm Ở Đây
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center
//        ) {
//            Button(
//                onClick = {
//                    list=db.XeHoiDAO().giamDan()/*TODO*/
//                },
//                modifier = Modifier.width(200.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
//            ) {
//                Text(text = "Sắp Xếp Giảm")
//            }
//            Button(
//                onClick = {
//                    list=db.XeHoiDAO().tangDan()/*TODO*/
//                },
//                modifier = Modifier.width(200.dp),
//                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
//            ) {
//                Text(text = "Sắp Xếp Tăng")
//            }
//        }
        Text(
            text = "Danh sách phim",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight(600),
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            textAlign = TextAlign.Center,
            color = Color.Red
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp)
        ) {
            LazyColumn {
                items(list) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .clickable {
                                carToShowDetails = item
                                isShowDetailDialog = true
                            }
                            .shadow(
                                elevation = 3.dp,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                val painter = rememberImagePainter(
                                    data = item.img,
                                    builder = {
                                        placeholder(R.drawable.baseline_place_24)
                                        error(R.drawable.baseline_error_24)
                                    }
                                )
                                Image(
                                    painter = painter,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(100.dp)
                                        .padding(top = 10.dp)
                                )
                                Text(
                                    text = "Tên phim: ${item.name}",
                                    fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "ticket: ${item.ticket}",
                                    fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = "date: ${item.date}",
                                    fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = "Trạng thái: ${if (item.status) "Sản phẩm mới" else "Sản phẩm cũ"}",
                                    fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
//                        Nút Sửa,Xóa Ở Đây
                        Row(
                            modifier = Modifier.weight(0.3f)
                        ) {
                            IconButton(onClick = {
                                navController.navigate("${Router.Updatee.name}/${item.id}")
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = null
                                )
                            }
                            IconButton(onClick = {
                                carToDelete = item
                                isShowDeleteDialog = true
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }
            }
        }
    }
// Nút Add Ở Đây
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = {
                navController.navigate(Router.Addd.name) {
                    popUpTo(Router.Homee.name) { inclusive = true }
                }
            },
            containerColor = Color.Red,
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}
//  Dialog Chi Tiết Ở Đây
@Composable
fun DetailDialog(fim: Model, onClose: () -> Unit) {
    androidx.compose.material3.AlertDialog(
        onDismissRequest = onClose,
        title = {
            Text(
                text = "Chi tiết phim",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        },
        text = {
            Column {
                val painter = rememberImagePainter(
                    data = fim.img,
                    builder = {
                        placeholder(R.drawable.baseline_place_24)
                        error(R.drawable.baseline_error_24)
                    }
                )
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(16.dp)
                )
                Text(text = "Tên: ${fim.name}", fontWeight = FontWeight.Bold)
                Text(text = "ticket: ${fim.ticket}", fontWeight = FontWeight.Bold)
                Text(text = "date: ${fim.date}", fontWeight = FontWeight.Bold)
                Text(
                    text = "Trạng thái: ${if (fim.status) "Sản phẩm mới" else "Sản phẩm cũ"}",
                    fontWeight = FontWeight.Bold
                )
            }
        },
        confirmButton = {
            androidx.compose.material3.TextButton(onClick = onClose) {
                Text("Close")
            }
        }
    )
}

