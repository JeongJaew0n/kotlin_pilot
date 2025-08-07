package org.ktor_lecture.repository

import com.github.f4b6a3.ulid.UlidCreator
import org.jetbrains.exposed.sql.insert
import org.ktor_lecture.types.storage.CapsuleFileKeyMapper

class CapsuleFileKeyRepository {

    fun create(
        capsuleId : String,
        filePath : String,
        fileName : String
    ) : String {
        val id = UlidCreator.getUlid().toString()

        CapsuleFileKeyMapper.insert {
            it[CapsuleFileKeyMapper.id] = id
            it[CapsuleFileKeyMapper.capsuleId] = capsuleId
            it[CapsuleFileKeyMapper.filePath] = filePath
            it[CapsuleFileKeyMapper.storage] = "minIO"
            it[CapsuleFileKeyMapper.fileName] = fileName
        }

        return id
    }
}