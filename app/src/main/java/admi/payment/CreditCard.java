package admi.payment;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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


public class CreditCard extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    EditText cardNoEt;
    EditText cvvEt;
    TextView cardNoTv;
    TextView cvvTv;
    Button payBtn;
    LinearLayout layoutMonth;
    LinearLayout layoutYear;
    TextView monthTv;
    TextView yearTv;
    String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    String[] years = {"2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027",
            "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041"
            , "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);
        init();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {
        payBtn.setOnClickListener(this);
        layoutMonth.setOnClickListener(this);
        layoutYear.setOnClickListener(this);
        cardNoEt.setOnTouchListener(this);
        cvvEt.setOnTouchListener(this);
        cvvEt.addTextChangedListener(watcher);

    }

    private void initViews() {
        cardNoEt = (EditText) findViewById(R.id.card_no_credit_et);
        cvvEt = (EditText) findViewById(R.id.cvv_credit_et);
        payBtn = (Button) findViewById(R.id.credit_pay_btn);
        cardNoTv = (TextView) findViewById(R.id.tv_card_no_credit);
        cvvTv = (TextView) findViewById(R.id.cvv_credit_tv);
        layoutMonth = (LinearLayout) findViewById(R.id.layout_month_credit);
        layoutYear = (LinearLayout) findViewById(R.id.layout_year_credit);
        monthTv = (TextView) findViewById(R.id.credit_month_tv);
        yearTv = (TextView) findViewById(R.id.credit_year_tv);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.credit_pay_btn:
                checkData();
                break;
            case R.id.layout_month_credit:
                final Dialog dialog = new Dialog(CreditCard.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custome_dialog_list_view);
                dialog.show();
                ListView monthList = (ListView) dialog.findViewById(R.id.custome_list_view);
                ArrayAdapter monthAdapter = new ArrayAdapter<String>(this, R.layout.custome_text_view, months);
                monthList.setAdapter(monthAdapter);
                monthList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView month = (TextView) view;
                        monthTv.setText(month.getText().toString());
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.layout_year_credit:
                final Dialog yearDialog = new Dialog(CreditCard.this);
                yearDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                yearDialog.setContentView(R.layout.custome_dialog_list_view);
                yearDialog.show();
                ListView yearListView = (ListView) yearDialog.findViewById(R.id.custome_list_view);
                ArrayAdapter yearAdapter = new ArrayAdapter<String>(this, R.layout.custome_text_view, years);
                yearListView.setAdapter(yearAdapter);
                yearListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView year = (TextView) view;
                        yearTv.setText(year.getText().toString());
                        yearDialog.dismiss();
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
            Toast.makeText(CreditCard.this, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (before == 2) {
                Toast.makeText(CreditCard.this, "Max text Limit Reached", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.card_no_credit_et:
                cardNoEt.setBackground(getResources().getDrawable(R.drawable.spinner_selected_bg));
                cvvEt.setBackground(getResources().getDrawable(R.drawable.spinner_bg));
                break;
            case R.id.cvv_credit_et:
                cvvEt.setBackground(getResources().getDrawable(R.drawable.spinner_selected_bg));
                cardNoEt.setBackground(getResources().getDrawable(R.drawable.spinner_bg));
                break;
        }
        return false;
    }


}
