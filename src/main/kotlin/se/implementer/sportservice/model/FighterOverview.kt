package se.implementer.sportservice.model

import com.fasterxml.jackson.annotation.JsonProperty

data class FighterOverview(
    val fighterId : Long,
    val firstName: String,
    val lastName: String,
    val showName: String,
    val gender: String,
    val totalFights: Int,
    val wins: Int,
    val losses: Int,
    val countryOrigin: String,
    val age: Int,
    @JsonProperty("status")
    val fighterStatus: String,
)
