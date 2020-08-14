import java.util

import scala.collection.convert.ImplicitConversions.`list asScalaBuffer`

class Comida(var tipoComida: String) {
  def energiaQueDa() = tipoComida.length
}

class Ave {
  var vuelos = 0

  def volar(): Unit = {
    vuelos = vuelos + 1
  }
}

class Oso {
  var pelo = "marron"
  var cansancio = 50

  def correr(minutos: Int): Unit = {
    cansancio = cansancio + (20 * minutos)
  }
}

trait Depredador {
  var energia = 0
  var alimentacion = new util.ArrayList[Comida]

  def comer(unaComida: String): Unit = {
    val comida = alimentacion.find((comida) => {
      println("eh " + comida.tipoComida.equals(unaComida) + ", " + comida.tipoComida + " " + unaComida)
      comida.tipoComida.equals(unaComida)
    }
    )
    comida match {
      case Some(comida) => energia = energia + comida.energiaQueDa
      case _ => {}
    }
  }

  def agregarAlimentacion(unaComida: String): Unit = {
    alimentacion.add(new Comida(unaComida))
  }
}

trait Contemplativo {
  var estaContemplativo = false

  def contemplar(): Unit = {
    estaContemplativo = true
  }
}

trait Mostrable {
  var quienSoyYo = "yo"

  override def toString: String = quienSoyYo
}

object Pepita extends Ave with Depredador with Mostrable {
  quienSoyYo = "pepita"
  agregarAlimentacion("semillas de sésamo")
  agregarAlimentacion("pepitos")
}

object Pooh extends Oso with Depredador with Contemplativo with Mostrable {
  quienSoyYo = "winny del PO"
  agregarAlimentacion("pepitos")
}