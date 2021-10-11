import arrow.core.partially1

fun main() {
    var x: Int = calculate(Pair(sum.partially1(2), 5), Pair(minus.partially1(5), 6))
    println(x)

    x = calculate(Pair(multiply.partially1(8), 5), Pair(divide.partially1(6), 6))
    println(x)
}

val sum = { x: Int, y: Int -> x + y }
val minus = { x: Int, y: Int -> x - y }
val multiply = { x: Int, y: Int -> x * y }
val divide = { x: Int, y: Int -> x / y }


fun calculate(vararg params: Pair<(Int) -> Int, Int>): Int {
    return params
        .map { it.first(it.second) }
        .reduce { x, y -> x + y }
}