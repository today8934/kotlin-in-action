package Chapter2

class Person (
    val name: String,
    var isMarried: Boolean
    )

fun main() {
    val person = Person("¿í»ó", false)
    println(person.name);
    println(person.isMarried)
    person.isMarried = true
    println(person.isMarried)
}