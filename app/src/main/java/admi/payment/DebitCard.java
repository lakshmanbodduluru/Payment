package admi.payment;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class DebitCard extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    EditText cardNoEt;
    EditText cvvEt;
    TextView cardNoTv;
    TextView cvvTv;
    Button payBtn;
    LinearLayout selectMonth;
    LinearLayout selectYear;
    TextView monthTv;
    TextView yearTv;
    String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    String[] years = {"2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027",
            "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041"
            , "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_card);
        init();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {
        cardNoEt.setOnTouchListener(this);
        cvvEt.setOnTouchListener(this);
        payBtn.setOnClickListener(this);
        selectMonth.setOnClickListener(this);
        selectYear.setOnClickListener(this);
    }

    private void initViews() {
        cardNoEt = (EditText) findViewById(R.id.card_no_debit_et);
        cvvEt = (EditText) findViewById(R.id.cvv_debit_et);
        payBtn = (Button) findViewById(R.id.debit_pay_btn);
        cardNoTv = (TextView) findViewById(R.id.tv_card_no_debit);
        cvvTv = (TextView) findViewById(R.id.tv_cvv_debit);
        selectMonth = (LinearLayout) findViewById(R.id.layout_month_debit);
        selectYear = (LinearLayout) findViewById(R.id.layout_year_debit);
        monthTv = (TextView) findViewById(R.id.debit_month_tv);
        yearTv = (TextView) findViewById(R.id.debit_year_tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.debit_pay_btn:
                checkData();
                break;
            case R.id.layout_month_debit:
                final Dialog dialog = new Dialog(DebitCard.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custome_dialog_list_view);
                dialog.show();
                ListView listView = (ListView) dialog.findViewById(R.id.custome_list_view);
                ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.custome_text_view, months);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView month = (TextView) view;
                        monthTv.setText(month.getText().toString());
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.layout_year_debit:
                final Dialog dialog1 = new Dialog(DebitCard.this);
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog1.setContentView(R.layout.custome_dialog_list_view);
                dialog1.show();
                ListView yearListView = (ListView) dialog1.findViewById(R.id.custome_list_view);
                ArrayAdapter yearAdapter = new ArrayAdapter<String>(this, R.layout.custome_text_view, years);
                yearListView.setAdapter(yearAdapter);
                yearListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView year = (TextView) view;
                        yearTv.setText(year.getText().toString());
                        dialog1.dismiss();
                    }
                });
                break;
        }
    }

    private void checkData() {
        if (cardNoEt.getText().toString().length() == 0) {
            cardNoTv.setTextColor(getResources().getColor(R.color.red));
        } else if (cvvEt.getText().toString().length() == 0) {
            cvvTv.setTextColor(getResources().getColor(R.color.red));
            cardNoTv.setTextColor(getResources().getColor(R.color.black));
        } else {
            cardNoTv.setTextColor(getResources().getColor(R.color.black));
            cvvTv.setTextColor(getResources().getColor(R.color.black));
            Toast.makeText(DebitCard.this, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.card_no_debit_et:
                cardNoEt.setBackground(getResources().getDrawable(R.drawable.spinner_selected_bg));
                cvvEt.setBackground(getResources().getDrawable(R.drawable.spinner_bg));
                break;
            case R.id.cvv_debit_et:
                cvvEt.setBackground(getResources().getDrawable(R.drawable.spinner_selected_bg));
                cardNoEt.setBackground(getResources().getDrawable(R.drawable.spinner_bg));
                break;
        }
        return false;
    }
}
