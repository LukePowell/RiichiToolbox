/*
 * Riichi Toolbox
 * Copyright (C) 2021 Dragon Well Studios
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.dragonwellstudios.riichitoolbox.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dragonwellstudios.riichitoolbox.android.ui.views.RecordGameView
import com.dragonwellstudios.riichitoolbox.android.ui.views.ScoreCalculatorView


sealed class Screen(val route: String, @StringRes val labelId: Int, @DrawableRes val iconId: Int) {
    object ScoreCalc :
        Screen("score_calc", R.string.score_calc, R.drawable.ic_baseline_calculate_24)

    object FindHand : Screen("find_hand", R.string.find_hand, R.drawable.cards_outline)
    object RecordGame :
        Screen("record_game", R.string.record_game, R.drawable.ic_baseline_videogame_asset_24)
}

class MainActivityCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            val items = listOf(
                Screen.ScoreCalc,
                Screen.FindHand,
                Screen.RecordGame
            )

            Scaffold(
                bottomBar = {
                    BottomNavigation {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination
                        items.forEach { screen ->
                            BottomNavigationItem(
                                icon = {
                                    Icon(
                                        painterResource(id = screen.iconId),
                                        contentDescription = null
                                    )
                                },
                                label = { Text(stringResource(screen.labelId)) },
                                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                onClick = {
                                    navController.navigate(screen.route) {
                                        // Pop up to the start destination of the graph to
                                        // avoid building up a large stack of destinations
                                        // on the back stack as users select items
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        // Avoid multiple copies of the same destination when
                                        // reselecting the same item
                                        launchSingleTop = true
                                        // Restore state when reselecting a previously selected item
                                        restoreState = true
                                    }
                                }
                            )
                        }
                    }
                }
            ) { innerPadding ->
                NavHost(
                    navController,
                    startDestination = Screen.ScoreCalc.route,
                    Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    composable(Screen.ScoreCalc.route) { ScoreCalculatorView() }
                    composable(Screen.FindHand.route) { Text("404: Cannot Find Hands") }
                    composable(Screen.RecordGame.route) { RecordGameView() }
                }
            }
        }
    }
}
