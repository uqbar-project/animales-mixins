import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class OsoTest extends AnyFlatSpec with should.Matchers {

  def fixture = {

    new {
      val kenai = new Oso() with Depredador with Contemplativo
      val winniePooh = new Oso() with Depredador with Mostrable
      winniePooh.quienSoyYo = "Winnie Pooh"
      winniePooh.agregarAlimentacion("miel")

      kenai.agregarAlimentacion("salmón")
    }
  }

  it should "Pooh y Kenai inicialmente no tienen energía" in {
    assertResult(fixture.winniePooh.energia)(0)
    assertResult(fixture.kenai.energia)(0)
  }

  it should "Pooh y Kenai incrementar en energía  cuando comen cosas que les gustan" in {
    val winniePooh = fixture.winniePooh
    val kenai = fixture.kenai

    winniePooh.comer("miel")
    kenai.comer("salmón")

    assertResult(winniePooh.energia)(4)
    assertResult(kenai.energia)(6)
  }

  it should "Winnie al mandarle el mensaje quienSoyYo, debe responder quién es" in {
    assertResult(fixture.winniePooh.quienSoyYo)("Winnie Pooh")
  }

  it should "Kenai al contemplar, cambiar su estado a está contemplativo" in {
    val kenai = fixture.kenai

    kenai.contemplar()
    assertResult(kenai.estaContemplativo)(true)
  }

  it should "Show linearization mechanism" in {
    val oso = new Oso() with Depredador with Contemplativo with Mostrable

    assertResult(oso.toString)("yo pensativo depredador oso")
  }
}