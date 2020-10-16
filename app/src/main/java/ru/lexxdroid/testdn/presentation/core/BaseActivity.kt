package ru.lexxdroid.testdn.presentation.core

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import moxy.MvpAppCompatActivity
import ru.lexxdroid.testdn.presentation.extensions.baseMoxyPresenter
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject
import javax.inject.Provider

abstract class BaseActivity<VB : ViewBinding, P : BasePresenter<*, *, *>> : MvpAppCompatActivity(),
    HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var presenterProvider: Provider<P>

    protected val presenter: P by baseMoxyPresenter(::presenterProvider::class.java.name) { presenterProvider.get() }

    private var _binding: VB? = null

    protected val binding: VB
        get() = requireNotNull(_binding)

    override fun androidInjector() = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        _binding = layoutInflater.createBinding()
        setContentView(binding.root)
        restoreState(savedInstanceState)
    }

    @CallSuper
    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    abstract fun LayoutInflater.createBinding(): VB

    abstract fun restoreState(savedInstanceState: Bundle?)

    protected open fun getCurrentFragment(): Fragment? = null

    override fun onBackPressed() {
//        when (val fragment = getCurrentFragment()) {
//            is BackButtonListener -> fragment.onBackPressed()
//            else -> super.onBackPressed()
//        }
    }
}