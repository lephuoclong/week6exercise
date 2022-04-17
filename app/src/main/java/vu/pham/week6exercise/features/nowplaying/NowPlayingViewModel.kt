package vu.pham.week6exercise.features.nowplaying

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import vu.pham.week6exercise.models.NowPlaying
import vu.pham.week6exercise.utils.Constants

class NowPlayingViewModel:ViewModel() {
    private var _nowplaying :MutableLiveData<ArrayList<NowPlaying>> = MutableLiveData()
    private var _menuOptions: MutableLiveData<Boolean> = MutableLiveData(false)
    var LISTVIEW_OPTION = 1
    var GRIDVIEW_OPTION = 2
    var CURRENT_OPTION = LISTVIEW_OPTION
    val menuOptions:LiveData<Boolean>
        get() = _menuOptions


    fun setValueToCurrentOption(value:Int){
        CURRENT_OPTION = value
    }

    val nowPlaying : LiveData<ArrayList<NowPlaying>>
        get() = _nowplaying

    fun onChangeMenu(value:Boolean){
        _menuOptions.postValue(value)
    }

}