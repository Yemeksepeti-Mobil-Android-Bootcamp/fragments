package com.kodluyoruz.fragments

import android.content.Context
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {
    var iNavigation: INavigation? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        iNavigation = context as INavigation
    }

}