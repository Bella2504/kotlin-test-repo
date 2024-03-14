package js.demo.user.catalogue.api

import js.demo.user.catalogue.api.model.CreateUserRequest
import js.demo.user.catalogue.domain.UserService
import js.demo.user.catalogue.domain.model.command.CreateUserCommand
import js.demo.user.catalogue.query.UserQueryService
import js.demo.user.catalogue.query.view.UserSimpleView
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserEndpoint(@Autowired val userService: UserService,
                   @Autowired val userQueryService: UserQueryService){

    @PostMapping
    fun createUser(@RequestBody request: CreateUserRequest) {
        userService.createUser(CreateUserCommand(
                lastName = request.lastName,
                firstName = request.firstName,
                email = request.email,
                login = request.login,
        ))
    }

    @GetMapping
    fun findAllUSer(): List<UserSimpleView> {
        return userQueryService.findAll();
    }

}