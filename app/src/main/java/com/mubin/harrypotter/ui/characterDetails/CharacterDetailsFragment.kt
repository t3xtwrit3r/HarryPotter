package com.mubin.harrypotter.ui.characterDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.mubin.harrypotter.databinding.FragmentCharacterDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDetailsBinding
    private val characterDetailsViewModel: CharacterDetailsViewModel by viewModels()
    private val navArgs: CharacterDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCharacterDetailsBinding.inflate(layoutInflater, container, false).apply {
            viewModel = characterDetailsViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData(navArgs.characterId)
        setOnClick()

    }

    private fun getData(characterId: String?) {
        characterDetailsViewModel.getCharacterDetails(characterId ?: "")
    }

    private fun setOnClick() {
        binding.refreshButton.setOnClickListener {
            getData(navArgs.characterId)
        }
    }
}