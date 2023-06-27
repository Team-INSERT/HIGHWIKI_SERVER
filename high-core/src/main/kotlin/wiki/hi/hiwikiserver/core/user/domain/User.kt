package wiki.hi.hiwikiserver.core.user.domain

data class User (
    val id: Long,
    val email: Email,
    val nickName: String,
    val authority: Authority,
    val schoolId: Long,
    val contributeId: ArrayList<Long>,
    val thumbsUpId: ArrayList<Long>
)