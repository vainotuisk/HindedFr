package com.example.hindedfr;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class FrKeskmine extends Fragment {
	public static EditText maxpunneET;
	public static EditText punneET;
	public static TextView protsentTV;
	public static TextView hinneTV;
	private int punne;
	private int maxpunne;
	
	public FrKeskmine() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_fr_keskmine, container, false);
//		return inflater
//				.inflate(R.layout.fragment_fr_keskmine, container, false);
		maxpunneET= (EditText) view.findViewById(R.id.maxpunneSisend);
		punneET=(EditText) view.findViewById(R.id.punneSisend);
		protsentTV= (TextView) view.findViewById(R.id.protsentTxt);
		hinneTV= (TextView) view.findViewById(R.id.hinneTxt);
		punneET.addTextChangedListener(punnemuutuseListener);
		maxpunneET.addTextChangedListener(maxpunnemuutuseListener);
				return view;
	}
	private TextWatcher maxpunnemuutuseListener = new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			try {
				maxpunne = Integer.parseInt(s.toString());
				Log.d("omalog","Siin on maxpunne olemas: " + maxpunne);
			}
			catch(NumberFormatException e)
			{
				Log.d("omalog","Siin on maxpunne : " + s.toString());
				maxpunne =100;
			}
			updateProssa();
			updateHinne();
			
		}
		private void updateProssa()
		{
			int Punne; 
			try {Punne = Integer.parseInt(punneET.getText().toString());
			
			}
			catch(NumberFormatException e)
			{
				Punne =0;
			}
		if(maxpunne!=0)
		{
			double proTsent = (double )Punne *100d / (double) maxpunne;
			protsentTV.setText(String.format("%.02f", proTsent));
		}
//		else
//		{
//			Log.d("omalog","nulliga jagamine maxpunne osast!!!");
//		}
			
		}
		private void updateHinne()
		{
			String hindeTaht ="";
			double proTsent;
			try {
				proTsent = Double.parseDouble(protsentTV.getText().toString().replace(",","."));
			}
			catch(NumberFormatException e)
			{
//				Log.d("omalog","maxpunne viga: "+ e.getLocalizedMessage());
				proTsent =0.0;
			}
			
//			Log.d("omalog","HindearvutusOK " + proTsent);
			if (proTsent > 95)
			{
			hindeTaht="A"; 
			}
			else if (proTsent > 89){
				hindeTaht="B";
			}
			else if (proTsent > 75){
				hindeTaht="C";
			}
			else if (proTsent > 65){
				hindeTaht="D";
			}
			else if (proTsent > 49){
				hindeTaht="E";
			}
			else {
				hindeTaht="F";
			}
			hinneTV.setText(hindeTaht);
			
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
	};
	private TextWatcher punnemuutuseListener = new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
//			maxpunneET.setText("Proov");
			try {
				punne = Integer.parseInt(s.toString());
			}
			catch(NumberFormatException e)
			{
//				Log.d("omalog","punne viga: "+ e.getLocalizedMessage());
				punne =0;
			}
			updateProssa();
			updateHinne();
		}
		
		private void updateProssa()
		{
			int maxPunne;
			try
			{
			maxPunne= Integer.parseInt(maxpunneET.getText().toString());
			}
			catch (NumberFormatException e) {
				maxPunne=0;
			}
		if (maxPunne!=0)
		{
			double proTsent = (double )punne *100d / (double) maxPunne;
			protsentTV.setText(String.format("%.02f", proTsent));
		}
//		else
//		{
//			Log.d("omalog","nuliga jagamine punne osast");
//		}
		}
		
		private void updateHinne()
		{
			String hindeTaht ="";
			double proTsent;
			try {
				proTsent = Double.parseDouble(protsentTV.getText().toString().replace(",","."));
			}
			catch(NumberFormatException e)
			{
//				Log.d("omalog","maxpunne viga: "+ e.getLocalizedMessage());
				proTsent =0.0;
			}
			
//			Log.d("omalog","HindearvutusOK " + proTsent);
			if (proTsent > 95)
			{
			hindeTaht="A"; 
			}
			else if (proTsent > 89){
				hindeTaht="B";
			}
			else if (proTsent > 75){
				hindeTaht="C";
			}
			else if (proTsent > 65){
				hindeTaht="D";
			}
			else if (proTsent > 49){
				hindeTaht="E";
			}
			else {
				hindeTaht="F";
			}
			hinneTV.setText(hindeTaht);
				
		}
			
		
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
	};

}
