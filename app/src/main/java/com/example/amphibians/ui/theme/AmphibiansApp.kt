package com.example.amphibians.ui.theme



import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.example.amphibians.ui.theme.Screens.AmphibiansViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.ui.theme.Screens.HomeScreen

@Composable
@ExperimentalMaterial3Api
fun AmphibiansApp(  modifier: Modifier = Modifier) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection), // Added comma here
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                name = "Amphibians", // Passing the variable name correctly
                modifier = modifier
            )
        }
    ) { innerPadding ->
        // Content goes here
        val amphibiansViewModel:AmphibiansViewModel= viewModel(factory= AmphibiansViewModel.Factory)
         Surface(
                modifier=modifier.padding(innerPadding).fillMaxSize()
         ) {
                HomeScreen(
                    AmphibianUiState=amphibiansViewModel.amphibianUiState,
                    retryAction = amphibiansViewModel::getAmphibiansPhotos,
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = innerPadding
                )
         }
    }
}

@Composable
@ExperimentalMaterial3Api
fun TopAppBar(scrollBehavior: TopAppBarScrollBehavior, name: String, modifier: Modifier = Modifier) {

    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
        }, modifier = modifier
    )

}
