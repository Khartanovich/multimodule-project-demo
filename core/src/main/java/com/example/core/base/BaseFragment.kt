package com.example.core.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.core.app.App
import com.example.core.app.ApplicationProvider
import com.example.core.base.di.ViewModelFactory
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel,
        VB : ViewBinding
        >(
    private val inflate: (
        LayoutInflater,
        ViewGroup?,
        Boolean
    ) -> VB
) : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected abstract val viewModel: VM

    private var _binding: VB? = null
    val binding get() = requireNotNull(_binding) { "Binding not initialized" }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        inject((requireActivity().application as App).getApplicationProvider())
        _binding = inflate.invoke(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //Предназначен для инициализации dagger component
    protected abstract fun inject(applicationProvider: ApplicationProvider)
}