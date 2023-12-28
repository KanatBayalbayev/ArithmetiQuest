package com.qanatdev.arithmetiquest.presentation

import android.os.Bundle
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

    private lateinit var outcome: Outcome

    private val args by navArgs<GameCompletedFragmentArgs>()

    private var _binding: FragmentGameCompletedBinding? = null
    private val binding: FragmentGameCompletedBinding
        get() = _binding ?: throw RuntimeException("FragmentGameCompletedBinding == null")

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        parseArgs()
//    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameCompletedBinding.inflate(inflater,container,false)
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
            emojiResult.setImageResource(getSmileResId())
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

    private fun getSmileResId(): Int {
        return if (args.outcome.winner) {
            R.drawable.ic_smile
        } else {
            R.drawable.ic_sad
        }
    }

    private fun getPercentOfRightAnswers() = with(args.outcome) {
        if (countOfQuestions == 0) {
            0
        } else {
            ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
        }
    }

    private fun startAgain(){
        binding.buttonRetry.setOnClickListener {
            retryGame()
        }
    }

//    private fun parseArgs() {
//        outcome = requireArguments().getSerializable(KEY_GAME_RESULT) as Outcome
//    }

    private fun retryGame() {
//        requireActivity().supportFragmentManager.popBackStack(
//            GameFragment.NAME,
//            FragmentManager.POP_BACK_STACK_INCLUSIVE
//        )
        findNavController().popBackStack(R.id.gameFragment,true)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

         const val KEY_GAME_RESULT = "outcome"

        fun newInstance(outcome: Outcome): GameCompletedFragment {
            return GameCompletedFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_GAME_RESULT, outcome)
                }
            }
        }
    }
}
