package js.demo.user.catalogue.domain.model.command


data class CreateUserCommand(
        val lastName: String,
        val firstName: String,
        val email: String,
        val login: String
)