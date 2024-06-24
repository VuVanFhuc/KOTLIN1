package phucvvph34858.fpt.edu.vn.Data

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update
import phucvvph34858.fpt.edu.vn.Model.Model


@Database(entities = [Model::class], version = 1)
abstract class phimDB : RoomDatabase() {
    abstract fun phimDAO(): phimDAO
}

@Dao
interface phimDAO {
    //    Hiển Thị Danh Sách
    @Query("SELECT * FROM phimTable")
    fun getAll(): List<Model>

    // Xóa Hết
    @Delete
    fun delete(xh: Model)

    // Xóa Theo ID
    @Query("DELETE FROM phimTable WHERE id = :id")
    fun deleteById(id: Int)

    // Thêm
    @Insert
    fun insert(vararg xh: Model)

    // Sửa
    @Update
    fun update(xh: Model)

    // Hiển Thị Chi Tiết
    @Query("SELECT * FROM phimTable WHERE id = :id")
    fun getById(id: Int): Model?

    //    Tìm Kiếm
    @Query("SELECT * FROM phimTable WHERE ph34858Name LIKE :searchQuery")
    fun search(searchQuery: String): List<Model>

    //    Tăng Dần
    @Query("SELECT * FROM phimTable ORDER BY  ph34858Ticket ASC")
    fun tangDan(): List<Model>

    //    Giảm Dần
    @Query("SELECT * FROM phimTable ORDER BY  ph34858Ticket DESC")
    fun giamDan(): List<Model>

}