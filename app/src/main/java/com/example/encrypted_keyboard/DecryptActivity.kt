package com.example.encrypted_keyboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.encrypted_keyboard.databinding.ActivityDecryptBinding
import android.view.inputmethod.EditorInfo
import android.text.Editable
import android.text.TextWatcher
import android.content.ClipboardManager
import android.content.Context

class DecryptActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDecryptBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDecryptBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.encryptedInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val encryptedText = s?.toString() ?: ""
                binding.decryptedTextView.text = CipherUtils.decryptText(encryptedText)
            }
        })

        binding.pasteButton.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            clipboard.primaryClip?.getItemAt(0)?.text?.toString()?.let { clipboardText ->
                binding.encryptedInput.setText(clipboardText)
                // The TextWatcher will handle decryption automatically
            }
        }
    }
}