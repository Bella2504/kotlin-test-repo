package js.demo.user.catalogue.adapter.persistence

import js.demo.user.catalogue.config.UserCatalogueTestConfig
import js.demo.user.catalogue.domain.UserService
import js.demo.user.catalogue.domain.model.User
import js.demo.user.catalogue.domain.model.command.CreateUserCommand
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.kotlin.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.junit4.SpringRunner
import java.util.UUID.randomUUID
import kotlin.test.Test


@Import(UserCatalogueTestConfig::class)
@DataJpaTest
@RunWith(SpringRunner::class)
class UserRepositoryTest(@Autowired private val userService: UserService) {

    @Test
    fun createUser(){
        /* Given */
        val userDto = CreateUserCommand(
                lastName = "Test",
                firstName =  "Test",
                email =  "Test",
                login =  "Test"
        )
       val user = userService.createUser(userDto)
        verify(user.login) === userDto.login
    }
}