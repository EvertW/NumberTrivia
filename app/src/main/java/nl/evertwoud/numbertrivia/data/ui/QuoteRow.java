package nl.evertwoud.numbertrivia.data.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import nl.evertwoud.numbertrivia.R;
import nl.evertwoud.numbertrivia.data.models.NumberQuote;

@EViewGroup(R.layout.view_quote)
public class QuoteRow extends FrameLayout {

    @ViewById(R.id.quote_number)
    TextView number;

    @ViewById(R.id.quote_text)
    TextView text;

    public QuoteRow(Context context) {
        super(context);
    }

    public QuoteRow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QuoteRow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    void bind(NumberQuote quote){
        number.setText(String.valueOf(quote.getNumber()));
        text.setText(quote.getText());
    }
}
