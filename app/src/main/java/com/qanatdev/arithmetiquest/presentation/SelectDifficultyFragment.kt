package com.qanatdev.arithmetiquest.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.qanatdev.arithmetiquest.R
import com.qanatdev.arithmetiquest.databinding.FragmentSelectDifficultyBinding
import com.qanatdev.arithmetiquest.domain.entities.Level


class SelectDifficultyFragment : Fragment() {

    private var _binding: FragmentSelectDifficultyBinding? = null
    private val binding: FragmentSelectDifficultyBinding
        get() = _binding ?: throw RuntimeException("FragmentSelectDifficultyBinding == null")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectDifficultyBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            buttonLevelTest.setOnClickListener {
                launchGameFragment(Level.TEST)
            }
            buttonLevelEasy.setOnClickListener {
                launchGameFragment(Level.EASY)
            }
            buttonLevelNormal.setOnClickListener {
                launchGameFragment(Level.NORMAL)
            }
            buttonLevelHard.setOnClickListener {
                launchGameFragment(Level.HARD)
            }
        }

    }

    private fun launchGameFragment(level: Level) {
//        val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
//        val navController = navHostFragment.navController
//        val args = Bundle().apply {
//            putSerializable(GameFragment.KEY_LEVEL, level)
//        }
//        navController.navigate(R.id.action_selectDifficultyFragment_to_gameFragment, arguments)


//        findNavController().navigate(
//            R.id.action_selectDifficultyFragment_to_gameFragment,
//            args
//        )
        findNavController().navigate(SelectDifficultyFragmentDirections.actionSelectDifficultyFragmentToGameFragment(level))
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        const val NAME = "SelectDifficultyFragment"
        fun newInstance(): SelectDifficultyFragment{
            return SelectDifficultyFragment()
        }
    }
}
