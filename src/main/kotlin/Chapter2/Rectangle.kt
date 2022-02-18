package Chapter2

import java.util.Random

class Rectangle (val height: Int, var width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun createRandomRectangle() : Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}