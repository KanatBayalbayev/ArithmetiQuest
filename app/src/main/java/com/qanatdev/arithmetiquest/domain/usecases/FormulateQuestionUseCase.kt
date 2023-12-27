package com.qanatdev.arithmetiquest.domain.usecases

import com.qanatdev.arithmetiquest.domain.entities.Question
import com.qanatdev.arithmetiquest.domain.repo.GameRepository

class FormulateQuestionUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object {

        private const val COUNT_OF_OPTIONS = 6
    }
}
