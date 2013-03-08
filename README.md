jdb
===

Provee funcionalidad para crear conexiones a distintos motores con conexiones configurables. La
idea es tener un unico punto para solicitar las conexiones y no tener que programarlas cada vez que las necesitamos.
La creaciòn de este juego de clases surgiò por la necesidad de migrar datos entre distintos motores con conexiones cambiantes.


El directorio src del repositorio es el codigo fuente de una factoria de conexiones.
La factoria construye las conexiones leyendo un archivos de configuracion llamado bds.properties 
que donde deben estar los datos de las mismas. Todas las conexiones tiene un "nombre" y es como la llamamos
desde cualquier codigo.

La forma de utilizar este juego de clases es llamar a la factoria de la sgte manera:

FactoriaConexionesDB.getConexion("conexion_mysql")

La factoria busca si tiene esa conexion establecida, si es así, devuelve la conexion y listo. En caso 
de que la misma no este establecida o ya este cerrada la crea nuevamente con los datos del archivo bds.prooperties.



El archivo bds.properties

Los datos del archivo de configuracion debe tener esta estructura. No se provee funcionalidad para agregarlas por 
alguna forma de consola, hay que editar el archivo y agregar las conexiones que necesitemos cambiando el nùmero final.
La idea es modificarla para que este archivo de configuraciòn sea de formato xml. Esta hecha asi por una cuestion de tiempo
para hacer algo mejor.


nombre_conexion_0=conexion_mysql
motor_0=mysql
driver_conexion_0=com.mysql.jdbc.Driver
puerto_conexion_0=3306
host_conexion_0=127.0.0.1
nombre_bd_conexion_0= nombre_db
usuario_conexion_0= usuario
clave_conexion_0= clave

nombre_conexion_1=conexion_dbf
motor_1=dbf
driver_conexion_1=com.hxtt.sql.dbf.DBFDriver
puerto_conexion_1=
host_conexion_1=////carpeta/donde/estan/lasDBF/DATOS
nombre_bd_conexion_1=
usuario_conexion_1=
clave_conexion_1=

