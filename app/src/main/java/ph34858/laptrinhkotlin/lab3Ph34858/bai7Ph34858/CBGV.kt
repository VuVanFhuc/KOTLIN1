package ph34858.laptrinhkotlin.lab3Ph34858.bai7Ph34858

class CBGV(
    hoTen: String,
    tuoi: Int,
    queQuan: String,
    var maSoGV: String,
    var luongCung: Float,
    var luongThuong: Float,
    var tienPhat: Float) :
    Nguoi(hoTen, tuoi, queQuan) {
    // Phương thức tính lương thực lĩnh
    fun tinhLuongThucLinh(): Float {
        val luongThuc = luongCung + luongThuong - tienPhat
        return luongThuc
    }
}