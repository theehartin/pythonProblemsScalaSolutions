import org.scalacheck.Prop.forAll
import org.scalacheck.Properties

object KaracasEncryptionCheck extends Properties("KaracasEncryptionCheck"){

  val encryption = KaracasEncryption.karacasEncryption _

  property("Length") = forAll { (input: String) =>
    encryption(input).length == input.length + 3
  }

  property("No Vowels") = forAll { (input: String) =>
    !encryption(input).contains("a")
    !encryption(input).contains("e")
    !encryption(input).contains("i")
    !encryption(input).contains("o")
    !encryption(input).contains("u")

  }
}
