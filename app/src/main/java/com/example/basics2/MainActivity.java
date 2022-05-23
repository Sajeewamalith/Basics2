package com.example.basics2;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
        EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
       String getName = nameEditText.getText().toString();

        //displayPrice(quantity*5);
        price =  calculatePrice(hasWhippedCream,hasChocolate );
        String priceMessage = createOrderSummary(hasWhippedCream,hasChocolate,getName);

        /**
         * add Email intent to go Email App
         * All intent activities are not work (Error)
         */
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for "+getName);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
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
        // max order
        if(quantity ==100){
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
           return;
        }
        quantity= quantity+1;
        display(quantity);
    }
    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        // less order
        if(quantity ==1){
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do

            return;
        }
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
    private int calculatePrice(boolean addWhippedCream,boolean addChocolate) {
        int basePrice = 5;

        if (addWhippedCream){
            basePrice = basePrice+1;
        }

        if (addChocolate){
            basePrice = basePrice+2;
        }

        return quantity * basePrice;
    }

    private String createOrderSummary(boolean hasWhippedCream,boolean hasChocolate,String name){
        return "Name = "+name+"\nAdd Whipped cream? "+hasWhippedCream+"\nAdd Chocolate? "+hasChocolate+"\nQuantity :"+quantity+"\nTotal: $"+price +"\n"+ getString(R.string.thank_you);

      //  String priceMessage = "Name: Lyla the Labyrinth";
      //  priceMessage += "\nAdd whipped cream? " + addWhippedCream;
      //  priceMessage += "\nAdd chocolate? " + addChocolate;
      //  priceMessage += "\nQuantity: " + quantity;
      //  priceMessage += "\nTotal: $" + price;
      //  priceMessage += "\nThank you!";
      //  return priceMessage;
    }
   

}