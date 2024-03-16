package js.demo.user.catalogue.query

import js.demo.user.catalogue.adapter.persistence.UserRepository
import js.demo.user.catalogue.query.view.UserSimpleView
import org.springframework.stereotype.Service
import mu.KotlinLogging
import java.lang.Exception

@Service
class UserQueryService(private val userRepository: UserRepository) {
    private val logger = KotlinLogging.logger {}

    fun findAll(): List<UserSimpleView> {
        try {
            return userRepository.findAll()
                .map { UserSimpleView(it.lastName, it.firstName, it.email, it.login,) }
                .toList()
        } catch (e: Exception) {
            logger.error("Could not fetch data: ${e.message}")
        }
        return listOf();
    }

}