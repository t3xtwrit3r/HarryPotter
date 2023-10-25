package com.mubin.harrypotter.ui.characterList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.mubin.harrypotter.databinding.FragmentCharacterListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFragment : Fragment() {

    private lateinit var binding: FragmentCharacterListBinding
    private val characterListViewModel: CharacterListViewModel by viewModels()
    private lateinit var characterListAdapter: CharacterListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCharacterListBinding.inflate(layoutInflater, container, false).apply {
            viewModel = characterListViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        setupObserver()
        setOnClick()

    }

    private fun initViews() {
        characterListAdapter = CharacterListAdapter()
        with(binding.characterListRv) {
            isNestedScrollingEnabled = false
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
            adapter = characterListAdapter
        }

        characterListAdapter.characterItemClicked = { characterId ->
            findNavController().navigate(CharacterListFragmentDirections.actionCharacterListFragmentToCharacterDetailsFragment(characterId))
        }
    }

    private fun setupObserver() {
        characterListViewModel.apply {

            getCharacters()

            characterList.observe(viewLifecycleOwner) { dataList ->

                if (!dataList.isNullOrEmpty()) {

                    if (this@CharacterListFragment::characterListAdapter.isInitialized) {
                        characterListAdapter.addAll(dataList)
                    }

                }

            }

        }
    }

    private fun setOnClick() {
        binding.refreshButton.setOnClickListener {
            characterListViewModel.getCharacters()
        }
    }

}