package model.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;
import gui.util.Alerts;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ExportProducts {

	public void createXml(TextField txtPathToSave, TextField txtNumber, TextField txtDescription) {

		List<Product> list = ImportProducts.getProductList();		

		String path = txtPathToSave.getText();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			
			String products = "";
			
			for (Product p : list) {
				products += "<ITEM CODIGO=\"" + p.getErpNumber() + "\">\n"
									+ "<QUANTIDADE>" + p.getQuantity() + "</QUANTIDADE>\n"
									+ "<ALMOXARIFADO>3</ALMOXARIFADO>\n"
								+ "</ITEM>\n";
			}
			
			String archieve = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
							+ "<FOCCOINTEGRADOR CHAVE_PRODUTO=\"6921835630\">\n"
								+ "<IMPORTACAO TIPO=\"ESTRUTURA\">\n"
									+ "<EMPRESA CNPJ=\"09553326000110\">\n"
										+ "<ITEM CODIGO=\"" + txtNumber.getText() + "\">\n"
										+	"<DESCRICAO>\"" + txtDescription.getText() + "\"</DESCRICAO>\n"
											+ "<ESTRUTURA>\n"
												+ products
											+ "</ESTRUTURA>\n"
										+ "</ITEM>\n"
									+ "</EMPRESA>\n"
								+ "</IMPORTACAO>\n"
							+ "</FOCCOINTEGRADOR>";

			bw.write(archieve);
			
			Alerts.showAlert("Success", null, "A new file was created!", AlertType.INFORMATION);

		} catch(IOException e) {
			Alerts.showAlert("ERROR", null, "Error to create a .xml file", AlertType.ERROR);
		}	
	}
}