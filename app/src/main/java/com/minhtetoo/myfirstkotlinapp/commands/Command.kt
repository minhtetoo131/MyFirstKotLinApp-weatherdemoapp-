package com.minhtetoo.myfirstkotlinapp.commands

interface Command<out T> {
    fun execute(): T
}