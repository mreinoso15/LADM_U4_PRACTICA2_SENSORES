package mx.tecnm.tepic.ladm_u4_practica2_sensores


import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View


class Lienzo(act: MainActivity):View(act) {

    var posX = 600f
    var posY = 1100f
    var paintField = Paint()

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()

        c.drawColor(paintField.color)

        p.color = Color.WHITE
        p.strokeWidth = 20f
        c.drawLine(0f,1100f,1200f,1100f,p)
        p.style = Paint.Style.STROKE
        c.drawCircle(600f,1100f,200f,p)

        p.color = Color.RED
        p.style = Paint.Style.FILL
        c.drawCircle(posX,posY,90f,p)
    }

}