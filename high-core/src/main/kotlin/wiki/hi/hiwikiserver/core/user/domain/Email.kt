package wiki.hi.hiwikiserver.core.user.domain

class Email(
    email: String
) {
    companion object {
        fun of(email: String): Email{
            if (email.endsWith("hs.kr"))
                return Email(email)

            else
                throw IllegalArgumentException("email의 형식이 올바르지 않습니다.")
        }
    }
}
