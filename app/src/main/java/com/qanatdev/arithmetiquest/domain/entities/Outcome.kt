package com.qanatdev.arithmetiquest.domain.entities

import java.io.Serializable

data class Outcome(
    val winner: Boolean,
    val countOfRightAnswers: Int,
    val countOfQuestions: Int,
    val gameConfiguration: GameConfiguration
): Serializable
