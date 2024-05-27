# Qué es un Contenedor?

Un contenedor es un ENTORNO AISLADO dentro de un SO Linux donde puedo ejecuatr procesos.
AISLADO:
√ Tiene su propio sistema de archivos (como si fuera su propio HDD)
√ Tiene sus propias variables de entorno
√ Tiene su propia configuración de red (y por ende su propia IP... en una red virtual creada por docker)
- Puede tener limitaciones de acceso al HARDWARE del host.

Son una alternativa para desplegar software en una máquina.

## Procedimientos para desplegar/instalar software en máquinas

### Más tradicional

       App1   +   App2   +  App3        PROBLEMAS GORDOS:
    -------------------------------         - Las apps pueden requerir de dependencias (requisitos previos)
           Sistema Operativo                  incompatibles entre si
    -------------------------------         - Las apps pueden potencialmente espiarse datos (virus)
             HIERRO / PC                    - Si una app: App1 se vuelve loca (100% CPU)
                                                    App1 pasa a estado OFFLINE (No responde)
                                                    App2 igual
                                                    App3 igual

### Máquinas virtuales

        App1    |   App2 + App3         PROBLEMAS:
    -------------------------------         - Se me complica la configuración: 3 sistemas operativos
        SO1     |       SO2                     - Más mnto, actualizaciones, instalaciones...
    -------------------------------         - Desperdicio de HW: 3SO... con sus respectivos consumos de RAM, CPUs(procesos en 2º plano), HDD
        MV1     |       MV2                 - Merma en el rendimiento.
    -------------------------------
        Hipervisor: KVM, CITRIX
        VMWARE, HYPERV, VirtualBox
    -------------------------------
        Sistema operativo
    -------------------------------
               Hierro

### CONTENEDORES

       App1    |   App2 + App3     
    -------------------------------
        C1      |       C2         
    -------------------------------
        Gestor de contenedores:
        Docker, Podman, CRIO, 
        Containerd 
    -------------------------------
        Sistema operativo: LINUX
    -------------------------------
               Hierro
               

Los contenedores se crean desde Imágenes de contenedor.

#### Imagen de contenedor

Un triste archivo comprimido (tar) que contiene un propgrama YA INSTALADO DE ANTEMANO normalmente por el fabricante.. 
o alguien que sabe un huevo de instalar programas. 
Además, pueden venir dentro otros programas más instalados... que me puedan ser de utilidad.
Y ... ese archivo se acompaña de unos metadatos:
- Quien es el creador de la imagen
- Qué comando es el que debe ejecutarse para arrancar el software principal que viene ahí comprimido
- En que puertos funciona por defecto el programa principal que ahñi viene...
 
Las imágenes de contenedor las encuentro en registros de repositorios de imágenes de contenedor: docker hub
Las imágenes se identifican por una URL:

    https://registro/repo:tag
    
    Habitualmente nunca ponemos el registry... salvo que trabajemos con un registry privado (propio)
    Y uso el que tenga configurado por defecto el gestor de contenedores: DOCKER
    
        repo:tag
    
    También puedo omitir el tag... y en ese caso se utiliza el tag "latest"
    El tag "latest" es otro tag más... como cualquier otro... que el fabricante puede haber creado... o no.
    Habitualmente, los fabricantes crean un tag latest apuntando a la última versión estable del producto...
    Es una mala practica... Es un tag variable que en un momento dado me puede montar una versión del producto incompatible con mis requisitos/ necesidades.


Las imagenes de contenedor siguen un estandar... Da igual el programa que use para crear la imagen de contenedor, 
puede usarse por cualquier gestor de contenedores.

El trabajo con los programas que hay dentro de un contenedor también está estandarizado.

    DOCKER CONTAINER START <CONTENEDOR>

### Versionado de software

    1.2.3
                    Cuándo se incrementa?
    1:  Major       Breaking changes: Cambios que NO RESPETAN RETROCOMPATIBILIDAD:
                    Quitar funciones del programa (con o sin reemplazo)
    2:  Minor       Nueva funcionalidad que respeta retrocompatibilidad del programa    3.2 -> 3.3 sé que mis cosas siguen funcionando
                    Funcionalidad marcada como DEPRECATED (Obsoleta)
                        + Adicionalmente pueden veniur arreglos de bugs.
    3:  Patch       Arreglo de bugs

