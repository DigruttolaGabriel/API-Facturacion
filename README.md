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
    <tr>
        <th>Columna</th>
        <th>Configuración</th>
    </tr>
    <tr>
        <td>id_cargo</td>
        <td>bigint(20) AI PK</td>
    </tr>
<tr>
<td>estado</td>
<td>int(11)</td>
</tr>
<tr>
<td>fecha</td>
<td>datetime</td>
</tr>
<tr>
<td>total</td>
<td>double</td>
</tr>
<tr>
<td>id_evento</td>
<td>int(11) FK</td>
</tr>
<tr>
<td>id_factura</td>
<td>bigint(20) FK</td>
</tr>
</table>
<h5>
tb_cargo_pago
</h5>
<table>
    <tr>
        <th>Columna</th>
        <th>Configuración</th>
    </tr>
    <tr>
        <td>id_cargo_pago</td>
        <td>bigint(20) AI PK</td>
    </tr>
<tr>
<td>monto_asociado</td>
<td>doublé</td>
</tr>
<tr>
    <td>id_cargo</td>
    <td>bigint(20) FK</td>
</tr>
    <tr>
        <td>id_pago</td>
        <td>bigint(20) FK</td>
    </tr>

</table>
<h5>
tb_categoria_evento
</h5>
<table>
    <tr>
        <th>Columna</th>
        <th>Configuración</th>
    </tr>
    <tr>
            <td>id_categoria_evento</td>
        <td>int(11) AI PK</td>
    </tr>
        <tr>
                <td>nombre</td>
            <td>varchar</td>
        </tr>
</table>
<h5>
tb_evento
</h5>
<table>
    <tr>
        <th>Columna</th>
        <th>Configuración</th>
    </tr>
    <tr>
        <td>id_evento</td>
        <td>int(11) AI PK</td>
    </tr>
        <tr>
            <td>nombre</td>
            <td>varchar</td>
        </tr>
            <tr>
                <td>id_categoria_evento</td>
                <td>int(11) FK</td>
            </tr>
</table>
<h5>
tb_factura
</h5>
<table>
    <tr>
        <th>Columna</th>
        <th>Configuración</th>
    </tr>
    <tr>
        <td>id_factura</td>        
        <td>bigint(20) AI PK</td>
    </tr>
        <tr>
            <td>fecha_facturacion</td>        
            <td>date</td>
        </tr>
            <tr>
                <td>id_usuario</td>        
                <td>bigint(20) FK</td>
            </tr>
</table>
<h5>
tb_moneda
</h5>
<table>
    <tr>
        <th>Columna</th>
        <th>Configuración</th>
    </tr>
    <tr>
        <td>id_moneda</td>
        <td>int(11) PK</td>
    </tr>
        <tr>
            <td>nombre</td>
            <td>varchar</td>
        </tr>
            <tr>
                <td>valor</td>
                <td>double</td>
            </tr>
</table>
<h5>
tb_pago
</h5>
<table>
    <tr>
        <th>Columna</th>
        <th>Configuración</th>
    </tr>
    <tr>
        <td>id_pago</td>
        <td>bigint(20) AI PK</td>
    </tr>
        <tr>
            <td>fecha</td>
            <td>datetime</td>
        </tr>
            <tr>
                <td>monto</td>
                <td>doublé</td>
            </tr>
</table>
<h5>
tb_usuario
</h5>
<table>
    <tr>
        <th>Columna</th>
        <th>Configuración</th>
    </tr>
    <tr>
        <td>id_usuario</td>
        <td>bigint(20) AI PK</td>
    </tr>
        <tr>
            <td>apellido</td>
            <td>varchar</td>
        </tr>
            <tr>
                <td>email</td>
                <td>varchar</td>
            </tr>
                <tr>
                    <td>fecha_alta</td>
                    <td>datetime</td>
                </tr>
                    <tr>
                        <td>nombre</td>
                        <td>varchar</td>
                    </tr>
