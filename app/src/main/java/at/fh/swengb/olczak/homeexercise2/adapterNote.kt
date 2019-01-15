package at.fh.swengb.olczak.homeexercise2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_item_note.view.*






class AdapterNote(): RecyclerView.Adapter<NoteViewHolder>()
{
    var noteList = listOf<Notes>()

    fun updateList(newList: List<Notes>)
    {
        noteList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): NoteViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)
        val noteItemView = inflater.inflate(R.layout.activity_item_note, parent, false)
        return NoteViewHolder(noteItemView)
    }

    override fun getItemCount(): Int
    {
        return noteList.size
    }

    override fun onBindViewHolder(viewHolder: NoteViewHolder, position: Int)
    {
        val notes = noteList[position]
        viewHolder.bindItem(notes)
    }
}

class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
{
    fun bindItem(notes: Notes) {
        itemView.title.text = notes.title
        itemView.content.text = notes.content
    }

}