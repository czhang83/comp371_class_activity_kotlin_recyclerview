package com.example.classactivity8

// val - don't hava setters
data class Villager(val name:String, val birthday:String, val phrase:String,
                    val houseURL:String, val villagerURL:String, var showVillager : Boolean = false){
    // auto set toString, getters, setters, equals
}
