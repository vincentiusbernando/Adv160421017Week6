package com.ubayadev.adv160421017week6.model

data class Student(
    val id:Int,
    val name:String,
    val age:Int,
    val scores:List<Int>,
    val address:Address,
    val img:String
)