</table>
<hr>
Usuarios existentes en base de datos:
<table>
    <tr>
        <th>id_usuario</th>
        <th>apellido</th>
        <th>email</th>
        <th>fecha_alta</th>
        <th>nombre</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Smith</td>
        <td>msmith@gmail.com</td>
        <td>2017-10-05 12:24:34</td>
        <td>Mario</td>
    </tr>
    <tr>
        <td>2</td>
        <td>López</td>
        <td>jlopez@gmail.com</td>
        <td>2018-12-07 16:34:40</td>
        <td>Jorge</td>
    </tr>
    <tr>
         <td>3</td>
         <td>Perlo</td>
         <td>aperlo@gmail.com</td>
         <td>2019-01-27 21:42:15</td>
         <td>Antonio</td>
     </tr>
     <tr>
         <td>4</td>
         <td>Risco</td>
         <td>orisco@gmail.com</td>
         <td>2019-04-12 04:50:31</td>
         <td>Omar</td>
     </tr>
</table>
Monedas existentes en base de datos:
<table>
    <tr>
        <th>id_moneda</th>
        <th>nombre</th>
        <th>valor</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Peso Argentino</td>
        <td>1</td>
    </tr>
    <tr>
        <td>2</td>
        <td>Dólar</td>
        <td>60</td>
    </tr>
</table>
Eventos existentes en base de datos:
<table>
    <tr>
        <th>id_evento</th>
        <th>nombre</th>
        <th>id_categoria_evento</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Clasificado</td>
        <td>1</td>
    </tr>
    <tr>
        <td>2</td>
        <td>Venta</td>
        <td>1</td>
    </tr>
    <tr>
        <td>3</td>
        <td>Publicidad</td>
        <td>2</td>
    </tr>
    <tr>
        <td>4</td>
        <td>Envío</td>
        <td>1</td>
    </tr>
    <tr>
        <td>5</td>
        <td>Crédito</td>
        <td>2</td>
    </tr>
    <tr>
        <td>6</td>
        <td>MercadoPago</td>
        <td>3</td>
    </tr>
    <tr>
        <td>7</td>
        <td>MercadoShop</td>
        <td>3</td>
    </tr>
    <tr>
        <td>8</td>
        <td>Fidelidad</td>
        <td>2</td>
    </tr>
</table>
Categorías existentes en base de datos:
<table>
    <tr>
        <th>id_categoria_evento</th>
        <th>nombre</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Market Place</td>
    </tr>
    <tr>
        <td>2</td>
        <td>Servicios</td>
    </tr>
    <tr>
        <td>3</td>
        <td>Externo</td>
    </tr>
</table>

