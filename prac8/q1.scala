object CaesarCipher {
  
  def encrypt(text: String, shift: Int): String = {
    text.map(char => {
      if (char.isLetter) {
        val base = if (char.isLower) 'a' else 'A'
        ((char - base + shift) % 26 + base).toChar
      } else {
        char
      }
    })
  }

  def decrypt(cipherText: String, shift: Int): String = {
    encrypt(cipherText, 26 - shift) 
  }
  
  def cipher(text: String, shift: Int, cipherFunction: (String, Int) => String): String = {
    cipherFunction(text, shift)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
  val text = "Hello, World!"
  val shift = 1

  val encryptedText = CaesarCipher.cipher(text, shift, CaesarCipher.encrypt)
  println(s"Encrypted Text: $encryptedText")

  val decryptedText = CaesarCipher.cipher(encryptedText, shift, CaesarCipher.decrypt)
  println(s"Decrypted Text: $decryptedText")
  }
}
