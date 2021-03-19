package ru.dopegeek.currencyexchange;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.dopegeek.currencyexchange.response.OptionalResponse;
import ru.dopegeek.currencyexchange.response.ResponseModelCurrency;

import static ru.dopegeek.currencyexchange.CurrencyFactory.sCurrencyList;

public class CurrencyFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private CurrencyAdapter mCurrencyAdapter;
    private MenuItem mRefresh;
    private TextView mDateTextView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_currency, container,false);
        mRecyclerView = v.findViewById(R.id.currency_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                mRefresh = item;
                new DownloadingTask().execute();
                updateUI();
                return true;
                default: return super.onOptionsItemSelected(item);
    }}

    private class CurrencyHolder extends RecyclerView.ViewHolder{
        private final TextView mCharCode;
        private final TextView mNominal;
        private final TextView mName;
        private final TextView mValue;


        public CurrencyHolder(LayoutInflater inflater,ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_currency, parent, false));
            mCharCode = itemView.findViewById(R.id.charcode);
            mNominal = itemView.findViewById(R.id.nominal);
            mName = itemView.findViewById(R.id.name);
            mValue = itemView.findViewById(R.id.value);
        }

        public void bind(Currency currency){
            mCharCode.setText(currency.getCharCode());
            mNominal.setText(currency.getNominal()+"");
            mName.setText(currency.getName());
            mValue.setText(currency.getValue()+"");
                    }
    }

    private void updateUI() {
        CurrencyFactory curFab = CurrencyFactory.get(getActivity());
        List<Currency> currencyList = curFab.getCurrencyList();

        if (mCurrencyAdapter == null) {
            mCurrencyAdapter = new CurrencyAdapter(currencyList);
            mRecyclerView.setAdapter(mCurrencyAdapter);
        } else {
            mCurrencyAdapter.setValuteList(currencyList);
            mCurrencyAdapter.notifyDataSetChanged();
        }
    }


    public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyHolder>{
        private List<Currency> mCurrencyList;

        public CurrencyAdapter(List<Currency> currencyList){ mCurrencyList = currencyList;}

        @NonNull
        @Override
        public CurrencyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater =LayoutInflater.from(getActivity());
            return new CurrencyHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CurrencyHolder holder, int position) {
            Currency currency = mCurrencyList.get(position);
            holder.bind(currency);
        }

        public void setValuteList(List<Currency> currencyList){mCurrencyList = currencyList;}

        @Override
        public int getItemCount() {
            return mCurrencyList.size();
        }
    }

    private class DownloadingTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            OptionalResponse resp = CurrencyDownloader.getCurrency();
           ResponseModelCurrency[] currenciesModels = resp.get().getValute().getCurrenciesModels();
            sCurrencyList = new ArrayList<>();
            for (int i = 0; i< currenciesModels.length; i++){
                 if(currenciesModels[i]!=null) {
                     sCurrencyList.add(new Currency(currenciesModels[i]));
                 }
}
            CurrencyFactory.addCurrency();
             return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
                    }
    }

}
