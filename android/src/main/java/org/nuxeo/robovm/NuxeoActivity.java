package org.nuxeo.robovm;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NuxeoActivity extends Activity {

    private NuxeoClient nuxeoClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder
                ().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        nuxeoClient = new NuxeoClient();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuxeo);

        final TextView textView = (TextView) findViewById(R.id.textView);
        final Button showButton = (Button) findViewById(R.id.showButton);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuxeoClient.getDocumentTitle(new NuxeoClient.OnNuxeoListener() {
                    @Override
                    public void onClick(String title) {
                        textView.setText(title);
                    }
                });
            }
        });
    }
}
