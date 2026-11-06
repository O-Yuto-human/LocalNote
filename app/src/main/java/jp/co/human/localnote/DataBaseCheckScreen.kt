package jp.co.human.localnote

import androidx.room3.Entity
import androidx.room3.PrimaryKey
import androidx.room3.*

@Entity(tableName = "users")
data class User(
    @PrimaryKey val loginId: String,
    val password: String,
    val name: String
)

@Dao
interface UserDao{
    @Query("SELECT COUNT(*) FROM users")
    suspend fun count(): Int
}

@Database(entities = [User::class], version = 1,
    exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao // abstract 中身を書かない
}