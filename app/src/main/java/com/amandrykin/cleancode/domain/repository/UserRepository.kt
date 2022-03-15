package com.amandrykin.cleancode.domain.repository

import com.amandrykin.cleancode.domain.models.SaveUserNameParam
import com.amandrykin.cleancode.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}