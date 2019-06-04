

package com.vish.observability.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import kotlin.collections.ArrayList

@Entity(tableName = "users")
data class User(@PrimaryKey
                @ColumnInfo(name = "userid")
                val id: String = UUID.randomUUID().toString(),
                @ColumnInfo(name = "username")
                val userName: String,
                @ColumnInfo(name = "friendslist")
                val friendsList: List<String>,
                @ColumnInfo(name = "numbers")
                val numbers: List<Int>)
