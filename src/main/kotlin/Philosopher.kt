class Philosopher(name: String) {
    private val name: String = name
    var rightHand = false
    var leftHand = false

    fun eat() {
        if (rightHand || leftHand) {
            print("$name, философ, ест ")
            if (leftHand){
                println("левой рукой")
            }
            else{
                println("правой рукой")
            }
        }
        else {
            // Философия начинается с голодухи =)
            think()
        }
    }

    private fun think() {
        println("$name, философ, рассуждает")
    }

    fun takeSpoon(isLeft: Boolean) {
        when (isLeft){
            true -> leftHand = true
            false -> rightHand = true
        }
    }
}