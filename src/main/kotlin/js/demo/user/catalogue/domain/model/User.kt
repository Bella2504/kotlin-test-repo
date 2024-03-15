package js.demo.user.catalogue.domain.model

import java.util.UUID
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="CatalogueUser")
class User(
        @Id
        val userId: UUID,
        val lastName: String,
        val firstName: String,
        val email: String,
        var login: String,
        var active: Boolean?
)