### Tags de contenedores

    latest: 2.3.1 -> 3.5.1
    ***2.3.1 -> Es un tag fijo... que apunta a una versión concreta, con una funcionalidad (MINOR) + FIXES (PATCH)
    **2.3   -> Es un tag variable... que apunta a la última versión 2.3 que exista.. un día puede ser la 2.3.1 y otro día la 2.3.9
    *2     -> Es otro tag variable... que apunta a la íultima 2 que haya... un día puede ser la 2.3.1-> 2.3.8-> 2.5.1

    Me interesa una funcionalidad concreta para que lo que sea que monte funcione.

### Cliente de docker:

docker TIPO_OBJETO  VERBO   <args>

TIPO_OBJETO: 
    image           list    inspect     rm      pull    push
    container       list    inspect     rm      create  start   stop    restart logs...

Cuidado que todo (o casi todo) comando en docker tiene un alias más corto...

    docker image list -> docker images
    docker image pull -> docker pull
    docker image rm   -> docker rmi
    docker container list -> docker ps
    
---

# nginx
puerto 80
protocolo: http

---


    +------------------------------------------------------+---red física de mi empresa
    |                                                      |
    172.31.44.92                                        172.31.44.99
    |                                                      |
    Ivan PC                 mi-nginx                    MenchuPC: http://172.31.44.92:8888
    |   |                       |
    |   172.17.0.1          172.17.0.2:80 
    |   |                       |
    |   +-----------------------+
    |   |
    |   |red de docker
    |
    127.0.0.1 -> localhost
    |
    |red loopback (red virtual interna del ordenador)
    
    NAT: Redireccion de puertos a nivel del host:
        172.31.44.92:8888 -> 172.17.0.2:80 
        
        docker container create --name=mi-nginx -e MIVARIABLE=mivalor -e MIVAR2=mival2 -p 172.31.44.92:8888:80 nginx:latest
        docker container create --name=mi-nginx  -p 0.0.0.0:8888:80 nginx:latest
        docker container create --name=mi-nginx  -p 8888:80 nginx:latest
    
    
---

Quiero instalar en mi máquina una BBDD Mongo, SQL Server...

0º Tener el sistema configurado correctamente y con las dependencias necesarias
1º Bajar el instalador de mongo
2º Ejecutarlo... que puede ser más o menos complejo
---> c:\Windows\MongoDB -> .zip --> Email --> a vuestro pc

Ese ZIP es lo que sería una IMAGEN DE CONTENEDOR

---

# Montar una app java

- Muy sencilla                          \
- App web (tradicional)                  \ MAVEN
- Librería                               /
- Pruebas automatizadas (unitarias)     /

La app, la querremos compilar, probar (unitarias) y empaquetar (MAVEN)

# Maven es una herramienta de automatización de tareas habituales en proyectos JAVA.

# Montaremos un SonarQube

Y mandaremos nuestro código a Sonar.

---

Montar una app... y su flujo de trabajo:
- JAVA
- MAVEN

---

Imagen de maven con JAVA: 3.8.5-openjdk-18

- descargar la imagen de contenedor: 
    $ docker image pull maven:3.8.5-openjdk-18
- crear contenedor desde esa imagen 
    $ docker container create --name=mi-maven -v /home/ubuntu/environment/curso/proyectos:/proyectos maven:3.8.5-openjdk-18
    
        -w (establece el WORKING DIR por defecto... el directorio donde se ejecutarán los comandos del contenedor)

    docker container create --name=mi-maven -w /proyectos -v /home/ubuntu/environment/curso/proyectos:/proyectos maven:3.8.5-openjdk-18 \
    mvn archetype:generate \
        -DarchetypeGroupId=org.apache.maven.archetypes \
        -DarchetypeArtifactId=maven-archetype-webapp \
        -DarchetypeVersion=1.4 \
        -DgroupId=com.curso \
        -DartifactId=proyecto \
        -Dversion=1.0.0 \
        -Dpackage=com.curso\
        -B

- arrancar el contenedor:
    $ docker container start... AQUI HEMOS PINCHAO EN HUESO !!!! NECESITAMOS PASAR NUESTRO PROPIO COMANDO (resuelto)
    
    maven no es un servicio... que queda corriendo... como nginx... o mysql...
    Es un comando... que se ejecuta y acaba...

- Y después? Borro el contenedor... ya no lo quiero para nada...
    $ docker container rm mi-maven

