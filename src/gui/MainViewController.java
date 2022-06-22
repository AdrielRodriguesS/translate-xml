package gui;

import java.io.File;

import javax.swing.JFileChooser;

import gui.util.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
	private Label txtArchiveNameEmpty;
	
	@FXML
	private Label txtPathToSaveEmpty;
	
	@FXML
	public void onBtSearchArquiveAction(ActionEvent event){
		
		Stage parentStage = currentStage(event);
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File file = fileChooser.showOpenDialog(parentStage);
		
		if(file != null) {
			txtArchiveName.setText(file.getAbsolutePath());
			txtArchiveNameEmpty.setText("");
		}
	}
	
	@FXML
	public void onBtImportAction(){
		
		if(txtArchiveName.getText() == null || txtArchiveName.getText().trim().equals("")) {			
		
			txtArchiveNameEmpty.setText("Field can't be Empty!!");	
		}
		else {
			ImportProducts ip = new ImportProducts();
			ip.readFile(txtArchiveName);
			txtArchiveNameEmpty.setText("");
		}
	}
	
	@FXML
	public void onBtSearchPathAction() {
				
		final JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(fc);
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		File file = fc.getSelectedFile();
		
		if(file != null) {		
		txtPathToSave.setText(file.getAbsolutePath());
		txtPathToSaveEmpty.setText("");
		}
	}
	
	@FXML
	public void onBtCreateXmlAction() {
		
		if(txtPathToSave.getText() == null || txtPathToSave.getText().trim().equals("")) {		
			
			txtPathToSaveEmpty.setText("Field can't be Empty!!");	
		}		
		else {		
			ExportProducts ep = new ExportProducts();
			ep.createXml(txtPathToSave, txtNumber, txtDescription);
			txtPathToSaveEmpty.setText("");			
		}
	}
	
	//return the stage to use in the FileChooser
	public static Stage currentStage(ActionEvent event) {
		return (Stage) ((Node) event.getSource()).getScene().getWindow();
	}
	
	public TextField getTxtArchiveName() {
		return txtArchiveName;
	}
	
}
