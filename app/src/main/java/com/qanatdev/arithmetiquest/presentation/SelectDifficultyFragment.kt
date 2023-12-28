package com.qanatdev.arithmetiquest.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.qanatdev.arithmetiquest.R
import com.qanatdev.arithmetiquest.databinding.FragmentGameBinding
import com.qanatdev.arithmetiquest.databinding.FragmentSelectDifficultyBinding


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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
