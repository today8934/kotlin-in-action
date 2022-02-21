package Chapter2

import java.io.BufferedReader
import java.io.StringReader
import java.util.TreeMap

class Chapter2 {
}

fun main() {
    val person = Person("¿í»ó", false)
    println(person.name);
    println(person.isMarried)
    person.isMarried = true
    println(person.isMarried)

    val rectangle = Rectangle(100, 30)
    println(rectangle.isSquare)
    rectangle.width = 100
    println(rectangle.isSquare)

    val createdRectangle = createRandomRectangle()

    println("height: ${createdRectangle.height}, width: ${createdRectangle.width}, isSquare: ${createdRectangle.isSquare}")

    val red = Color.RED
    val blue = Color.BLUE

    println(red.rgb())
    println(blue.rgb())
    println(Color.INDIGO.r)

    println(getMnemonic(red))
    println(getMnemonic(Color.INDIGO))
    println(getMnemonic(Color.BLUE))

    println(getWarmth(Color.ORANGE))
    println(getWarmth(Color.GREEN))
    println(getWarmth(Color.INDIGO))

    println(mix(Color.RED, Color.YELLOW))
    //println(mix(Color.RED, Color.VIOLET))

    println(mixOptimized(Color.BLUE, Color.YELLOW))

    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))

    for(i in 1..100) {
        print(fizzBuzz(i))
        if(i == 100) println("")
    }

    for(i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
        if(i == 2) println("")
    }

    mapIteration()

    println(isLetter('q'))
    println(isLetter('&'))
    println(isNotDigit('x'))
    println(isNotDigit('9'))

    println(recognize('8'))
    println(recognize('c'))
    println(recognize('*'))
    println(recognize('H'))
    println(recognize('0'))

    val reader = BufferedReader(StringReader("It's not a number"))
    readNumber(reader)
}

fun eval(e: Expr) : Int =
    when(e) {
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun evalWithLogging(e: Expr) : Int =
    when(e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown Expression")
    }

fun fizzBuzz(i: Int) =
    when {
        i % 15 == 0 -> "FizzBuzz "
        i % 3 == 0 -> "Fizz "
        i % 5 == 0 -> "Buzz "
        else -> "$i "
    }

fun mapIteration() {
    val binaryReps = TreeMap<Char, String>()

    for(c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.code)
        binaryReps[c] = binary
    }

    for((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    val list = arrayListOf("10", "11", "1001")

    for((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) =
    when(c) {
        in '0'..'9' -> "It's a digit!"
        in 'a'..'z', in 'A'..'Z' -> "'It's a letter!"
        else -> "I dont't know.."
    }

fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    }
    catch(e: NumberFormatException) {
        null
    }
    println(number)
}