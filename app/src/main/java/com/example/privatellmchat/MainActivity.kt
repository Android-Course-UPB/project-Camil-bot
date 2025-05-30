package com.example.privatellmchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.privatellmchat.ui.theme.PrivateLLMChatTheme
import com.example.privatellmchat.ui.screens.chat.ChatScreen
import com.example.privatellmchat.ui.screens.profile.ProfileScreen
import com.example.privatellmchat.ui.screens.login.LoginScreen
import com.example.privatellmchat.ui.theme.ThemeViewModel
import com.example.privatellmchat.ui.viewModel.SharedViewModel

class MainActivity : ComponentActivity() {
    private val themeViewModel: ThemeViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkMode by themeViewModel.isDarkMode.collectAsState()
            
            PrivateLLMChatTheme(darkTheme = isDarkMode) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable("login") {
                            LoginScreen(navController, sharedViewModel)
                        }
                        composable("chat") {
                            ChatScreen(navController, sharedViewModel)
                        }
                        composable("profile") {
                            ProfileScreen(navController, themeViewModel, sharedViewModel)
                        }
                    }
                }
            }
        }
    }
} 