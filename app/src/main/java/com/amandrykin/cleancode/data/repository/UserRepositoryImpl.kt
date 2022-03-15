package com.amandrykin.cleancode.data.repository


import com.amandrykin.cleancode.data.storage.models.User
import com.amandrykin.cleancode.data.storage.UserStorage
import com.amandrykin.cleancode.domain.models.SaveUserNameParam
import com.amandrykin.cleancode.domain.models.UserName
import com.amandrykin.cleancode.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.firstName)
    }
}