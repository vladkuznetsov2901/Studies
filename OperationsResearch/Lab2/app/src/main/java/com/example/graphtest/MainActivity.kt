import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class MainActivity : AppCompatActivity() {
    private lateinit var lineChart: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lineChart = findViewById(R.id.lineChart)

        val entries = mutableListOf<Entry>()
        entries.add(Entry(0f, 4f))
        entries.add(Entry(1f, 8f))
        entries.add(Entry(2f, 6f))
        entries.add(Entry(3f, 2f))
        entries.add(Entry(4f, 7f))

        val dataSet = LineDataSet(entries, "Example Dataset")
        dataSet.color = Color.BLUE
        dataSet.valueTextColor = Color.RED

        val lineData = LineData(dataSet)
        lineChart.data = lineData

        lineChart.invalidate()
    }
}
