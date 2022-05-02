#!/bin/bash
#Instalador del programa MataVise
#Diálogo inicial para iniciar la instalación
zenity --question \
       --title="MataVise Installer" \
       --width=250 \
       --ok-label="Continuar" \
       --cancel-label="Abandonar" \
       --text="Bienvenido al instalador de MataVise.
       ¿Desea continuar con la instalación?"
ans=$?
if [ $ans -eq 0 ]
then #Si el usuario dice que sí, se muestra un mensaje de selección de la carpeta.
    zenity --info \
           --title="MataVise Installer" \
           --width=250 \
           --text="A continuación selecciona la carpeta donde se realizará la instalación del programa."
    directorio=$(zenity --file-selection \
                     --title="MataVise Installer" \
                     --height=200 \
                     --width=100 \
                     --directory \
                     --text="Selecciona la carpeta de instalación:" )
    ans=$?
    if [ $ans -eq 0 ]
    then #Si el usuario ha seleccionado un directorio, entonces se ejecuta el diálogo de la barra mientras se instala
        echo $directorio>bin/mataVise/.ruta.dat
        (
        sleep 1
        echo "10"
        echo "# Aplicando permisos..."; chmod +x *.sh;sleep 1
        echo "20"
        echo "# Generando estructura de archivos...";
              mkdir $directorio/mataVise; #Genera el directorio mataVise en la ruta de instalación.
              directorio=$directorio/mataVise; #Actualiza la variable directorio con la ruta de la carpeta nueva.
              sleep 1
        echo "30"
        echo "# Copiando archivos...";cp -R * $directorio ; sleep 1
        echo "60"
        echo "# Compilando el código";javac -d $directorio/bin/ -cp $directorio/jar/jlayer-1.0.1.jar $directorio/src/mataVise/*.java; sleep 1
        echo "80"
        echo "# Generando script...";echo "mate-terminal --zoom=1.6 --full-screen --command 'java -cp $directorio/jar/jlayer-1.0.1.jar:$directorio/bin/ mataVise.mataVise' --display=:0">$directorio/mataVise.sh;sleep 1
        echo "90"
        echo "# Creando acceso directo...";
              echo "[Desktop Entry]
              Name=MataVise
              Comment=MataVise
              Exec=$directorio/mataVise.sh
              Icon=$directorio/files/knife.png
              Terminal=false
              Type=Application">/home/$USER/Desktop/MataVise.desktop; sleep 1
        echo "# Terminado"
        echo "100"
        ) |
        zenity --progress \
          --title="MataVise Installer" \
          --text="Iniciando el proceso" \
          --percentage=0
        if [ "$?" = -1 ] ; then
                zenity --error \
                  --text="Instalación cancelada"
        fi
    else #Si el usuario no ha elegido ningún directorio, se acaba el programa.
        exit 0
    fi

else #Si el usuario dice que no quiere continuar, se acaba el programa.
    exit 0
fi
