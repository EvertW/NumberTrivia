package nl.evertwoud.numbertrivia.data.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import nl.evertwoud.numbertrivia.R;
import nl.evertwoud.numbertrivia.data.models.NumberQuote;
import nl.evertwoud.numbertrivia.data.network.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.trivia_recycler)
    RecyclerView recycler;
    TrivaAdapter trivaAdapter;
    ArrayList<NumberQuote> quoteList = new ArrayList<>();

    @AfterViews
    void init() {
        trivaAdapter = new TrivaAdapter(this);
        trivaAdapter.setItems(quoteList);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setAdapter(trivaAdapter);

        requestData();
    }

    @Click(R.id.add_button)
    void addNumber(){
        requestData();
    }

    private void requestData() {
        APIService service = APIService.retrofit.create(APIService.class);
        Random r = new Random();
        int number = r.nextInt(300);
        String trivia = "trivia";

        /**
         * Make an a-synchronous call by enqueing and definition of callbacks.
         */

        Call<NumberQuote> call = service.getQuote(number, trivia);
        call.enqueue(new Callback<NumberQuote>() {
            @Override
            public void onResponse(Call<NumberQuote> call, Response<NumberQuote> response) {
                NumberQuote quote = response.body();
                quoteList.add(quote);
                trivaAdapter.setItems(quoteList);
                trivaAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NumberQuote> call, Throwable t) {
                Log.d("error", t.toString());

            }

        });

    }
}
