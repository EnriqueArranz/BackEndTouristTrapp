La API de Tourist Trapp está diseñada para gestionar lugares de interés cultural y puntos de concentración turística en la ciudad de Barcelona. El objetivo principal es ayudar a descongestionar la ciudad, proporcionando información útil tanto a intermediarios (como hoteles, agencias de viaje y guías turísticos) como a los propios turistas que buscan comodidad y una mejor experiencia turística. 

Características
Gestión de Lugares de Interés Cultural: Permite crear, leer, actualizar y eliminar lugares de interés cultural.
Gestión de Puntos de Concentración Turística: Permite crear, leer, actualizar y eliminar puntos de concentración turística.
Cálculo de Proximidad: Calcula el porcentaje de proximidad entre un punto de interés y un lugar cultural.
Importación de Datos: Permite la importación de datos desde archivos CSV para ambos tipos de entidades.

Endpoints

Lugares de Interés Cultural

GET /api/culturalPlace: Obtiene todos los lugares de interés cultural.

GET /api/culturalPlace/{id}: Obtiene un lugar de interés cultural por su ID.

GET /api/culturalPlace/import: Importa lugares de interés cultural desde un archivo CSV.

GET /api/culturalPlace/proximity: Calcula el porcentaje de proximidad entre un punto de interés y los lugares culturales

Puntos de Concentración Turística

GET /api/turistConcentration: Obtiene todos los puntos de concentración turística.

GET /api/turistConcentration/{id}: Obtiene un punto de concentración turística por su ID.

GET /api/turistConcentration/import: Importa puntos de concentración turística desde un archivo CSV.

GET /api/turistConcentration/proximity: Calcula el porcentaje de proximidad entre un punto de interés y los puntos de concentración turística.

Instalación

Clona el repositorio:  <pre>git clone https://github.com/audiochemist/Tourist_Trapp.git cd Tourist_Trapp </pre>

Configura la base de datos en el archivo src/main/resources/application.properties:  <pre>spring.datasource.url=jdbc:mysql://localhost:3306/touristdb spring.datasource.username=root spring.datasource.password=root </pre>
Ejecuta la aplicación:  <pre>mvn spring-boot:run </pre>

Uso
Importación de Datos
Para importar datos desde archivos CSV, asegúrate de que los archivos culturalPlace.csv y turistConcentration.csv estén ubicados en el directorio src/main/resources.
