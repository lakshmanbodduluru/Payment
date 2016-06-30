package admi.payment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Wallet extends AppCompatActivity implements View.OnClickListener {
    ImageView addMoney;
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        init();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {
        addMoney.setOnClickListener(this);
    }

    private void initViews() {
        addMoney = (ImageView) findViewById(R.id.add_money_img_view_btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_money_img_view_btn:
                for(int i=0;i<numbers.length;i++){
                    Toast.makeText(Wallet.this, ""+numbers[i], Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
