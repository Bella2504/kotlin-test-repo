package test

import js.demo.user.catalogue.adapter.persistence.UserRepository
import java.util.UUID.randomUUID

@SpringBootTest(
    classes = [UserService::class])
class UserServiceTest {

    @Test
    @RunWith(MockitoJUnitRunner::class)
    fun createUser(){
        /* Given */
        val newUUID = randomUUID();
        /**val mock = mock<UserRepository> {
            on { createUser() } doReturn newUUID
        }
        val classUnderTest = ClassUnderTest(mock)

        /* When */
        classUnderTest.createUser()

        /* Then */
        verify(mock).createUser()
        verify()*/
    }
}