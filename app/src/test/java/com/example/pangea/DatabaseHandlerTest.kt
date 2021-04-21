package com.example.pangea

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import junit.framework.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DatabaseHandlerTest {

    @Test
    fun registerNewUserTest() {
        val email = "test.user@test.com"
        val pw = "1234abc"
        val register = com.example.pangea.DatabaseHandler()
        val context = ApplicationProvider.getApplicationContext<Context>()
        val errorCode = register.registerUser(email, pw, context)
        Assert.assertEquals(0, errorCode)
    }

    @Test
    fun registerNewUserTest2() {
        val email = "test.user@test.com"
        val pw = "1234abc"
        val register = com.example.pangea.DatabaseHandler()
        val context = ApplicationProvider.getApplicationContext<Context>()
        register.registerUser(email, pw, context)
        val user = register.getRegisteredUser(email, context)
        Assert.assertEquals(email, user.email)
        Assert.assertEquals(pw, user.password)
    }
}