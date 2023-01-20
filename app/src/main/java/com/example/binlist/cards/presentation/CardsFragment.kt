package com.example.binlist.cards.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.example.binlist.R
import com.example.binlist.main.presentation.BaseFragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

/**
 * @author Vitaly.N on 18.01.2023.
 */
class CardsFragment : BaseFragment<CardsViewModel.Base>() {
    override val viewModelClass = CardsViewModel.Base::class.java
    override val layoutID = R.layout.fragment_cards
    private lateinit var inputEditText: TextInputEditText

    private val watcher = object : SimpleTextWatcher() {
        override fun afterTextChanged(p0: Editable?) = viewModel.clearError()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inputLayout = view.findViewById<TextInputLayout>(R.id.textInputLayout)
        inputEditText = view.findViewById(R.id.editText)
        inputEditText.addTextChangedListener(watcher)
        val buttonGo = view.findViewById<Button>(R.id.buttonGo)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        val adapter = CardsAdapter(object : ClickListener {
            override fun click(item: CardUi) = viewModel.showDetail(item)
        })
        recyclerView.adapter = adapter
        viewModel.init(savedInstanceState == null)
        buttonGo.setOnClickListener {
            viewModel.fetchCard(inputEditText.text.toString())
        }
        viewModel.observerState(this) {
            it.apply(inputLayout, inputEditText)
        }
        viewModel.observeList(this) {
            adapter.map(it)
        }
        viewModel.observerProgress(this) {
            progressBar.visibility = it
        }

    }

    abstract class SimpleTextWatcher : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
        override fun afterTextChanged(p0: Editable?) = Unit
    }
}