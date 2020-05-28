package com.mlvolt.protienboothuser;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class BarGraph{

    BarChart barChart;
    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String> labelallnames;

    ArrayList<MonthSalesData> monthSalesDataArrayList = new ArrayList<>();

    public void setBarChart(BarChart barChart) {
        this.barChart = barChart;
    }

    public void fun( int box, int your){

        barEntryArrayList = new ArrayList<>();
        labelallnames = new ArrayList<>();

        monthSalesDataArrayList.clear();
        monthSalesDataArrayList.add(new MonthSalesData("Box", box));
        monthSalesDataArrayList.add(new MonthSalesData("Your", your));

        for(int i=0; i<monthSalesDataArrayList.size(); i++){

            String month = monthSalesDataArrayList.get(i).getMonth();
            int sales = monthSalesDataArrayList.get(i).getSales();
            barEntryArrayList.add(new BarEntry(i, sales));
            labelallnames.add(month);



        }

        BarDataSet barDataSet = new BarDataSet(barEntryArrayList,"Supplement (gm)");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        Description description = new Description();
        description.setText("");
        barChart.setDescription(description);
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labelallnames));

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(labelallnames.size());
        xAxis.setLabelRotationAngle(320);

        barChart.animateY(2000);
        barChart.invalidate();



    }

    private void fillMonthSales(){


    }
}
