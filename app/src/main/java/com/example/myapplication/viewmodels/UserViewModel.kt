package com.example.myapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.repository.UserRepository
import com.example.myapplication.domain.User

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    // LiveData holds state which is observed by the View
    private val userLiveData: LiveData<User> = MutableLiveData()

    fun loadUser(userId: Int) {
        // Assuming UserRepository returns LiveData
        val user = userRepository.getUser(userId)
    }
}