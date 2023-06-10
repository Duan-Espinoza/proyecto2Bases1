<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Firma_TEC.svg/1200px-Firma_TEC.svg.png" alt="Logo" width="500" height="80">
  </a>
</div>


# Proyecto 2 BlockBuster-App

* Nombre: Duan Antonio Espinoza Olivares
* Carnet: 2019079490.



Proyecto 2 para el curso curso de Bases de datos 1.



##### NOTA: La ejecución del programa hace uso de Apache Maven ( https://maven.apache.org/ )

#
## Instalación de Maven en W11

Abre el menú de inicio y busca "Editar las variables de entorno del sistema" y selecciona la opción correspondiente.

En la ventana de Propiedades del sistema, haz clic en el botón "Variables de entorno".

En la sección "Variables del sistema", busca la variable PATH y haz clic en "Editar".

Verifica que la ruta al directorio bin de Maven esté presente en la lista de rutas. La ruta debería ser similar a C:\Apache\apache-maven-3.9.2\bin, pero asegúrate de que coincida con la ubicación real de tu instalación de Maven.

Si la ruta no está presente, haz clic en "Nuevo" y agrega la ruta completa al directorio bin de Maven.

Asegúrate de guardar los cambios haciendo clic en "Aceptar" en todas las ventanas abiertas.

Cierra todas las ventanas de PowerShell y vuelve a abrir una nueva ventana de PowerShell.

Ejecuta el comando mvn -v nuevamente para verificar si Maven es reconocido correctamente.

#
## Pre-compilación:
```bash
mvn clean install
```

 Actualmente algunos de los comandos fueron modificados para evitar conflictos en sus nombres, asi como por la implementacion de la base de datos.

 ## Comandos de ejecucion para cada tabla:
 Por diseño de la base de datos, se se insertan ID's a la hora de crear filas; solo son usados para busquedas.

 ### Tabla Category:

 | Comando | Funcion |
 |---------|---------|
 | catc + {descrip} | Crea una categoria |
 | catr    | Imprime todas las categorias |
 | catrid + {id} | Imprime la categoria con el id respectivo |
 | catd + {id} | Elimina la categoria con el id respectivo |
 | catu + {id} + {descrip} | Actualiza la categoria con el id respectivo |

Ejemplos:
```bash
mvn exec:java -Dexec.args="catc Terror"

mvn exec:java -Dexec.args="catr"

mvn exec:java -Dexec.args="catrid 1"

mvn exec:java -Dexec.args="catd 1"

mvn exec:java -Dexec.args="catu 1 Parodia"
```

 ### Tabla Loan:

 | Comando | Funcion |
 |---------|---------|
 | loanc + {id pelicula} + {id cliente} + {fecha} | Crea una prestamo |
 | loanr    | Imprime todos los prestamos |
 | loanrid + {id pelicula} | Imprime el prestamos de esa pelicula |
 | loand + {id pelicula} + {id cliente} | Elimina el prestamos con los id's respectivos |

Ejemplos:
```bash
mvn exec:java -Dexec.args="loanc 1 3 2021-02-12" //Fecha de la forma aaaa-mm-dd

mvn exec:java -Dexec.args="loanr"

mvn exec:java -Dexec.args="loanrid 1"

mvn exec:java -Dexec.args="loand 1 3"
```

 ### Tabla Film:

 | Comando | Funcion |
 |---------|---------|
 | movc + {titulo} + {fecha} + {categoria} | Crea una pelicula |
 | movr    | Imprime todos las peliculas |
 | movrid + {id pelicula} | Imprime la pelicula asociada |
 | movd + {id pelicula} | Elimina la pelicula con los id's respectivos |
 | movu + {id pelicula} + {titulo} + {fecha} + {cat} | Actualiza la pelicula con el id respectivo |

Ejemplos:
```bash
mvn exec:java -Dexec.args="movc Titanic 1997-17-12 4" //Fecha de la forma aaaa-mm-dd

mvn exec:java -Dexec.args="movr"

mvn exec:java -Dexec.args="movrid 1"

mvn exec:java -Dexec.args="movd 1"

mvn exec:java -Dexec.args="movu 11 Titanic 1997-17-12 4"
```


 ### Tabla Film:
 No implementada 
 Razones:
 1- La falta de tiempo hizo que no se pudiera terminar las implementaciones pendientes de Film, por lo que...por orden de sacar el proyecto a tiempo, se decidió prescindir de sto


 
