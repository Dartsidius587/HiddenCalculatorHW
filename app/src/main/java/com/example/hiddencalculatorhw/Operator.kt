package com.example.hiddencalculatorhw

class Operator(private var first: Double, private var second: Double) {
    fun sum() = first + second
    fun dif() = first - second
    fun mult() = first * second
    fun div(): Double = try{
        first / second
    } catch(e: Exception){
        0.0
    }
}