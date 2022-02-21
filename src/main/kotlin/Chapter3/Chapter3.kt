package Chapter3

class Chapter3 {
}

fun main() {
    val set = hashSetOf(1, 7, 53)
    val alist = arrayListOf(1,7,53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    println(set.javaClass)
    println(alist.javaClass)
    println(map.javaClass)

    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())

    val numbers = setOf(1, 14, 12)
    println(numbers.maxOrNull())

    val list = listOf(1, 2, 3)
    println(joinToString(list, "; ", "(", ")"))
    println(joinToString(list, ", ", "<", ">"))
    println(joinToString(collection = list, separator = ", ", prefix = "[", postfix = "]"))
    println(joinToString(list))
    println(joinToString(list, "; "))
    println(joinToString(list, postfix = "}", prefix = "{"))

    println("Kotlin".lastChar())
}

fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) : String {
    val result = StringBuilder(prefix)
    for((index, element) in collection.withIndex()) {
        if(index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun String.lastChar() : Char = get(length-1)