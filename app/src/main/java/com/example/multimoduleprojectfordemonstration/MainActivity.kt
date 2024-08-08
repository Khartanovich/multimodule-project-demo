package com.example.multimoduleprojectfordemonstration

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.core.base.di.ViewModelFactory
import com.example.core.navigation.routing.ApplicationNavigator
import com.example.multimoduleprojectfordemonstration.databinding.ActivityMainBinding
import com.example.multimoduleprojectfordemonstration.di.MainActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MainActivityViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)

        MainActivityComponent.init((newBase.applicationContext as SampleApp).getApplicationProvider())
            .inject(this)

    }

    override fun onResumeFragments() {
        super.onResumeFragments()

        viewModel.setNavigator(ApplicationNavigator(this, binding.containerId.id))
    }

    override fun onPause() {
        super.onPause()

        viewModel.removeNavigator()
    }
}