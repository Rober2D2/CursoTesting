mkdir -p /home/ubuntu/environment/data/sonar/core
mkdir -p /home/ubuntu/environment/data/sonar/extensions
mkdir -p /home/ubuntu/environment/data/sonar/logs
mkdir -p /home/ubuntu/environment/data/postgresql/data
mkdir -p /home/ubuntu/environment/data/postgresql/core

sudo chmod 777 /home/ubuntu/environment/data/sonar/core
sudo chmod 777 /home/ubuntu/environment/data/sonar/extensions
sudo chmod 777 /home/ubuntu/environment/data/sonar/logs
sudo chmod 777 /home/ubuntu/environment/data/postgresql/data
sudo chmod 777 /home/ubuntu/environment/data/postgresql/core

sudo sysctl -w vm.max_map_count=524288

# docker compose up          # Crea y arranca unos contenedores... y me deja la terminal bloqueada viendo sus logs
 docker compose up -d      # Crea y arranca unos contenedores... 
#docker compose down        # Para y borra los contenedores
#docker compose start       # Arranca contenedores previamente parados, pero nos crea
#docker compose stop        # Para cvontenedores, pero no los borra
#docker compose restart     # Reinicia los contenedores

# CUIDADO CON TUTORIALES VIEJOS POR INTERNET:
# Antaño el comando era:
# docker-compose up... Ese comando está deprecated