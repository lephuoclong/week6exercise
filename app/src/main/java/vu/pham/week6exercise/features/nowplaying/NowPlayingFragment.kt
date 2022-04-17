package vu.pham.week6exercise.features.nowplaying

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import vu.pham.week6exercise.R
import vu.pham.week6exercise.models.NowPlaying
import java.util.Observer


class NowPlayingFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.show()
    }
    private lateinit var viewModel: NowPlayingViewModel

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menuoption, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_LIST -> if(viewModel.CURRENT_OPTION!= viewModel.LISTVIEW_OPTION) {
                viewModel.onChangeMenu(false)
                viewModel.setValueToCurrentOption(viewModel.LISTVIEW_OPTION)
            }
            R.id.menu_GRID -> if(viewModel.CURRENT_OPTION!=viewModel.GRIDVIEW_OPTION){
                viewModel.onChangeMenu(true)
                viewModel.setValueToCurrentOption(viewModel.GRIDVIEW_OPTION)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

