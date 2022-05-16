package com.example.basics2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
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

        CheckBox whippedCreamCheckBox = (CheckBox)findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream =  whippedCreamCheckBox.isChecked();

        // for check Logcat
        Log.v("ManActivity","Has whipped cream: "+hasWhippedCream);

        CheckBox chocolateCheckBox = (CheckBox)findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate =  chocolateCheckBox.isChecked();

        //displayPrice(quantity*5);
         price =  calculatePrice();
        String priceMessage = createOrderSummary(hasWhippedCream,hasChocolate);
        displayMessage(priceMessage);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
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
        orderSummaryTextView.setTextColor(Color.RED);

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

    private String createOrderSummary(boolean hasWhippedCream,boolean hasChocolate){
        String summary = "Name = Kaptain kunal"+"\nAdd Whipped cream? "+hasWhippedCream+"\nAdd Chocolate? "+hasChocolate+"\nQuantity :"+quantity+"\nTotal: $"+price +"\nThank You!";
        return summary ;
    }


}