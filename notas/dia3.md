# MAVEN

Herramienta de automatización/gestión de proyectos de software (principalmentye JAVA)

proyecto/
    |
    +- src      < Código asociado al proyecto
    |   |
    |   + main
    |   |   |
    |   |   + resources < Archivos extras (que no requieren compilación) que forman parte de mi proyecto: configuraciones...
    |   |   |
    |   |   + java      < Código JAVA de mi app... y librerías
    |   |   |
    |   |   + webapp    < Código HTML, archivos de recursos... JSP (plantillas de HTMLs + JAVA)
    |   |
    |   + test
    |       |
    |       + resources < Archivos extras (que no requieren compilación) que requieren mis programas de prueba (datos...)
    |       |
    |       + java      < Código JAVA de mi programas de prueba (unitarias, integración... sistema)
    |
    +- pom.xml  < Archivo de configuración de mi proyecto
    
    
mvn GOAL (TAREAS QUE PUEDO AUTOMATIZAR)

Y maven viene ya de serie con unos goals preconfigurados.
Los goals... esas tareas, son ejecutadas por plugins de maven.
Entre los más comunes:
- compile               Compila los archivos .java que tengo en src/main/java -> target/classes
                        Se copian los archivos de src/main/resources también a target/classes
- test-compile          Compila los archivos .java que tengo en src/test/java -> target/test-classes
                        Se copian los archivos de src/test/resources también a target/test-classes
- test                  Se ejecutan las pruebas disponible en la carpeta target/test-classes
                        Se genera un informe de pruebas (con formato XML) en la carpeta target/surefire-reports
- package               Empaqueda mi aplicación para su distribución: -> .war, .jar, .ear
- install               Copia el .jar.. .war a mi carpeta .m2, para que pueda ser usado como dependencia en otros proyectos mios
- clean                 Borra target
- generate:archetype    Crear un proyecto desde una plantilla

# Carpeta .m2
Es una carpeta que maven crea dentro de mi carpeta de usuario:
    c:\usuarios\Ivan\.m2
    /home/ivan/.m2
En esa carpeta es donde maven busca dependencias para los proyectos...
Es decir, librerías adicionales que mi app pueda necesitar.
Si no se encuentran en esa carpeta, se buscan en un repo de artefacrtos que esté configurado (maven central, artifactory)

De hecho la carpeta TARGET nunca debería subirse al repo de git (o a mi sistema de control de código fuente de turno).
Ya que es una carpeta que puede generarse automáticamente desde el código (src/) gracias a maven.


---

# Instalar sonar...
2 contenedores:
- Sonar
   - datos: volumenes
   - usuario bbdd, contraseña,.. variables de entorno
   - ruta de la BBDD
   - Exponer unos puertos: 
- BBDD
   - datos: volumenes
   - usuario, contraseña...variables de entorno
   - 
   
---

10 GiB	- 10 Gibibytes
1 GiB = 1024 MiB
1MiB  = 1024 KiB

1Gb = 1000 Mb
1Mb = 1000 Kb 
1Kb = 1000 b

Esto no siemrpe ha sido así.. Antiguamente: Se cambió hace más de 25 años !!!!!
1Gb = 1024 Mb
1Mb = 1024 Kb 
1Kb = 1024 b
---

Sonar calcula la deuda técnica...
El tiempo que tardaría en arreglar todas las mierdas...
Pero cuidado... DEUDA:
Deuda es que lo debo... y las deudas tienen un problema.. y es que cuanto más tarde en pagarla, más interes pago.

El dato que da sonar es con intereses.
No es lo mismo que pague hoy... que pago con pocos intereses... a que pague dentro de un año...
donde voy a pagar un huevo de intereses.

---

Cobertura...

Sonar no ejecuta pruebas... y no sabe que lineas de cógico concretas están siendo probadas por las pruebas que haga.
Sonar lo que permite es que le suministre un informe JACOCO (JAVA CODE COBERTURE)
Ese informe puedo pedir que se genere al ejecutar las pruebas automatizadas.

Al leerlo, entenderá quñé lineas son las que he probado... y en base a eso calcula el % de cobertura del código.


public void edad(int edad){
    Si edad >=18 :
        print("eres mayor de edad")
    Si edad == 17:
        print("el año que viene pruebas campeón!")
    si no:
        print("Aqui no entras")
}


3 caminos = COMPLEJIDAD CICLOMATICA = NUMERO MINIMO DE PRUEBAS QUE NECESITO

---

Complejidad cognitiva:

Cómo de complejo para un ser humano es entender un código.

Puedo hacer algo, para reducir la complejidad cilomática? NO... sale de donde? DE LOS REQUISITOS


tarea1
si condicion1:
    tarea2
    si condicion2:
        tarea3
    sino, si condicion3
        tarea4
sino
    tarea5
    si condicion4
        tarea6
    si condicion5
        tarea7
        
        
Complejidad ciclomática de ese código? 7       
    
Para un ser humano este código es fácil de entender? NI DE COÑA !!!


select case / switch{
    caso 1
        tarea1
    caso 2
        tarea2
    caso 3
        tarea3
    caso 4
        tarea4
    caso 5
        tarea5
    caso 6
        tarea6
    caso por defecto
        tarea7
}

