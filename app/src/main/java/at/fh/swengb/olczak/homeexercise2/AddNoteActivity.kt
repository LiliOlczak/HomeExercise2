package at.fh.swengb.olczak.homeexercise2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_note.*




class AddNoteActivity : AppCompatActivity() {

    lateinit var db: RoomDatabaseNote

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        db = RoomDatabaseNote.getDatabase(this)
    }

    fun addNote(view: View)
    {
        val title = editText.text.toString()
        val content = editContent.text.toString()
        val notes = Notes(title, content)
        db.noteDao.insert(notes)
        finish()
    }
}