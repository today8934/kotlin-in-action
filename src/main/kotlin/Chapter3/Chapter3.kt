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

    println(list.joinToString2(separator = "; ", prefix = "(", postfix = ")"))
    println(list.joinToString2(" "))

    println(listOf("one", "two", "eight").join())

    println("Kotlin".lastChar)

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)

    val kotlinLogo = """
                        |  //
                       .| //
                       .|/ \"""
    println(kotlinLogo.trimMargin())
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

fun <T> Collection<T>.joinToString2(
    separator: String = ", ",
    prefix: String ="",
    postfix: String = ""
) : String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString2(separator, prefix, postfix)

val String.lastChar : Char
    get() = get(length-1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

fun parsePath(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, extension: $extension")
    }
}

class User(val id: Int, val name: String, val address: String)

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser(user: User) {
    user.validateBeforeSave()
}