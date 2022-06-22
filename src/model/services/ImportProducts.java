package model.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;
import gui.MainViewController;
import gui.util.Alerts;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ImportProducts {
	
	private static List<Product> products = new ArrayList<>();	

	public void readFile(TextField txtArchiveName) {	
			
			try (BufferedReader br = new BufferedReader(new FileReader(txtArchiveName.getText()))){
				
				String line = br.readLine();
				
				while (line != null) {
					
					String[] fields = line.split(",");
					Double qtd = Double.parseDouble(fields[1]);
					Integer erpNumber = Integer.parseInt(fields[2]);
					
					products.add(new Product(qtd, erpNumber));
					line = br.readLine();
				}
				
				Alerts.showAlert("Import .csv file", null, 
						"Success to Import!\nWas imported " + products.size() + " products!", AlertType.INFORMATION);
				
			} catch (IOException e) {
				Alerts.showAlert("ERROR!", null, "Error to import .csv file", AlertType.ERROR);
			}		
	}
	
	public static List<Product> getProductList() {
		return products;
	}
	
}