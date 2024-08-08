package com.example.feature.presentation

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.core.app.ApplicationProvider
import com.example.core.base.BaseFragment
import com.example.core.utils.CompositeAdapter
import com.example.core.view.itemfilmcard.ItemFilmCardDelegateAdapter
import com.example.core.view.itemfilmcard.ItemFilmUiModel
import com.example.feature.databinding.FragmentMainScreenBinding
import com.example.feature.di.MainScreenComponent
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

internal class MainScreenFragment : BaseFragment<MainScreenViewModel, FragmentMainScreenBinding>(
    FragmentMainScreenBinding::inflate
) {

    companion object {
        fun newInstance() = MainScreenFragment()
    }

    override val viewModel: MainScreenViewModel by viewModels { viewModelFactory }

    private val premiersFilmAdapter by lazy {
        CompositeAdapter.Builder()
            .add(ItemFilmCardDelegateAdapter(::onFilmClick))
            .build()
    }

    override fun inject(applicationProvider: ApplicationProvider) {
        MainScreenComponent.init(applicationProvider).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvFFilmPremiers.adapter = premiersFilmAdapter
        updateState()
    }

    private fun updateState() {

        viewModel.state.onEach { state ->
            when (state) {
                is MainScreenState.Error -> {
                    Toast.makeText(requireActivity(), state.message, Toast.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.INVISIBLE
                }

                MainScreenState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is MainScreenState.Success -> {
                    premiersFilmAdapter.submitList(state.listFilm)
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun onFilmClick(film: ItemFilmUiModel) {
        viewModel.onFilmClick(film.kinopoiskId)
    }
}