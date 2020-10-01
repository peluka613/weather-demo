# weather-demo
Weather-demo with Spring Boot and H2 restful API

El objetivo de este reto es construir servicios API REST para proveer información metereológica
haciendo uso de Spring Boot.
REQUERIMIENTO DE NEGOCIO
Cada dato meteorológico es una entrada JSON con las siguientes claves:
id: ID único de los datos meteorológicos.
date: Fecha de registro de datos meteorológicos (formato yyyy-MM-dd)
location: Lugar para el que se registraron los datos meteorológicos. El location en sí es una
entrada JSON que consta de los siguientes campos:
◦ lat: Latitud (Máximo cuatro decimales) de la ubicación.
◦ lon: Longitud (Máximo cuatro decimales) de la ubicación.
◦ city: Nombre de la ciudad.
◦ state: Nombre del estado.
temperature: Array de 24 valores flotantes (hasta un decimal), que describe la temperatura por
hora (en F°) para la ubicación dada.
RESTful Endpoints
1. Agregar registros: El servicio debería poder agregar nuevos datos meteorológicos
mediante una solicitud POST en el endpoint /weather. El JSON se envía en el cuerpo de
la solicitud. Si ya existen datos meteorológicos con el mismo ID, el código de respuesta
HTTP debería ser un 400, de lo contrario, el código de respuesta debería ser 201.
2. Devolución de todos los registros: el servicio debería poder devolver un array JSON
de todos los datos meteorológicos mediante la solicitud GET en el endpoint /weather. El
código de respuesta HTTP debe ser 200. El array JSON debe clasificarse en orden
ascendente del ID de los datos meteorológicos.
3. Devolver los registros filtrados por fecha: El servicio debería poder devolver un array
JSON de todos los datos meteorológicos que están asociados con la fecha dada por
medio de una solicitud GET en el endpoint /weather?date= {date}. Si la fecha solicitada
no tiene registro, el código de respuesta HTTP debe ser 404; de lo contrario, el código
de respuesta debe ser 200. Los registros JSON debe clasificarse en orden ascendente
de ID de datos meteorológicos.
4. Eliminar de todos los registros: el servicio debería poder borrar todos los datos
meteorológicos mediante una petición DELETE al endpoint /eliminar. El código de
respuesta HTTP debe ser 200.
Ejemplo objeto json:
{
"id": 37892,
"date": "2020-09-15",
"location": {
"lat": 2.0223,
"lon": 2.3349,
"city": "Dallas",
"state": "Texas"
},
"temperature": [
30.0,
2.1,
11.2,
110.1,
21412.7,
1873.0,
182.9,
1821.2,
209.2,
39.2,
52.9,
2121.0,
240.3,
52.3,
344.1,
1023.2,
1241.2,
12.1,
124.4,
124.6,
18.6,
183.2,
224.9,
3423.3
]
}
CONDICIONES
Los registros deben ser guardados en una base de datos en memoria (tipo h2), así mismo
condición popular previamente la(s) tabla(s) creada(s) para que la aplicación sea capaz
inicialmente de retornar 5 registros.
Se sugiere crear test para probar las condiciones dadas de cada endpoint.
