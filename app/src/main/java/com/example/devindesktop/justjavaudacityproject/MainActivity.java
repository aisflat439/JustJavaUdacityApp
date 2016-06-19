package com.example.devindesktop.justjavaudacityproject;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    double price = 5.00;
    int numOrders = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View v){
        double total = calculatePrice();
//        createOrderSummary(wantsWhippedCream(), total);
        displayMessage(createOrderSummary(wantsWhippedCream(), total));
        displayToastAndUpdate();
    }

    private String createOrderSummary(boolean wantsWhippedCream, double t){
        String orderSummaryMessage = "Name: Kaptain Kunal";
        orderSummaryMessage += "\nQuantity: " + quantity;
        orderSummaryMessage += "\nWants whipped cream: " + wantsWhippedCream;
        orderSummaryMessage += "\nTotal: " + NumberFormat.getCurrencyInstance().format(t);
        orderSummaryMessage += "\nThank You!";
        return orderSummaryMessage;
    }

    private boolean wantsWhippedCream(){
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        return whippedCreamCheckBox.isChecked();
    }

    private void display(int number){
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setTextSize(20);
        orderSummaryTextView.setTextColor(Color.parseColor("#303F9F"));
        orderSummaryTextView.setText(message);
    }

    private void displayToastAndUpdate(){
        Toast.makeText(this, "You have had " + numOrders + " orders.", Toast.LENGTH_SHORT).show();
        numOrders++;
    }

    private double calculatePrice() {
        double totalPrice = quantity * price;
        return totalPrice;
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