package ph34858.laptrinhkotlin.lab2Ph34858

data class SinhVienModel(
    var tenSV: String,
    var mssv: String,
    var diemTB: Float,
    var daTotNghiep: Boolean? = null,
    var tuoi: Int? = null
) {
    fun getThongTin(): String {
        return if (daTotNghiep != null && tuoi != null) {
            "Ten: $tenSV, mssv: $mssv, diemTB: $diemTB, da tot nghiep: $daTotNghiep, tuoi: $tuoi"
        } else {
            "Ten: $tenSV, mssv: $mssv, diemTB: $diemTB"
        }
    }
}

class DanhSachSinhVien {
    private val listSV = mutableListOf<SinhVienModel>()

    fun themSinhVien(sv: SinhVienModel) {
        listSV.add(sv)
    }

    fun suaSinhVien(index: Int, svMoi: SinhVienModel) {
        if (index in listSV.indices) {
            listSV[index] = svMoi
        } else {
            println("Index không hợp lệ")
        }
    }

    fun xoaSinhVien(index: Int) {
        if (index in listSV.indices) {
            listSV.removeAt(index)
        } else {
            println("Index không hợp lệ")
        }
    }

    fun xoaTatCaSinhVien() {
        listSV.clear()
    }

    fun hienThiDanhSach() {
        if (listSV.isNotEmpty()) {
            listSV.forEachIndexed { index, sv ->
                println("Sinh viên $index: ${sv.getThongTin()}")
            }
        } else {
            println("Danh sách sinh viên trống")
        }
    }
}


