package vu.pham.week6exercise.features.toprated

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vu.pham.week6exercise.models.TopRated
import vu.pham.week6exercise.utils.Constants

class TopRatedViewModel:ViewModel() {

        private var _toprated : MutableLiveData<ArrayList<TopRated>> = MutableLiveData()
        private var _menuOptions1: MutableLiveData<Boolean> = MutableLiveData(false)
        var LISTVIEW_OPTION1 = 1
        var GRIDVIEW_OPTION1 = 2
        var CURRENT_OPTION1 = LISTVIEW_OPTION1
        val menuOptions1: LiveData<Boolean>
            get() = _menuOptions1


        fun setValueToCurrentOption(value:Int){
            CURRENT_OPTION1 = value
        }

        val topRated : LiveData<ArrayList<TopRated>>
            get() = _toprated

        fun onChangeMenu(value:Boolean){
            _menuOptions1.postValue(value)
        }

    }