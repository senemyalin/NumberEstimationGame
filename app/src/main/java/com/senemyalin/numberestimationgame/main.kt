package com.senemyalin.numberestimationgame

import java.util.*


fun main(){
    gameProcess()
}

private fun gameProcess(){
    println("Hello, welcome to our Number Estimation Game. Please estimate a number between 0 and 101")

    val randomNumber = getRandomNumber()
    println(randomNumber)

    for (estimationCount in 1..3){
        val estimatedNumber = getEstimatedNumber()

        //Gives remaining estimation count
        println("Remaining estimation count is:  ${remainingEstimationCount(estimationCount)}")

        //Check if the user input is valid
        if (estimatedNumber > 101 || estimatedNumber < 1){
            if(isEstimationCountOver(estimationCount)){
                break
            }
            println("Invalid input, please try again.")
            continue
        }

        //Check if estimated number correct, or not
        if(isEstimatedNumberCorrect(estimatedNumber, randomNumber)){
            println("Your estimation is correct. Congratulations!")
            break
        }else{
            if(isEstimationCountOver(estimationCount)){
                break
            }

            informUser(randomNumber, estimatedNumber)
        }
    }
}

private fun isEstimatedNumberCorrect(estimatedNumber: Int, randomNumber: Int): Boolean{
    return estimatedNumber == randomNumber
}

private fun getRandomNumber(): Int{
    return (1..100).random()
}

private fun getEstimatedNumber(): Int {
    val reader = Scanner(System.`in`)

    return try {
        println("Enter a number: ")
        reader.nextInt()
    } catch (e: Exception) {
        reader.nextLine()
        -1
    }
}

private fun remainingEstimationCount(estimatedNumberCount: Int): Int {
    val totalEstimationCount = 3

    return totalEstimationCount - estimatedNumberCount
}

private fun informUser(randomNumber: Int, estimatedNumber: Int){
    if(randomNumber > estimatedNumber){
        println("Try bigger number, please.")
    }else{
        println("Try smaller number, please.")
    }
}

private fun isEstimationCountOver(estimationCount: Int): Boolean{
    if (estimationCount == 3){
        println("Game over.")
        return true
    }
    return false
}