package com.example.moneycomefirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var profileCircleImageView: CircleImageView
//    private var profileImageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.gemtvasia.com%2F7-things-you-didnt-know-about-mackenyu-arata&psig=AOvVaw2aNhJXJwDLwzb8KZR2q7qp&ust=1622963131554000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCOjEgoH3__ACFQAAAAAdAAAAABAP"
//    private lateinit var btnRiwayatTransaksi: Button
//    private lateinit var btnTambahSaldo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

//        profileCircleImageView = navView.getHeaderView(0).findViewById(R.id.iv_navbarProfPict)
//        Glide.with(this)
//            .load(profileImageUrl)
//            .into(profileCircleImageView)

        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.home, R.id.riwayatTransaksi, R.id.tambahSaldo, R.id.scanQr, R.id.login), drawerLayout)

        val navController = findNavController(R.id.nav_host_fragment)

        //untuk mengatur judul AppBar agar sesuai dengan Fragment yang ditampilkan.
        setupActionBarWithNavController(navController, appBarConfiguration)

        //supaya NavigationDrawer menampilkan Fragment yang sesuai ketika menu dipilih.
        navView.setupWithNavController(navController)

//        //untuk mengaktifkan button di dashboard
//        btnRiwayatTransaksi = findViewById(R.id.btn_RiwayatTransaksi)
//        btnTambahSaldo = findViewById(R.id.btn_TambahSaldo)
//
//        btnRiwayatTransaksi.setOnClickListener(this)
//        btnTambahSaldo.setOnClickListener(this)
    }

    //cara mengaktifkan tombol back
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

//    //untuk mengaktifkan button di dashboard
//    override fun onClick(v: View?) {
//        return
//    }
}