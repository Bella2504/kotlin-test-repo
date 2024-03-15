package js.demo.user.catalogue.domain

import js.demo.user.catalogue.domain.model.User
import js.demo.user.catalogue.domain.model.command.CreateUserCommand
import js.demo.user.catalogue.domain.model.command.UpdateUserCommand
import js.demo.user.catalogue.domain.port.UserRepository
import org.springframework.stereotype.Service

import java.util.UUID

@Service
class UserService(private val userRepository: UserRepository) {
    fun createUser(command: CreateUserCommand): UUID {
        return userRepository.save(User(
                userId = UUID.randomUUID(),
                lastName = command.lastName,
                firstName = command.firstName,
                email = command.email,
                login = command.login,
                active = null
        )).userId
    }

    fun updateUser(command: UpdateUserCommand): User {
        val uuid = command.uuid;
        val user = userRepository.findById(uuid).get();
        command.active?.let { user.active = it }
        command.login?.let { user.login = it }
        return userRepository.save(user)
    }
}