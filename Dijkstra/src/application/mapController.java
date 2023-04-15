package application;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class mapController {

	@FXML
	public AnchorPane root;

	@FXML
	public Button run;

	@FXML
	public TextArea path;

	@FXML
	public TextField Distance;

	@FXML
	public ChoiceBox<String> sourceCity1;
	@FXML
	public ChoiceBox<String> targetCity2;

	@FXML
	public Group circles;
	int count = 0;
	int runcount = 0;
	Table table = new Table();

	public void initialize() {
		table.setGraph("src\\application\\cities.txt");
		sourceCity1.getItems().addAll("Budrus", "Qibya", "Shuqba", "Nili", "Aboud", "Dayr Abu Mash'al", "Na'ale",
				"Nabi Saleh", "Halamish", "Deir Nidham", "Baytillu", "Deir 'Ammar", "Nahliel", "Mazra'a al-Qibliya",
				"Talmon", "Dolev", "Ein Qiniya", "Ein Arik", "Beitunia", "Ras Karkar", "Kafr Ni'ma", "Bil'in",
				"Modi'in Ilit", "Shilat", "Lapid", "Modi'in Makabim-Re'ut", "Bayt Sira", "Kharabtha al-Misbah",
				"Bayt Liqya", "Beit Ur al-Tahta", "Beit Horon", "Tira", "Kafr 'Aqab", "Kokhav Ya'akov", "Psagot",
				"Ramallah", "Al-Bireh", "Baytin", "Beit El", "Surda", "Jalazone", "Kaubar", "Abu Shukhaydam",
				"Ein Sinya", "Birzeit", "Atara", "Ateret", "Umm Safa", "Ajul", "Khirbat Abu Falah",
				"Al-Mazra'a ash-Sharqiya", "Kafr Malik", "Silwad", "Dayr Jarir", "Ofra", "Ofra", "Ramun", "Dayr Dibwan",
				"Ma'ale Michmash", "Mukhmas", "Rimonim", "Kohav HaShahar", "Mughayir");

		targetCity2.getItems().addAll("Budrus", "Qibya", "Shuqba", "Nili", "Aboud", "Dayr Abu Mash'al", "Na'ale",
				"Nabi Saleh", "Halamish", "Deir Nidham", "Baytillu", "Deir 'Ammar", "Nahliel", "Mazra'a al-Qibliya",
				"Talmon", "Dolev", "Ein Qiniya", "Ein Arik", "Beitunia", "Ras Karkar", "Kafr Ni'ma", "Bil'in",
				"Modi'in Ilit", "Shilat", "Lapid", "Modi'in Makabim-Re'ut", "Bayt Sira", "Kharabtha al-Misbah",
				"Bayt Liqya", "Beit Ur al-Tahta", "Beit Horon", "Tira", "Kafr 'Aqab", "Kokhav Ya'akov", "Psagot",
				"Ramallah", "Al-Bireh", "Baytin", "Beit El", "Surda", "Jalazone", "Kaubar", "Abu Shukhaydam",
				"Ein Sinya", "Birzeit", "Atara", "Ateret", "Umm Safa", "Ajul", "Khirbat Abu Falah",
				"Al-Mazra'a ash-Sharqiya", "Kafr Malik", "Silwad", "Dayr Jarir", "Ofra", "Ofra", "Ramun", "Dayr Dibwan",
				"Ma'ale Michmash", "Mukhmas", "Rimonim", "Kohav HaShahar", "Mughayir");

		// cs = new Circle[table.graph.length];
		for (int i = 0; i < table.graph.length; i++) {

			Circle cs = new Circle(table.graph[i].source.x, table.graph[i].source.y, 3.5, Color.RED);
			cs.setAccessibleText(table.graph[i].source.name);

			cs.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					if (count == 0) {
						sourceCity1.setValue(cs.getAccessibleText());
						count++;
					} else if (count == 1) {
						targetCity2.setValue(cs.getAccessibleText());
						count++;
					} else if (count == 2) {
						count = 0;
						sourceCity1.setValue(cs.getAccessibleText());
						count++;
					}
				}
			});
			root.getChildren().add(cs);
		}

	}

	@FXML
	public void Run(ActionEvent event) {
		
		int source = -1;
		int target = -1;
		// String target = targetCity2.getValue();
		for (int i = 0; i < table.graph.length; i++) {
			if (sourceCity1.getValue().compareTo(table.graph[i].source.name) == 0) {
				source = i;
				System.out.println(i);
			}
			if (targetCity2.getValue().compareTo(table.graph[i].source.name) == 0) {
				target = i;
				System.out.println(i);
			}
			if (source != -1 && target != -1)
				break;
		}
		table.dijkstra(source, target);
		table.getVertix(source, target);
		Distance.setText(table.graph[target].source.pathFromSource + "");
		int si = table.edge.size();
		//String p = "";
		int m = 0;
		Line line2;
		while (m < si - 1) {
			
				line2 = new Line(table.edge.get(m).x, table.edge.get(m).y, table.edge.get(m + 1).x,
						table.edge.get(m + 1).y);
				line2.setStrokeWidth(3);
				// printing path in text area
				/// p+=table.edge.get(m).name+"<-";
				// path.appendText(p);
				line2.setStroke(Color.RED);

				root.getChildren().add(line2);

				m++;
			 
		}
		
		
	}

	@FXML
	public void set(MouseEvent event) {

	}

}
