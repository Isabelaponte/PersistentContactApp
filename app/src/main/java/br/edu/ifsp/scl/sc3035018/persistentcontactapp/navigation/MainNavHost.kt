package br.edu.ifsp.scl.sc3035018.persistentcontactapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.edu.ifsp.scl.sc3035018.persistentcontactapp.ContactViewModel


@Composable
fun MainNavHost(
    navHostController: NavHostController,
    contactViewModel: ContactViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.List.route,
        modifier = modifier
    ) {
        composable(route = Screen.List.route) {
            ListRoute(contactViewModel)
        }
        composable(route = Screen.Contact.route) {
            ContactRoute(contactViewModel) { navHostController.popBackStack() }
        }
    }
}