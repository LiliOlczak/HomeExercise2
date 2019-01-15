package at.fh.swengb.olczak.homeexercise2

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


@Database(entities = [Notes::class], version = 1)
abstract class RoomDatabaseNote : RoomDatabase() {

    abstract val noteDao: NoteDao
    companion object {
        fun getDatabase(context: Context): RoomDatabaseNote
        {
            return Room.databaseBuilder(context, RoomDatabaseNote::class.java, "notes-db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}