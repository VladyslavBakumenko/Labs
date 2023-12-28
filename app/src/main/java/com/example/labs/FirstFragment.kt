package com.example.labs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.labs.databinding.FirstFragmentBinding

class FirstFragment : Fragment() {

    private var binding: FirstFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FirstFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SecondFragment.onClickInterface = object : SecondFragment.OnClick {
            override fun onClick() {
                binding?.textView?.text = "Текст на фрагменті було змінено"
            }

            override fun onClickWebView() {
                binding?.textView?.visibility = View.GONE
                binding?.webView?.apply {
                    visibility = View.VISIBLE
                    webViewClient = WebViewClient()
                    settings.allowContentAccess = true;
                    settings.allowFileAccess = true;
                    settings.javaScriptEnabled = true
                    settings.setSupportZoom(true)
                    loadUrl("https://jetiq.vntu.edu.ua/")
                }
            }
        }
    }
}