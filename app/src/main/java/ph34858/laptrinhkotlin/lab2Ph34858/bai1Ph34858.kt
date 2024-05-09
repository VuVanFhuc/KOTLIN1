package ph34858.laptrinhkotlin.lab2Ph34858
//Bài 1: Nhập 2 số a và b, Viết chương trình giải phương trình bậc 1: ax+b=0
fun main() {
    var a = 0.0
    var b = 0.0
    println("Nhập a:")
    var s = readLine()
    if (s != null) a = s.toDouble()
    println("Nhập b:")
    s = readLine()
    if (s != null) b = s.toDouble()
    if (a == 0.0 && b == 0.0) {
        println("Phương trình vô số nghiệm")
    } else if (a == 0.0 && b != 0.0) {
        println("Phương trình vô nghiệm")
    } else {
        val x = -b / a
        println("phuong trinh co nghiem la :  x=" + x)
    }
}

class bai1Ph34858 {
}