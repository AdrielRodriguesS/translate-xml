package model.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import entities.Product;
import javafx.scene.control.TextField;

public class ExportProducts {

	public void createXml(TextField txtPathToSave, TextField txtNumber, TextField txtDescription) {

		List<Product> list = ImportProducts.getProductList();

		String path = txtPathToSave.getText();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
		
			String header = "<h1>\n" + txtNumber.getText() + "<\\h1>";
			
			bw.write(header);

		} catch(IOException e) {
			e.printStackTrace();
		}	
	}
}