package se.implementer.sportservice.service

import java.util.logging.Logger
import org.springframework.stereotype.Service
import se.implementer.sportservice.client.MuayThaiClient
import se.implementer.sportservice.controller.ExternalSportsNewsResponse

@Service
class SportService (val muayThaiClient: MuayThaiClient){

    private val logger = Logger.getLogger(SportService::class.java.name)

    fun getSportNews(): ExternalSportsNewsResponse {
        logger.info("Fetching sports news")
        return ExternalSportsNewsResponse(
            muayThaiFighters = listOf(muayThaiClient.fetchMuayThaiRecords()),
        )
    }
}
