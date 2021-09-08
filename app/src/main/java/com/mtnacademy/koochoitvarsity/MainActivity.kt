package com.mtnacademy.koochoitvarsity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.open
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.material.navigation.NavigationView
import com.mtnacademy.koochoitvarsity.UserDetailsActivity
import com.mtnacademy.koochoitvarsity.adapter.UserAdapter
import com.mtnacademy.koochoitvarsity.core.model.User
import java.nio.channels.AsynchronousFileChannel.open

class MainActivity : AppCompatActivity() {

    private var mInterstitialAd: InterstitialAd? = null
    private final var TAG = "MainActivity"

    lateinit var adView : AdView

    lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Banner Ad
        //Banner Ad
        MobileAds.initialize(this) {}
        adView = findViewById(R.id.adView)
        val adBuilder = AdRequest.Builder().build()
        adView.loadAd(adBuilder)

        //Interstitial Ad


        val _recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        _recyclerView.layoutManager = LinearLayoutManager(this)

        val users = ArrayList<User>()

        users.add(
            User(
                "MacBook Pro",
                "R 41 000",
                "https://www.zdnet.com/a/hub/i/r/2017/06/15/01748d48-6a7b-40c6-ace6-26c13e96f4b2/resize/1200x900/fa2a4bc3fa73b5ff365dcc54a1ae7f48/macbook-13-2017-header.jpg"
            )
        )
        users.add(
            User(
                "Iphone 12",
                "R 18 0000",
                "https://media.wired.com/photos/5fa5c781f27ae435cc7226fa/master/w_1970,h_1476,c_limit/Gear-Mini-apple_iphone12mini-iphone12max-homepodmini-availability_products-available_110520.jpg"
            )
        )
        users.add(
            User(
                "HP Laptop 15s",
                "R 11400",
                "https://technave.com/data/files/article/202107140750323448.jpg"
            )
        )
        users.add(
            User(
                "Huawei P40 Lite",
                "R 15000",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRS-oYOw_qn-zZCUG9XjhIfjKpQEoFHFLwTB95JGQu5kd3Zf99w0ClH1GeI693wj3Htgk&usqp=CAU"
            )
        )
        users.add(
            User(
                "Lenovo IdeaPad Slim 1",
                "R 11999",
                "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6406/6406896cv12d.jpg"
            )
        )
        users.add(
            User(
                "Iphone 8",
                "R 4000",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxPFYIUHVuPsP_3mYkK6vt_ChyCZ1cbEPDQVcH87i1CO_C37DCwr8xq6qP8W2fpvO18K0&usqp=CAU"
            )
        )
        users.add(
            User(
                "Samsung s10 ",
                "R 13343",
                "https://media.takealot.com/covers_tsins/56824409/8801643767440-1-pdpxl.jpg"
            )
        )
        ////        // create an assign adapter
        val adapter = UserAdapter(users)
       _recyclerView.adapter = adapter

        // add on click for elements
        adapter.onItemClick = { user ->

            val intent = Intent(this, UserDetailsActivity::class.java)
            intent.putExtra("User", user)
            startActivity(intent)
        }




       val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
       val navView : NavigationView = findViewById(R.id.nav_view)

       toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {


           when(it.itemId){
                R.id.nav_home -> Toast.makeText(applicationContext, "Home", Toast.LENGTH_SHORT).show()
                R.id.nav_message -> Toast.makeText(applicationContext, "Messages", Toast.LENGTH_SHORT).show()
               R.id.nav_sync -> Toast.makeText(applicationContext, "Sync", Toast.LENGTH_SHORT).show()
               R.id.nav_trash -> Toast.makeText(applicationContext, "Trash", Toast.LENGTH_SHORT).show()
                R.id.settings -> Toast.makeText(applicationContext, "Settings", Toast.LENGTH_SHORT).show()
                R.id.nav_login -> Toast.makeText(applicationContext, "Login", Toast.LENGTH_SHORT).show()
               R.id.nav_share -> Toast.makeText(applicationContext, "Share", Toast.LENGTH_SHORT).show()
               R.id.nav_rate_us -> Toast.makeText(applicationContext, "Rate Us", Toast.LENGTH_SHORT).show()


            }

            true
        }
   }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){

            return  true
        }
       return super.onOptionsItemSelected(item)
    }
}