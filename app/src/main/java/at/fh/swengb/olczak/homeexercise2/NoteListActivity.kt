package at.fh.swengb.olczak.homeexercise2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_list_note.*






class NoteListActivity : AppCompatActivity() {

    private var notes = mutableListOf<Notes>()
    private val noteAdapter = AdapterNote()

    lateinit var pref: SharedPreferences
    lateinit var db: RoomDatabaseNote

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_note)
        pref = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        val username = pref.getString("Name","Name")
        val userage = pref.getInt("Age",0)

        recycler.adapter = noteAdapter
        recycler.layoutManager = LinearLayoutManager(this)

        userText.text = "Notes for $username,$userage"

        db = RoomDatabaseNote.getDatabase(this)
    }

    fun openAddNoteActivity(view : View)
    {
        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)
    }

    override fun onResume()
    {
        super.onResume()
        notes = db.noteDao.select().toMutableList()
        noteAdapter.updateList(notes)
    }
}

