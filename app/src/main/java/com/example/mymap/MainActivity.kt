package com.example.mymap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import com.example.mymap.models.*
private const val TAG = "MainActivity"
private const val REQUEST_CODE = 1234
const val EXTRA_USER_MAP = "EXTRA_USER_MAP"
const val EXTRA_MAP_TITLE = "EXTRA_MAP_TITLE"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userMaps = generateSampleData()
        val rView = rvMaps

        rView.layoutManager = LinearLayoutManager(this)
        rView.adapter = MapsAdapter(this, userMaps, object: MapsAdapter.OnClickListener{
            override fun onItemClick(position: Int) {
               Log.i(TAG, "onItemClick $position")
                val intent = Intent(this@MainActivity, DisplayMapActivity::class.java)
                intent.putExtra(EXTRA_USER_MAP,userMaps[position])
                startActivity(intent)
            }
        })
       /* fabCreateMap.setOnClickListener{
            Log.i(TAG,"Tap on FAB")
            val intent = Intent(this@MainActivity,CreateMapActivity::class.java)
            intent.putExtra(EXTRA_MAP_TITLE,"new name")
            startActivityForResult(intent, REQUEST_CODE)
        }*/

    }
    private fun generateSampleData(): List<UserMap> {
        return listOf(
            UserMap(
                "Truck Drivers",
                listOf(
                    Place("Padfinderi Koxi", "husher husher husher", 40.195288, 44.503858),
                    Place("Zebri demna", "shenqi tak", 40.194436, 44.503773),
                    Place("AUA-i dem@", "ba ape jan", 40.192831, 44.504214)
                )
            ),


        )
    }
}