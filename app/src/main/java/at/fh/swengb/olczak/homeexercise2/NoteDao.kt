package at.fh.swengb.olczak.homeexercise2

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query



@Dao
interface NoteDao {


    @Insert
    fun insert(notes: Notes)


    @Query("SELECT * FROM notes")
    fun select():List<Notes>
}


