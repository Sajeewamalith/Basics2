package com.example.basics2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int price =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //displayPrice(quantity*5);
         price =  calculatePrice();
        String priceMessage = createOrderSummary();
        displayMessage(priceMessage);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        quantity= quantity+1;
        display(quantity);
    }
    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity-1;
        display(quantity);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    /**
     * Calculates the price of the order.
     *
     * @param
     * @return
     * new methods
     */
    private int calculatePrice() {
        int priceB = quantity * 5;
        return priceB;
    }

    private String createOrderSummary(){
        String summary = "Name = Kaptain kunal"+"\nQuantity :"+quantity+"\nTotal: $"+price +"\nThank You!";
        return summary ;
    }


}