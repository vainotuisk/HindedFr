package com.example.hindedfr;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.hindedfr.R.id.Nutton;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class FrHinded extends Fragment {
	
	//globaalsed muutujad
	public static TextView keskmineTV;
	public static EditText hindedET;
	//private Button puhastaBtn;
	private String hinded;

	public FrHinded() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_fr_hinded, container, false);
		//--------
		keskmineTV = (TextView) view.findViewById(R.id.KeskminetextView);
		hindedET= (EditText) view.findViewById(R.id.HindededitText);
		hindedET.addTextChangedListener(hindedchangeListener);
       Button puhastaBtn = (Button) view.findViewById(Nutton);
        puhastaBtn.setOnClickListener(new Button.OnClickListener()
        {
                                          public void onClick(View view)
                                          {
                                              hindedET.setText("");
                                          }
                                      }
        );
		//--------
		return view;
	}
	
//	public void onClickBtn(View view)
//	{
//		Toast.makeText(getActivity().getApplicationContext(), "Vajutasid", Toast.LENGTH_LONG).show();
//	}
	private TextWatcher hindedchangeListener = new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			try {
				hinded= s.toString();
			}
			catch(Exception e)
			{
				hinded = "";
			}
			updateKeskmineHinne();
		}
		
		private void updateKeskmineHinne()
		{
			if (hinded.length()>0)
			{
				
				keskmineTV.setText(keskHinne());
				
			}
			else
			{
				keskmineTV.setText("");
			}
			
		}
/*
 *  Arvutab sümboli väärtuse
 *  @return - sümboli kood 1-6		
 */
		private int getVaartus(String taht)
		{
			 int vaartus=0;
			 
			 vaartus=taht.toLowerCase().codePointAt(0);
			return 103-vaartus;

		}

	/* Arvutab keskmise hinde
	 * 
	 * @return - keskmine hinne	
	 */
		private float aver()
		{
		int summa=0;
		
		for (int i=0;i<hinded.length();i++)
			{
			
				summa+=getVaartus(hinded.substring(i));
			
			}
		return (float)summa/hinded.length();
		}
		private String keskHinne()
		{
			int  ymardatud = Math.round(aver());
			if (ymardatud> 5)
			{return "A";}
			else if (ymardatud> 4)
			{return "B";}
			else if (ymardatud> 3)
			{return "C";}
			else if (ymardatud> 2)
			{return "D";}
			else if (ymardatud> 1)
			{return "E";}
			else if (ymardatud> 0)
			{return "F";}
			
			else {
				Toast.makeText(getActivity().getApplicationContext(),.getString(R.string.error_toast),Toast.LENGTH_SHORT).show();
				//( , ",Toast.LENGTH_LONG).show();
				return "Viga!";}
			
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
