package sourav.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvProduct;
    private ProductListAdapter adapter;
    private List<product> mProductList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProduct=(ListView) findViewById(R.id.Listview_product);
        mProductList= new ArrayList<>();
        mProductList.add(new product(1,"CobaltSS",4000000,"Chevrolet"));
        mProductList.add(new product(2,"Xseries",4000000,"BMW"));
        mProductList.add(new product(3,"YSeries",4000000,"BMW"));
        mProductList.add(new product(4,"C Class",4000000,"Mercedez"));
        mProductList.add(new product(5,"A4",4000000,"AUDI"));
        mProductList.add(new product(6,"X5",4000000,"AUDI"));
        mProductList.add(new product(7,"800",4000000,"Maruti"));
        mProductList.add(new product(8,"GT800",4000000,"NiSSAN"));

        mProductList.add(new product(9,"CobaltSS",4000000,"Chevrolet"));
        mProductList.add(new product(10,"Xseries",4000000,"BMW"));
        mProductList.add(new product(11,"YSeries",4000000,"BMW"));
        mProductList.add(new product(12,"C Class",4000000,"Mercedez"));
        mProductList.add(new product(13,"A4",4000000,"AUDI"));
        mProductList.add(new product(14,"X5",4000000,"AUDI"));
        mProductList.add(new product(15,"800",4000000,"Maruti"));
        mProductList.add(new product(16,"GT800",4000000,"NiSSAN"));

        mProductList.add(new product(21,"CobaltSS",4000000,"Chevrolet"));
        mProductList.add(new product(31,"Xseries",4000000,"BMW"));
        mProductList.add(new product(41,"YSeries",4000000,"BMW"));
        mProductList.add(new product(51,"C Class",4000000,"Mercedez"));
        mProductList.add(new product(61,"A4",4000000,"AUDI"));
        mProductList.add(new product(71,"X5",4000000,"AUDI"));
        mProductList.add(new product(81,"800",4000000,"Maruti"));
        mProductList.add(new product(91,"GT800",4000000,"NiSSAN"));

        mProductList.add(new product(101,"CobaltSS",4000000,"Chevrolet"));
        mProductList.add(new product(111,"Xseries",4000000,"BMW"));
        mProductList.add(new product(127,"YSeries",4000000,"BMW"));
        mProductList.add(new product(177,"C Class",4000000,"Mercedez"));
        mProductList.add(new product(1090,"A4",4000000,"AUDI"));
        mProductList.add(new product(18989,"X5",4000000,"AUDI"));
        mProductList.add(new product(177,"800",4000000,"Maruti"));
        mProductList.add(new product(18,"GT800",4000000,"NiSSAN"));

        mProductList.add(new product(16,"CobaltSS",4000000,"Chevrolet"));
        mProductList.add(new product(19,"Xseries",4000000,"BMW"));
        mProductList.add(new product(10,"YSeries",4000000,"BMW"));
        mProductList.add(new product(1999,"C Class",4000000,"Mercedez"));
        mProductList.add(new product(91,"A4",4000000,"AUDI"));
        mProductList.add(new product(901,"X5",4000000,"AUDI"));
        mProductList.add(new product(109,"800",4000000,"Maruti"));
        mProductList.add(new product(100,"GT800",4000000,"NiSSAN"));

        adapter= new ProductListAdapter(getApplicationContext(),mProductList);
        lvProduct.setAdapter(adapter);


    }
}
