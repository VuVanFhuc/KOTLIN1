package ph34858.laptrinhkotlin.lab2Ph34858
//làm việc với null safety
fun main() {
    val danhSachSV = DanhSachSinhVien()

    // Thêm sinh viên ban đầu
    val sv1 = SinhVienModel("Nguyen Van Long", "PH11324", 9.5f)
    val sv2 = SinhVienModel("Le Tuan Anh", "PH14572", 8.5f, false, 21)
    val sv3 = SinhVienModel("Tran Thu Thao", "PH16445", 8.5f, false, 20)

    danhSachSV.themSinhVien(sv1)
    danhSachSV.themSinhVien(sv2)
    danhSachSV.themSinhVien(sv3)

    println("Danh sách sinh viên ban đầu:")
    danhSachSV.hienThiDanhSach()

    // Sửa sinh viên thứ 2
    val sv2Moi = SinhVienModel("Vu Van Phuc ", "PH34858", 10.0f, true, 20)
    danhSachSV.suaSinhVien(1, sv2Moi)

    println("\nSau khi sửa sinh viên thứ 2:")
    danhSachSV.hienThiDanhSach()

    // Xóa sinh viên thứ 3
    danhSachSV.xoaSinhVien(2)

    println("\nSau khi xóa sinh viên thứ 3:")
    danhSachSV.hienThiDanhSach()

    // Xóa tất cả sinh viên
    danhSachSV.xoaTatCaSinhVien()

    println("\nSau khi xóa tất cả sinh viên:")
    danhSachSV.hienThiDanhSach()
}
