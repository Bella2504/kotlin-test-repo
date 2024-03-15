package js.demo.user.catalogue.api

import js.demo.user.catalogue.api.model.CreateUserRequest
import js.demo.user.catalogue.api.model.UpdateUserRequest
import js.demo.user.catalogue.domain.UserService
import js.demo.user.catalogue.domain.model.command.CreateUserCommand
import js.demo.user.catalogue.domain.model.command.UpdateUserCommand
import js.demo.user.catalogue.query.UserQueryService
import js.demo.user.catalogue.query.view.UserSimpleView
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserEndpoint(val userService: UserService,
                   val userQueryService: UserQueryService){

    @PostMapping
    fun createUser(@RequestBody request: CreateUserRequest) {
        userService.createUser(CreateUserCommand(
                lastName = request.lastName,
                firstName = request.firstName,
                email = request.email,
                login = request.login,
        ))
    }


    @PutMapping
    fun updateUser(@RequestBody request: UpdateUserRequest) {
        userService.updateUser(UpdateUserCommand(
            uuid = request.uuid,
            login = request.login,
            active = request.active
        ))
    }

    @GetMapping
    fun findAllUSer(): List<UserSimpleView> {
        return userQueryService.findAll();
    }

}