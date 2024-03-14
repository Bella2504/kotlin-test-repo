package js.demo.user.catalogue.domain

import js.demo.user.catalogue.domain.model.User
import js.demo.user.catalogue.domain.model.command.CreateUserCommand
import js.demo.user.catalogue.domain.model.command.UpdateUserCommand
import js.demo.user.catalogue.domain.port.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

import java.util.UUID

@Service
class UserService(@Autowired val userRepository: UserRepository) {
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

    fun updateUser(command: UpdateUserCommand): UUID {
        val uuid = command.uuid;
        val user = userRepository.findById(uuid);
        return user.get().let {
            userRepository.save(User(
                userId = command.uuid,
                lastName = it.lastName,
                firstName = it.firstName,
                email = it.email,
                login = it.login,
                active = command.active
            ))
        }.userId
    }
}