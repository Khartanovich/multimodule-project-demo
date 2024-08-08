package com.example.film_screen.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.core.app.ApplicationProvider
import com.example.core.base.BaseFragment
import com.example.core.extensions.loadImageFromUrl
import com.example.film_screen.databinding.FragmentFilmScreenBinding
import com.example.film_screen.di.FilmScreenComponent
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

private const val KEY_FILM_ID = "KEY"

internal class FilmScreenFragment : BaseFragment<FilmScreenViewModel, FragmentFilmScreenBinding>(
    FragmentFilmScreenBinding::inflate
) {

    companion object {

        fun newInstance(filmId: Int) =
            FilmScreenFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_FILM_ID, filmId)
                }
            }
    }

    override val viewModel: FilmScreenViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.onEach { state ->
            updateState(state)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun updateState(state: FilmScreenState) {

        with(binding) {
            when (state) {
                is FilmScreenState.Error -> {
                    Toast.makeText(requireActivity(), state.message, Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.INVISIBLE
                }

                FilmScreenState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }

                is FilmScreenState.Success -> {
                    state.filmInfo.posterUrl?.let {
                        imgPoster.loadImageFromUrl(it)
                    }
                    tvDescription.text = state.filmInfo.description
                    progressBar.visibility = View.INVISIBLE
                }

            }
        }
    }

    override fun inject(applicationProvider: ApplicationProvider) {
        FilmScreenComponent.init(
            applicationProvider,
            filmId = arguments?.getInt(KEY_FILM_ID) ?: error("No film Id")
        ).inject(this)
    }
}