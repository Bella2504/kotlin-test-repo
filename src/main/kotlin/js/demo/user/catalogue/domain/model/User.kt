package js.demo.user.catalogue.domain.model

import java.util.UUID
import javax.persistence.Entity

@Entity
data class User(
        val userId: UUID,
        val lastName: String,
        val firstName: String,
        val email: String,
        val login: String,
        val active: Boolean?
)