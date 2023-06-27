package wiki.hi.hiwikiserver.persistence.user.mapper

import wiki.hi.hiwikiserver.core.user.domain.User
import wiki.hi.hiwikiserver.persistence.GenericMapper
import wiki.hi.hiwikiserver.persistence.user.entity.UserJpaEntity

class UserMapper : GenericMapper<User, UserJpaEntity> {
    override fun toDomain(entity: UserJpaEntity): User {
        TODO("ThumbsUpsId과 contributeId 때문에 추후에 개발")
    }

    override fun toEntity(domain: User): UserJpaEntity {

        return UserJpaEntity(
            id = domain.id,
            email = domain.email,
            nickName = domain.nickName,
            authority = domain.authority,
            schoolId = domain.schoolId
        )
    }

}