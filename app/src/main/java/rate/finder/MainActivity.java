package rate.finder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText length;
    private EditText breadth;
    private EditText height;
    private EditText weight;
    private int lengthChoice;
    private int breadthChoice;
    private int heightChoice;
    private int weightChoice;
    private String result;
    private String packType;
    private String price;
    private String confirmButton;
    private int maxWeight = 25;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        length = findViewById(R.id.length);
        breadth = findViewById(R.id.breadth);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        Button btnSubmit = findViewById(R.id.submit);
        Button btnGoToReport = findViewById(R.id.goToReport);
        Button btnGoToWebsite = findViewById(R.id.goToWebsite);

        // Objects Created
        final Package small = new Package(200, 300, 150, 5.00);
        final Package medium = new Package(300, 400, 200, 7.00);
        final Package large = new Package(400, 600, 250, 8.50);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getAndConverter();

                if (lengthChoice > large.getMaxLength() || breadthChoice > large.getMaxBreadth() || heightChoice > large.getMaxHeight() || weightChoice > maxWeight) {
                    buildDialogMsg(getString(R.string.error), getString(R.string.maxValues), getString(R.string.maxWeight), getString(R.string.got_it));

                } else {

                    if (lengthChoice > 0 && breadthChoice > 0 && heightChoice > 0 && weightChoice > 0) {

                        if (lengthChoice <= small.getMaxLength() && breadthChoice <= small.getMaxBreadth() && heightChoice <= small.getMaxHeight()) {
                            buildDialogMsg(getString(R.string.pack_msg), getString(R.string.small), getString(R.string.price_msg) + " " + small.getPrice(), getString(R.string.buy));

                        } else if (lengthChoice > medium.getMaxLength() || breadthChoice > medium.getMaxBreadth() || heightChoice > medium.getMaxHeight()) {
                            buildDialogMsg(getString(R.string.pack_msg), getString(R.string.large), getString(R.string.price_msg) + " " + medium.getPrice(), getString(R.string.buy));

                        } else {
                            buildDialogMsg(getString(R.string.pack_msg), getString(R.string.medium), getString(R.string.price_msg) + " " + large.getPrice(), getString(R.string.buy));
                        }

                    } else {
                        checkField(lengthChoice, breadthChoice, heightChoice, weightChoice);
                        buildDialogMsg(getString(R.string.error), getString(R.string.no_values_msg), getString(R.string.fill_field), getString(R.string.got_it));
                    }
                }
            }

        });

        btnGoToWebsite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,

                        Uri.parse("http://bit.ly/2ENK7oN"));
                startActivity(browserIntent);
            }
        });

        // Future feature (starting code)
        btnGoToReport.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                getAndConverter();

                Intent sendDimens = new Intent(MainActivity.this, Report.class);

                Bundle bundle = new Bundle();
                bundle.putString("KEY1", String.valueOf(lengthChoice));
                bundle.putString("KEY2", String.valueOf(breadthChoice));
                bundle.putString("KEY3", String.valueOf(heightChoice));
                bundle.putString("KEY4", String.valueOf(weightChoice));

                sendDimens.putExtras(bundle);
                startActivity(sendDimens);
            }
        });
    }

    private void getAndConverter() {
        lengthChoice = length.getText().toString().isEmpty() ? 0 : Integer.parseInt(length.getText().toString());
        breadthChoice = breadth.getText().toString().isEmpty() ? 0 : Integer.parseInt(breadth.getText().toString());
        heightChoice = height.getText().toString().isEmpty() ? 0 : Integer.parseInt(height.getText().toString());
        weightChoice = weight.getText().toString().isEmpty() ? 0 : Integer.parseInt(weight.getText().toString());
    }

    private void checkField(Integer a, Integer b, Integer c, Integer d) {

        ArrayList<Integer> fields = new ArrayList<Integer>();
        fields.add(a);
        fields.add(b);
        fields.add(c);
        fields.add(d);

        ArrayList<EditText> choices = new ArrayList<EditText>();
        choices.add(length);
        choices.add(breadth);
        choices.add(height);
        choices.add(weight);

        for (int index = 0; index < fields.size(); index++) {

            if (fields.get(index) == 0) {
                choices.get(index).setError(getString(R.string.no_values_msg));

            }
        }
    }

    public void buildDialogMsg(String title, String message, String subMessage, String
            buttonMsg) {

        result = title;
        packType = message;
        price = subMessage;
        confirmButton = buttonMsg;
        buildAlertUser(MainActivity.this).show();
    }

    private AlertDialog.Builder buildAlertUser(MainActivity c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle(result);
        builder.setMessage(packType + "\n" + price);

        builder.setPositiveButton(confirmButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onPause();
            }
        });
        return builder;
    }

}
