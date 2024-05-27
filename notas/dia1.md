
# Testing (de software)

## Vocabulario en el mundo del testing:

- Error     Los errores los cometemos los humanos (errar es de humanos), por estar cansados, distraídos, faltos de conocimiento.
            Las máquinas no cometen errores.
- Defecto   Al cometer un humano un error puede introducir un DEFECTO en el producto.
- Fallo     Es la manifestación de un defecto al usar el producto

## Para qué sirven las pruebas?

- Asegurar el cumplimiento de unos requisitos.
  - Detectar la calidad de la aplicación / código
  - Asegurarnos que cumple con las especificaciones
  - Asegurarnos que no rompemos nada al modificar el código
  - Asegurar unos niveles de seguridad
- Tratar de identificar la mayor cantidad posible de defectos en el producto, antes de su entrega!
  Una vez identificado un defecto... lo arreglaré (DEPURACION/DEBUGGING -> Desarrollo)
  Para identificar defectos, podemos:
  - Buscar los defectos en el producto directamente
  - Intentar usar el producto en busca de fallos. ESTO ES LO MAS HABITUAL
    Desde el fallo, lo siguiente es identificar el DEFECTO que lo provoca.
- Aportar la mayor cantidad posible de información, que permita la rápida identificación de un DEFECTO desde el FALLO identificado. (2)
- Ver donde se puede mejorar un producto
- Para saber qué tal va mi proyecto! = COMO CONSECUENCIA DE USAR UNA METODOLOGÍA ÁGIL. (1)
  - Cuántas pruebas nuevas se han superado esta semana?
    - Si estoy ya en nivel DIOS de pruebas
        23 pruebas se han superados(de 35 planificadas) <<< El poder decir esto implica haber definido las pruebas lo primero.
- Y más!!!

## Tipos de pruebas

Las pruebas las clasificamos en base a múltiples taxonomías (clasificaciones) paralelas entre si.
Cualquier prueba se debe centrar en una ÚNICA característica del producto a probar. (2)

### En base al objeto de prueba

- Pruebas funcionales            Se centran en requisitos funcionales
- Pruebas no funcionales         Se centran en requisitos no funcionales
  - Rendimiento
  - Carga
  - Estrés
  - UX
  - Seguridad

### En base al nivel de la prueba

- Unitarias                 Cuando me centro en una característica de un componente AISLADO del sistema

    TREN: Motor, ruedas, asientos, frenos...
                                                           TEST-DOUBLE (mock, stub, fake, dummy, spy)
                                                            vvvvvv
        MOTOR:  Prueba UNITARIA al motor... Lo monto en un bastidor (4 hierros mal solados)
                Le meto corriente (llamo a una función del motor)... y quiero ver que gira (la salida de la función)
        SISTEMA DE FRENOS: 
                Monto ese sistema en un BASTIDOR (4 hierros mal soldados)
                Le meto corriente y miro a ver si cierren las pinzas de frenos... pongo un sensor en las pinzas.
        ASIENTOS: 
                Les hago unas pruebas unitarias (AISLADAS): Voy a poner el asiento a tornillao' a un bastidor (4 hierros mal soldados)
                - Si se reclina (funcional)
                - Que no se mueva ... o que no me muevo yo en el asiento (seguridad)
                - Que no me rompa el culo después de 4 horas sentao' (UX)
                - Que tras estarse usando 1 año... no se desgaste mucho (Estrés)
                - Que una persona de 150kg.. no la parta por la mitad (carga)
      El haber hecho todas estas pruebas me garantiza que el tren va a funcionar? NO
      Qué me dan? CONFIANZA +1   Vamos BIEN ! Doy pasos sobre seguro

- Integración               La que se centra en la COMUNICACION entre 2 componentes del sistema
        SISTEMA-DE-FRENOS / RUEDAS
                Monto ese sistema de frenos en un BASTIDOR (4 hierros mal soldados), le pongo una rueda en medio de las pinzas
                Le pego un viaje a la rueda, para que empiece girar...
                Le meto corriente al sistema de frenos y miro a ver si se paran las ruedas
      El haber hecho todas estas pruebas me garantiza que el tren va a funcionar? NO
      Qué me dan? CONFIANZA +1   Vamos BIEN ! Doy pasos sobre seguro

