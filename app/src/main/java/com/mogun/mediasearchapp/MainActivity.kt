package com.mogun.mediasearchapp

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.google.android.material.tabs.TabLayoutMediator
import com.mogun.mediasearchapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val searchFragment = SearchFragment()
    private val fragmentList = listOf(searchFragment, FavoriteFragment())
    private val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle, fragmentList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            view = this@MainActivity
            viewPager.adapter = adapter

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = if(fragmentList[position] is SearchFragment) {
                    "검색 결과"
                } else {
                    "즐겨 찾기"
                }
            }.attach()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        (menu?.findItem(R.id.search)?.actionView as SearchView).apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {

                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }

            })
        }

        return true
    }
}