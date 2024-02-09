package se.implementer.sportservice.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import java.util.logging.Logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import se.implementer.sportservice.model.FighterOverview
import se.implementer.sportservice.service.SportService

@RestController
@RequestMapping("external/v1/sport-news")
class SportController (val sportService: SportService) {

    private val logger = Logger.getLogger(SportController::class.java.name)

    @Operation(
        summary = "Fetches sport news.",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Fetches sport news",
            ),
        ],
    )
    @GetMapping
    fun getSportNews(): ExternalSportsNewsResponse{
        logger.info("Received request to fetch sports news")
        return sportService.getSportNews()
    }
}

data class ExternalSportsNewsResponse(
    val muayThaiFighters: List<FighterOverview> = emptyList(),
)