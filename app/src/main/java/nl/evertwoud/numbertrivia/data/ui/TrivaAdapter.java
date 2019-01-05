package nl.evertwoud.numbertrivia.data.ui;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import nl.evertwoud.numbertrivia.base.BaseRecyclerAdapter;
import nl.evertwoud.numbertrivia.base.ViewWrapper;
import nl.evertwoud.numbertrivia.data.models.NumberQuote;

public class TrivaAdapter extends BaseRecyclerAdapter<NumberQuote,QuoteRow> {

    private Context mContext;

    public TrivaAdapter(Context pContext) {
        mContext = pContext;
    }

    @Override
    protected QuoteRow onCreateItemView(ViewGroup parent, int viewType) {
        return QuoteRow_.build(mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper<QuoteRow> holder, int position) {
        holder.getView().bind(getData().get(position));
    }
}
