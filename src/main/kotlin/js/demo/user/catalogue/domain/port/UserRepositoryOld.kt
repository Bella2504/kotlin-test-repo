package js.demo.user.catalogue.domain.port

import js.demo.user.catalogue.domain.model.User
import java.util.UUID

interface UserRepositoryOld {

    fun find(userId: UUID): User?

    fun findAll(): List<User>

    fun upsert(user: User): User

}