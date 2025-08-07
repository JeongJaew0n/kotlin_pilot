package org.ktor_lecture.repository

import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update
import org.ktor_lecture.types.storage.UsersTokenMapper

class UserTokenMapperRepository {

    suspend fun createPasetoToken(userId : String, token : String) {
        val existingToken = UsersTokenMapper.select { UsersTokenMapper.id eq userId }.singleOrNull()

        if (existingToken == null) {
            UsersTokenMapper.insert {
                it[id] = userId
                it[UsersTokenMapper.token] = token
            }
        } else {
            UsersTokenMapper.update({ UsersTokenMapper.id eq userId }) {
                it[UsersTokenMapper.token] = token
            }
        }
    }

}