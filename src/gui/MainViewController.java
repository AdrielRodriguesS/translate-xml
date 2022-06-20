package gui;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.services.ImportProducts;

public class MainViewController {
	
	@FXML
	private Button btSearchArchive;
	
	@FXML
	private TextField txtArchiveName;
	
	@FXML
	private Button btImport;
	
	@FXML
	public void onBtSearchArquiveAction(ActionEvent event){
		
		Stage parentStage = currentStage(event);
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File file = fileChooser.showOpenDialog(parentStage);
		
		if(file != null) {
			txtArchiveName.setText(file.getAbsolutePath());			
		}
	}
	
	@FXML
	public void onBtImportAction(){
		ImportProducts ip = new ImportProducts();
		ip.readFile(txtArchiveName);	
		}
	
	//return the stage to use in the FileChooser
	public static Stage currentStage(ActionEvent event) {
		return (Stage) ((Node) event.getSource()).getScene().getWindow();
	}
	
	public TextField getTxtArchiveName() {
		return txtArchiveName;
	}
	
}
