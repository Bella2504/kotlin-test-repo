package js.demo.user.catalogue.domain

import js.demo.user.catalogue.api.exceptions.UserNotFoundException
import js.demo.user.catalogue.domain.model.User
import js.demo.user.catalogue.domain.model.command.CreateUserCommand
import js.demo.user.catalogue.domain.model.command.UpdateUserCommand
import js.demo.user.catalogue.adapter.persistence.UserRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service
import java.lang.Exception

import java.util.UUID

@Service
class UserService(private val userRepository: UserRepository) {
    private val logger = KotlinLogging.logger {}
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

    /**
     * I haven't decided yet, in this case I have allowed to update login and is user is active
     */
    fun updateUser(command: UpdateUserCommand): User {
        val uuid = command.uuid;
        val userResponse = userRepository.findById(uuid);
        val user = userResponse.get();

        if (command.login === null && command.active === null) {
            throw IllegalArgumentException("Nothing to update in query for user id=${command.uuid}")
        }

        (command.login === user.login).let {  }
        if (command.login === user.login && command.active === user.active) {
            throw IllegalArgumentException("No values to update user with id=${command.uuid} with active=${command.active} and login=${command.login} were provided")
        }
        if (userResponse.isEmpty) {
            throw UserNotFoundException("")
        }
        command.active?.let { user.active = it }
        command.login?.let { user.login = it }
        return userRepository.save(user)

    }

    fun deleteUser(id: UUID) {
        try {
            val userResponse = userRepository.findById(id);

            if (userResponse.isEmpty) {
                throw UserNotFoundException("User with id=$id not found")
            }
        } catch (e: Exception){
            logger.error("Could not remove user=${id}: ${e.message}")
        }
    }
}