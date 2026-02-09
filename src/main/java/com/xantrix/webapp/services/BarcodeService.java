package com.xantrix.webapp.services;

import java.util.ArrayList;
import java.util.List;

import com.xantrix.webapp.entities.Barcode;

public class BarcodeService {
	
	List<Barcode> barcode = new ArrayList<Barcode>() {{
		add(new Barcode());
		add(new Barcode());
	}};
	
	public List<Barcode> getAllBarcode(){
		return barcode;
	}
	
	public Barcode getBarcodeById(String id) {
		return barcode
				.stream()
				.filter(i -> (i.getBarcode()) == id)
				.findFirst()
				.orElse(null);
	}
	
	public Barcode addBarcode(Barcode bar) {
		String newCode = String.valueOf(barcode.size() + 1);
		bar.setBarcode(newCode);
		barcode.add(bar);
		return bar;
	}
}
