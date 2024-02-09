package se.implementer.sportservice.client

import java.lang.RuntimeException
import java.util.logging.Logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import se.implementer.sportservice.model.FighterOverview

@Component
class MuayThaiClient (@Value("\${integration.muay-thai-service.url}")  val baseUrl: String) {

    private final val fighterOverviewUrl = "/fighter/overview/{fighterId}"

    private val restClient = RestClient.create()

    private val fighterId: String = "2"

    private val logger = Logger.getLogger(MuayThaiClient::class.java.name)

    fun fetchMuayThaiRecords(): FighterOverview {
        logger.info("Fetching muay thai fighter stats for fighter with id: $fighterId")

        val fighter = restClient
            .get()
            .uri(baseUrl + fighterOverviewUrl, fighterId)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .body(FighterOverview::class.java)

        logger.info("Muay thai fighter stats for fighter with id: $fighterId was fetched")
        return fighter ?: throw RuntimeException("Fighter not found with id $fighterId",)
    }
}