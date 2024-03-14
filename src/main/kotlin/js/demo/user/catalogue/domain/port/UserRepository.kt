package js.demo.user.catalogue.domain.port

import js.demo.user.catalogue.domain.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, UUID> {
}