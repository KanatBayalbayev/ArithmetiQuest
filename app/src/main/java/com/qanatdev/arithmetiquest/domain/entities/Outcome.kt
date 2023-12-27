package com.qanatdev.arithmetiquest.domain.entities

data class Outcome(
    val winner: Boolean,
    val countOfRightAnswers: Int,
    val countOfQuestions: Int,
    val gameConfiguration: GameConfiguration
)
