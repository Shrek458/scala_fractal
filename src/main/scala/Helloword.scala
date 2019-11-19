import scala.collection.immutable.Range.Inclusive
import java.awt.image.BufferedImage
import java.awt.{BasicStroke, Color, Font, Graphics2D, Polygon}
import java.awt.geom._

import scala.math.sqrt


object Helloword {
  val vp1 =(800,200)
  val vp2 = (800,800)
  val vp3 = (200,5000)
  val vx = Array(800,800,200)
  val vy = Array(200,800,500)


  def main(args: Array[String]): Unit = {
    val a = new Can(1000,1000)

  }










  class Can(x: Int, y : Int){


      val canvas = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB)
      val g = canvas.createGraphics()
      g.setColor(Color.GRAY)
      g.fillRect(0, 0, canvas.getWidth, canvas.getHeight)
      g.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,
        java.awt.RenderingHints.VALUE_ANTIALIAS_ON)
     triangle(vx,vy)

    g.dispose()
      javax.imageio.ImageIO.write(canvas, "png", new java.io.File("drawing.png"))


    def triangle(p1 : Array[Int] , p2 :Array[Int] ): Unit={
    var l = 0
      val écart = sqrt( (p1( 0 ) - p1( 1 )) * (p1( 0 ) - p1( 1 )) + (p2( 0 ) - p2( 1 )) * (p2( 0 ) - p2( 1 )) )
      print(écart)
    if (l%2==0)g.setColor(Color.BLACK)
      else g.setColor(Color.WHITE)

      if (écart < 10) g.fill(new Polygon(p1, p2, 3))
      else {
        l = l+1
        val xab = (p1( 0 ) + p1( 1 )) / 2
        val xac = (p1( 0 ) + p1( 2 )) / 2
        val xbc = (p1( 1 ) + p1( 2 )) / 2

        val yab = (p2( 0 ) + p2( 1 )) / 2
        val yac = (p2( 0 ) + p2( 2 )) / 2
        val ybc = (p2( 1 ) + p2( 2 )) / 2
        val x1 = Array( p1( 0 ), xab, xac )
        val y1 = Array( p2( 0 ), yab, yac )
        triangle( x1, y1 )
        val x2 = Array( p1( 1 ), xab, xbc )
        val y2 = Array( p2( 1 ), yab, ybc )
        triangle( x2, y2 )
        val x3 = Array( p1( 2 ), xac, xbc )
        val y3 = Array( p2( 2 ), yac, ybc )
        triangle(x3,y3)


      }



    }
  }

}