- End2End(sistema)          Miran que el comportamiento del sistema en su conjunto sea el adecuado.
      Si hago estas pruebas... y van bien... necesito hacer las pruebas de integración y unitarias para algo? NO... ya tengo el sistema OK
      Y entonces... para que carayos... he hecho la pruebas unitarias y de integración... SOY UN PRINGAO! NO?
        "Si hago estas pruebas... y van bien.."
        - Y cuando puedo hacer estas pruebas? Cuando tengo el sistema completo... y hasta entonces, que voy a ciegas?
        - Y si no van bien? Desmonto el tren? y a buscar a ver donde colesterol puede estar el problema?

### en base al procedimiento de ejecución de la prueba

- Pruebas estáticas         Las que no necesitan poner el programa en funcionamiento: REVISIÓN DE CÓDIGO: SONAR     ---> DEFECTOS
- Pruebas dinámicas         Las que necesitan poner el programa en funcionamiento: JUNIT, SELENIUM                  ---> FALLOS

### En base al conocimiento previo del sistema

- Caja negra                No se conoce el diseño/interior del sistema
- Caja blanca               Se conoce el diseño/interior del sistema

### Otros tipos de pruebas

- De Regresión              Cuando tengo una prueba, que ejecuto de nuevo.. a ver si he roto algo tras un cambio.
- Aceptación.....           Suelen ser un subconjunto de las pruebas de sistema

# Metodologías ágiles

Son una evolución de las formas de trabajo que usábamos antes (waterfall, cascada, etc.).

Entregar el producto de forma incremental. En lugar de entregarlo todo al final, se va entregando por partes.

EXTRAÍDO DEL MANIFIESTO ÁGIL:
- El software funcionando es la MEDIDA principal de progreso ---> DEFINE UN INDICADOR PARA UN CUADRO DE MANDO

La medida principal de progreso es el "software funcionando"
La forma (el indicador) que vamos a usar para determinar el grado de avance del proyecto (progreso) es el "software funcionando"

- "Software funcionando": Software que funciona, que se comporta como debe comportarse.
  Y quién dice eso? EL CLIENTE !!!!
  El cliente debe recibir un producto 100% funcional!
  El desarrollador? De ese no me fío
  El tester? Me fio .. pero ...
    LAS PRUEBAS !

Cómo lo medíamos antes?

HITO 1: Conjunto de **requisitos** que debían estar en una fecha:
    15 de Junio: R1, R2, R4

    Si el día 15 de Junio, no estaba el R4, qué se hacía?
    - Saltaban las alarmas
    - Ostias pa' tos los la'os
    - Se re-planificaba el hito. Se retrasaba la fecha del hito. El proyecto va con retraso.
    - Nueva fecha: 21 de Junio

HITO 2: Conjunto de requisitos que debían estar en una fecha:
    15 de Septiembre de 2026: R101, R102

Antaño, cuántas veces iba a producción? 1, al final.
---

SPRINT 1: Conjunto de requisitos que debían estar en una fecha:
    **15 de Junio**: R1, R2, R4

    Si el día 15 de Junio, no está el R4, qué se hace?
        Ese requisito se para al siguiente.. pero el 15 de Junio se sube producción!

    AQUÍ VOY A PRODUCCIÓN CON LO QUE TENGO!             10% de la funcionalidad
        Lo que implica: Pruebas... de producción        10% de la funcionalidad

SPRINT 2: Conjunto de requisitos que debían estar en una fecha:
    15 de Septiembre de 2026: R101, R102
    
    AQUÍ VOY A PRODUCCIÓN CON LO QUE TENGO!             +5% de la funcionalidad
        Lo que implica: Pruebas... de producción        +5% de la funcionalidad + 10% de la funcionalidad de antes
SPRINT 3: 
    AQUÍ VOY A PRODUCCIÓN CON LO QUE TENGO!             +15% de la funcionalidad
        Lo que implica: Pruebas... de producción        +15% de la funcionalidad + 15% de la funcionalidad de antes

