package js.demo.user.catalogue.domain.model.command

import java.util.UUID

data class CreateUserCommand(
        val lastName: String,
        val firstName: String,
        val email: String,
        val login: String
)

data class UpdateUserCommand(
        val uuid: UUID,
        val login: String?,
        val active: Boolean?
)