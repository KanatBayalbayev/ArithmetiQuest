package com.qanatdev.arithmetiquest.domain.usecases

import com.qanatdev.arithmetiquest.domain.entities.GameConfiguration
import com.qanatdev.arithmetiquest.domain.entities.Level
import com.qanatdev.arithmetiquest.domain.repo.GameRepository

class GetGameConfigurationUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(level: Level): GameConfiguration {
        return repository.getGameSettings(level)
    }
}
