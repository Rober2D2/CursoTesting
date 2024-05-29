MAESTRO DE JENKINS
    Aqui tengo instalado JENKINS... con SU java (11... 17)
    Éste inicia la ejecución de los trabajos
    
    Dónde se van a ejecuatr esos trabajo?
        - En la misma máquina de Jenkins: NUNCA
            Como un trabajo (que jenkins solicite la compilación o pruebas de un proyecto) de jenkins... se quede pillao...
            - Voy a montar 1 jenkins por proyecto? NI DE COÑA
                - Y en todos los proyectos necesito el mismo JAVA? MAVEN? NODE? ANGULAR? ANSIBLE? ......
                    Y así otros 1000
        - En otro sitio
Los trabajos de jenkins siempre quiero que se hagan en un entorno independiente... al del servidor.
Eso si.. ese entorno tendrá que tener instaladas las herramientas que necesite para el trabajo:
- JAVA 11
- JAVA 17
- JAVA 8
- MAVEN 3.6.1
- MAVEN 3.8.5
- NodeJS15 + Angular 16
- Python 3.9
- Python 3.2

Y antiguamente configurábamos máquinas trabajadoras... que especializábamos...
- MAQUINA JS/ANGULAR: AGENTES
- MAQUINA JAVA 17
- MAQUINA JAVA 11

Un agente en jenkins es un entorno independiente al de jenkins, donde ejecuto trabajos.
Antiguamente precreabamos agentes especializados.

Hoy en día: esos agentes los creamos sobre la marcha en contenedores

DOCKER es una herramienta muy divertida.. y totalmente INUTUL en un entorno de producción. NO SE USA.
En los entornos de producción, donde si trabajamos con contenedores, lo que trabajamos es con KUBERNETES.
- Balanceadores de carga
- Autoescalado
- Reglas de firewall
- Proxies reversos
- Volumenes de almacenamiento en red

Cuando instalo JENKINS, mediante contenedores, CREO UN UNICO CONTENEDOR: EL DEL MAESTRO DE JENKINS

Ese maestro de jenkins irá creando contenedores según los necesite para ejecutar trabajos DINAMICAMENTE...
y los borrará tan pronto acaben esos trabajo.


---

# Git (Linus Torvals)

Sistema de Control de Código fuente: SCM

Nuestro código va a ir a un REPOSITORIO... una especie de BBDD, donde tenemos copias de nuestro código en distintos momentos del tiempo.

COMMIT: Una foto COMPLETA de mi proyecto en un momento dado del tiempo. NO ES UN PAQUETE DE CAMBIOS... NI UNA ACTUALIZACION.
    CUIDADO... que en CVS o en Subversion (SVN) si lo era.

Lo que tengo son secuencias de copias de seguridad de mi proyecto

En git.. igual que en otros SCM, podemos tener varias secuencias paralelas de copias de seguridad (COMMITS) = RAMAS = BRANCHES

En todo proyecto seguimos lo que llamos un flow (flujo) de trabajo... ESTO ES LO MAS IMPORTANTE DE UN PROYECTO

- master---main (trunk)
    REGLA DE ORO: No se hace ni un PUTO COMMIT en ella
                  Todo lo que hay en ella se considera LISTO PARA PRODUCCION
                  
- dev (desa, desarrollo, develop)... aqui es donde se van haciendo los cambios en un proyecto o al menos, donde se consolidan, antes de su paso a producción / pruebas finales
- feature1
- feature2
- ivan
- feature3
    - ivan
    - menchu    

------master ----------------------------------------------- C7
                                                            /
------release                                              C7       < Pruebas de sistema (end2End) 
                                                          /
------desa----- C1 --- C2 --- C3 -- C4 ---------------- C7
                                \                    \  /  ^        ^ Pruebas de integración superadas  
------caracteristica 1 --------- C3 -- C5 -- C6* >--- C7          * > Pruebas unitarias superadas
                                  \
------caracteristica 2 ----------- C3 --- C8 -- C9

GIT es un sistema de SCM distribuido:
    El proyecto es la union de todos los repos que hay asociados al proyecto
    
Lo que tengo son un huevo de REPOS DISTINTOS ENTRE SI... LA SUMA(UNION) de todos los repos es el proyecto

                remoto1/desarrollo-C1-C2
                   |
                REPO REMOTO         REPO REMOTO 2
                   |                  |
     +-------------+------------------+-------------+
     |                                              |
    Ivan                                         Menchu
     |                                              |
    RepoIvan                                     RepoMenchu
     \ desarrollo-C1-C2                             \ remoto1/desarrollo-C1           C2 **
     \ remoto1/desarrollo-C1-C2                     \ desarrollo-C1       \         C2  
                                                    \ caracteristica1      C1 --> C2
    
    git fetch
    git merge | git rebase
    
    git pull  = git fetch + (git merge o git rebase)

