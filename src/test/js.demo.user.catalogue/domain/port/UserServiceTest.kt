package js.demo.user.catalogue.domain.port

import js.demo.user.catalogue.adapter.persistence.UserRepository
import js.demo.user.catalogue.domain.model.User
import org.junit.runner.RunWith
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*
import kotlin.test.Test


@RunWith(SpringRunner::class)
@DataJpaTest
class UserServiceTest(private val userRepository: UserRepository) {

    @Test
    private fun createUser(){
        val uuid = UUID.randomUUID();
        val user = userRepository.save(User(
                userId = uuid,
                lastName = "test_last_name",
                firstName = "test_first_name",
                email = "test_email",
                login = "test_login"
        ))
        assert(user.userId === uuid);
    }
}