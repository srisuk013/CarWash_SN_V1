package com.example.carwash_sn_v1.ui

import android.os.Bundle
import android.os.StrictMode
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.carwash_sn_v1.datasource.DataSource
import com.example.carwash_sn_v1.datasource.DataSourceImpl
import org.jetbrains.exposed.sql.Database

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {

    val dataSource: DataSource = DataSourceImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userId =context?.getSharedPreferences("file", AppCompatActivity.MODE_PRIVATE)?.getInt("userId",0)
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        val host = "192.168.111.167"
        val databaseName = "carwash"
        val url = "jdbc:mysql://$host:3306/$databaseName?useUnicode=true&characterEncoding=utf-8"
        Database.connect(
            url = url,
            driver = "com.mysql.jdbc.Driver",
            user = "srisuk013",
            password = "srisuk013",
        )
    }
}
