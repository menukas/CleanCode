package com.amandrykin.cleancode.domain.usecase

import com.amandrykin.cleancode.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam) : Boolean {
        if (param.name.isEmpty()) {
            return false
        } else {
            return true
        }
    }
}