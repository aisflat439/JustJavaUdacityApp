package com.example.devindesktop.justjavaudacityproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    double price = 2.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View v){
        double value;
        value = quantity * price;
        String priceMessage = "Total is " + NumberFormat.getCurrencyInstance().format(value) + "\nThank you!";
        displayMessage(priceMessage);
    }

    private void display(int number){
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        quantity--;
        display(quantity);
    }
}