package no.nav.hm.imb.request.api.rest

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.authentication.Authentication
import io.micronaut.security.rules.SecurityRule
import org.slf4j.LoggerFactory

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/api/v1/request")
class RequestController {

    @Get("/ping")
    fun ping(authentication: Authentication): String {
        LOG.info("Ping request ${authentication.name}  with roles ${authentication.roles}")
        return "pong"
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(RequestController::class.java)
    }

}