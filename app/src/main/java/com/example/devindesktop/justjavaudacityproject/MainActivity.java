package com.example.devindesktop.justjavaudacityproject;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    double price = 5.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View v){
        String message = createOrderSummary(getUserName(), wantsWhippedCream(), wantsChocolate());
        displayMessage(message);
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "devinfitzsimons@yahoo.com");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your Coffee Order");
        emailIntent.putExtra(Intent.EXTRA_STREAM, message);
        if(emailIntent.resolveActivity(getPackageManager()) != null){
            startActivity(emailIntent);
        }
    }

    private String createOrderSummary(String userName, boolean wantsWhippedCream, boolean wantsChocolate){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + userName);
        sb.append("\nQuantity: " + quantity);
        sb.append("\nWants whipped cream: " + wantsWhippedCream);
        sb.append("\nWants chocolate: " + wantsChocolate);
        sb.append("\nTotal: " + NumberFormat.getCurrencyInstance().format(calculatePrice(quantity, wantsChocolate, wantsWhippedCream)));
        sb.append("\nThank You!!");
        return sb.toString();
    }

    private String getUserName(){
        String userName = "";
        EditText et = (EditText) findViewById(R.id.et_get_full_name);
        userName = et.getText().toString();
        return userName;
    }

    private boolean wantsWhippedCream(){
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        return whippedCreamCheckBox.isChecked();
    }

    private boolean wantsChocolate(){
        CheckBox chocolateCheckBox= (CheckBox) findViewById(R.id.chocolate_checkbox);
        return chocolateCheckBox.isChecked();
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

    private double calculatePrice(int q, boolean wantsChocolate, boolean wantsWhip) {
        if (wantsChocolate){
            price += 2;
        }
        if (wantsWhip){
            price += 1;
        }

        return q * price;
    }

    public void increment(View view) {
        if (quantity >= 100){
            Toast.makeText(this, "100 is the maximum available number of coffees to order.", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity == 1){
            Toast.makeText(this, "You cannot sell negative coffee.", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity--;
        display(quantity);
    }
}