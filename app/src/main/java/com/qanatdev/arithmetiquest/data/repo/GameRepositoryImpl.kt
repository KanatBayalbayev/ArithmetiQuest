package com.qanatdev.arithmetiquest.data.repo

import com.qanatdev.arithmetiquest.domain.entities.GameConfiguration
import com.qanatdev.arithmetiquest.domain.entities.Level
import com.qanatdev.arithmetiquest.domain.entities.Question
import com.qanatdev.arithmetiquest.domain.repo.GameRepository
import javax.inject.Inject
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl : GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        val to = min(maxSumValue, rightAnswer + countOfOptions)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())
    }

    override fun getGameSettings(level: Level): GameConfiguration {
        return when (level) {
            Level.TEST -> {
                GameConfiguration(
                    10,
                    3,
                    50,
                    8
                )
            }

            Level.EASY -> {
                GameConfiguration(
                    10,
                    10,
                    70,
                    60
                )
            }

            Level.NORMAL -> {
                GameConfiguration(
                    20,
                    20,
                    80,
                    40
                )
            }

            Level.HARD -> {
                GameConfiguration(
                    30,
                    30,
                    90,
                    30
                )
            }
        }
    }

}
