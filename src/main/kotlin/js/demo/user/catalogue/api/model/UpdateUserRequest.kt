package js.demo.user.catalogue.api.model

import java.util.*

data class UpdateUserRequest(
    val uuid: UUID,
    val login: String?,
    val active: Boolean?
)