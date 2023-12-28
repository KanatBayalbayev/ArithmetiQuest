package com.qanatdev.arithmetiquest.domain.entities

import java.io.Serializable

data class GameConfiguration(
    val maxSumValue: Int,
    val minCountOfRightAnswers: Int,
    val minPercentOfRightAnswers: Int,
    val gameTimeInSeconds: Int
): Serializable
