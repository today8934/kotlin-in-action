package Chapter2

import java.util.Random

class Rectangle (val height: Int, var width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun main() {
    val rectangle = Rectangle(100, 30)
    println(rectangle.isSquare)
    rectangle.width = 100
    println(rectangle.isSquare)

    val createdRectangle = createRandomRectangle()

    println("height: ${createdRectangle.height}, width: ${createdRectangle.width}, isSquare: ${createdRectangle.isSquare}")
}

fun createRandomRectangle() : Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}