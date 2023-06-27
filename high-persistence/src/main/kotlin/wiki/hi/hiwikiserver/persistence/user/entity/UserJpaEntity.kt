package wiki.hi.hiwikiserver.persistence.user.entity

import wiki.hi.hiwikiserver.core.user.domain.Authority
import wiki.hi.hiwikiserver.core.user.domain.Email
import javax.persistence.*

@Entity
@Table(name = "USER")
class UserJpaEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long?,
    @Embedded
    val email: Email,
    val nickName: String,
    val authority: Authority,
    val schoolId: Long
)