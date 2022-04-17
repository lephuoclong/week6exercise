package vu.pham.week6exercise.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import org.json.JSONArray
import vu.pham.week6exercise.models.NowPlaying
import java.io.InputStream
import kotlin.coroutines.coroutineContext

object Datastore {
        val _nowplaying: ArrayList<NowPlaying> = ArrayList()
        lateinit var sharedPreferences: SharedPreferences

        fun initSharedPref(context: Context) {
            sharedPreferences = context.getSharedPreferences(Constants.API_KEY_NAME, Context.MODE_PRIVATE)
        }

        fun writeDataIsFirstTimeToggle(){
            sharedPreferences.edit().putBoolean(Constants.API_KEY_VALUE, false).apply()
        }

        fun getFirstTimeToggle():Boolean{
            return sharedPreferences.getBoolean(Constants.API_KEY_VALUE, true)
        }




        fun removeUserDataFromSharedPref(){
            sharedPreferences.edit()
                .remove(Constants.BASE_URL)
                .apply()
        }
    }