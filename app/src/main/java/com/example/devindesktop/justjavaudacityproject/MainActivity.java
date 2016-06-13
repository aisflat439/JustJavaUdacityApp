package com.example.devindesktop.justjavaudacityproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View v){
        int quantity = 2;
        double priceOfCofees = 0;
        double paperCupCharge = 0;
        display(quantity);
        displayPrice(quantity * 5);
    }

    private void display(int number){
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(
                R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increment(View view) {
        int quantity = 0;
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantity = Integer.parseInt(quantityTextView.getText().toString());
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        int quantity = 0;
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantity = Integer.parseInt(quantityTextView.getText().toString());
        quantity--;
        display(quantity);
    }
}