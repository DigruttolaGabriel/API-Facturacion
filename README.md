# API-Facturacion

<p>
La presente documentación comenta la estructura del proyecto, detalla la estructura de la base de datos pedida, los datos existentes en la base de datos necesarios para poder probar los endpoints de la API, y las posibles llamadas realizables hacia la API (requests) y las posibles devoluciones de datos de la estas llamadas (responses). Además contiene la información necesaria para poder ejecutar la aplicación de forma local.
</p>
<hr>
<p>El proyecto está generado con Maven, utiliza Spring framework con anotaciones para la generación de servicios, repositorios, controllers, entidades, etc. y Hibernate para el mapeo del código Java con la base de datos y la base de datos está hospedada en MySQL Server.
</p>
Se encuentra dividido en las siguientes abstracciones:
<ul>
<li>Controllers ----> en ellos están desarrollados los endpoints consumibles para interactuar con la aplicación.</li>
<li>Enums ----> contiene los enumeradores definidos para mapear con datos parametrizados en la base de datos.</li>
<li>Mappers ----> son estructuras generadas para el mapeo de objetos, ya sean JSONs, models o responses.</li>
<li>Models ----> son las definiciones de las tablas generadas en la base de datos. Gracias a anotaciones de Spring y Hibernate la base de datos se genera a partir del código.</li>
<li>Repositories* ----> contienen los métodos y queries para acceder a datos o interactuar con la base de datos.</li>
<li>Responses ----> son las estructuras devueltas por las funciones de los controllers.</li>
<li>Services* ----> contiene los servicios (interfaces) y sus respectivas implementaciones. En ellos está desarrollado el negocio de la aplicación.</li>
</ul>
*Los repositories y services son generados a través de la inyección de dependencias proveída por Spring framework (con la anotación @Autowired)
<p>
Todas estas abstracciones están identificadas por las tablas generadas en la base de datos o por cada uno de los modelos.
</p>
<hr>
<p>
Existen dos bases de datos, ambas con las mismas tablas y definiciones. La diferencia entre ellas es el fin “api_facturacion” es la productiva y “api_facturacion_test” es la que contiene los datos de los tests generados en la aplicación (no modificar esta base de datos para no romper los tests).
</p>
Las tablas generadas son nombradas con el prefijo “tb” y cada palabra es separada con “_”. Las tablas son las siguientes:
<ul>
<li>tb_cargo ----> contiene los cargos asociados a una factura</li>
<li>tb_cargo_pago ----> contiene las relaciones entre los cargos y los pagos</li>
<li>tb_categoria_evento ----> contiene las categorías posibles de eventos</li>
<li>tb_evento ----> contiene los distintos eventos posibles</li>
<li>tb_factura ----> contiene las facturas mensuales de los usuarios</li>
<li>tb_moneda ----> contiene las cotizaciones de monedas</li>
<li>tb_pago ----> contiene los pagos de los usuarios</li>
<li>tb_usuario ----> contiene los usuarios registrados</li>
</ul>

<h5>
tb_cargo
</h5>
<table>
    
</table>
•	id_cargo – bigint(20) AI PK
•	estado – int(11)
•	fecha – datetime
•	total – doublé
•	id_evento – int(11) FK
•	id_factura – bigint(20) FK

















