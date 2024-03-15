package js.demo.user.catalogue.config

import js.demo.user.catalogue.domain.UserService
import js.demo.user.catalogue.domain.port.UserRepository
import js.demo.user.catalogue.query.UserQueryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class UserCatalogueConfig {
    //@Autowired
    //private val userRepository: UserRepository? = null

    @Bean
    fun userService(userRepository: UserRepository) = UserService(userRepository)

    @Bean
    fun userQueryService(userRepository: UserRepository) = UserQueryService(userRepository)
}