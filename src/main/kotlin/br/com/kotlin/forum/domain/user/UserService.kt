package br.com.kotlin.forum.domain.user

interface UserService {

    fun getUsers(): List<User>
    fun getUserById(id: Long): User

}