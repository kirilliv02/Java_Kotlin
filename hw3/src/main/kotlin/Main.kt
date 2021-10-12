import arrow.core.andThen
import arrow.core.partially1

val sum = { x: Int, y: Int -> x + y }
val minus = { x: Int, y: Int -> x - y }
val multiply = { x: Int, y: Int -> x * y }
val divide = { x: Int, y: Int -> x / y }

fun main() {
    println(calculate(Pair(sum.partially1(2), 5), Pair(minus.partially1(5), 6)))
    println(calculate(Pair(multiply.partially1(8), 5), Pair(divide.partially1(6), 6)))
}


fun calculate(vararg params: Pair<(Int) -> Int, Int>): Int {
    val fnc = params
        .map {
            val v = it.first.partially1(it.second)
            val f = { x: Int -> x + v() }
            f
        }
        .reduce { c, n -> c andThen n }

    return fnc(0)
}