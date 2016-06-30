package admi.payment;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class NetBanking extends AppCompatActivity implements View.OnClickListener {
    TextView bankTv;
    ImageView sbi;
    ImageView icici;
    ImageView axis;
    ImageView city;
    ImageView kotak;
    ImageView hdfc;
    LinearLayout selectBankLayout;
    Button netBankingPayBtn;
    ListView listView;
    String[] banksName = {"Allahabad Bank", "Andhra Bank", "Axis Bank", "BNP Paribas", "Bank of Bharain and kuwait",
            "Bank of Baroda", "Bank of Baroda Corporate",
            "Bank of Baroda Retail", "Bank of India", "Bank of Maharashtra",
            "Canara Bank", "Catholic Syrian Bank", "Catholic Syrian Bank",
            "Central Bank", "CitiBank", "City Union Bank", "Corporation Bank",
            "Cosmos Co-op Bank", "DBC BANK LTD", "Dena Bank", "HDFC Bank", "ICICI Bank",
            "Indian Bank", "Kotak Bank", "State Bank Of India", "Syndicate Bank", "Vijaya Bank"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_banking);
        init();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {
        sbi.setOnClickListener(this);
        icici.setOnClickListener(this);
        axis.setOnClickListener(this);
        city.setOnClickListener(this);
        kotak.setOnClickListener(this);
        hdfc.setOnClickListener(this);
        selectBankLayout.setOnClickListener(this);
        netBankingPayBtn.setOnClickListener(this);
    }

    private void initViews() {
        bankTv = (TextView) findViewById(R.id.tv_bank);
        sbi = (ImageView) findViewById(R.id.img_sbi);
        icici = (ImageView) findViewById(R.id.img_icici);
        axis = (ImageView) findViewById(R.id.img_axis);
        city = (ImageView) findViewById(R.id.img_city_bank);
        kotak = (ImageView) findViewById(R.id.img_kotak_bank);
        hdfc = (ImageView) findViewById(R.id.img_hdfc);
        selectBankLayout = (LinearLayout) findViewById(R.id.layout_select_bank);
        netBankingPayBtn = (Button) findViewById(R.id.net_banking_pay_btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_sbi:
                bankTv.setText("State Bank Of India");
                break;
            case R.id.img_icici:
                bankTv.setText("ICICI Bank");
                break;
            case R.id.img_axis:
                bankTv.setText("Axis Bank");
                break;
            case R.id.img_hdfc:
                bankTv.setText("HDFC Bank");
                break;
            case R.id.img_city_bank:
                bankTv.setText("City Bank");
                break;
            case R.id.img_kotak_bank:
                bankTv.setText("Kotak Bank");
                break;
            case R.id.layout_select_bank:
                final Dialog dialog = new Dialog(NetBanking.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custome_dialog_list_view);
                dialog.show();
                ListView listView = (ListView) dialog.findViewById(R.id.custome_list_view);
                ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.custome_text_view_bank, banksName);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView temp = (TextView) view;
                        bankTv.setText(temp.getText().toString());
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.net_banking_pay_btn:
                Toast.makeText(NetBanking.this, "" + bankTv.getText().toString(), Toast.LENGTH_SHORT).show();
                break;

        }
    }

}
