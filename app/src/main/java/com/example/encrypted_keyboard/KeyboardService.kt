package com.example.encrypted_keyboard

import android.inputmethodservice.InputMethodService
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputConnection
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView

class KeyboardService : InputMethodService(), KeyboardView.OnKeyboardActionListener {
    private val TAG = "KeyboardService"
    private lateinit var keyboardView: KeyboardView
    private lateinit var qwertyKeyboard: Keyboard
    private val inputBuffer = StringBuilder()
    private var cipherRotation = 1
    private var wordCount = 0
    
    // Define substitution alphabets


    override fun onCreateInputView(): View {
        Log.d(TAG, "onCreateInputView")
        val rootView = layoutInflater.inflate(R.layout.keyboard_view, null)
        keyboardView = rootView.findViewById(R.id.keyboard_view)
        qwertyKeyboard = Keyboard(this, R.xml.qwerty)
        keyboardView.keyboard = qwertyKeyboard
        keyboardView.setOnKeyboardActionListener(this)
        return rootView
    }

    override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
        Log.d(TAG, "onKey: $primaryCode")
        val inputConnection: InputConnection? = currentInputConnection
        
        when (primaryCode) {
            -5 -> { // Keyboard.KEYCODE_DELETE
                Log.d(TAG, "Delete key pressed")
                inputConnection?.deleteSurroundingText(1, 0)
            }
            -4 -> { // Keyboard.KEYCODE_ENTER
                Log.d(TAG, "Enter key pressed")
                inputConnection?.commitText("\n", 1)
            }
            32 -> { // Space key
                Log.d(TAG, "Space key pressed")
                inputConnection?.commitText(" ", 1)
            }
            else -> {
                if (primaryCode >= 65 && primaryCode <= 90) { // A-Z keys
                    Log.d(TAG, "Character key pressed: $primaryCode")
                    val char = primaryCode.toChar().uppercaseChar()
                    val encrypted = encryptChar(char)
                    inputConnection?.commitText(encrypted, 1)
                }
            }
        }
    }

    private fun encryptChar(char: Char): String {
        val encrypted = CipherUtils.encryptChar(char, cipherRotation)
        cipherRotation = (cipherRotation % 2) + 1
        return encrypted
    }



    // Required override methods
    override fun onPress(primaryCode: Int) {}
    override fun onRelease(primaryCode: Int) {}
    override fun onText(text: CharSequence?) {}
    override fun swipeLeft() {}
    override fun swipeRight() {}
    override fun swipeDown() {}
    override fun swipeUp() {}
}