package com.qanatdev.arithmetiquest.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.qanatdev.arithmetiquest.R
import com.qanatdev.arithmetiquest.databinding.ActivityWelcomeBinding
import com.qanatdev.arithmetiquest.databinding.FragmentGameCompletedBinding


class GameCompletedFragment : Fragment() {

    private var _binding: FragmentGameCompletedBinding? = null
    private val binding: FragmentGameCompletedBinding
        get() = _binding ?: throw RuntimeException("FragmentGameCompletedBinding == null")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameCompletedBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
