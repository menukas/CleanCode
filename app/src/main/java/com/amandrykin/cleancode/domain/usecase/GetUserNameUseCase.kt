package com.amandrykin.cleancode.domain.usecase

import com.amandrykin.cleancode.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firstName = "Alexey", lastName = "Mandrykin")
    }
}