package ru.lexxdroid.testdn.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import ru.lexxdroid.testdn.R
import ru.lexxdroid.testdn.databinding.ActivityMainBinding
import ru.lexxdroid.testdn.domain.main.MainState
import ru.lexxdroid.testdn.presentation.core.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainPresenter>(), MainView {

    companion object MainContainerIdProvider : ContainerIdProvider {
        override val containerId = R.id.fragment_container
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.isFreshStart = savedInstanceState == null
    }

    override fun LayoutInflater.createBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(this)

    override fun restoreState(savedInstanceState: Bundle?) {
        presenter.restoreState(MainState)
    }
}