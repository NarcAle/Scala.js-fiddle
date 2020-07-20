package main

import org.scalajs.dom
import org.scalajs.dom.document
import scala.scalajs.js.annotation.JSExportTopLevel

object Main {

  def main(args: Array[String]): Unit = {
    document.addEventListener("DOMContentLoaded", { (e: dom.Event) =>
      setupUI()
    })
  }

  @JSExportTopLevel("hello")
  def sayHello(): Unit = {
    appendParagraph(document.body, "Hello!")
  }

  @JSExportTopLevel("setupUI")
  def setupUI(): Unit = {
    val button = document.createElement("button")
    button.textContent = "Click me too!"
    button.addEventListener("click", { (e: dom.MouseEvent) =>
      sayHello()
    })
    document.body.appendChild(button)

    appendParagraph(document.body, "Hello World!")
  }

  def appendParagraph(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }
}