package vu.pham.week6exercise.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import vu.pham.week6exercise.R
import vu.pham.week6exercise.models.Movie

class MovieAdapter(private val layout:Int) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imageView:ImageView
        var txtName:TextView
        var txtDescription:TextView
        init {
            imageView = itemView.findViewById(R.id.imageViewMovieItem)
            txtName = itemView.findViewById(R.id.textViewNameMovieItem)
            txtDescription = itemView.findViewById(R.id.textViewDescriptionMovie)
        }
    }

    val differCallBack = object : DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    fun submitList(list:List<Movie>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false))
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = differ.currentList[position]
        Glide.with(holder.itemView.context).load("").into(holder.imageView) // bỏ url vào nha
        holder.txtName.text = "" // bỏ name vào nha
        holder.txtDescription.text = ""//tương tự
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}