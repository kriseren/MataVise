                                                                             
      #_____           _____  _____   ______         _____   ____       _____    
  #___|\    \     ____|\    \|\    \ |\     \   ____|\    \ |    |  ___|\    \   
 #/    /\    \   /     /\    \\\    \| \     \ |    | \    \|    | /    /\    \  
#|    |  |    | /     /  \    \\|    \  \     ||    |______/|    ||    |  |____| 
#|    |  |____||     |    |    ||     \  |    ||    |----'\ |    ||    |    ____ 
#|    |   ____ |     |    |    ||      \ |    ||    |_____/ |    ||    |   |    |
#|    |  |    ||\     \  /    /||    |\ \|    ||    |       |    ||    |   |_,  |
#|\ ___\/    /|| \_____\/____/ ||____||\_____/||____|       |____||\ ___\___/  /|
#| |   /____/ | \ |    ||    | /|    |/ \|   |||    |       |    || |   /____ / |
# \|___|    | /  \|____||____|/ |____|   |___|/|____|       |____| \|___|    | / 
   #\( |____|/      \(    )/      \(       )/    )/           \(     \( |____|/  
    #'   )/          '    '        '       '     '             '      '   )/     
        #'                                                                '       
#Por Diego Calatayud
#!/bin/bash 
#Definición de variable programa
opcion=$(zenity --list \
                    --title="MATAVISE CONFIG SCRIPT" \
                    --height=250 \
                    --width=550 \
                    --ok-label="Aceptar" \
                    --cancel-label="Cancelar" \
                    --text="Selecciona las características a activar:" \
                    --checklist \
                    --column="" \
                    --column="Característica" \
                    --column="Descripción" \
                    1 "Banda Sonora" "Activa la banda sonora del juego." 2 "Modo Desarrollador" "Activa un modo especial diseñado para desarrolladores.")
echo "----------------------------------------------
--   ARCHIVO DE CONFIGURACIÓN DE MATAVISE   --
----------------------------------------------
# Para modificar los atributos de la configuración, tan solo has de cambiar el parámetro de "true" a "false" y viceversa.
# Si no sabes lo que estás haciendo, mejor no toques nada...
# Disfruta del juego :)
----------------------------------------------
----------------------------------------------" > files/config.txt
IFS="|" ; for word in $opcion ; do 
   case $word in
      "Banda Sonora") sed -i '8i\set_on_music(true);' files/config.txt ;;
      "Modo Desarrollador") sed -i '9i\set_on_admin(true);' files/config.txt ;;
   esac
done