package js.demo.user.catalogue

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan("js.demo")
@EnableJpaRepositories("js.demo")
@EntityScan("js.demo")
class UserCatalogueApplication

fun main(args: Array<String>) {
	runApplication<UserCatalogueApplication>(*args)
}
