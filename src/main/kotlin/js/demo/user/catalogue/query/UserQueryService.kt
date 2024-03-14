package js.demo.user.catalogue.query

import js.demo.user.catalogue.domain.port.UserRepository
import js.demo.user.catalogue.query.view.UserSimpleView
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserQueryService {
    @Autowired
    private lateinit var userRepository: UserRepository;

    fun findAll(): List<UserSimpleView> {
        return userRepository.findAll()
                .map { UserSimpleView(it.lastName, it.firstName, it.email, it.login, ) }
                .toList()
    }

}