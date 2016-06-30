package admi.payment;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MeterialButtons extends AppCompatActivity implements View.OnClickListener {
    Button debitBtn;
    Button creditBtn;
    Button netBankingBtn;
    Button walletBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meterial_buttons);
        init();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {
        debitBtn.setOnClickListener(this);
        creditBtn.setOnClickListener(this);
        netBankingBtn.setOnClickListener(this);
        walletBtn.setOnClickListener(this);

    }

    private void initViews() {
        debitBtn = (Button) findViewById(R.id.debit_btn);
        creditBtn = (Button) findViewById(R.id.credit_btn);
        netBankingBtn = (Button) findViewById(R.id.net_banking_btn);
        walletBtn = (Button) findViewById(R.id.wallet_btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.debit_btn:
                Intent debitIntent = new Intent(MeterialButtons.this, DebitCard.class);
                startActivity(debitIntent);
                break;
            case R.id.credit_btn:
                Intent creditIntent = new Intent(MeterialButtons.this, CreditCard.class);
                startActivity(creditIntent);
                break;
            case R.id.net_banking_btn:
                Intent netBankingIntent = new Intent(MeterialButtons.this, NetBanking.class);
                startActivity(netBankingIntent);
                break;
            case R.id.wallet_btn:
                Intent walletIntent = new Intent(MeterialButtons.this, Wallet.class);
                startActivity(walletIntent);
                break;
        }
    }
}