<hr>
<h3>Requests</h3>
<p>
<strong>POST /api/cargos/generarCargo</strong>
<br>
Recibe un JSON en el body con el siguiente formato:
<br>
{<br>
	“event_type”: tipo de evento (String),<br>
	“user_id”: ID del usuario en la base de datos (long),<br>
	“amount”: total del cargo (double),<br>
	“currency”: moneda (String),<br>
	“date”: fecha de generación del evento (date)<br>
}<br>
Devuelve un HttpStatus.OK y un String con el mensaje (resultado) de lo sucedido internamente, o un HttpStatus.CONFLICT y un String con el mensaje (resultado) con el error sucedido cuando ocurre una excepción.
</p>
<br>
<p>
<strong>GET /api/cargos/getCargos</strong><br>
Recibe el parámetro “idUsuario” (long) con el valor del ID del usuario del que se quieren obtener datos.<br>
Devuelve un HttpStatus.OK y un JSON array con los cargos relacionados al usuario con el siguiente formato:<br>
{<br>
	“idCargo”: ID del cargo en la base de datos (long),<br>
	“fechaCargo”: fecha de generación del cargo (date),<br>
	“total”: total del cargo (double),<br>
	“evento”: tipo de evento (String),<br>
	“estado”: estado del cargo (String)<br>
}<br>
O un HttpStatus.CONFLICT y un String con el mensaje con el error sucedido cuando ocurre una excepción.
</p>
<br>
<p>
<strong>GET  /api/facturas/getFacturas/porFecha</strong><br>
Recibe los parámetros “mes” (int) con el valor del mes y “anio” con el valor del año que se desean consultar.<br>
Devuelve un HttpStatus.OK y un JSON array con las facturas con el filtro aplicado con el siguiente formato:<br>
{<br>
	“idFactura”: ID de la factura en la base de datos (long),<br>
	“fechaFactura”: fecha de generación de la factura (date),<br>
	“totalFactura”: total de la factura (double),<br>
	“deudaFactura”: total que se debe de la factura (double),<br>
	“usuarioResponse”: usuario al que corresponde la factura con sus respectivos datos (UsuarioResponse)<br>
}<br>
O un HttpStatus.CONFLICT y un String con el mensaje con el error sucedido cuando ocurre una excepción.
</p>
<br>
<p>
<strong>GET  /api/facturas/getFacturas/porUsuario</strong><br>
Recibe el parámetro “idUsuario” (long) con el valor del ID del usuario del que se quieren obtener datos.<br>
Devuelve un HttpStatus.OK y un JSON array con las facturas del usuario pedido con el siguiente formato:<br>
{<br>
	“idFactura”: ID de la factura en la base de datos (long),<br>
	“fechaFactura”: fecha de generación de la factura (date),<br>
	“totalFactura”: total de la factura (double),<br>
	“deudaFactura”: deuda total de la factura (double),<br>
	“usuarioResponse”: usuario al que corresponde la factura con sus respectivos datos (UsuarioResponse)<br>
}<br>
O un HttpStatus.CONFLICT y un String con el mensaje con el error sucedido cuando ocurre una excepción.
</p>
<br>
<p>
<strong>POST  /api/pagos/generarPago</strong><br>
Recibe un JSON en el body con el siguiente formato:<br>
{<br>
	“user_id”: ID del usuario en la base de datos (long),<br>
	“amount”: monto a pagar (double),<br>
	“currency”: moneda (String)<br>
}<br>
Devuelve un HttpStatus.OK y un String con el mensaje de lo sucedido internamente, o un HttpStatus.CONFLICT y un String con el mensaje con el error sucedido cuando ocurre una excepción.
</p>
<br>
<p>
<strong>GET  /api/pagos/getPagos</strong><br>
Recibe el parámetro “idUsuario” (long) con el valor del ID del usuario del que se quieren obtener datos.<br>
Devuelve un HttpStatus.OK y un JSON array con los pagos generados para el usuario pedido con el siguiente formato:<br>
{<br>
	“idPago”: ID del pago en la base de datos (long),<br>
	“monto”: total del pago (date),<br>
	“fechaPago”: fecha de generación del pago (date)<br>
}<br>
O un HttpStatus.CONFLICT y un String con el mensaje con el error sucedido cuando ocurre una excepción.
</p>
<br>
<p>
<strong>GET  /api/usuarios/getEstadoUsuario</strong><br>
Recibe el parámetro “idUsuario” (long) con el valor del ID del usuario del que se quieren obtener datos.<br>
Devuelve un HttpStatus.OK y los datos del usuario pedido con el siguiente formato:<br>
{<br>
	“idUsuario”: ID del usuario en la base de datos (long),<br>
	“nombreUsuario”: nombre del usuario (String),<br>
	“apellidoUsuario”: apellido del usuario (String),<br>
	“email”: email del usuario (String),<br>
	“totalFacturado”: total facturado hasta el momento por el usuario (double),<br>
	“totalDeuda”: deuda total del usuario (double)<br>
}<br>
O un HttpStatus.CONFLICT y un String con el mensaje con el error sucedido cuando ocurre una excepción.<br>
</p>
<hr>
<p>
Para correr la aplicación localmente se deben instalar los siguientes programas:
</p>
<p>
Maven – JVM 8 – Intellij o Eclipse – MySQL Server – MySQL Workbench
</p>
<p>
Configurar MySQL Server con usuario “root” y password “Mysql-Passw0rd” o cambiar las credenciales de la conexión a MySQL Server de la aplicación, la misma se encuentra en el archivo “application.properties” (producción) y “application-test.properties” (tests).
Teniendo los programas instalados y habiendo ejecutado los scripts en el repositorio para generar las bases de datos podemos iniciar la aplicación, la clase que contiene el método main es “ApiFacturacionApplication”.
</p>






