... en lugar de todo esto... podemos usar otro comando de docker :
docker run:
    Descarga la imagen
    Crea el contenedor
    Ejecuta el comando que yo quiera
    Y hasta me lo borra después si se lo pido.
    
    $ docker run \
        --rm \
        -v /home/ubuntu/environment/curso/proyectos:/proyectos \
        -w /proyectos \
        maven:3.8.5-openjdk-18 \
        mvn archetype:generate \
            -DarchetypeGroupId=org.apache.maven.archetypes \
            -DarchetypeArtifactId=maven-archetype-webapp \
            -DarchetypeVersion=1.4 \
            -DgroupId=com.curso \
            -DartifactId=proyecto \
            -Dversion=1.0.0 \
            -Dpackage=com.curso\
            -B
    
    --rm (lo borras después de ejecutarlo)

docker run \
        --rm \
        -v /home/ubuntu/environment/curso/proyectos/proyecto:/proyecto \
        -w /proyecto \
        maven:3.8.5-openjdk-18 \
        mvn  compile

---

Para instalar maven, y sonar... y más herramientas que vamos a necesitar: Jenkins, Tomcat, 
Entorno con Python para lanzar pruebas de selenium, selenium grid, chrome, firefox, sus correspondientes drivers...
usaremos CONTENEDORES

---

# Qué es LINUX?

Un kernel de un SO... de hecho, el kernel más usado del mundo... con diferencia sobre cualquier otro.
Y hay 1 sólo sistema operativo que ya convierte a Linux en el kernel más usado: ANDROID.

Muchos SO incluyen el kernel de Linux:
- Android
- GNU/Linux... Este SO es el que se distruibuye mediante compendios de software generados por distintos fabricantes:
    - Debian -> Ubuntu (XUbuntu, mint)
    - Familia Redhat: RHEL, FEDORA, CENTOS, ORACLE UNBREAKEABLE LINUX. Amazon Linux
    - Suse
    - ....

Qué es eso de un kernel de un SO?
Un SO no es solo un programa. Una parte de un SO es lo que llamamos el KERNEL... Es la parte más crítica:
- La que controla el HW
- La que controla los procesos que corren sobre ese HW

Todo SO tiene un Kernel.
De hecho... windows es un SO? NO
Es una familia de SO, creados por microsoft... Y como todo SO, tienen su kernel:
    Windows 7
    Windows 8
    Windows 11
    Windows Server 2019
    Windows 3
    Windows 95

Microsoft ha tenido 2 kernels a lo largo de su historia:
- DOS -> MS-DOS, Window,1, 2, 3, 95, 98, millenium
- NT (New technology) -> Windows NT, XP, Server, 7, 8, 10, 11



---

# Tiene los contenedores persistencia de los datos en su sistema de archivos? 

SI...

Qué pasa si borro el contenedor? Me quedo sin su FS.. y sus carpetas y sus datos...
Qué pasa si borro una mv?  Me quedo sin su FS.. y sus carpetas y sus datos...
Qué pasa si borro uns máquina física? LA MISMA MIERDA !!!!

La cuestión es otra... con qué frecuencia borro una Máquina física? POCO
La cuestión es otra... con qué frecuencia borro una Máquina virtual? POCO
Y un contenedor? de continuo...

Tengo instalado mysql 5.7.1... y quiero pasar a mysql 7.2

En una máquina física qué hago? Actualizar el mysql
Y en una máquina virtual? Lo mismo
Y en contenedor? Borro el contenedor y creo otro que no tiene na' que ver.. con una imagen nueva actualizada!
El problema es... y los datos del viejo? A tomar por culo cuando lo borre!!!!

En los contenedores existe el concepto de volumen... 
Un volumen es una carpeta / o archivo que realmente está alojado fuera del contenedor (cuando trabajamos con docker, normalmente en el host)
y lo hago accesible en el fs del contenedor... en una determinada ruta (punto de montaje)

BASICAMENTE COMPARTO LA CARPETA / ARCHIVO ENTRE EL HOST Y EL CONTENEDOR...
De forma que al borrar el contenedor, esa carpeta o archivo no se borra... 
Y puedo crear luego OTRO CONTENEDOR... al que le pongo los mismos archivos, que tengo guardados en el host (le comparto la misma carpeta)

        docker container create --name=mi-nginx -v CARPETA-HOST:RUTA-CONTANEDOR -e MIVARIABLE=mivalor -e MIVAR2=mival2 -p 172.31.44.92:8888:80 nginx:latest
        docker container create --name=mi-nginx -v /home/ubuntu/environment:/datos -e MIVARIABLE=mivalor -e MIVAR2=mival2 -p 172.31.44.92:8888:80 nginx:latest
        
Para que usamos los volúmenes:
- Persistir datos del contenedor tras su muerte/eliminación
- Inyectar datos del host al contenedor
- Compartir datos entre contenedores