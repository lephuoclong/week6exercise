package vu.pham.week6exercise.features.toprated

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import vu.pham.week6exercise.R
import vu.pham.week6exercise.models.TopRated
import java.util.Observer

class TopRatedFragment:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.show()
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menuoption, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private lateinit var viewModel: TopRatedViewModel
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_LIST -> if(viewModel.CURRENT_OPTION1!= viewModel.LISTVIEW_OPTION1) {
                viewModel.onChangeMenu(false)
                viewModel.setValueToCurrentOption(viewModel.LISTVIEW_OPTION1)
            }
            R.id.menu_GRID -> if(viewModel.CURRENT_OPTION1!=viewModel.GRIDVIEW_OPTION1){
                viewModel.onChangeMenu(true)
                viewModel.setValueToCurrentOption(viewModel.GRIDVIEW_OPTION1)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}