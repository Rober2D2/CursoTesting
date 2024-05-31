
# Proyecto java

MAVEN: automatizador de trabajos para proyectos de software.

1º Crear un proyecto mediante maven, usando un arquetipo (PLANTILLA)
   Para poder usar maven, necesitamos JAVA y MAVEN... Las versiones que me interesan.
   En nuestro caso realizamos una instalación (despliegue) de maven y java mediante un contenedor.
2º Completar un poco el proyecto:
    - Código JAVA
    - Pruebas unitarias JAVA
    - Plantillas de HTML (JSP)
3º Compilación (contenedor-maven)
4º Compilación de las pruebas (contenedor-maven)
5º Ejecución de las pruebas (contenedor-maven)
    Se genera un informe de pruebas JUNIT(xml)... con el resultado de las pruebas unitarias
6º Necesitamos generar un informe JACOCO    - TODO
7º Mandar el código a SonarQube (contenedor-maven)
    - Sonar identifica problemas
    - Usa el concepto de Cobertura de Código (% del código que tiene asociadas pruebas automatizadas) - TODO
    - Nos indica si pasamos el QualityGate
8º Usar jenkins para hacer todas estas operaciones:
    - Jenkins no hace nada... solo llama a otros programas de automatización (MAVEN)
    - Lo que configuramos en Jenkins son scripts... (PIPELINES)
    Problemas al trabajar con Jenkins son:
    - No quiero ejecutar trabajos en la propia máquina (entorno) donde corre jenkins.
    - Por otro lado, en el entorno que sea que quiera usar para hacer los trabajos necesito las herramientas de turno.
    Solución:
    - Trabajar con contenedores
    
    PIPELINE de nuestro proyecto:
    - Compilar
    - Compilar las pruebas
    - Ejecutar pruebas
    - Capturar el informe de pruebas de JUNIT para publicarlo en JENKINS (bonito)
    - Mandar el código a Sonar
    - Esperar la respuesta de sonar
    
---

# Integración entre Jenkins y Sonar

- Instalamos un plugin en Jenkins: Sonarqube Scanner.
- Al hacerlo: 
    - En la pantalla de configuración de Jenkins, 
      se me habilita una opción para poder dar de alta servidores de sonar... 
      incluido token de seguridad para la conexión
    - Se me añaden 2 funciones nuevas que puedo usar en los ficheros Pipeline:
        - withSonarQubeEnv('misonar'): Inyecta Variables de entorno que proveen la URL y el TOKEN autom. a los trabajos de sonar.
        - waitForQualityGate: Espera a que Sonar notifique que el trabajo ha finalizado (el análisis) y comunica el veredicto
    - Se instala un programa en Jenkins, que se publica mediante una URL para recibir comunicaciones de Sonar.

maven, a petición de Jenkins, manda el código a Sonar... y se desentiende!

    Jenkins -> maven -> Sonar
        ^                 |
        |                 |
        +-----------------+

# Integración entre Sonar y Jenkins

Es sonar el que posteriormente da el visto bueno o no al proyecto y manda esa información de vuelta a Jenkins.
    En sonar podemos configurar WEBHOOKS que sirven para esto.
    Cuando un análisis acaba, sonar manda una comunicación a una URL (WEBHOOK) indicando:
    - Tal PROYECTO PASA o NO el quality gate.
    Qué información necesitará sonar para poder hacer eso?
    - URL Jenkins
    - TOKEN de seguridad de JENKINS
    - ID del proyecto (esto lo sabe... el sonar)
Pregunta... cuál va a ser la URL que pongamos?
    Sonar hará una petición a la UR: http://IP_DE_MI_JENKINS:8080/atender_peticiones_sonar <--- TOKEN+PROYECTO+OK_NOK
    
    
---

# Hay mucho gestores de contenedores:
- Docker
- Podman
- CRIO
- ContainerD: Era el antiguo motor de procesamiento de contenedores de DOCKER

# Orquestador de contenedores: Gestor de gestores de contenedores
- Kubernetes: K8s
- K3s
- Minikube
- Openshift
- Tamzu
- Karbon
- Minishift

Entorno de producción basado en contenedores.

## Entorno de producción

- Alta disponibilidad: 
    Tratar de asegurar un determinado tiempo de servicio. 99.99%
        99% = RUINA ! 3,6 días al año me parece razonable tener el sistem OFFLINE (peluquería)  | €
        99.9 =        8 horas al año con el sistema caído (mercadona)                           | €€€€
        99.99 =       minutos al años (hospital, banco)                                         v €€€€€€€€€€€€€€
- Escalabilidad
    Ajustar la infra a las necesidades de cada momento

    Para ambos, hacemos uso del concepto de CLUSTER: MUCHAS MAQUINAS/PROCESOS haciendo el mismo trabajo
    
    Granja de computadores (cluster)
        Maquina 1
            crio|containerd
        Maquina 2
            crio|containerd
        Maquina N
            crio|containerd
            
        KUBERNETES
    


---

Jenkins va a crear un contenedor para ejecutar los trabajos: maven-contenedor-1
Pero ese contenedor se crea a nivel del HOST.
Y otra cosa... el contenedor maven-contenedor-1, tiene acceso a los ficheros del proyecto? 
A priori no.
Es más... cuántos contenedores puedo necesitar para el pipeline de un proyecto?
Todos esos contenedores deben compartir el código del proyecto.

Cómo resolvemos eso con contenedores? VOLUMENES

En automático, Jenkins al descargar el código de un proyecto de git, lo desacarga en? 
En su máquina... en /var/jenkins_home/proyectos
                    /var/jenkins_home/workspace/proyecto1

Esa carpeta es la que necesita inyectar jenkins a los contenedores... para que puedan acceder al código

Pero claro... Si en el host esa carpeta la tenemos en /home/ubuntu/environment....:/var/jenkins_home
Jenkins conoce la ruta real a nivel del host de esa carpeta? NO

Y tenemos un problema.

Quien ejecuta el comando:
    docker container create --name maven-contenedor-1 -v /var/jenkins_home/workspace/proyecto1:/var/jenkins_home/workspace/proyecto1 maven:3.8.5-openjdk-19
    Pero existe la ruta /var/jenkins_home/workspace/proyecto1 en el host? NO... en el host existe:
        /home/ubuntu/environment/...
es Jenkins

Solución a este problema, /var/jenkins_home, que es la que usa Jenkins internamente, 
el la que vamos a usar a nivel del HOST también... para que coincidan y quitarnos problemas.
