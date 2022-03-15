package com.amandrykin.cleancode.data.storage

import com.amandrykin.cleancode.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}