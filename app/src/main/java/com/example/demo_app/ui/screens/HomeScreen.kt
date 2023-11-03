package com.example.demo_app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.demo_app.model.EmployeeData

@Composable
fun HomeScreen() {
    val homeViewModel: HomeViewModel = hiltViewModel()

    Content(
        homeViewModel.state.value
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Content(
    state: HomeViewModel.HomeState
) {
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state.generalError) {
        if (state.generalError != null) {
            snackbarHostState.showSnackbar(message = state.generalError)
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            items(state.list) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = it.employee_name
                )
                Spacer(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxWidth()
                        .background(Color.Black)
                        .height(1.dp)
                )
            }
        }
    }

}


@Preview
@Composable
private fun PreviewContent() {
    Content(HomeViewModel.HomeState(
        list = listOf(EmployeeData("12","Hello","12","1","sdf"))
    ))
}