package at.fh.swengb.olczak.homeexercise2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {

    lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pref = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        editName.setText(pref.getString("Name", "Name"))
        editAge.setText(pref.getInt("Age", 0).toString())
    }

    fun saveInput(view: View)
    {
        val ageString =  editAge.text.toString()
        var age : Int = 0
        val name = editName.text.toString()

        if(ageString!="")
        {
            age = ageString.toInt()
        }

        if(name!="" && age > 0 )
        {
            pref.edit().putInt("Age",age).apply()
            pref.edit().putString("Name", name).apply()
            val intent = Intent(this, NoteListActivity::class.java)
            startActivity(intent)
        }
    }
}