import kotlin.random.Random

var philosophers = mutableListOf<Philosopher>()
fun main() {
    println("Пять филосовоф обедают")

    var waiting = mutableListOf<Philosopher>()
    // Добавление философов
    for (i in 0 until 5) {
        philosophers.add(Philosopher((i + 1).toString()))
       // waiting.add(Philosopher((i + 1).toString()))
        waiting.add(philosophers[i])
    }
    waiting = philosophers
    // Случайный выбор вилки для случайно-выбранного философа
    for (i in 0 until 5) {
        val unit = waiting.random()
        action(unit)
        waiting.remove(unit)
    }

    // Для удобства отслеживания они пытаются поесть последовательно (с 1 по 5)
    philosophers.forEach {
        it.eat()
    }

    println(" ")
}

fun action(philosopher: Philosopher) {
    val index = philosophers.indexOf(philosopher)
    if (!philosophers[(5 + index - 1 )% 5].rightHand ||
        !philosophers[(index + 1) % 5].leftHand) {
        if (philosophers[(5 + index - 1 )% 5].rightHand) {
            philosophers[index].takeSpoon(false)
        }
        else if (philosophers[(index + 1) % 5].leftHand) {
            philosophers[index].takeSpoon(true)
        }
        else {
            philosophers[index].takeSpoon(Random.nextBoolean())
        }
    }
}

