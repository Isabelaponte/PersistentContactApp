package br.edu.ifsp.scl.sc3035018.persistentcontactapp.navigation

sealed class Screen(val route: String) {
    data object List: Screen("list_screen")
    data object Contact: Screen("contact_screen")
}