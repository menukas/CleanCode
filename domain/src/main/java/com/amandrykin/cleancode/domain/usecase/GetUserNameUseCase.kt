package com.amandrykin.cleancode.domain.usecase

import com.amandrykin.cleancode.domain.models.UserName
import com.amandrykin.cleancode.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}