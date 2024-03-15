package js.demo.user.catalogue.domain.model.command

import java.util.UUID

data class UpdateUserCommand(
    val uuid: UUID,
    val login: String?,
    val active: Boolean?
)