Me crecen las pruebas como chinches.
Y las instalaciones... to' el dia instalando.

DE DONDE SACO LA PASTA EN EL PROYECTO PARA TANTA INSTALACIÓN y PRUEBAS? Y el tiempo? Y los recursos? DE NINGÚN LAO. No la hay!
SOLUCIÓN: AUTOMATIZAR 

# Devops

Qué es devops?
CULTURA, MOVIMIENTO, FILOSOFÍA en pro de la AUTOMATIZACIÓN.. y que da visibilidad a la parte de OPERACIONES. PELOTA !
AUTOMATIZACIÓN DE QUE? De todo lo que hay entre el DEV ---> OPS

               AUTOMATIZABLE        HERRAMIENTAS
PLAN                x
CODE                x
BUILD               √
                                        JAVA: MAVEN, GRADLE, SBT
                                        JS:   NPM, YARN, WEBPACK
                                        .net: MSBUILD, DOTNET, NUGET

-------------> Si consigo automatizar hasta este punto: DESARROLLO ÁGIL (no tiene nada que ver con seguir o usar una metodología ágil de desarrollo de software)

TEST
    diseño          x
    ejecución       √
                                        PRUEBAS DE UNITARIAS, INTEGRACION, SISTEMA: JUNIT, TESTNG, MOCHA, JEST, CUCUMBER, MSTEST, TESTUNIT
                                        Componente WEB: Cypress, Karma
                                        Sitio Web: Selenium, Katalon
                                        App movil: Appium
                                        Rendimiento /Estres: JMeter, Gatling, LoadRunner
                                        Servicios WEB: SOAPUI, POSTMAN, ReadyAPI, Karate
                                        Pruebas de calidad de código: SONAR
    Y esas pruebas donde las ejecuto?
        En la máquina del desarrollador? No me fío... está malea!
        Y en la del tester? No me fío... está malea!
        Y en un entorno de test? Antes si.... Ahora ... si... pero no!
            Qué pasa cuando tengo un entorno de test (pruebas, pre-producción, Q&A, entorno de INTEGRACIÓN) precreado... y ya he instalado 30 veces? Ya está maleao!
        LA TENDENCIA HOY EN DIA es a usar entornos de pruebas de USAR Y TIRAR. Cada vez que necesito una prueba, la creo, la uso y la tiro.... quien me ayuda guay con esto? LOS CONTENEDORES !!!!

        De donde saco esos entornos... su creación ... ES AUTOMATIZABLE? SI
                                        DOCKER, KUBERNETES
                                        VAGRANT, ANSIBLE, CHEF, PUPPET, SALSTACK
                                        TERRAFORM, CLOUDFORMATION
--------------> Quiero tener automatizado el proceso de CONTINUAMENTE instalar la última versión del software creado por desarrollo en el entorno de INTEGRACIÓN, sometido a pruebas automatizadas: INTEGRACIÓN CONTINUA. 
    Cuál es el producto de un pipeline de INTEGRACIÓN CONTINUA???? INFORME DE PRUEBAS (para qué???? (1))

RELEASE:    Acto de poner en manos de mi cliente una versión funcional de mi programa
--------------> Si automatizo hasta aquí? CONTINUOUS DELIVERY (Entrega continua)
DEPLOY
--------------> Si automatizo hasta aquí? CONTINUOUS DEPLOYMENT (Despliegue continuo)
OPERATION
MONITOR
---------------> GUAY... ya he adoptado una filosofía DEVOPS COMPLETA

---
AUTOMATIZACIÓN: 
Hacer una máquina o un programa que haga lo que antes hacía un humano

SYSADMIN: No es ya un tio / tia que administra sistemas...  
            Es un programador que hace programas que administran sistemas
TESTER:   No es ya un tio / tia que hace pruebas...  
            Es un programador que hace programas que pruebas otros programas


Con toda esa colección de herramientas:
 MAVEN, JUNIT, SELENIUM, ANSIBLE, DOCKER....
