package js.demo.user.catalogue.domain.model

import com.sun.istack.NotNull
import java.util.UUID
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="CatalogueUser")
class User(
        @Id
        val userId: UUID,
        @NotNull
        val lastName: String,
        @NotNull
        val firstName: String,
        @NotNull
        val email: String,
        @NotNull
        var login: String,
        var active: Boolean?
)
