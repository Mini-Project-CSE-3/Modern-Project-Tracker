package com.example.protrack;

import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.formatter.PercentFormatter;

import android.graphics.Color;
import android.os.Bundle;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.components.Legend;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PieChart pie_chart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pie_chart = findViewById(R.id.piechart);
        setupPieChart();
        loadPieChartData();
    }
    private void setupPieChart() {
        pie_chart.setDrawHoleEnabled(true);
        pie_chart.setUsePercentValues(true);
        pie_chart.setEntryLabelTextSize(12);
        pie_chart.setEntryLabelColor(Color.BLACK);
        pie_chart.setCenterText("Work Done");
        pie_chart.setCenterTextSize(24);
        pie_chart.getDescription().setEnabled(false);

        Legend l = pie_chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);
    }
    private void loadPieChartData()
    {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(20f,"documentation"));
        entries.add(new PieEntry(15f,"research"));
        entries.add(new PieEntry(40f,"designing"));
        entries.add(new PieEntry(25f,"more research"));
        ArrayList<Integer> colors = new ArrayList<>();
        for (int color: ColorTemplate.MATERIAL_COLORS) {
            colors.add(color);
        }

        for (int color: ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color);
        }
        PieDataSet dataSet = new PieDataSet(entries, "Phase 1");
        dataSet.setColors(colors);
        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pie_chart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);
        pie_chart.setData(data);
        pie_chart.invalidate();



    }

}