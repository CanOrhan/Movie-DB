package uk.co.kiwisoft.moviedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uk.co.kiwisoft.moviedb.ui.movie_list.MoviesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MoviesFragment.newInstance())
                .commitNow()
        }
    }

}
