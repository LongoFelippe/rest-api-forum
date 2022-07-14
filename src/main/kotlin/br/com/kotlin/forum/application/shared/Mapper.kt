package br.com.kotlin.forum.application.shared

interface Mapper<O, D> {

    fun mapTo(origin: O): D

}