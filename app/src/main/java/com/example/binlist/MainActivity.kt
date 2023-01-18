package com.example.binlist

import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels

import android.os.Bundle
import com.example.binlist.cards.presentation.CardDetailViewModel

class MainActivity : AppCompatActivity() {
    //инициализируем ViewModel ленивым способом
    private val cardViewModel: CardDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cardViewModel.card
    }
}