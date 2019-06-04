

package com.vish.observability.ui

import androidx.lifecycle.ViewModel
import com.vish.observability.persistence.User
import com.vish.observability.persistence.UserDao
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * View Model for the [UserActivity]
 */
class UserViewModel(private val dataSource: UserDao) : ViewModel() {

    /**
     * Get the user name of the user.

     * @return a [Flowable] that will emit every time the user name has been updated.
     */
    // for every emission of the user, get the user name
    fun userName(): Flowable<String> {
        return dataSource.getUserById(USER_ID)
                .map { user -> user.userName }
    }

    // for every emission of the user, get the user name
    fun userFriends(): Flowable<List<String>> {
        return dataSource.getUserById(USER_ID)
                .map { user -> user.friendsList }
    }

    // for every emission of the user, get the user name
    fun numbers(): Flowable<List<Int>> {
        return dataSource.getUserById(USER_ID)
                .map { user -> user.numbers }
    }

    /**
     * Update the user name.
     * @param userName the new user name
     * *
     * @return a [Completable] that completes when the user name is updated
     */
    fun updateUserName(userName: String,friends:List<String>,numbers:List<Int>): Completable {
        val user = User(USER_ID, userName, friends, numbers)
        return dataSource.insertUser(user)
    }

    companion object {
        // using a hardcoded value for simplicity
        const val USER_ID = "1"
    }
}
