package gui;

import java.io.IOException;
import java.util.List;

import entities.Departamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.DepartamentoService;

public class DepartamentoListController {

	private DepartamentoService service;

	@FXML
	private TableView<Departamento> tableViewDepartamento;

	@FXML
	private TableColumn<Departamento, Integer> tableColumId;

	@FXML
	private TableColumn<Departamento, Integer> tableColumName;

	@FXML
	private Button btNovo;
	
	private ObservableList<Departamento> obsList;

	public void setDepartamentoService(DepartamentoService service) {
		this.service = service;
	}

	@FXML
	public void onBtNewAction(ActionEvent event) {
		Stage parentStage = gui.util.Utils.currentStage(event);
		createDialogForm("/gui/DepartamentoForm.fxml", parentStage);
	}

	public void updateTableView() {
		if (service == null) {
			throw new  IllegalStateException("Bagaça nula");
		}
		List<Departamento> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartamento.setItems(obsList);

	}

	private void createDialogForm(String nomeAbsoluto, Stage parentStage) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeAbsoluto));

			Pane pane = loader.load();

			Stage dialogStage = new Stage();

			dialogStage.setTitle("Cadasto de Departamento");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
}
