package model.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;
import gui.MainViewController;
import javafx.scene.control.TextField;

public class ImportProducts {	

	public void readFile(TextField txtArchiveName) {
		
		List<Product> products = new ArrayList<>();		
			
			try (BufferedReader br = new BufferedReader(new FileReader(txtArchiveName.getText()))){
				
				String line = br.readLine();
				
				while (line != null) {
					
					String[] fields = line.split(",");
					Double qtd = Double.parseDouble(fields[1]);
					Integer erpNumber = Integer.parseInt(fields[2]);
					
					products.add(new Product(qtd, erpNumber));
					line = br.readLine();
				}
				
			} catch (IOException e) {
					System.out.println("Error reading file: " + e.getMessage());
			}
		
		for(Product p : products) {
		System.out.println(p);
		}	
	}	
	
}