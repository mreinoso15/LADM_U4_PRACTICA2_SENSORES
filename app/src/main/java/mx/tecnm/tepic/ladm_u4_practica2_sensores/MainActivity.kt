package mx.tecnm.tepic.ladm_u4_practica2_sensores

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), SensorEventListener{

    lateinit var sensorManager: SensorManager
    lateinit var lienzo: Lienzo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lienzo = Lienzo(this)
        lienzo.paintField.color = Color.GREEN
        setContentView(lienzo)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(event: SensorEvent) {

        when(event.sensor.type){
            Sensor.TYPE_PROXIMITY -> {
                if (event.values[0] == 0f) {
                    lienzo.paintField.color = Color.BLACK
                } else {
                    lienzo.paintField.color = Color.GREEN
                }
            }
            Sensor.TYPE_ACCELEROMETER ->{
                if(event.values[0] < 0){ lienzo.posX -- }
                else{ lienzo.posX++ }
                if (event.values[1] < 0){ lienzo.posY --}
                else{ lienzo.posY++}
                println("X ${lienzo.posX}, Y: ${lienzo.posY}")
            }
        }
        lienzo.postInvalidate()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}