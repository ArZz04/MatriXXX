package com.arzz.matrices.matrices;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MatrixController {

    @FXML
    private TextField input1Columns;

    @FXML
    private TextField input1Rows;

    @FXML
    private TextField input2Columns;

    @FXML
    private TextField input2Rows;

    @FXML
    private HBox mainHBox;

    @FXML
    private MenuButton operationMenuButton;

    private VBox outputMatrix;

    @FXML
    private Button generateButton;

    @FXML
    private void handleOperationSelect(ActionEvent event) {
        // Obtenemos el elemento que fue seleccionado
        MenuItem selectedItem = (MenuItem) event.getSource();

        // Actualizamos el texto del MenuButton con el texto de la operación seleccionada
        operationMenuButton.setText(selectedItem.getText());
    }

    @FXML
    private void handleGenerate(ActionEvent event) {

        // Leer los valores ingresados por el usuario para INPUT 1 y INPUT 2
        int rows1 = Integer.parseInt(input1Rows.getText());
        int cols1 = Integer.parseInt(input1Columns.getText());
        int rows2 = Integer.parseInt(input2Rows.getText());
        int cols2 = Integer.parseInt(input2Columns.getText());

        // Verificar si alguna de las dimensiones es mayor a 15
        if (rows1 > 6 || cols1 > 6 || rows2 > 6 || cols2 > 6) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error en la entrada");
            alert.setContentText("Por favor, ingrese un número válido (las dimensiones no pueden ser mayores a 15).");
            alert.showAndWait();
            return;  // Salir del método si hay un error
        }

        String selectedOperation = operationMenuButton.getText();

        if (selectedOperation.contains("SELECCIONE")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error en la entrada");
            alert.setContentText("Por favor, seleccione una operación.");
            alert.showAndWait();
            return;  // Salir del método si hay un error
        }

        System.out.println("Operación seleccionada: " + selectedOperation);

        // Crear los VBox para las matrices
        VBox matrix1 = createMatrix("Matriz 1", rows1, cols1);
        VBox matrix2 = createMatrix("Matriz 2", rows2, cols2);

        // Crear un VBox para la matriz de resultados
        outputMatrix = new VBox(10);  // Espaciado de 10 unidades entre los elementos
        outputMatrix.setStyle("-fx-background-color: #e8e8e8; -fx-background-radius: 5; -fx-padding: 10;");
        // Título del VBox
        Label title = new Label("Matriz Resultado");
        title.setStyle("-fx-font-size: 14px;");
        outputMatrix.getChildren().add(title);  // Agregar el título al VBox

        // Limpiar el contenido anterior del HBox
        mainHBox.getChildren().clear();

        // Agregar las nuevas matrices al HBox
        mainHBox.getChildren().addAll(matrix1, matrix2, outputMatrix);

        // Agregar botón de "CALCULAR" solo en el VBox del resultado
        Button calculateButton = new Button("CALCULAR");
        calculateButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        outputMatrix.getChildren().add(calculateButton);

        // Evento para calcular
        calculateButton.setOnAction(this::handleCalculate);
    }

    // Método para crear una tabla o matriz en un VBox
    private VBox createMatrix(String title, int rows, int cols) {
        VBox matrixVBox = new VBox(10);
        matrixVBox.setStyle("-fx-background-color: #e8e8e8; -fx-background-radius: 5; -fx-padding: 10;");

        // Título del VBox (nombre de la matriz)
        matrixVBox.getChildren().add(new javafx.scene.control.Label(title));

        // Crear GridPane para la matriz
        GridPane matrixGrid = new GridPane();
        matrixGrid.setHgap(5);
        matrixGrid.setVgap(5);

        // Llenar el GridPane con campos de texto vacíos
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                TextField textField = new TextField();
                textField.setPrefWidth(50);  // Ajusta el tamaño de las celdas si es necesario
                matrixGrid.add(textField, col, row);
            }
        }

        matrixVBox.getChildren().add(matrixGrid);
        return matrixVBox;
    }

    // Método para manejar el cálculo (placeholder)
    private void handleCalculate(ActionEvent event) {
        // Obtén las matrices de entrada
        int[][] matriz1 = obtenerMatriz(input1Rows.getText(), input1Columns.getText());
        int[][] matriz2 = obtenerMatriz(input2Rows.getText(), input2Columns.getText());

        // Obtén la operación seleccionada
        String operacion = operationMenuButton.getText();

        int[][] resultado = null;

        switch (operacion) {
            case "SUMA":
                resultado = ArithmeticFunctions.sumaMatrices(matriz1, matriz2);
                break;
            case "RESTA":
                resultado = ArithmeticFunctions.restaMatrices(matriz1, matriz2);
                break;
            case "MULTIPLICACION":
                resultado = ArithmeticFunctions.multiplicacionMatrices(matriz1, matriz2);
                break;
            case "DIVISION":
                // Aquí implementas la lógica para la división si fuera necesario
                break;
            default:
                System.out.println("Operación no soportada");
                return;
        }

        // Aquí puedes mostrar el resultado o hacer lo que necesites con la matriz resultado
        mostrarResultado(resultado);
    }

    // Método para obtener las matrices de los campos de texto
    private int[][] obtenerMatriz(String filasText, String columnasText) {
        int filas = Integer.parseInt(filasText);
        int columnas = Integer.parseInt(columnasText);
        int[][] matriz = new int[filas][columnas];

        // Aquí deberías leer los valores de la matriz que el usuario ha ingresado (puedes hacerlo con campos de texto o de otra forma)

        return matriz;
    }

    // Método para mostrar el resultado
    private void mostrarResultado(int[][] resultado) {

        // Aquí puedes mostrar el resultado en la matriz de resultado
        // Por ejemplo, puedes recorrer la matriz y mostrar los valores en los campos de texto correspondientes



    }
}
