package ru.lexxdroid.testdn.presentation.navigation

import ru.lexxdroid.testdn.presentation.main.ContainerIdProvider
import ru.lexxdroid.testdn.presentation.main.MainActivity
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class NavigatorImpl
@Inject constructor(
    activity: MainActivity,
    containerIdProvider: ContainerIdProvider
) : SupportAppNavigator(activity, activity.supportFragmentManager, containerIdProvider.containerId)
