package com.qanatdev.arithmetiquest.domain.repo

import com.qanatdev.arithmetiquest.domain.entities.GameConfiguration
import com.qanatdev.arithmetiquest.domain.entities.Level
import com.qanatdev.arithmetiquest.domain.entities.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameConfiguration
}
