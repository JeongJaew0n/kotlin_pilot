package org.ktor_lecture.common.di

import io.ktor.server.application.ApplicationEnvironment
import org.koin.dsl.module
import org.ktor_lecture.common.factory.EmailServiceFactory
import org.ktor_lecture.config.EmailConfig
import org.ktor_lecture.config.EmailServiceImpl
import org.ktor_lecture.repository.CapsuleContentRepository
import org.ktor_lecture.repository.CapsuleFileKeyRepository
import org.ktor_lecture.repository.CapsuleRepository
import org.ktor_lecture.repository.RecipientsRepository
import org.ktor_lecture.repository.TimeEncryptionMapperRepository
import org.ktor_lecture.repository.UserRepository
import org.ktor_lecture.repository.UserTokenMapperRepository
import org.ktor_lecture.router.auth.service.AuthService
import org.ktor_lecture.router.capsule.service.CapsuleService

val additionModule = module {
    single {
        val env : ApplicationEnvironment = get()
        EmailConfig.fromApplicationConfig(env.config)
    }

    single{ EmailServiceFactory() }

    single<EmailServiceImpl> {
        val factory : EmailServiceFactory = get()
        val config : EmailConfig = get()
        factory.create(config)
    }

}

var repositoryModule = module {
    single { UserRepository() }
    single { UserTokenMapperRepository() }
    single { TimeEncryptionMapperRepository() }
    single { CapsuleContentRepository() }
    single { CapsuleFileKeyRepository() }
    single { CapsuleRepository() }
    single { RecipientsRepository() }
}

var serviceModule = module {
    single {
        AuthService(
            get(),
            get()
        )
    }

    single {
        CapsuleService(
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
}

val appModule = module {
    includes(additionModule)
    includes(repositoryModule)
    includes(serviceModule)
}