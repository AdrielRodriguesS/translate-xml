package gui;

import java.io.File;

import javax.swing.JFileChooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.services.ExportProducts;
import model.services.ImportProducts;

public class MainViewController {
	
	@FXML
	private Button btSearchArchive;
	
	@FXML
	private TextField txtArchiveName;
	
	@FXML
	private Button btImport;
	
	@FXML
	private TextField txtNumber;
	
	@FXML
	private TextField txtDescription;
	
	@FXML
	private TextField txtPathToSave;
	
	@FXML
	private Button btSearchPath;
	
	@FXML
	private Button btCreateXml;	
	
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
	
	@FXML
	public void onBtSearchPathAction() {
				
		final JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(fc);
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		File file = fc.getSelectedFile();
		
		if(file != null) {		
		txtPathToSave.setText(file.getAbsolutePath());
		}
	}
	
	@FXML
	public void onBtCreateXmlAction() {
		ExportProducts ep = new ExportProducts();
		ep.createXml(txtPathToSave, txtNumber, txtDescription);
	}
	
	//return the stage to use in the FileChooser
	public static Stage currentStage(ActionEvent event) {
		return (Stage) ((Node) event.getSource()).getScene().getWindow();
	}
	
	public TextField getTxtArchiveName() {
		return txtArchiveName;
	}
	
}
