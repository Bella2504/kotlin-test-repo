package js.demo.user.catalogue.api.model

data class CreateUserRequest(
        val lastName: String,
        val firstName: String,
        val email: String,
        val login: String
)