import org.scalatest.flatspec.AnyFlatSpec

class KaracasEncryptionTest extends AnyFlatSpec {

  val encryption = KaracasEncryption.karacasEncryption _

  "KaracasEncryption" should "replace all occurrences of 'a' with 0 and append 'aca' " in {
    assert(encryption("a") == "0aca")
    assert(encryption("A") == "0aca")
    assert(encryption("aAaAa") == "00000aca")
  }

  it should "replace all occurrences of 'e' with 1 and append 'aca' " in {
    assert(encryption("e") == "1aca")
    assert(encryption("E") == "1aca")
    assert(encryption("eEeEe") == "11111aca")
  }

  it should "replace all occurrences of 'i' with 2 and append 'aca' " in {
    assert(encryption("i") == "2aca")
    assert(encryption("I") == "2aca")
    assert(encryption("iIiIi") == "22222aca")
  }

  it should "replace all occurrences of 'o' with 3 and append 'aca' " in {
    assert(encryption("o") == "3aca")
    assert(encryption("O") == "3aca")
    assert(encryption("oOoOo") == "33333aca")
  }

  it should "replace all occurrences of 'u' with 4 and append 'aca' " in {
    assert(encryption("u") == "4aca")
    assert(encryption("U") == "4aca")
    assert(encryption("uUuUu") == "44444aca")
  }

  it should "reverse the input and append 'aca' " in {
    assert(encryption("qwrty") == "ytrwqaca")
    assert(encryption("12345") == "54321aca")
  }


}
