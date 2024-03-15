package js.demo.user.catalogue

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement


@EnableJpaRepositories("js.demo.*")
@ComponentScan(basePackages = ["js.demo.*"])
@EntityScan("js.demo.*")
@EnableTransactionManagement
@SpringBootApplication
class UserCatalogueApplication

fun main(args: Array<String>) {
	runApplication<UserCatalogueApplication>(*args)
}
