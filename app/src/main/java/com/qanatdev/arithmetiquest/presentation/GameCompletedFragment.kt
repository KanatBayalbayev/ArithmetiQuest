package com.qanatdev.arithmetiquest.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.qanatdev.arithmetiquest.R
import com.qanatdev.arithmetiquest.databinding.ActivityWelcomeBinding
import com.qanatdev.arithmetiquest.databinding.FragmentGameCompletedBinding
import com.qanatdev.arithmetiquest.domain.entities.Outcome


class GameCompletedFragment : Fragment() {


    private val args by navArgs<GameCompletedFragmentArgs>()

    private var _binding: FragmentGameCompletedBinding? = null
    private val binding: FragmentGameCompletedBinding
        get() = _binding ?: throw RuntimeException("FragmentGameCompletedBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameCompletedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        bindViews()
        startAgain()
    }

    private fun setupClickListeners() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                retryGame()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
    }

    private fun bindViews() {
        with(binding) {
            getEmojiResult()
            tvRequiredAnswers.text = String.format(
                getString(R.string.required_score),
                args.outcome.gameConfiguration.minCountOfRightAnswers
            )
            tvScoreAnswers.text = String.format(
                getString(R.string.score_answers),
                args.outcome.countOfRightAnswers
            )
            tvRequiredPercentage.text = String.format(
                getString(R.string.required_percentage),
                args.outcome.gameConfiguration.minPercentOfRightAnswers
            )
            tvScorePercentage.text = String.format(
                getString(R.string.score_percentage),
                getPercentOfRightAnswers()
            )
        }
    }

        private fun getEmojiResult() {
        if (args.outcome.winner) {
            binding.wonEmoji.visibility = View.VISIBLE
            binding.lostEmoji.visibility = View.GONE
        } else {
            binding.lostEmoji.visibility = View.VISIBLE
            binding.wonEmoji.visibility = View.GONE
        }
    }



    private fun getPercentOfRightAnswers() = with(args.outcome) {
        if (countOfQuestions == 0) {
            0
        } else {
            ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
        }
    }

    private fun startAgain() {
        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
    }


    private fun retryGame() {
        findNavController().popBackStack(R.id.gameFragment, true)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
