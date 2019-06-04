

package com.vish.observability

import android.content.Context
import com.vish.observability.persistence.UserDao

import com.vish.observability.persistence.UsersDatabase
import com.vish.observability.ui.ViewModelFactory

/**
 * Enables injection of data sources.
 */
object Injection {

    fun provideUserDataSource(context: Context): UserDao {
        val database = UsersDatabase.getInstance(context)
        return database.userDao()
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val dataSource = provideUserDataSource(context)
        return ViewModelFactory(dataSource)
    }
}
