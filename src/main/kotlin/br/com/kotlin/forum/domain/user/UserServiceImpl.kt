package br.com.kotlin.forum.domain.user

import br.com.kotlin.forum.application.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    private val users: List<User> = buildUsers()

    override fun getUsers(): List<User> {
        return users
    }

    override fun getUserById(id: Long): User {
        return users.stream()
            .filter { u -> u.id == id }
            .findFirst()
            .orElseThrow { NotFoundException("Usuário não encontrado") }
    }

    private fun buildUsers(): List<User> {
        return mutableListOf(
            User(
                id = 1,
                name = "João",
                email = "joao@dev.com"
            ),
            User(
                id = 2,
                name = "Maria",
                email = "maria@dev.com"
            )
        )
    }
}