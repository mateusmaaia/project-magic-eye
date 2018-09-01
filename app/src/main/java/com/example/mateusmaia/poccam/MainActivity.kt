package com.example.mateusmaia.poccam

import android.databinding.DataBindingUtil
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.mateusmaia.poccam.databinding.ActivityMainBinding
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.look = Look()
        val handler = Handler()

        Glide.with(this)
                .load(R.drawable.nonsinal)
                .into(binding.logo)
        binding.logo.visibility = View.VISIBLE

        binding.acceptButton.setOnClickListener {
            Toast.makeText(this, "To be implemented", Toast.LENGTH_SHORT).show()
        }

        binding.refuseButton.setOnClickListener {
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        mBinding?.camera?.start()
    }

    override fun onPause() {
        mBinding?.camera?.stop()
        super.onPause()
    }
}