lo que hago es montar automatismos.... pequeños programas (tipo script)

Imaginad que para un proyecto, he montado ya todos los automatismos posibles... con esas herramientas... Quedaría ya todo automatizado?
Faltaría algo? SI. Qué? El que llama/orquesta a todas esas automatizaciones: 
SERVIDORES DE AUTOMATIZACIÓN: JENKINS, BAMBOO, TEAMCITY, AZURE DEVOPS, TRAVISCI, GITLAB CI/CD, GITHUB ACTIONS
---

# Herramientas de testing : SONAR (- JENKINS)

---

## Voy a plantear el sistema de ANIMALITOS FERMIN !!!

Hace años... habríamos montado un sistema MONOLITICO (un megasistema que hace de todo)
De eso aprendimos... y vimos que no era buena solución... es más, que a día de hoy, ni siquiera vale.
PROBLEMAS:
- Un cambio implica distribuir de nuevo el sistema entero
- Si quiero escalar, tengo que escalar todo el sistema
- Antiguamente, el HTML se generaba donde? En servidor

Sistema de animalitos Fermín:


<------------- Frontal ---------------------------> <-------------------------- Backend ---------------------------->
    App web                                                                                             
        JS/TS- Angular, 
        React, LitElement, 
            Vue
            
        WEB-COMPONENT    <>  Servicio Animalitos   <> Controlador REST  <> Servicio Animalitos  <> Repositorio <> BBDD
        Panel de detalle                                                        getAnimalito()
        de un  animalito

RESPONSABILIDAD:
        Mostrar info de un animalito
                            Comunicarse con un backend
                                                     Exponer un servicio por un protocolo
                                                                            Aportar la lógica de negocio
                                                                                                    Lógica de persistencia
                                                                                                                  Persistencia
        https://animalitos-fermin.com/api/v1/animalito/172 ---> getAnimalito(172)
            ^^^
        Quiero probar esto... (controlador)

        Tipos de prueba?
            - Unitarias:     Llamo a la URL con unos datos (17)
                             Espero que me devuelva un json, con los datos del animalito 17
                             De donde salen esos datos? De una query? Entonces.. si hago query... a una BBDD.. por deficnión es unitaria? NO... ya hay comunicación con un sistema externo (NO ES AISLADO EL COMPONENTE) 
                             Monto un bastidor (4 hierros mal soldados): Un servicio de mentirijilla... que cuando le pregunten:
                                getAnimalito(17) devuelva {"nombre":"Fermín", "edad": 3, "tipo": "perro"}
                            Este servicio de mentirijilla... es un TEST-DOUBLE: STUB

            - Integración   Sería cortando comunicación con el repo... SUPLANTANDO EL REPO... 
            - End2End       Meter un dato en BBDD y ver si lo recupero


    App nativa Android
    App nativa IOS                        {json}                          
    App desktop para los empleados
    IVR
    Alexa, OK Google, Siri



---

# Escalar

Ajustar la infra a las necesidades de cada momento.

    App1
        Dia 1:     100 usuarios
        Dia 100:   100 usuarios   NO NECESITO ESCALAR
        Dia 1000:  100 usuarios

    App2
        Dia 1:     100 usuarios
        Dia 100:   1000 usuarios            NECESITO ESCALAR: ESCALADO VERTICAL: MÁS MAQUINA!
        Dia 1000:  10000 usuarios
    
    App3. Este es el hoy en día: INTERNET
        Dia n:    100 usuarios
        Dia n+1:  1000000 usuarios
        Dia n+2:  0 usuarios
        Dia n+3:  10000000 usuarios

        Web del telepi:
            00:00   usuarios: 0 cerrado
            05:00   usuarios: 0 cerrado
            10:00   usuarios: 0 cerrado     NECESITO ESCALAR HORIZONTÁLMENTE: MÁS MAQUINAS (o menos)
            12:00   usuarios: 50                          Quién me permite esto con esta flexibilidad (los clouds)
            14:00   usuarios: 100
            16:30   usuarios: 40
            20:30 Madrid/Barça de por medio (QUE NOS VAMOS): 10000000