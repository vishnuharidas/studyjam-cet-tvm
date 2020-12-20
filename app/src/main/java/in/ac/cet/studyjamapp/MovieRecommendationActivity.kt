package `in`.ac.cet.studyjamapp

import `in`.ac.cet.studyjamapp.data.Movie
import `in`.ac.cet.studyjamapp.data.movies
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MovieRecommendationActivity : AppCompatActivity() {

    lateinit var txtTitle: TextView
    lateinit var txtYear: TextView
    lateinit var txtRuntime: TextView
    lateinit var txtRating: TextView
    lateinit var txtSummary: TextView
    lateinit var txtDirector: TextView
    lateinit var txtCast: TextView

    lateinit var btnRecc: Button

    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_reccomendation)

        txtTitle = findViewById(R.id.txtTitle)
        txtYear = findViewById(R.id.txtYear)
        txtRuntime = findViewById(R.id.txtRuntime)
        txtRating = findViewById(R.id.txtRating)
        txtSummary = findViewById(R.id.txtSummary)
        txtDirector = findViewById(R.id.txtDirector)
        txtCast = findViewById(R.id.txtCast)

        btnRecc = findViewById(R.id.btnRecommend)
        imageView = findViewById(R.id.imgPoster)

        btnRecc.setOnClickListener {
            showMovieDetails( movies.random() )
        }

        showMovieDetails( movies.random() )
    }

    private fun showMovieDetails(movie: Movie){
        txtTitle.text = movie.title
        txtYear.text = movie.year
        txtRuntime.text = movie.runtime
        txtRating.text = movie.imdbRating
        txtSummary.text = movie.plot
        txtDirector.text = movie.director
        txtCast.text = movie.cast

        Glide.with(this)
            .load(movie.posterUrl)
            .into(imageView);
    }
}