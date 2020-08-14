import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class AveTest extends AnyFlatSpec with should.Matchers {

  def fixture = {
    val pepita = new Ave() with Depredador with Mostrable

    new {
      pepita.quienSoyYo = "pepita"
      pepita.agregarAlimentacion("semillas de sesamo")
      pepita.agregarAlimentacion("pepitos")
    }

    it should "pepita inicialmente no tener energia" in {
      assertResult(pepita.energia)(0)
    }

    it should "pepita al comer algo que le gusta, debe subir la energia" in {
      pepita.comer("pepitos")
      assertResult(pepita.energia)(7)
    }

    it should "pepita al comer algo que no le gusta, debe quedar con la misma energia" in {
      pepita.comer("lechuga")
      assertResult(pepita.energia)(0)
    }

    it should "pepita al mandarle el mensaje quienSoyYo, debe responder quién es" in {
      assertResult(pepita.quienSoyYo)("pepita")
    }

    it should "pepita al volar, debe incrementar su cantidad de vuelos" in {
      pepita.volar()
      assertResult(pepita.vuelos)(1)
    }

  }
}

// dos tipos de osos distintos => con diferentes traits
// "Armelo ud. mismo " => construya su animal como quiera
