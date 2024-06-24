package phucvvph34858.fpt.edu.vn.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "phimTable")
data class Model(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "ph34858Name") var name: String?,
    @ColumnInfo(name = "ph34858Image") var img: String,
    @ColumnInfo(name = "ph34858Ticket") var ticket: Float?,
    @ColumnInfo(name = "ph34858Date") var date: String?,
    @ColumnInfo(name = "ph34858Status") var status: Boolean
) {

}