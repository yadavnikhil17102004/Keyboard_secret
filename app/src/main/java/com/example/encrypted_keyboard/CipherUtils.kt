package com.example.encrypted_keyboard

object CipherUtils {
    private val alphabet1 = mapOf(
        'A' to "!", 'B' to "@", 'C' to "#", 'D' to "$", 'E' to "%",
        'F' to "^", 'G' to "&", 'H' to "*", 'I' to "(", 'J' to "M",
        'K' to "-", 'L' to "+", 'M' to "=", 'N' to "<", 'O' to ">",
        'P' to "?", 'Q' to "/", 'R' to "T", 'S' to "|", 'T' to ";",
        'U' to ":", 'V' to "`", 'W' to "~", 'X' to "{", 'Y' to "}", 'Z' to "["
    )
    
    private val alphabet2 = mapOf(
        'A' to "α", 'B' to "β", 'C' to "F", 'D' to "δ", 'E' to "ε",
        'F' to "φ", 'G' to "γ", 'H' to "η", 'I' to "ι", 'J' to "B",
        'K' to "κ", 'L' to "λ", 'M' to "μ", 'N' to "ν", 'O' to "ο",
        'P' to "π", 'Q' to "θ", 'R' to "ρ", 'S' to "σ", 'T' to "τ",
        'U' to "υ", 'V' to "ω", 'W' to "ς", 'X' to "ξ", 'Y' to "ζ", 'Z' to "∇"
    )

    fun encryptChar(char: Char, rotation: Int): String {
        val cipherMap = if (rotation == 1) alphabet1 else alphabet2
        return cipherMap[char.uppercaseChar()] ?: char.toString()
    }

    fun decryptText(encrypted: String): String {
        val invertedAlphabet1 = alphabet1.entries.associate { (k, v) -> v to k }
        val invertedAlphabet2 = alphabet2.entries.associate { (k, v) -> v to k }
        var currentRotation = 1

        return encrypted.map { char ->
            val cipherMap = if (currentRotation == 1) invertedAlphabet1 else invertedAlphabet2
            val original = cipherMap[char.toString()] ?: char
            currentRotation = (currentRotation % 2) + 1
            original
        }.joinToString("")
    }
}