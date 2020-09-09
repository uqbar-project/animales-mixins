import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class AveTest extends AnyFlatSpec with should.Matchers {

  def fixture =
    new {
      val pepita = new Ave() with Depredador with Mostrable
      pepita.quienSoyYo = "pepita"
      pepita.agregarAlimentacion("semillas de sesamo")
      pepita.agregarAlimentacion("pepitos")
    }

  it should "pepita inicialmente no tener energia" in {
    assert(fixture.pepita.energia === 0)
  }

  it should "pepita al comer algo que le gusta, debe subir la energia" in {
    val pepita = fixture.pepita
    pepita.comer("pepitos")
    assertResult(pepita.energia)(7)
  }

  it should "pepita al comer algo que no le gusta, debe quedar con la misma energia" in {
    val pepita = fixture.pepita
    pepita.comer("lechuga")
    assertResult(pepita.energia)(0)
  }

  it should "pepita sabe mostrarse con su nombre" in {
    val pepita = fixture.pepita
    assertResult(pepita.toString)("pepita depredador ave")
  }

  it should "pepita al volar, debe incrementar su cantidad de vuelos" in {
    val pepita = fixture.pepita
    pepita.volar()
    assertResult(pepita.vuelos)(1)
  }

}

// dos tipos de osos distintos => con diferentes traits
// "Armelo ud. mismo " => construya su animal como quiera
