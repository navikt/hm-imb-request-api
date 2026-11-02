package no.nav.hm.imb.request.api.internal

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/internal/")
class AliveController {

    @Get("/alive")
    fun alive(): String {
        return "alive"
    }

    @Get("/ready")
    fun ready(): String {
        return "ready"
    }
}