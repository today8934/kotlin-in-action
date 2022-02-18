package Chapter2

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
        if(i == 1) println("")
    }
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