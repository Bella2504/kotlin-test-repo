package js.demo.user.catalogue.config

import js.demo.user.catalogue.domain.UserService
import js.demo.user.catalogue.adapter.persistence.UserRepository
import js.demo.user.catalogue.query.UserQueryService
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class UserCatalogueTestConfig {

    @Bean
    fun userService(userRepository: UserRepository) = UserService(userRepository)

    @Bean
    fun userQueryService(userRepository: UserRepository) = UserQueryService(userRepository)
}