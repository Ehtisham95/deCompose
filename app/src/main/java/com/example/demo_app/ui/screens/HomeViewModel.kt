package com.example.demo_app.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo_app.model.Post
import com.example.demo_app.repository.PostRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: PostRepo
) : ViewModel() {

    data class HomeState(
        val postsList: List<Post> = emptyList(),
        val generalError: String? = null
    )

    var state = mutableStateOf(HomeState())
        private set

    init {
        viewModelScope.launch {
            getEmployees()
        }
    }

    private suspend fun getEmployees() {
        repo.getAllPosts()
            .onSuccess {
                state.value = state.value.copy(postsList = it.posts, generalError = null)
            }
            .onFailure {
                state.value = state.value.copy(generalError = "Something went wrong!")
            }
    }

}