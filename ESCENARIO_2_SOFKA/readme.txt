Buen día ejecutor del test, a continuación te dare unos pasos escenciales para la compilación exitosa del siguente
escenario

Puedes realizar la ejecución del escenario (hay otras opciones pero no se agregaron al proyecto):

1. Ubicar el archivo compilar.bat de la ruta <TU_UBICACION_DE_DESCARGA>\ESCENARIO_2_SOFKA\compilar.bat
2. Doble clic y dejar que se ejecute

Para visualizar el reporte de la prueba ubique la carpeta <TU_UBICACION_DE_DESCARGA>\ESCENARIO_2_SOFKA\target\site\serenity\index.html
y abralo en un navegador google preferiblemente, y navegue en el para visualizar el resultado de las pruebas

Si desea realizar cambios a la prueba, ubique <TU_UBICACION_DE_DESCARGA>\ESCENARIO_2_SOFKA\src\test\resources\features\swagger.feature
Recomendaciones:
    - El step "se envian los datos <username>, <firstName>, <lastName>, <email>" cuenta con una tabla de datos de la
      fila 18 en adelante, agregue o elimine filas como desee, conservando el formato de cada columna
    - En step "se obtiene code "200"", puede cambiar el valor 200 por otro numero de codigo
    - En step "se editan los datos <set> del registro buscado por <values>", al igual que la primera recomendación, cuenta con una tabla;
      mantenga el formato de los datos allí recopilados, no olvidar la coma (,) como separador de la columna Set.