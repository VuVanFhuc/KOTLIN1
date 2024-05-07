package ph34858.laptrinhkotlin.lab1Ph34858
// bài tập giao thêm 10 ví dụ :



//VÍ DỤ 1
fun main() {
    cases("HELLO")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("HELLO")
}

fun cases(obj: Any) {
    when (obj) {
        1 -> println("ONE")
        "Hello" -> println("GREETING")
        is Long -> println("LONG")
        !is String -> println("NOT A STRING")
        else -> println("UNKNOWN")
    }
}
class MyClass



// VÍ DỤ 2
//fun main() {
//    println(whenAssign("Hello"))
//    println(whenAssign(3.4))
//    println(whenAssign(1))
//    println(whenAssign(MyClass()))
//}
//
//fun whenAssign(obj: Any): Any {
//    val result = when (obj) {
//        1 -> "one"
//        "Hello" -> 1
//        is Long -> false
//        else -> 42
//    }
//    return result
//}
//
//class MyClass




//VÍ DỤ 3
//fun main(args: Array<String>) {
//    val cakes = listOf("carrot", "cheese", "chocolate")
//
//    for (cake in cakes) {
//        println("Yummy, it's a $cake cake!")
//    }
//
//}



// VÍ DỤ 4
//fun eatACake() = println("Eat a Cake")
//fun bakeACake() = println("Bake a Cake")
//
//fun main(args: Array<String>) {
//    var cakesEaten = 0
//    var cakesBaked = 0
//
//    while (cakesEaten < 5) {
//        eatACake()
//        cakesEaten ++
//    }
//
//    do {
//        bakeACake()
//        cakesBaked++
//    } while (cakesBaked < cakesEaten)
//
//}




//VÍ DỤ 5
//class Animal(val name: String)
//
//class Zoo(val animals: List<Animal>) {
//
//    operator fun iterator(): Iterator<Animal> {
//        return animals.iterator()
//    }
//}
//
//fun main() {
//
//    val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))
//
//    for (animal in zoo) {
//        println("Watch out, it's a ${animal.name}")
//    }
//
//}




//VÍ DỤ 6
//fun main() {
//    for(i in 0..3) {
//        print(i)
//    }
//    print(" ")
//
//    for(i in 0 until 3) {
//        print(i)
//    }
//    print(" ")
//
//    for(i in 2..8 step 2) {
//        print(i)
//    }
//    print(" ")
//
//    for (i in 3 downTo 0) {
//        print(i)
//    }
//    print(" ")
//
//}




//VÍ DỤ 7
//fun main() {
//    for (c in 'a'..'d') {
//        print(c)
//    }
//    print(" ")
//
//    for (c in 'z' downTo 's' step 2) {
//        print(c)
//    }
//    print(" ")
//
//}



//VÍ DỤ 8
//fun main() {
//    val x = 2
//    if (x in 1..5) {
//        print("x is in range from 1 to 5")
//    }
//    println()
//
//    if (x !in 6..10) {
//        print("x is not in range from 6 to 10")
//    }
//}


//VÍ DỤ 9
//fun main() {
//
//    val authors = setOf("Shakespeare", "Hemingway", "Twain")
//    val writers = setOf("Twain", "Shakespeare", "Hemingway")
//
//    println(authors == writers)
//    println(authors === writers)
//}




//VÍ DỤ 10
//fun main() {
//    fun max(a: Int, b: Int) = if (a > b) a else b
//
//    println(max(99, -42))
//}


class Bai4Ph34858 {
}