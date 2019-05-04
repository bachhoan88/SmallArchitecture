package com.example.mvvm.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.mvvm.BR
import com.example.mvvm.base.BaseFragment
import com.example.mvvm.binding.FragmentDataBindingComponent
import com.example.mvvm.databinding.FragmentMainBinding
import com.example.mvvm.util.autoCleared
import org.koin.android.ext.android.inject
import com.example.mvvm.R
import com.example.mvvm.extension.setVisible

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    companion object {
        fun newInstance() = MainFragment()
    }

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_main

    override val viewModel: MainViewModel by inject()

    private var mainAdapter by autoCleared<MainAdapter>()
    private var bindingComponent = FragmentDataBindingComponent(this)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewDataBinding.run {
            search.setOnClickListener {
                showSoftKeyboard(activity?.currentFocus?.windowToken, false)
                viewModel?.searchRepo()
            }
        }

        subscribeUI()
    }

    private fun subscribeUI() {
        val adapter = MainAdapter(bindingComponent) { item ->
            Toast.makeText(activity, item.name, Toast.LENGTH_SHORT).show()
        }

        this.mainAdapter = adapter
        viewDataBinding.listRepo.adapter = mainAdapter

        viewModel.run {
            data.observe(viewLifecycleOwner, Observer {
                adapter.submitList(it)
            })

            loading.observe(viewLifecycleOwner, Observer { loading ->
                viewDataBinding.loading.setVisible(loading)
            })
        }
    }
}
