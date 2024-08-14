package com.example.scroll;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
private Button extbtn;
private TextView extv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        extbtn=findViewById(R.id.B1);
        extv=findViewById(R.id.PDF);
    }

    public  void  extPDF(View view) throws IOException {
        try{
            String exttext="";
            PdfReader pd=new PdfReader("res/raw/vvce.pdf");

            int n=pd.getNumberOfPages();
            for(int i=0;i<n;i++)
            {
                exttext = exttext + PdfTextExtractor.getTextFromPage(pd,i+1).trim()+"\n";
            }
            extv.setText(exttext);
            pd.close();
        }
        catch(Exception e){
            extv.setText("Error in fetching the data");
        }
    }
}