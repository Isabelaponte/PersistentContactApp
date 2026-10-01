package br.edu.ifsp.scl.sc3035018.persistentcontactapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.edu.ifsp.scl.sc3035018.persistentcontactapp.navigation.MainNavHost
import br.edu.ifsp.scl.sc3035018.persistentcontactapp.navigation.Screen
import br.edu.ifsp.scl.sc3035018.persistentcontactapp.ui.composable.component.MainTopAppBar
import br.edu.ifsp.scl.sc3035018.persistentcontactapp.ui.theme.PersistentContactAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()
            val contactViewModel: ContactViewModel = viewModel()
            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
            val showActions = navBackStackEntry?.destination?.route == Screen.List.route

            PersistentContactAppTheme {
                Scaffold(
                    topBar = {
                        MainTopAppBar(showActions = showActions) {
                            navHostController.navigate(Screen.Contact.route)
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    MainNavHost(
                        navHostController = navHostController,
                        contactViewModel = contactViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}