package no.nav.hm.imb.request.api

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info


@OpenAPIDefinition(
	info = Info(
		title = "IMB Request API",
		version = "0.1",
		description = "Request API for IMB",
	)
)
object Application {
	@JvmStatic
	fun main(args: Array<String>) {
		Micronaut.build()
			.packages("no.nav.hm.imb.request.api")
			.mainClass(Application::class.java)
			.start()
	}
}
